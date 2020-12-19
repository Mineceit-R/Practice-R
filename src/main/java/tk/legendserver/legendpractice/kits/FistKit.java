package tk.legendserver.legendpractice.kits;

import org.bukkit.entity.Player;
import tk.legendserver.legendpractice.utils.KitsUtil;
import tk.legendserver.legendpractice.utils.kits.BaseKit;

public class FistKit extends BaseKit
{

    public FistKit()
    {
        super(KitsUtil.FIST, "Fist");
    }

    public void sendKit(Player player)
    {
        BaseKit.player = player;
        player.getInventory().clear();

        item("cooked_beef", 64, false);

    }

}