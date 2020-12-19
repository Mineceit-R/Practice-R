package tk.legendserver.legendpractice.gui;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import me.realized.duels.api.Duels;
import me.realized.duels.api.kit.Kit;
import me.realized.duels.api.queue.DQueue;
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

import java.util.Objects;

public final class DuelsGUI implements InventoryProvider
{

    public static final SmartInventory duels = SmartInventory.builder()
            .id("lobbyDuels")
            .provider(new DuelsGUI())
            .size(3, 9)
            .title(ChatColor.GOLD + "Pick a duel kit:")
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
                e -> queue("duel.nodebuff", player)));

//        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE);
//        ItemMeta gappleMeta = gapple.getItemMeta();
//        gappleMeta.setDisplayName(ChatColor.YELLOW + "Gapple");
//        gapple.setItemMeta(gappleMeta);
//
//        contents.set(1, 2, ClickableItem.of(gapple,
//                e -> teleport("duel.gapple", player)));

    }

    @Override
    public void update(Player player, InventoryContents contents)
    {
        // Unused.
    }

    private void queue(String validArena, Player player)
    {
        Duels api = LegendPractice.getInstance().getDuelsAPI();

        // Kits
        Kit nodebuff = api.getKitManager().get("NoDebuff");

        // Queues
        DQueue qNoDebuff = api.getQueueManager().get(nodebuff, 0);

        switch(validArena)
        {
            default:
                return;
            case "duel.nodebuff":
                // Hand off to the API
                assert qNoDebuff != null;
                LegendPractice.getInstance().getDuelsAPI().getQueueManager().addToQueue(player, qNoDebuff);
                break;
//            case "arena.gapple":
//                KitsUtil.sendKit(player, KitsUtil.GAPPLE);
//
//                if(Bukkit.getWorld("Gapple") == null)
//                {
//                    new WorldCreator("Gapple").createWorld();
//                }
//
//                player.teleport(new Location(Bukkit.getWorld("Gapple"), 225, 51, 255));
//                Util.castMessage(player, ChatColor.GREEN + "Loaded 'Gapple' kit. Good Luck!");
//
//                lPlayer.setScoreboardType(LegendPlayer.FFA_SCOREBOARD);
//                new FFAScoreboard(lPlayer.getBukkitPlayer());
//
//                player.setGameMode(GameMode.ADVENTURE);
//                break;
        }

        // Close Inventory
        duels.close(player);
    }

}