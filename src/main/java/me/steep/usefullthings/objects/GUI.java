package me.steep.usefullthings.objects;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUI {

    private final Inventory inv;

    public GUI() {

        this.inv = Bukkit.createInventory(new GUIHolder(), 36);

    }

    public void show(Player p) {

        p.openInventory(inv);

    }

}
