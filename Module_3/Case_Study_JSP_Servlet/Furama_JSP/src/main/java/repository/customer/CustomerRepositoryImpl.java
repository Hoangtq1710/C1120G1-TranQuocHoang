package repository.customer;

import model.Customer;
import model.CustomerType;
import repository.DBConnection;
import service.customer_type.CustomerTypeService;
import service.customer_type.CustomerTypeServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{

    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    public static final String SELECT_ALL_CUS = "select * from customer;";
    public static final String INSERT_NEW_CUS = "insert into customer(customer_id,customer_type_id,customer_name," +
                                                            "customer_gender,customer_birthday,customer_id_card," +
                                                            "customer_phone,customer_email,customer_address)" +
                                                "values (?, ?, ? ,?, ?, ? ,?, ?, ?);";
    public static final String SELECT_CUS_BY_ID = "select * from customer where customer_id = ?;";
    public static final String DELETE_CUS_SQL = "delete from customer where customer_id = ?;";
    public static final String UPDATE_CUS_SQL = "update customer " +
                                                "set customer_name = ?, customer_type_id = ?, customer_gender = ?," +
                                                    "customer_birthday = ?, customer_id_card = ?, customer_phone = ?," +
                                                    "customer_email = ?, customer_address = ?" +
                                                " where customer_id = ?;";
    public static final String SEARCH_CUS_SQL = "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_id like ? " +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer.customer_type_id from customer " +
                                                "inner join customer_type on customer_type.customer_type_id = customer.customer_type_id\n" +
                                                        "where customer_type.customer_type_name like ?" +
                                                "union "+
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_name like ? " +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender" +
                                                        ",customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_type_id like ?" +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_id_card like ?" +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_address like ?" +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_birthday like ?" +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_phone like ?" +
                                                "union " +
                                                "select customer_id,customer_name,customer_birthday,customer_gender," +
                                                        "customer_id_card,customer_phone,customer_email,customer_address," +
                                                        "customer_type_id from customer where customer_email like ?;";

    public static final String SEARCH_DEEPER = "select * from customer\n" +
            "where customer_id like ? and customer_name like ? and customer_address like ?;";

    public static final String SORT_CUS_BY_NAME_DESC = "select * from customer order by customer_name desc;";
    public static final String SORT_CUS_BY_NAME_ASC = "select * from customer order by customer_name;";

//    public static final String SORT_CUS_BY_ID_DESC = "select * from customer order by customer_id desc;";
//    public static final String SORT_CUS_BY_ID_ASC = "select * from customer order by customer_id;";
//
//    public static final String SORT_CUS_BY_BD_DESC = "select * from customer order by customer_birthday desc;";
//    public static final String SORT_CUS_BY_BD_ASC = "select * from customer order by customer_birthday;";
//
//    public static final String SORT_CUS_BY_EMAIL_DESC = "select * from customer order by customer_email desc;";
//    public static final String SORT_CUS_BY_EMAIL_ASC = "select * from customer order by customer_email;";

    public static final String SORT_CUS_BY_ADDRESS_DESC = "select * from customer order by customer_address desc;";
    public static final String SORT_CUS_BY_ADDRESS_ASC = "select * from customer order by customer_address;";


    @Override
    public List<Customer> findAllCustomer() {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> listCustomer = new ArrayList<>();
        CustomerType customerType;

        if (con != null) {
            try {
                statement = con.prepareStatement(SELECT_ALL_CUS);
                resultSet = statement.executeQuery();

                Customer customer;
                while (resultSet.next()) {
                    String id = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int int_gender = resultSet.getInt("customer_gender");
                    boolean gender = (int_gender == 1);
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int cusTypeId = resultSet.getInt("customer_type_id");
                    customerType = this.customerTypeService.findCusTypeById(cusTypeId);
                    customer = new Customer(id,name,birthday,gender,idCard,phone,email,address,customerType);
                    listCustomer.add(customer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return listCustomer;
    }

    @Override
    public void save(Customer customer) {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (con != null) {
            try {
                statement = con.prepareStatement(INSERT_NEW_CUS);
                statement.setString(1,customer.getCustomerId());
                statement.setInt(2,customer.getCustomerType().getCustomerTypeId());
                statement.setString(3,customer.getCustomerName());
                statement.setInt(4,(customer.isCustomerGender()) ? 1 : 0);
                statement.setString(5, customer.getCustomerBirthday().toString());



                statement.setString(6,customer.getCustomerIdCard());
                statement.setString(7, customer.getCustomerPhone());
                statement.setString(8, customer.getCustomerEmail());
                statement.setString(9, customer.getCustomerAddress());

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Customer findCustomerById(String id) {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;
        if (con != null) {
            try {
                statement = con.prepareStatement(SELECT_CUS_BY_ID);
                statement.setString(1,id);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String customerId = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int int_gender = resultSet.getInt("customer_gender");
                    boolean gender = (int_gender == 1);
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");

                    int typeCustomerId = resultSet.getInt("customer_type_id");
                    CustomerType customerType = this.customerTypeService.findCusTypeById(typeCustomerId);

                    customer = new Customer(customerId,name,birthday,gender,idCard,phone,email,address,customerType);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customer;
    }

    @Override
    public void update(String id, Customer customer) {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (con != null) {
            try {
                statement = con.prepareStatement(UPDATE_CUS_SQL);

                statement.setString(1,customer.getCustomerName());
                statement.setInt(2,customer.getCustomerType().getCustomerTypeId());
                statement.setInt(3,((customer.isCustomerGender()) ? 1 : 0));
                statement.setString(4, customer.getCustomerBirthday().toString());
                statement.setString(5,customer.getCustomerIdCard());
                statement.setString(6, customer.getCustomerPhone());
                statement.setString(7, customer.getCustomerEmail());
                statement.setString(8, customer.getCustomerAddress());
                statement.setString(9,customer.getCustomerId());

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void remove(String id) {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (con != null) {
            try {
                statement = con.prepareStatement(DELETE_CUS_SQL);
                statement.setString(1, id);

                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Customer> search(String search) {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> listCustomer = new ArrayList<>();
        Customer customer;
        String[] str = new String[3];
        String[] arraySearch = search.split(",");
        int n = arraySearch.length;
        switch (n) {
            case 0:
                str[0] = str[1] = str[2] = "";
                break;
            case 1:
                str[0] = arraySearch[0];
                str[1] = str[2] = "";
                break;
            case 2:
                str[0] = arraySearch[0];
                str[1] = arraySearch[1];
                str[2] = "";
                break;
            default:
                str = Arrays.copyOf(arraySearch,3);
                break;
        }

        if (con != null) {
            try {
                statement = con.prepareStatement(SEARCH_DEEPER);
                statement.setString(1,'%'+str[0]+'%');
                statement.setString(2,'%'+str[1]+'%');
                statement.setString(3,'%'+str[2]+'%');


                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String customerId = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int int_gender = resultSet.getInt("customer_gender");
                    boolean gender = (int_gender == 1);
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");

                    int typeCustomerId = resultSet.getInt("customer_type_id");
                    CustomerType customerType = this.customerTypeService.findCusTypeById(typeCustomerId);

                    customer = new Customer(customerId,name,birthday,gender,idCard,phone,email,address,customerType);
                    listCustomer.add(customer);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return listCustomer;
    }

    @Override
    public List<Customer> sortCustomer(String sortBy) {
        Connection con = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> listCustomer = new ArrayList<>();
        Customer customer;

//        switch (factor) {
////            case "id":
////                sql = (sortBy.equals("desc") ? SORT_CUS_BY_ID_DESC : SORT_CUS_BY_ID_ASC );
////                break;
//            case "name":
//                sql = (sortBy.equals("desc") ? SORT_CUS_BY_NAME_DESC : SORT_CUS_BY_NAME_ASC );
//                break;
////            case "birthday":
////                sql = (sortBy.equals("desc") ? SORT_CUS_BY_BD_DESC : SORT_CUS_BY_BD_ASC );
////                break;
////            case "email":
////                sql = (sortBy.equals("desc") ? SORT_CUS_BY_EMAIL_DESC : SORT_CUS_BY_EMAIL_ASC );
////                break;
//            case "address":
//                sql = (sortBy.equals("desc") ? SORT_CUS_BY_ADDRESS_DESC : SORT_CUS_BY_ADDRESS_ASC );
//                break;
//        }



        if (con != null) {
            try {
                if (sortBy.equals("desc")) {
                    statement = con.prepareStatement(SORT_CUS_BY_NAME_DESC);
                } else {
                    statement = con.prepareStatement(SORT_CUS_BY_NAME_ASC);
                }

                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String id = resultSet.getString("customer_id");
                    String name = resultSet.getString("customer_name");
                    Date birthday = resultSet.getDate("customer_birthday");
                    int int_gender = resultSet.getInt("customer_gender");
                    boolean gender = (int_gender == 1);
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    int cusTypeId = resultSet.getInt("customer_type_id");
                    CustomerType customerType = this.customerTypeService.findCusTypeById(cusTypeId);
                    customer = new Customer(id,name,birthday,gender,idCard,phone,email,address,customerType);
                    listCustomer.add(customer);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return listCustomer;
    }

}
