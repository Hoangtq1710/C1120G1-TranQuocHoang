package repository;

import com.sun.corba.se.spi.activation.TCPPortHelper;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    @Override
    public List<Product> findAllProduct() {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> listProduct = new ArrayList<>();

        if (connection != null){
            try {
                statement = connection.prepareStatement("select * from product;");
                resultSet =statement.executeQuery();

                while (resultSet.next()){
                    int id = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int price = resultSet.getInt("price");
                    int percent = resultSet.getInt("percent");
                    int stock = resultSet.getInt("stock");
                    product = new Product(id,productName,price,percent,stock);
                    listProduct.add(product);

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
        return listProduct;
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void save(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null){
            try {
                statement = connection.prepareStatement("insert into product(product_name,price,percent,stock)\n" +
                        "values(?,?,?,?);");

                statement.setString(1,product.getProductName());
                statement.setInt(2,product.getPrice());
                statement.setInt(3, product.getPercent());
                statement.setInt(4, product.getStock());

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Product> topView(int number) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> listProduct = new ArrayList<>();

        if (connection != null){
            try {
                statement = connection.prepareStatement("select product.product_id,product_name,price,percent,stock, count(contract.product_id) as tong from product\n" +
                        "inner join contract on contract.product_id = product.product_id\n" +
                        "group by contract.product_id\n" +
                        "having count(contract.product_id)\n" +
                        "order by tong desc\n" +
                        "limit ?;");

                statement.setInt(1,number);

                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    int id = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int price = resultSet.getInt("price");
                    int percent = resultSet.getInt("percent");
                    int stock = resultSet.getInt("stock");
                    product = new Product(id,productName,price,percent,stock);
                    listProduct.add(product);

                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return listProduct;
    }

    @Override
    public List<Product> distance(Date start, Date end) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> listProduct = new ArrayList<>();

        if (connection != null){
            try {
                statement = connection.prepareStatement("select product.product_id,product_name,price,percent,stock from product\n" +
                        "inner join contract on contract.product_id = product.product_id\n" +
                        "where contract.start_date between ? and ?;");

                statement.setDate(1, start);
                statement.setDate(2, end);

                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    int id = resultSet.getInt("product_id");
                    String productName = resultSet.getString("product_name");
                    int price = resultSet.getInt("price");
                    int percent = resultSet.getInt("percent");
                    int stock = resultSet.getInt("stock");
                    product = new Product(id,productName,price,percent,stock);
                    listProduct.add(product);
                    System.out.println(listProduct.size());
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return listProduct;
    }
}
