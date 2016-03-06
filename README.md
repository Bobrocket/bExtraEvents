# bExtraEvents
Extra events to allow more functionality within Spigot.

# Dual wielding
Dual wielding can be caught with <b>PlayerDualWieldEvent</b>:
<pre>
@EventHandler
public void onPlayerDualWield(PlayerDualWieldEvent event) {
	if (event.isCancelled()) return;
	
	if (!event.getOffHandItem().getType().equals(Material.SHIELD)) {
		event.setCancelled(true);
		event.getPlayer().sendMessage(ChatColor.RED + "Hey! " + ChatColor.GRAY + "You can't dual wield (bar shields)");
	}
}
</pre>
<b>Note: </b> bExtraEvents does <b><i>not</i></b> catch the hot swap key. If you have a way, feel free to submit it.

# Anvil repairs
You can catch when an anvil repairs with AnvilRepairEvent:
<pre>
@EventHandler
public void onPlayerRepair(AnvilRepairEvent event) {
	event.getPlayer().sendMessage("You repaired an item!");
}
</pre>

# Using bExtraEvents
In your plugin.yml:
<pre>
depend: [bExtraEvents]
</pre>
And then import the bExtraEvents jar and use the events as normal -
<pre>
co.bobrocket.bextraevents.event.AnvilRepairEvent
co.bobrocket.bextraevents.event.PlayerDualWieldEvent
</pre>

<b>Make sure that you also have the bExtraEvents jar in your plugins folder!</b>

