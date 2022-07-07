package me.steep.usefullthings.handlers;

import me.steep.usefullthings.utils.Util;
import org.bukkit.Bukkit;

import java.sql.SQLException;

public class Log {

    public static void failed_Connection_To_SQL_Database() {
        Bukkit.getConsoleSender().sendMessage(Util.color("&c[" + "plugin name here" + "] Failed to connect to database."));
    }

    public static void failed_Connection_To_SQL_DataBase(SQLException ex) {
        Bukkit.getConsoleSender().sendMessage(Util.color("&c[" + "plugin name here" + "] Failed to connect to database:"));
        ex.printStackTrace();
    }

}
