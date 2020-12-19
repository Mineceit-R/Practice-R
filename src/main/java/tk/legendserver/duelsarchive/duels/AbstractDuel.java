//package tk.legendserver.legendpractice.duels;
//
//import org.bukkit.entity.Player;
//import org.bukkit.event.Listener;
//import org.bukkit.event.entity.PlayerDeathEvent;
//import tk.legendserver.legendpractice.LegendPractice;
//import tk.legendserver.legendpractice.player.interfaces.ILegendPlayer;
//import tk.legendserver.legendpractice.scoreboards.DuelsScoreboard;
//import tk.legendserver.legendpractice.utils.KitsUtil;
//import tk.legendserver.legendpractice.utils.Util;
//
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//public abstract class AbstractDuel implements Listener
//{
//
//    private final Map<UUID, Player> players = new HashMap<UUID, Player>();
//
//    protected String id = null;
//    protected int seconds = 0; // the amount of seconds since the duel has started
//    protected int phase = -1;
//
//    protected DuelsScoreboard scoreboard = null;
//
//    /*
//     * Constants
//     */
//
//    public static int PHASE_0 = -1; // CREATE --> Countdown
//    public static int PHASE_1 = 0; // Countdown --> Start
//    public static int PHASE_2 = 1; // Start --> End
//    public static int PHASE_3 = 2; // End --> CLOSE
//
//    // init:
//    // Starts the process.
//
//    public void init()
//    {
//        // Create player array for foreach.
//        Collection<Player> values = players.values();
//        ArrayList<Player> playerList
//                = new ArrayList<Player>(values);
//
//        // Create scoreboard
//        scoreboard = new DuelsScoreboard(this);
//
//        for(Player player : playerList)
//        {
//            // Send kits to player
//            KitsUtil.sendKit(player, getDuelKit());
//
//            // Send scoreboard
//            scoreboard.sendScoreboard(player);
//
//            // Send Title;
//            player.sendTitle(getDuelName(), "Starting in...", 20, 20, 20);
//        }
//
//        // Start duel task.
//        DuelsUpdateTask task = new DuelsUpdateTask();
//        task.runTaskTimer(LegendPractice.getInstance(), 1, 20L);
//
//        // Do countdown.
//
//        // Run extra start functions
//        start();
//    }
//
//    // Abstract Functions
//
//    // start:
//    // Self explanatory.
//
//    protected abstract void start();
//
//    // handlePlayer:
//    // Depending on what duel type is extending this class,
//    // this function might need a bit more work. Called when
//    // a player is added to the hashmap.
//
//    protected abstract boolean handlePlayer(ILegendPlayer player);
//
//    // getDuelKit:
//    // Self explanatory.
//
//    protected abstract String getDuelKit();
//
//    // getTeamSize:
//    // Self explanatory.
//
//    protected abstract String getTeamSize();
//
//    // getDuelName:
//    // Self explanatory.
//
//    protected abstract String getDuelName();
//
//    // death:
//    // Called when a player dies.
//    // Self explanatory.
//
//    protected abstract void death(Player player);
//
//    // Extra Functions
//
//    // update:
//    // Called every tick if the duel hasn't ended.
//    // Can be used for tracking replays real-time tbh.
//
//    public void update()
//    {
//        // FIST THINGS FIST: CHECK FOR DUEL DONE!
//        // TODO: If we implement 2v2s, 3v3s, etc. we will need to change this up a bit.
//        switch(getTeamSize())
//        {
//            case "ONE_VS_ONE":
//                if(players.size() <= 1)
//                {
//                    end(); // Close the duel.
//                }
//                break;
//        }
//
//        // Check Phase, run code.
//        switch(getPhase())
//        {
//            case 1:
//                // Create player array for foreach.
//                Collection<Player> values = players.values();
//                ArrayList<Player> playerList
//                        = new ArrayList<Player>(values);
//
//                for(Player player : playerList)
//                {
//                    Util.castMessage(player, "What is meant to happen here is the player is teleported, then a title happens for 3 seconds that alerts the player that they are about to engage in a duel. They are frozen during this time and cannot move while in this state.");
//
//
//                }
//
//                // Update Phase
//                phase = 2;
//                break;
//        }
//    }
//
//    // end:
//    // Self explanatory.
//
//    protected void end()
//    {
//
//    }
//
//    // addPlayer:
//    // Adds a player to the duel.
//
//    public void addPlayer(ILegendPlayer player)
//    {
//        if(!handlePlayer(player))
//            return;
//
//        players.put(player.getBukkitPlayer().getUniqueId(), player.getBukkitPlayer());
//
//        // Check if the duel players are in.
//        int count = players.size();
//        switch(getTeamSize())
//        {
//            case "ONE_VS_ONE":
//                if(count == 2)
//                {
//                    init(); // This is the p-sudo run function.
//                }
//                break;
//        }
//    }
//
//    // getPlayers:
//    // Returns an array of players.
//
//    public ArrayList<Player> getPlayers()
//    {
//        Collection<Player> values = players.values();
//        return new ArrayList<Player>(values);
//    }
//
//    // getDuration:
//    // Returns a pre-formatted version of
//    // the duel's duration.
//
//    public String getDuration()
//    {
//        String formatted = "";
//
//        // For context:
//        // %MM%:%SS%
//
//        // Convert seconds to minutes.
//        long minutes = TimeUnit.SECONDS.toMinutes(seconds);
//        formatted += minutes;
//
//        formatted += ":";
//
//        // Subtract minutes from seconds to make a formatted string.
//        long trueSeconds = seconds - minutes;
//
//        // Finish format
//        formatted += trueSeconds;
//
//        return formatted;
//    }
//
//    // getID:
//    // Returns or generates an ID
//    // used for matchmaking, etc.
//
//    public String getID()
//    {
//        if(id == null)
//        {
//            int numberOfWords = 1;
//            String[] randomStrings = new String[numberOfWords];
//            Random random = new Random();
//            for(int i = 0; i < numberOfWords; i++)
//            {
//                char[] word = new char[random.nextInt(8)+3];
//                for(int j = 0; j < word.length; j++)
//                {
//                    word[j] = (char)('a' + random.nextInt(26));
//                }
//                randomStrings[i] = new String(word);
//            }
//
//            id = randomStrings[0];
//        }
//
//        return id;
//    }
//
//    // getPhase:
//    // Returns the current duel phase.
//
//    public int getPhase()
//    {
//        return phase;
//    }
//
//    // Event Handlers
//
//    // onDeath:
//    // Updates the duel when a player dies.
//
//    public void onDeath(PlayerDeathEvent event)
//    {
//        Player player = event.getEntity().getPlayer();
//        if(player == null)
//            return;
//
//        // Check if player is in the duel. Then remove them.
//        // TODO: Optimize
//        if(players.containsKey(player.getUniqueId()))
//        {
//            players.remove(player.getUniqueId());
//            death(player);
//        }
//    }
//
//}