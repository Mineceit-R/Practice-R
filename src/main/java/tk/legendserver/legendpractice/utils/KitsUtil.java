package tk.legendserver.legendpractice.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tk.legendserver.legendpractice.kits.ComboKit;
import tk.legendserver.legendpractice.kits.GappleKit;
import tk.legendserver.legendpractice.utils.kits.BaseKit;

import java.util.HashMap;
import java.util.Map;

public final class KitsUtil
{

    // Registered Kits
    private static final Map<String, BaseKit> registeredKits = new HashMap<String, BaseKit>();

    /*
     * Kit Constants
     */

    public static String NODEBUFF = "kits.nodebuff";
    public static String GAPPLE = "kits.gapple";
    public static String FIST = "kits.fist";
    public static String COMBO = "kits.combo";
    public static String DEBUFF = "kits.debuff";

    public static String INVENTORY = "slot.inventory";
    public static String HEAD = "slot.helmet";
    public static String CHEST = "slot.chestplate";
    public static String LEGS = "slot.leggings";
    public static String FEET = "slot.boots";

    public static void sendKit(Player player, String kitTag)
    {
        BaseKit kit = registeredKits.get(kitTag);
        kit.sendKit(player);

        String kitName = kit.getName();
    }

    public static void put(Player player, ItemStack item, String slotName)
    {
        switch(slotName)
        {
            case "slot.inventory":
                player.getInventory().addItem(item);
                break;
            case "slot.helmet":
                player.getInventory().setHelmet(item);
                break;
            case "slot.chestplate":
                player.getInventory().setChestplate(item);
                break;
            case "slot.leggings":
                player.getInventory().setLeggings(item);
                break;
            case "slot.boots":
                player.getInventory().setBoots(item);
                break;
        }
    }

    public static void sendKit(BaseKit kit, String kitTag)
    {
        registeredKits.put(kitTag, kit);
    }

    public static void registerKit(BaseKit kit, String kitTag)
    {
        KitsUtil.registeredKits.put(kitTag, kit);
    }
}