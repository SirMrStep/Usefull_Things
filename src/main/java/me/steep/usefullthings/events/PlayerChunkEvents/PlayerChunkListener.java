package me.steep.usefullthings.events.PlayerChunkEvents;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerChunkListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {

        if(e.isCancelled() || e.getTo() == null || e.getFrom().getChunk().equals(e.getTo().getChunk())) return;

        Bukkit.getPluginManager().callEvent(new PlayerChunkLeaveEvent(e.getPlayer(), e.getFrom().getChunk()));
        Bukkit.getPluginManager().callEvent(new PlayerChunkEnterEvent(e.getPlayer(), e.getTo().getChunk()));

    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {

        if(e.isCancelled() || e.getTo() == null || e.getFrom().getChunk().equals(e.getTo().getChunk())) return;

        Bukkit.getPluginManager().callEvent(new PlayerChunkLeaveEvent(e.getPlayer(), e.getFrom().getChunk()));
        Bukkit.getPluginManager().callEvent(new PlayerChunkEnterEvent(e.getPlayer(), e.getTo().getChunk()));


    }

}
