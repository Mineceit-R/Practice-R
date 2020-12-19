package tk.legendserver.legendpractice.kits;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tk.legendserver.legendpractice.utils.KitsUtil;
import tk.legendserver.legendpractice.utils.kits.BaseKit;


public class NoDebuffKit extends BaseKit
{

    public NoDebuffKit()
    {
        super(KitsUtil.NODEBUFF, "NoDebuff");
    }

    public void sendKit(Player player)
    {
        BaseKit.player = player;
        player.getInventory().clear();

        // Armor
        ItemStack piece = armor("diamond_helmet", 0, true);
        piece.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        piece.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        KitsUtil.put(player, piece, KitsUtil.HEAD);

        ItemStack piece1 = armor("diamond_chestplate", 1, true);
        piece1.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        piece1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        KitsUtil.put(player, piece1, KitsUtil.CHEST);

        ItemStack piece2 = armor("diamond_leggings", 2, true);
        piece2.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        piece2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        KitsUtil.put(player, piece2, KitsUtil.LEGS);

        ItemStack piece3 = armor("diamond_boots", 3, true);
        piece3.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        piece3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        KitsUtil.put(player, piece3, KitsUtil.FEET);

        // Hotbar
        ItemStack enchDia = item("diamond_sword", 0, true);
        enchDia.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
        enchDia.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
        enchDia.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        KitsUtil.put(player, enchDia, KitsUtil.INVENTORY);

        item("ender_pearl", 16, false);
        item("golden_carrot", 64, false);

        ItemStack health = item("potion", 28, true);
        health.setDurability( (short) 16421 );
        KitsUtil.put(player, health, KitsUtil.INVENTORY);

        ItemStack fireres = item("potion", 1, true);
        fireres.setDurability( (short) 8259 );
        KitsUtil.put(player, fireres, KitsUtil.INVENTORY);

        ItemStack speed = item("potion", 4, true);
        speed.setDurability( (short) 8226 );
        KitsUtil.put(player, speed, KitsUtil.INVENTORY);
    }

}