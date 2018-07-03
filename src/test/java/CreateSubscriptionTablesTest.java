import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CreateSubscriptionTablesTest {
    private static Connection connection;

    @BeforeClass
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql","ryan","password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void createSubscriptionTable() {
        Statement stmt = null;
        boolean result = false;
        final String query =
                "CREATE TABLE subscriptions(" +
                        "id varchar(255)," +
                        "stationId varchar(255)," +
                        "userId varchar(255)," +
                        "direction varchar(255)," +
                        "startTime bigint," +
                        "endTime bigint" +
                        ");";

        try {
            stmt = connection.createStatement();
            result = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        assertFalse(result);
    }

    @Ignore
    @Test
    public void deleteSubscriptionTable() {
        Statement stmt = null;
        boolean result = false;
        final String query =
                "drop TABLE subscriptions;";

        try {
            stmt = connection.createStatement();
            result = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        assertFalse(result);
    }


    @Ignore
    @Test
    public void deleteDataFromSubscriptionTable() {
        Statement stmt = null;
        boolean result = false;
        final String query =
                "DELETE FROM subscriptions";

        try {
            stmt = connection.createStatement();
            result = stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        assertFalse(result);
    }

    @Test
    public void createAndDeleteSubscription() {
        PreparedStatement stmt = null;
        ResultSet resultSet;
        final String query =
                "INSERT INTO subscriptions VALUES(" +
                        "'abcd'," +
                        "'123', " +
                        "'1234', " +
                        "'outbound'," +
                        System.currentTimeMillis()/1000 +"," +
                        " " + System.currentTimeMillis()/1000 +
                        ")";

        final String query2 =
                "SELECT * FROM subscriptions where id = 'abcd';";

        final String query3 =
                "DELETE * FROM subscriptions where id = 'abcd';";

        try {
            stmt = connection.prepareStatement(query);
            stmt.execute(query);
            resultSet = stmt.executeQuery(query2);
            if(resultSet.next()) {
                assertEquals(stmt.getResultSet().getString("stationId"), "123");
            }
            //stmt.execute(query3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createTestSubscriptions() {
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement("INSERT INTO subscriptions (id, stationId, userId, direction, startTime, endTime) VALUES (?, ?, ?, ?, ?, ?);");

            for (int i = 0 ;i < 10 ;i++) {
                stmt.setString(1, UUID.randomUUID().toString());
                stmt.setString(2, "1");
                stmt.setString(3, "123");
                stmt.setString(4, "outbound");
                stmt.setInt(5, (int)((System.currentTimeMillis()) / 1000) + 60 * i);
                stmt.setInt(6, (int)((System.currentTimeMillis()) / 1000) + 70 * i);
                stmt.addBatch();
            }
            stmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
