package github.mathianasj.secrets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.sql.*;

@Path("/hello")
public class HelloService {
    @Resource( mappedName = "jboss/datasources/ExampleDS" )
    private DataSource exampleDS;

    @Inject
    SecretsBean secretsBean;

    @GET
    @Path("/load")
    public void loadData() throws SQLException {
        Connection connection = null;
        try {
            connection = exampleDS.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE table USERS (firstname VARCHAR(50));");
            statement.executeUpdate("INSERT INTO users VALUES ('John')");
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }

    @GET
    public String hello() throws SQLException {
        Connection connection = null;
        try {
            connection = exampleDS.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from users;");
            resultSet.next();

            return "Hello from DB: " + resultSet.getString("firstName") +"\n";
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
}