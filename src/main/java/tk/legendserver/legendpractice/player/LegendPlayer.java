package tk.legendserver.legendpractice.player;

import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;

public class LegendPlayer implements ILegendPlayer
{

    // LegendPlayer:
    // A wrapper class for Player.

    // The "REAL" player class.
    protected Player player;

    // The Player's version.
    protected Integer version = -1;

    // The Player's scoreboard.
    protected String scoreboard = "";

    /*
     * Constants
     */

    public static final Integer JAVA = 0;
    public static final Integer BEDROCK = 1;

    public static final String LOBBY_SCOREBOARD = "scoreboard.lobby";
    public static final String FFA_SCOREBOARD = "scoreboard.ffa";
    public static final String DUEL_SCOREBOARD = "scoreboard.duel";

    public LegendPlayer(Player thisPlayer)
    {
        player = thisPlayer;
    }

    // Gets the REAL player
    // assigned by Bukkit.
    public Player getBukkitPlayer()
    {
        return player;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public int getVersion()
    {
        return version;
    }

    @Override
    public String getScoreboardType()
    {
        return scoreboard;
    }

    @Override
    public void setScoreboardType(String scoreboard)
    {
        this.scoreboard = scoreboard;
    }
}