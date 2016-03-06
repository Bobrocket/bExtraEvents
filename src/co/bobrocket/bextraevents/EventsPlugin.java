package co.bobrocket.bextraevents;

import co.bobrocket.bextraevents.event.AnvilRepairEvent;
import co.bobrocket.bextraevents.event.PlayerDualWieldEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Bobrocket on 06/03/2016.
 */
public class EventsPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.isCancelled()) return;

        if (event.getAction().name().startsWith("PICKUP") && event.getRawSlot() == 2) {
            if (event.getView().getType().equals(InventoryType.ANVIL)) {
                Bukkit.getServer().getPluginManager().callEvent(new AnvilRepairEvent(event.getView()));
            }
        }

        if ((event.getAction().name().startsWith("PLACE_") || event.getAction().equals(InventoryAction.SWAP_WITH_CURSOR)) && event.getRawSlot() == 45) {
            if (event.getView().getType().equals(InventoryType.CRAFTING)) {
                ItemStack offHand = (event.getView().getItem(45)); //Just in case the item is actually placed BEFORE the event is called (isn't, but just in case)
                offHand = (offHand == null || offHand.getType().equals(Material.AIR)) ? event.getCursor() : offHand; //If it isn't placed before (essentially always true), we get the cursor item

                PlayerDualWieldEvent wieldEvent = new PlayerDualWieldEvent((Player)event.getView().getPlayer(), offHand);

                Bukkit.getServer().getPluginManager().callEvent(wieldEvent);

                if (wieldEvent.isCancelled()) event.setCancelled(true); //Cancel the event if need be
            }
        }
    }
}
