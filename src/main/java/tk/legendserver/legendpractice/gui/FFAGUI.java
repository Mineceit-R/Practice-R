package tk.legendserver.legendpractice.gui;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tk.legendserver.legendpractice.LegendPractice;
import tk.legendserver.legendpractice.player.LegendPlayer;
import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
import tk.legendserver.legendpractice.scoreboards.FFAScoreboard;
import tk.legendserver.legendpractice.utils.KitsUtil;
import tk.legendserver.legendpractice.utils.Util;

public final class FFAGUI implements InventoryProvider
{

    public static final SmartInventory ffa = SmartInventory.builder()
            .id("lobbyFFA")
            .provider(new FFAGUI())
            .size(3, 9)
            .title(ChatColor.GOLD + "Pick an FFA Arena:")
            .build();

    @Override
    public void init(Player player, InventoryContents contents)
    {
        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(" ");
        glass.setItemMeta(glassMeta);

        contents.fillBorders(ClickableItem.empty(glass));

        ItemStack nodebuff = new ItemStack(Material.POTION, 1, (short) 16421);
        ItemMeta nodebuffMeta = nodebuff.getItemMeta();
        nodebuffMeta.setDisplayName(ChatColor.YELLOW + "NoDebuff");
        nodebuff.setItemMeta(nodebuffMeta);

        contents.set(1, 1, ClickableItem.of(nodebuff,
                e -> teleport("arena.nodebuff", player)));

        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta gappleMeta = gapple.getItemMeta();
        gappleMeta.setDisplayName(ChatColor.YELLOW + "Gapple");
        gapple.setItemMeta(gappleMeta);

        contents.set(1, 2, ClickableItem.of(gapple,
                e -> teleport("arena.gapple", player)));

                ItemStack combo = new ItemStack(Material.RAW_FISH, 3);
                ItemMeta comboMeta = combo.getItemMeta();
                gappleMeta.setDisplayName(ChatColor.YELLOW + "Combo");
                gapple.setItemMeta(comboMeta);
        
                contents.set(1, 2, ClickableItem.of(combo,
                        e -> teleport("arena.combo", player)));

    }

    @Override
    public void update(Player player, InventoryContents contents)
    {
        // Unused.
    }

    private void teleport(String validArena, Player player)
    {
        ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);

        String mode = "";
        String modeA = ""; // Just the capital version of "mode"
        
        switch(validArena)
        {
            default:
            case "arena.gapple":
            	mode = "gapple";
            	modeA = "Gapple";
                break;
            case "arena.nodebuff":
            	mode = "nodebuff";
            	modeA = "NoDebuff";
                break;
            case "arena.combo":
            	mode = "combo";
            	modeA = "Combo";
                break;
        }
        
        KitsUtil.sendKit(player, "kits." + mode);

        if(Bukkit.getWorld(modeA) == null)
        {
            new WorldCreator(modeA).createWorld();
        }

        player.teleport(new Location(Bukkit.getWorld(modeA), 0, 51, 0));
        Util.castMessage(player, ChatColor.GREEN + "Loaded '" + modeA + "' kit. Good Luck!");

        lPlayer.setScoreboardType(LegendPlayer.FFA_SCOREBOARD);
        new FFAScoreboard(lPlayer.getBukkitPlayer());

        player.setGameMode(GameMode.ADVENTURE);
        
    }

}