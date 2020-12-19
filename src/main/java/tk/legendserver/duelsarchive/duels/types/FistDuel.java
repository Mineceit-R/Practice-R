//package tk.legendserver.legendpractice.duels.types;
//
//import org.bukkit.entity.Player;
//import tk.legendserver.legendpractice.duels.AbstractDuel;
//import tk.legendserver.legendpractice.duels.DuelManager;
//import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
//import tk.legendserver.legendpractice.utils.KitsUtil;
//
//public final class FistDuel extends AbstractDuel
//{
//
//
//    @Override
//    protected void start()
//    {
//        return; // Since this is a 1vs1, nothing special needs to be done here.
//    }
//
//    @Override
//    protected void end()
//    {
//        return; // Since this is a 1vs1, nothing special needs to be done here.
//    }
//
//    public void update()
//    {
//        return; // Since this is a 1vs1, nothing special needs to be done here.
//    }
//
//    @Override
//    protected boolean handlePlayer(ILegendPlayer player)
//    {
//        return true; // Since this is a 1vs1, nothing special needs to be done here.
//    }
//
//    @Override
//    protected String getDuelKit() {
//        return KitsUtil.FIST;
//    }
//
//    @Override
//    protected String getTeamSize() {
//        return DuelManager.ONE_VS_ONE;
//    }
//
//    @Override
//    protected String getDuelName()
//    {
//        return "Fist";
//    }
//
//    @Override
//    protected void death(Player player)
//    {
//        return; // Since this is a 1vs1, nothing special needs to be done here.
//    }
//}