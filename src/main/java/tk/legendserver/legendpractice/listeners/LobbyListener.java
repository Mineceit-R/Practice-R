package tk.legendserver.legendpractice.listeners;

import fr.minuskube.netherboard.Netherboard;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.gui.DuelsGUI;
import tk.legendserver.legendpractice.gui.FFAGUI;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
import tk.legendserver.legendpractice.scoreboards.LobbyScoreboard;
import tk.legendserver.legendpractice.utils.LobbyItemsUtil;
import tk.legendserver.legendpractice.utils.Util;

import java.util.Collection;

public final class LobbyListener implements Listener
{

    // Handles transactions to make the lobby
    // experience better. Also handles other
    // block events, etc.

    // onJoin
    // Sends the player to the lobby. Also calls the DEBUG method.

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);

        // Clear Inventory
        player.getInventory().clear();

        // Reset Player
        player.setSaturation(20);
        player.setHealth(20);
        player.getActivePotionEffects().clear();

        player.setGameMode(GameMode.ADVENTURE);

        // Send to lobby
        player.teleport(new Location(Bukkit.getWorld("Hub"), 259.5, 128, 247.5));

        // Give Items
        LobbyItemsUtil.giveItems(player);

        // Add Scoreboard
        lPlayer.setScoreboardType(LegendPlayer.LOBBY_SCOREBOARD);
        new LobbyScoreboard(lPlayer.getBukkitPlayer());

        // Title Welcome
        player.sendTitle(ChatColor.BLACK + "Legend", ChatColor.GOLD + "Practice", 20, 20, 20);

        // Call Debug
        debug(player);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();

        // Remove scoreboard
        Netherboard.instance().removeBoard(player);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);

        // Spawn player at spawn.
        if(Bukkit.getWorld("Hub") == null)
        {
            new WorldCreator("Hub").createWorld();
        }

        // Set loot to NONE.
        event.getDrops().removeAll(event.getDrops());

        player.setHealth(20); // Cancels the "Death" screen.

        // Teleports the player after a certain period has passed.
        // Not Async because we access "Bukkit" here.
        Bukkit.getServer().getScheduler().runTaskLater(LegendPractice.getInstance(), (Runnable) () -> LobbyListener.resetPlayer(player), 5L);

        lPlayer.setScoreboardType(LegendPlayer.LOBBY_SCOREBOARD);
        new LobbyScoreboard(lPlayer.getBukkitPlayer());
    }

    @EventHandler
    public void blockBreak(BlockBreakEvent event)
    {
        Player player = event.getPlayer();

        if(!player.isOp())
        {
            event.setCancelled(true);
        }else if(player.getGameMode() != GameMode.CREATIVE){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent event)
    {
        Player player = event.getPlayer();

        if(!player.isOp())
        {
            event.setCancelled(true);
        }else if(player.getGameMode() != GameMode.CREATIVE){
            event.setCancelled(true);
        }
    }

    // onInteract:
    // A simple way to send GUIs and Forms to players.

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();

        // QUICK CHECK (prevents errors)
        if(!event.hasItem())
            return;

        ItemStack item = event.getItem();
        int id = item.getTypeId();

        if(!Bukkit.getWorld("Hub").equals(player.getWorld()))
        {
            return;
        }

        switch(id)
        {
            case 54: // Material.CHEST // Cosmetics
            case 340: // Material.BOOK // Events
            case 345: // Material.COMPASS // Reports
            case 267: // Material.IRON_SWORD // Unranked Duels
                Util.castMessage(player, ChatColor.RED + "This feature is not available at this time!");
                break;
            case 399: // Material.NETHER_STAR // FFA
                FFAGUI.ffa.open(player);
                break;
            case 276: // Material.DIAMOND_SWORD // Ranked Duels
                DuelsGUI.duels.open(player);
                break;
        }


    }

    // debug(Player player)
    // The DEBUG function for developers.

    private void debug(Player player)
    {
//        Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(LegendPractice.getInstance(), (Runnable) FFAForm::new, 20L);

//        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(LegendPractice.getInstance(), new Runnable() {
//
//            public void run() {
//                FFAGUI.ffa.open(player);
//            }
//
//        }, 20L);
    }

    public static void resetPlayer(Player player)
    {
        player.teleport(new Location(Bukkit.getWorld("Hub"), 259.5, 128, 247.5));

        player.getInventory().clear();
        player.getActivePotionEffects().clear();

        LobbyItemsUtil.giveItems(player);

        player.setSaturation(20);
    }

}