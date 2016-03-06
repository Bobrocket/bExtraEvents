package co.bobrocket.bextraevents.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.InventoryView;

/**
 * Created by Bobrocket on 06/03/2016.
 */
public class AnvilRepairEvent extends InventoryEvent {
    private static final HandlerList handlers = new HandlerList();
    private Player who;

    public AnvilRepairEvent(InventoryView transaction) {
        super(transaction);
        this.who = (Player)transaction.getPlayer();
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return who;
    }
}
