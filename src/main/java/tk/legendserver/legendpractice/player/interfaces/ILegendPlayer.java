package tk.legendserver.legendpractice.player.interfaces;

import org.bukkit.entity.Player;

public interface ILegendPlayer
{

    // ILegendPlayer:
    // An interface class used
    // for detecting players
    // with the LegendPlayer
    // wrapper class extended.

    /*
     * Most or all LegendPlayer methods will be
     * written here.
     */

    Player getBukkitPlayer();

    void setVersion(int version);

    int getVersion();

    void setScoreboardType(String scoreboard);

    String getScoreboardType();

}