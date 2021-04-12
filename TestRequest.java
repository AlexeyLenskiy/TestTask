
import java.sql.*;

public class TestRequest {
    public static final String URL = "jdbc:postgresql://localhost:5433/task";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "secret_password";
    static String select = "SELECT department, SUM(salary) as salary FROM employees GROUP BY department";

    public static void selectData() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD )) {
            PreparedStatement st = conn.prepareStatement(select);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("department") + ": " + rs.getInt("salary"));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        selectData();
    }
}
