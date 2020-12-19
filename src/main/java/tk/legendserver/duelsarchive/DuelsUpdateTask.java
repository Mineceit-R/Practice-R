//package tk.legendserver.legendpractice.tasks;
//
//import org.bukkit.Bukkit;
//import org.bukkit.entity.Player;
//import org.bukkit.scheduler.BukkitRunnable;
//import tk.legendserver.legendpractice.duels.AbstractDuel;
//import tk.legendserver.legendpractice.player.LegendPlayer;
//import tk.legendserver.legendpractice.LegendPractice;
//import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
//import tk.legendserver.legendpractice.scoreboards.FFAScoreboard;
//import tk.legendserver.legendpractice.scoreboards.LobbyScoreboard;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Map;
//
//public final class DuelsUpdateTask extends BukkitRunnable
//{
//
//    @Override
//    public void run()
//    {
//
//        // Get active duels.
//        Map<String, AbstractDuel> duelInstances = LegendPractice.getInstance().getDuelsAPI().get.getActiveDuels();
//
//        // Foreach duels, then update.
//        Collection<AbstractDuel> values = duelInstances.values();
//        ArrayList<AbstractDuel> duels
//                = new ArrayList<AbstractDuel>(values);
//
//        for(AbstractDuel duel : duels)
//        {
//            duel.update();
//        }
//
//    }
//}