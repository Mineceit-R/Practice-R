//package tk.legendserver.legendpractice.scoreboards;
//
//import fr.minuskube.netherboard.Netherboard;
//import fr.minuskube.netherboard.bukkit.BPlayerBoard;
//import org.bukkit.ChatColor;
//import org.bukkit.entity.Player;
//import tk.legendserver.legendpractice.LegendPractice;
//import tk.legendserver.legendpractice.duels.AbstractDuel;
//import tk.legendserver.legendpractice.player.LegendPlayer;
//import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
//import tk.legendserver.legendpractice.utils.Util;
//
//public final class DuelsScoreboard
//{
//
//    private static AbstractDuel playerDuel = null;
//
//    public DuelsScoreboard(AbstractDuel duel)
//    {
//        playerDuel = duel;
//    }
//
//    public void sendScoreboard(Player player)
//    {
//        ILegendPlayer lPlayer = LegendPractice.getInstance().getPlayerManager().getPlayer(player);
//        lPlayer.setScoreboardType(LegendPlayer.DUEL_SCOREBOARD);
//
//        BPlayerBoard board = Netherboard.instance().createBoard(player, LegendPractice.SCOREBOARDTITLE);
//
//        // Declare Variables
//        long pingA = 0;
//        long pingB = 0;
//        String currentDuration = "0:00";
//
//        // Set Lines
//        board.setAll(
//                "―――――――――――",
//                ChatColor.GOLD + "Fighting: " + ChatColor.WHITE + "%player%",
//                " ",
//                ChatColor.GOLD + "Duration: " + ChatColor.WHITE + currentDuration,
//                " ",
//                ChatColor.GOLD + "Your Ping: " + ChatColor.WHITE + pingA,
//                ChatColor.GOLD + "Their Ping: " + ChatColor.WHITE + pingB,
//                "⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯",
//                ChatColor.YELLOW + "@LegendServerUS"
//        );
//    }
//
//    public static void update()
//    {
//        for(Player player : playerDuel.getPlayers())
//        {
//            BPlayerBoard sb = Netherboard.instance().getBoard(player);
//
//            if(sb == null)
//                return;
//
//            // Declare Variables
//            int pingA = Util.getPing(playerDuel.getPlayers().get(0));
//            int pingB = Util.getPing(playerDuel.getPlayers().get(1));
//            String currentDuration = playerDuel.getDuration(); // pre-formatted
//
//            sb.set(ChatColor.GOLD + "Your Ping: " + ChatColor.WHITE + pingA, 4);
//            sb.set(ChatColor.GOLD + "Their Ping: " + ChatColor.WHITE + pingB, 3);
//            sb.set(ChatColor.GOLD + "Duration: " + ChatColor.WHITE + currentDuration, 6);
//        }
//    }
//
//}