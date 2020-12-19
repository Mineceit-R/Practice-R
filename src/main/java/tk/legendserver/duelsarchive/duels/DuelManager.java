//package tk.legendserver.legendpractice.duels;
//
//import tk.legendserver.legendpractice.duels.types.FistDuel;
//import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public final class DuelManager
//{
//
//    // DuelManager
//    // Manages duels. ???
//
//    /*
//     * Constants
//     */
//
//    public static String ONE_VS_ONE = "duel.type.1vs1";
//
//    public static String FIST = "duel.kit.fist";
//    public static String NODEBUFF = "duel.kit.nodebuff";
//
//    // Creates the hashmap for the player table.
//    private final Map<ILegendPlayer, AbstractDuel> players = new HashMap<ILegendPlayer, AbstractDuel>();
//
//    // Creates the hashmap for the duels table.
//    private final Map<String, AbstractDuel> duels = new HashMap<String, AbstractDuel>();
//
//    // createDuelInstance:
//    // Creates a duel instance.
//
//    public String createDuelInstance(String duelType, String maxPlayers)
//    {
//        switch(maxPlayers)
//        {
//            case "duel.type.1vs1":
//
//                switch(duelType)
//                {
//                    default: // Also known as Sumo
//                    case "duel.kit.fist":
//                        FistDuel duel = new FistDuel();
//                        String duelID = duel.getID(); // Initializes the ID. Used in a minute.
//
//                        duels.put(duelID, duel); // Registers the duel to the registry.
//                        return duelID;
//                    case "duel.kit.nodebuff":
//
//                        break;
//                }
//
//                break;
//            default:
//                return "";
//        }
//
//        return "";
//    }
//
//    // createDuel:
//    // Depending on the duel type, this is the system
//    // for players to be assigned to duels.
//
//    public void createDuel(ILegendPlayer player, String duelID)
//    {
//        AbstractDuel duelInstance = duels.get(duelID);
//        if(duelInstance != null)
//        {
//            duelInstance.addPlayer(player);
//        }
//    }
//
//    public Map<String, AbstractDuel> getActiveDuels()
//    {
//        return duels;
//    }
//
//
//}