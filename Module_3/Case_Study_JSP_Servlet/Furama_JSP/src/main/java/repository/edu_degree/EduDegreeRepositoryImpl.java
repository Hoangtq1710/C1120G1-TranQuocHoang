package repository.edu_degree;

import model.EduDegree;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EduDegreeRepositoryImpl implements EduDegreeRepository{
    public static final String SELECT_EDU_BY_ID = "select * from education_degree where education_degree_id = ?;";

    @Override
    public EduDegree findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        EduDegree eduDegree = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_EDU_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString("education_degree_name");
                    eduDegree = new EduDegree(id, name);
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
        return eduDegree;
    }
}
