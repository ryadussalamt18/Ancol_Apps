package AncolApps;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tirta Ryadussalam
 */
public class LoginAndSignUp {
    private static Connection AncolApps;
    
    public static Connection GetConnection() throws SQLException {
        if (AncolApps == null || AncolApps.isClosed()) {
            new Driver();
            AncolApps = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginapps", "root", "");
        }
        return AncolApps;
    }
}
