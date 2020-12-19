package tk.legendserver.legendpractice.utils;

import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.LegendPractice;

import javax.swing.text.Utilities;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class Util
{

    // Util:
    // Contains useful static methods to be used in the plugin.

    // castMessage(Player player, String message)
    // Sends a message to a player with the plugin prefix already attached.
    public static void castMessage(Player player, String message)
    {
        if(player == null)
            return;

        if(message == null)
            return;

        String finalMessage = LegendPractice.HEADER + " " + colorize(message);
        player.sendMessage(finalMessage);
    }

    // whoisgay:
    // Optical? Who else?
    public static String whoisgay()
    {
        return "optical";
    }

    // colorize(String message)
    // Basically pmmp TextFormat::colorize but in Java!
    public static String colorize(String message)
    {
        return message.replace("&", "§");
    }

    // getPing(Player player)
    // Gets a player's ping to the server.
    public static int getPing(Player player)
    {
        try {
            Object entityPlayer = player.getClass().getMethod("getHandle").invoke(player);
            return (int) entityPlayer.getClass().getField("ping").get(entityPlayer);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
            e.printStackTrace();
            return 0;
        }
    }

}