package tk.legendserver.legendpractice;

import fr.minuskube.inv.InventoryManager;
import me.realized.duels.api.Duels;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tk.legendserver.legendpractice.commands.KitsCommand;
import tk.legendserver.legendpractice.commands.ScoreboardCommand;
import tk.legendserver.legendpractice.commands.VersionCommand;
import tk.legendserver.legendpractice.kits.*;
import tk.legendserver.legendpractice.listeners.LobbyListener;
import tk.legendserver.legendpractice.listeners.PlayerClassListener;
import tk.legendserver.legendpractice.listeners.PracticeListener;
import tk.legendserver.legendpractice.listeners.ScoreboardListener;
import tk.legendserver.legendpractice.player.LegendPlayerManager;
import tk.legendserver.legendpractice.tasks.ScoreboardUpdateTask;

public final class LegendPractice extends JavaPlugin
{

    // Defines this class as main.
    public static void main(String[] args) {}

    // Plugin Instance. Used for executing stuff.
    private static LegendPractice instance;

    // The Duels plugin API.
    private static Duels duelsAPI = null;

    // The plugin's prefix.
    public static String HEADER = null;

    // The plugin's scoreboard title.
    public static String SCOREBOARDTITLE = null;

    // The amount of players currently in a fight.
    public static int IN_FIGHTS = 0;

    // LegendPlayerManager Instance Holder.
    private LegendPlayerManager playerManager;

    /*
     * Constants
     */

    // Easy access to the info logger.
    public static void info(String info)
    {
        LegendPractice.instance.getLogger().info(info);
    }

    // Instance Call
    public static LegendPractice getInstance()
    {
        return LegendPractice.instance;
    }

    @Override
    public void onEnable()
    {
        // Set the plugin instance.
        instance = this;

        // Register the duels API.
        duelsAPI = (Duels) Bukkit.getServer().getPluginManager().getPlugin("Duels");

        // Creates a player manager instance.
        this.playerManager = new LegendPlayerManager();

        // Sets the plugin's prefix.
        HEADER = ChatColor.YELLOW + "[Legend]" + ChatColor.RESET;
        SCOREBOARDTITLE = ChatColor.GOLD + "Legend" + ChatColor.DARK_GRAY + " | " + ChatColor.GOLD + "Practice " + ChatColor.GRAY + "[S3]";

        // Enables EVERYTHING
        this.enable();

        this.getLogger().info("Enabled Legend Practice (v3) by Magix!");
    }

    @Override
    public void onDisable()
    {
        this.getLogger().info("Disabled Legend Practice (v3) by Magix!");
    }

    // Enables all.
    private void enable()
    {
        // IMPORTANT: Register the Player class listener.
        this.registerListener(new PlayerClassListener());

        // Register Listeners
        this.registerListener(new ScoreboardListener());
        this.registerListener(new PracticeListener());
        this.registerListener(new LobbyListener());

        // Register Commands
        new VersionCommand();
        new ScoreboardCommand();
        new KitsCommand();

        // Register Kits
        new GappleKit();
        new ComboKit();
        new FistKit();
        new DebuffKit();
        new NoDebuffKit();

        // Register Inventory Manager
        InventoryManager man = new InventoryManager(this);
        man.init();

        // Scheldule Tasks
        new ScoreboardUpdateTask().runTaskTimer(this, 1, 20L);
    }

    // Quick access function to register a listener.
    public void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

    // Returns the Player Wrapper Class manager.
    public LegendPlayerManager getPlayerManager()
    {
        return playerManager;
    }

    // Gets the Duels API
    public Duels getDuelsAPI()
    {
        return duelsAPI;
    }

}