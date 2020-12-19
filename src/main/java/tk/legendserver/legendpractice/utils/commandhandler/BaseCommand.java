package tk.legendserver.legendpractice.utils.commandhandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;

import java.util.Objects;

public abstract class BaseCommand implements CommandExecutor
{

    // BaseCommand:
    // The main class for a PMMP-like
    // command structure.

    private String permission = "";
    private String label = "";
    private String desc = "";

    // Constructor
    // Requires the player to input basic
    // necessities for the command to be registered.
    public BaseCommand(String label, String permission, String desc)
    {
        this.permission = permission;
        this.label = label;
        this.desc = desc;

        Objects.requireNonNull(LegendPractice.getInstance().getCommand(label)).setExecutor(this);
    }

    /*
    Get methods for the command and its extender.
     */

    protected String getPermission()
    {
        return permission;
    }

    protected String getLabel()
    {
        return label;
    }

    protected String getDesc()
    {
        return desc;
    }

    // onCommand(stuff):
    // Useless to modify, runs execute. This also checks
    // the player's command permission here.
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player))
        {
            if(!(commandSender instanceof ConsoleCommandSender))
                return false;

            this.execute(commandSender, strings);

            return true;
        }

        if(!(commandSender.hasPermission(permission)))
        {
            return false;
        }

        this.execute(commandSender, strings);

        return true;
    }

    // execute(abstract)
    // Handoff method used to simulate a PMMP
    // style command register-er.
    protected abstract void execute(CommandSender commandSender, String[] args);

}