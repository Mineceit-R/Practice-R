package tk.legendserver.legendpractice.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.BedrockPlayer;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
import tk.legendserver.legendpractice.utils.Util;
import tk.legendserver.legendpractice.utils.commandhandler.BaseCommand;

public final class VersionCommand extends BaseCommand
{

    /*
     * In commands, do not expect there to be
     * some or any documentation. These are commands
     * that should be distinguishable via their
     * descriptions.
     */

    public VersionCommand() {
        super("setversion", "legend.practice.version", "Sets your version for the server to know.");
    }

    protected void execute(CommandSender commandSender, String[] args) {

        if(args.length < 1)
        {
            commandSender.sendMessage(ChatColor.RED + "Please provide a valid argument!");

            return;
        }

        if(!(commandSender instanceof Player))
            return;

        ILegendPlayer legendPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer( (Player) commandSender );
        if(legendPlayer.getVersion() > -1)
        {
            Util.castMessage(legendPlayer.getBukkitPlayer(), ChatColor.RED + "Unable to run command. Details: 'You may not run this command more than once.'");
            return;
        }

        switch(args[0])
        {
            case "bedrock":
                Util.castMessage(legendPlayer.getBukkitPlayer(), ChatColor.GREEN + "It seems your playing on Bedrock. For optimal game play, please change your GUI scale to 'Classic' in your video settings.");
                legendPlayer.setVersion(BedrockPlayer.BEDROCK);
                return;
            case "java":
                Util.castMessage(legendPlayer.getBukkitPlayer(), ChatColor.AQUA + "Thanks for playing on the Java Edition! (for optimal game play, use 1.8.9+)");
                legendPlayer.setVersion(LegendPlayer.JAVA);
                break;
        }

    }
}