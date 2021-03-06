package tk.legendserver.legendpractice.kits;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import tk.legendserver.legendpractice.utils.KitsUtil;
import tk.legendserver.legendpractice.utils.kits.BaseKit;

public class ComboKit extends BaseKit
{

    public ComboKit()
    {
        super(KitsUtil.COMBO, "Combo");
    }

    public void sendKit(Player player)
    {
        BaseKit.player = player;
        player.getInventory().clear();

        ItemStack piece = armor("diamond_helmet", 0, true);
        piece.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        piece.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        KitsUtil.put(player, piece, KitsUtil.HEAD);

        ItemStack piece1 = armor("diamond_chestplate", 1, true);
        piece1.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        piece1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        KitsUtil.put(player, piece1, KitsUtil.CHEST);

        ItemStack piece2 = armor("diamond_leggings", 2, true);
        piece2.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        piece2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        KitsUtil.put(player, piece2, KitsUtil.LEGS);

        ItemStack piece3 = armor("diamond_boots", 3, true);
        piece3.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
        piece3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        KitsUtil.put(player, piece3, KitsUtil.FEET);

        ItemStack enchDia = item("diamond_sword", 0, true);
        enchDia.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        enchDia.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        KitsUtil.put(player, enchDia, KitsUtil.INVENTORY);

        ItemStack enchApl = item("golden_apple", 16, true);
        enchApl.setDurability( (short) 1 );
        KitsUtil.put(player, enchApl, KitsUtil.INVENTORY);

        ItemStack strength = item("potion", 1, true);
        strength.setDurability( (short) 8265 );
        KitsUtil.put(player, strength, KitsUtil.INVENTORY);

        ItemStack speed = item("potion", 1, true);
        speed.setDurability( (short) 8226 );
        KitsUtil.put(player, speed, KitsUtil.INVENTORY);
    }

}