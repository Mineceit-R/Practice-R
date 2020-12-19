//package tk.legendserver.legendpractice.commands;
//
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.command.CommandSender;
//import org.bukkit.entity.Player;
//import tk.legendserver.legendpractice.LegendPractice;
//import tk.legendserver.legendpractice.duels.DuelManager;
//import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
//import tk.legendserver.legendpractice.utils.KitsUtil;
//import tk.legendserver.legendpractice.utils.Util;
//import tk.legendserver.legendpractice.utils.commandhandler.BaseCommand;
//
//import javax.swing.plaf.basic.BasicButtonUI;
//
//public final class DuelCommand extends BaseCommand
//{
//
//    /*
//     * In commands, do not expect there to be
//     * some or any documentation. These are commands
//     * that should be distinguishable via their
//     * descriptions.
//     */
//
//    public DuelCommand() {
//        super("duel", "legend.practice.duel", "Main command for dueling others!");
//    }
//
//    protected void execute(CommandSender commandSender, String[] args) {
//
//        if(args.length < 2)
//        {
//            commandSender.sendMessage(ChatColor.RED + "Please provide 2 valid arguments!");
//
//            return;
//        }
//
//        if(!(commandSender instanceof Player))
//            return;
//
//        if(!(commandSender.isOp()))
//        {
//            Util.castMessage( ((Player) commandSender).getPlayer(), ChatColor.RED + "At this time, this command is in beta testing. You do not have permission to use this command.");
//
//            return;
//        }
//
//        DuelManager duelMan = LegendPractice.getInstance().getDuelsManager();
//        String duelType = "";
//        switch(args[0])
//        {
////            case "gapple":
////                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.GAPPLE);
////                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Gapple.");
////                break;
////            case "combo":
////                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.COMBO);
////                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Combo.");
////                break;
//            case "fist":
//                duelType = DuelManager.FIST;
//                break;
////            case "nodebuff":
////                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.NODEBUFF);
////                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: NoDebuff.");
////                break;
////            case "debuff":
////                KitsUtil.sendKit( ((Player) commandSender).getPlayer(), KitsUtil.DEBUFF);
////                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.GREEN + "Given kit: Debuff.");
////                break;
//            default:
//                Util.castMessage( ( (Player) commandSender).getPlayer(), ChatColor.RED + "Unable to find kit " + args[0] + ".");
//                duelType = "";
//                break;
//        }
//
//        // Create duel.
//        String duelID = duelMan.createDuelInstance(duelType, DuelManager.ONE_VS_ONE);
//
//        // Add both players to the duel.
//        Player target = Bukkit.getPlayer(args[1]);
//        ILegendPlayer lTarget = LegendPractice.getInstance().getPlayerManager().getPlayer(target);
//        Player sender = Bukkit.getPlayer( ((Player) commandSender).getUniqueId() );
//        ILegendPlayer lSender = LegendPractice.getInstance().getPlayerManager().getPlayer(sender);
//
//        duelMan.createDuel(lTarget, duelID);
//        duelMan.createDuel(lSender, duelID);
//    }
//}