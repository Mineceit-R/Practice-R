package tk.legendserver.legendpractice.player;

import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;

import java.util.HashMap;
import java.util.Map;

public class LegendPlayerManager
{

    // LegendPlayerManager
    // Manages players. What else can it do?

    // Creates the hashmap for the player table.
    private final Map<Player, LegendPlayer> players = new HashMap<Player, LegendPlayer>();

    // registerPlayer(Player player)
    // Registers the given player into the hashmap of players.
    public void registerPlayer(Player player)
    {
        LegendPlayer legendPlayer = new LegendPlayer(player);
        players.put(player, legendPlayer);
    }

    // unregisterPlayer(Player player)
    // Unregisters a player for whatever reason.
    public void unregisterPlayer(Player player)
    {
        if(players.containsKey(player))
        {
            players.remove(player);

            LegendPractice.info("Unregistered " + player.getName() + " from the database.");
        }
    }

    // getPlayer(Player player)
    // Gets a player's player wrapper class from
    // the player manager.
    public ILegendPlayer getPlayer(Player player)
    {
        return players.getOrDefault(player, null);
    }


}