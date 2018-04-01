package tech.stefanolupo.westburyclub.data;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.skife.jdbi.v2.DBI;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseWrapper {

    private DBI dbi;

    public DatabaseWrapper() {
        try {
            Properties props = new Properties();

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("db.properties");
            props.load(inputStream);

            MysqlDataSource mysqlDataSource = new MysqlConnectionPoolDataSource();
            mysqlDataSource.setUrl(props.getProperty("mysql.url"));
            mysqlDataSource.setUser(props.getProperty("mysql.username"));
            mysqlDataSource.setPassword(props.getProperty("mysql.password"));
            this.dbi = new DBI(mysqlDataSource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DBI getDbi() {
        return dbi;
    }
}


