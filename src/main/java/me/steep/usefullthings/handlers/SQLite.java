package me.steep.usefullthings.handlers;

import me.steep.usefullthings.utils.Util;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("all")
public class SQLite {

    private static String name;
    private static String dataFolder;

    public static void initialize(String pluginName, String dataFolderPath) {
        name = pluginName;
        dataFolder = dataFolderPath;
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + dataFolder + "/database.db");
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

    private static void failed_To_Close_SQL_Connection() {
        Bukkit.getConsoleSender().sendMessage(Util.color("&c[" + name + "] Failed to close connection to database."));
    }

    private static void failed_To_Close_SQL_Connection(SQLException ex) {
        Bukkit.getConsoleSender().sendMessage(Util.color("&c[" + name + "] Failed to close connection to database:"));
        ex.printStackTrace();
    }

}
