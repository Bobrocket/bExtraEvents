package co.bobrocket.bextraevents.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Bobrocket on 06/03/2016.
 * <p>
 *     PlayerDualWieldEvent is an event that should fire when the player attempts to equip an item in their offhand.
 * </p> */
public class PlayerDualWieldEvent extends PlayerEvent implements Cancellable {

    private static HandlerList handlers = new HandlerList();
    private ItemStack offHandItem;
    private boolean cancelled = false;

    public PlayerDualWieldEvent(Player who, ItemStack offHandItem) {
        super(who);
        this.offHandItem = offHandItem;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Get the item that the player attempted to put in their offhand
     *
     * @return The item in their offhand
     * */
    public ItemStack getOffHandItem() {
        return offHandItem;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
