package tk.legendserver.legendpractice.player;

import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;

public class BedrockPlayer extends LegendPlayer implements ILegendPlayer
{

    // BedrockPlayer:
    // A wrapper class for
    // Bedrock edition players.

    public BedrockPlayer(Player thisPlayer) {
        super(thisPlayer);
    }

}