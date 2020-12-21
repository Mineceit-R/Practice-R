package tk.legendserver.legendpractice.utils.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tk.legendserver.legendpractice.utils.KitsUtil;

public abstract class BaseKit
{

    protected static String kitTag = "";
    protected static String name = "";
    protected static Player player;

    public BaseKit(String kitTag, String name)
    {
        BaseKit.kitTag = kitTag;
        BaseKit.name = name;

        KitsUtil.registerKit(this, kitTag);
    }

    public String getKitTag()
    {
        return kitTag;
    }

    public String getName()
    {
        return name;
    }

    protected ItemStack item(String itemName, int amount, boolean rtn)
    {
        if(BaseKit.player == null)
            return null;

        Material material = Material.valueOf(itemName.toUpperCase());
        if(amount == 0)
        {
            amount = material.getMaxStackSize();
        }

        ItemStack item = new ItemStack(material, amount);

        if(rtn)
        {
            return item;
        }else{
            player.getInventory().addItem(item);
            return null;
        }
    }

    protected ItemStack armor(String itemName, int slot, boolean rtn)
    {
        if(BaseKit.player == null)
            return null;

        if(slot > 3)
            slot = 0;

        Material material = Material.valueOf(itemName.toUpperCase());
        ItemStack item = new ItemStack(material, material.getMaxStackSize());

        if(rtn)
        {
            return item;
        }

        switch(slot)
        {
            case 0:
                player.getInventory().setHelmet(item);
                return null;
            case 1:
                player.getInventory().setChestplate(item);
                return null;
            case 2:
                player.getInventory().setLeggings(item);
                return null;
            case 3:
                player.getInventory().setBoots(item);
                return null;
            default:
                return null;
        }
    }

    public abstract void sendKit(Player player);
}