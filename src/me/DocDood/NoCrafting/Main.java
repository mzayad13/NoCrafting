package me.DocDood.NoCrafting;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		// startup
		// reloads
		// plugin reloads
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		// shutdown
		// reloads
		// plugin reloads
	}
	
	@EventHandler
	public void crafting(CraftItemEvent event) {
		Material item = (Material) event.getRecipe().getResult().getType();
		if (item == Material.ENDER_EYE) {
            return;
        } else if (item == Material.BLAZE_POWDER) {
            return;
        } else {
        	event.getView().getPlayer().sendMessage(ChatColor.RED + "Silly gamer boi!"); // gotcha gamer
            event.setCancelled(true); 
            return;
        }   
    }
	
	@EventHandler
	public void table(InventoryOpenEvent event) {
		Player player = (Player) event.getPlayer();
		if(event.getInventory().getType() == InventoryType.WORKBENCH) {
			player.sendMessage(ChatColor.RED + "Silly gamer boi!"); // gotcha gamer
			event.setCancelled(true);
		}
		return;
	}
}
