package tk.legendserver.legendpractice.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.utils.KitsUtil;
import tk.legendserver.legendpractice.utils.Util;
import tk.legendserver.legendpractice.utils.commandhandler.BaseCommand;

public final class KitsCommand extends BaseCommand
{

    /*
     * In commands, do not expect there to be
     * some or any documentation. These are commands
     * that should be distinguishable via their
     * descriptions.
     */

    public KitsCommand() {
        super("kit", "legend.practice.kit", "Obtain a kit to use!");
    }

    protected void execute(CommandSender commandSender, String[] args) {

        if(args.length < 1)
        {
            commandSender.sendMessage(ChatColor.RED + "Please provide a valid argument!");

            return;
        }

        if(!(commandSender instanceof Player))
            return;

        if(!(commandSender.isOp()))
        {
            Util.castMessage( ((Player) commandSender).getPlayer(), ChatColor.RED + "You do not have permission to use this command.");

            return;
        }

        switch(args[0])
        {
            case "gapple":
                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.GAPPLE);
                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Gapple.");
                break;
            case "combo":
                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.COMBO);
                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Combo.");
                break;
            case "fist":
                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.FIST);
                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Fist.");
                break;
            case "nodebuff":
                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.NODEBUFF);
                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: NoDebuff.");
                break;
            case "debuff":
                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.DEBUFF);
                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Debuff.");
                break;
            default:
                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.RED + "Unable to find kit " + args[0] + ".");
                break;
        }

    }
}