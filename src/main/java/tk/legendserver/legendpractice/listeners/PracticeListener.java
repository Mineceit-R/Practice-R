package tk.legendserver.legendpractice.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import tk.legendserver.legendpractice.LegendPractice;

public final class PracticeListener implements Listener
{

    // Handles PvP transactions and other
    // events to add a QoL experience
    // to practice.

    // onItemConsume:
    // Checks if the consumed item was a potion.
    // THen clears the glass bottle it adds.

    // NOTE; Taken from: https://bukkit.org/threads/remove-bottle-after-drinking-potion.204163/

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        final Player player = e.getPlayer();

        if (e.getItem().getTypeId() == 373) {
            Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(LegendPractice.getInstance(), (Runnable) () -> player.getInventory().remove(Material.GLASS_BOTTLE), 1L);
        }

    }

    // onDamage:
    // If the damage is from falling, cancel the damage event
    // and all damage associated.

    @EventHandler
    public void onDamage(EntityDamageEvent event)
    {
        if(event.getCause() == EntityDamageEvent.DamageCause.FALL)
        {
            event.setCancelled(true);
        }
    }

    // onDeath:
    // Summons the lightning on player death. That's it.

    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {
        Location loc = event.getEntity().getLocation();
        loc.getWorld().strikeLightningEffect(loc);
    }

}