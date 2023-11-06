package Util;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnection {

    private static final HikariDataSource dataSource;
    static {
            try {
                FileInputStream fileInputStream = new FileInputStream("C:\\Git Repositories\\Git Clones\\Maven\\FinalProject\\src\\main\\resources\\Config.properties");
                Properties properties = new Properties();
                properties.load(fileInputStream);

                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String pass = properties.getProperty("pass");

                dataSource = new HikariDataSource();

                dataSource.setJdbcUrl(url);
                dataSource.setUsername(username);
                dataSource.setPassword(pass);


                dataSource.setMinimumIdle(100);
                dataSource.setMinimumIdle(1000);
                dataSource.setLoginTimeout(3);

            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

}

