package org.golde.bukkit.redhcf;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class ChestGUI implements Listener {

	private String name;
	private int size;
	private OptionClickEventHandler handler;
	private Plugin plugin;
	private Player player;

	private String[] optionNames;
	private ItemStack[] optionIcons;

	public static final String[] NO_LORE = {"NO_LORE"};
	
	private InventoryView openView;

	
	public ChestGUI(String name, int size, OptionClickEventHandler handler, Plugin plugin) {
		this.name = ColorFormatter.color(name);
		this.size = size;
		this.handler = handler;
		this.plugin = plugin;
		this.optionNames = new String[size];
		this.optionIcons = new ItemStack[size];
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	public ChestGUI setOption(int position, ItemStack icon, String name, String... lore) {
		optionNames[position] = name;
		lore = checkNullLore(lore);
		optionIcons[position] = setItemNameAndLore(icon, ColorFormatter.color(name), ColorFormatter.color(lore));
		return this;
	}
	
	private String[] checkNullLore(String... lore) {
		if(lore == null || lore.equals(null) || lore.length == 0){
			lore = NO_LORE;
		}
		return lore;
	}

	public void setSpecificTo(Player player) {
		this.player = player;
	}

	public boolean isSpecific() {
		return player != null;
	}
	
	public void updateOpenLore(int position, String... lore)
	{
		if (openView != null) {
			ItemStack item = openView.getItem(position);
			ItemMeta im = item.getItemMeta();
			lore = checkNullLore(lore);
			ArrayList<String> loreList = new ArrayList<String>();
			loreList.addAll(Arrays.asList(ColorFormatter.color(lore)));
			if(!lore[0].equals(NO_LORE[0])) {
				im.setLore(loreList);
			}
			item.setItemMeta(im);
			openView.setItem(position, item);
		}
	}
	
	public void updateOpenItem(int position, ItemStack icon, String name, String... info)
	{
		if (openView != null) {
			ItemStack newItem = setItemNameAndLore(icon, name, info);
			openView.setItem(position, newItem);
		}
	}

	public void open(Player player) {
		Inventory inventory = Bukkit.createInventory(player, size, name);
		for (int i = 0; i < optionIcons.length; i++) {
			if (optionIcons[i] != null) {
				inventory.setItem(i, optionIcons[i]);
			}
		}
		openView = player.openInventory(inventory);
	}

	public void destroy() {
		HandlerList.unregisterAll(this);
		handler = null;
		plugin = null;
		optionNames = null;
		optionIcons = null;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	void onInventoryClick(InventoryClickEvent event) {
		if (event.getInventory().getTitle().equals(name) && (player == null || event.getWhoClicked() == player)) {
			event.setCancelled(true);
			if (event.getClick() != ClickType.LEFT)
				return;
			int slot = event.getRawSlot();
			if (slot >= 0 && slot < size && optionNames[slot] != null) {
				Plugin plugin = this.plugin;
				OptionClickEvent e = new OptionClickEvent(this, (Player) event.getWhoClicked(), slot, optionNames[slot], optionIcons[slot]);
				handler.onOptionClick(e);
				((Player) event.getWhoClicked()).updateInventory();
				if (e.willClose()) {
					final Player p = (Player) event.getWhoClicked();
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						public void run() {
							p.closeInventory();
						}
					});
				}
				if (e.willDestroy()) {
					destroy();
				}
			}
		}
	}

	public interface OptionClickEventHandler {
		public void onOptionClick(OptionClickEvent event);
	}

	public class OptionClickEvent {
		private ChestGUI iconMenu;
		private Player player;
		private int position;
		private String name;
		private boolean close;
		private boolean destroy;
		private ItemStack item;

		public OptionClickEvent(ChestGUI menu, Player player, int position, String name, ItemStack item) {
			this.iconMenu = menu;
			this.player = player;
			this.position = position;
			this.name = name;
			this.close = true;
			this.destroy = false;
			this.item = item;
		}
		
		public ChestGUI getIconMenu() {
			return iconMenu;
		}

		public Player getPlayer() {
			return player;
		}

		public int getPosition() {
			return position;
		}

		public String getName() {
			return name;
		}

		public boolean willClose() {
			return close;
		}

		public boolean willDestroy() {
			return destroy;
		}

		public void setWillClose(boolean close) {
			this.close = close;
		}

		public void setWillDestroy(boolean destroy) {
			this.destroy = destroy;
		}

		public ItemStack getItem() {
			return item;
		}
	}

	private ItemStack setItemNameAndLore(ItemStack item, String name, String... lore) {
		if(item.getType() == Material.AIR){return item;}
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(name);
		lore = checkNullLore(lore);
		if(!lore[0].equals(NO_LORE[0])) {
			List<String> newLore = new ArrayList<String>();
			newLore.addAll(Arrays.asList(ColorFormatter.color(lore)));
			im.setLore(newLore); 
		}
		item.setItemMeta(im);
		return item;
	}

}

