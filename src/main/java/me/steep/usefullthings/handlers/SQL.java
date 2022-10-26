package me.steep.usefullthings.handlers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.steep.usefullthings.utils.Util;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This uses HikariCP
 */
@SuppressWarnings("all")
public class SQL {

    private static String name;

    public static void initialize(String pluginName) {
        name = pluginName;
    }

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        config.setJdbcUrl( "" );
        config.setUsername( "" );
        config.setPassword( "" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
    }

    private SQL() {}

    public static void close() {
        ds.close();

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closeConnection(Connection con) {

        if(con != null) {

            try {

                con.close();

            } catch (SQLException e) {

                failed_To_Close_SQL_Connection(e);

            }

        }

    }

    public static void closeResult(ResultSet result) {

        if(result != null) {

            try {

                result.close();

            } catch (SQLException e) {

                failed_To_Close_SQL_Connection(e);

            }

        }

    }

    public static void closeConnectionAndResult(Connection con, ResultSet result) {

        if(con != null) {

            try {

                con.close();

            } catch (SQLException e) {

                failed_To_Close_SQL_Connection(e);

            }

        }

        if(result != null) {

            try {

                result.close();

            } catch (SQLException e) {

                failed_To_Close_SQL_Connection(e);

            }

        }

    }

    private static void failed_To_Close_SQL_Connection(SQLException ex) {
        Bukkit.getConsoleSender().sendMessage(Util.color("&c[" + name + "] Failed to close connection to database:"));
        ex.printStackTrace();
    }

}
