package org.golde.bukkit.redhcf;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.golde.bukkit.redhcf.ChestGUI.OptionClickEvent;
import org.golde.bukkit.redhcf.ChestGUI.OptionClickEventHandler;

public class Main extends JavaPlugin implements Listener{

	public void onEnable() {
		getCommand("kit").setExecutor(this);
        Bukkit.getPluginManager().registerEvents(this, this);
		getLogger().info("RedHCF plugin is starting.");
	}

	public void onDisable() {
		getLogger().info("RedHCF plugin is stopping.");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player)sender;
			openGui(p);
		}
		else {
			sender.sendMessage("Players only :)");
		}
		
		return true;
	}
	
	private void openGui(final Player p) {
		ChestGUI gui = new ChestGUI("Kits", 45, new OptionClickEventHandler() {
			
			@Override
			public void onOptionClick(OptionClickEvent event) {
				if(event.getPosition() == 10) {
					//Diamond 3
					Kits.giveDiamondKit(p);
				}
				else if(event.getPosition() == 12) {
					//Bard 4
					Kits.giveBardKit(p);
				}
				else if(event.getPosition() == 14) {
					//Miner 0
					Kits.giveMinerKit(p);
				}
				else if(event.getPosition() == 16) {
					//Archer 12
					Kits.giveArcherKit(p);
				}
				else if(event.getPosition() == 28) {
					//Starter 5
					Kits.giveKitStarter(p);
				}
				else if(event.getPosition() == 34) {
					//Rogue 14
					Kits.giveRogueKit(p);
				}
				else {
					event.setWillClose(false);
					event.setWillDestroy(true);
					return;
				}
				event.setWillClose(true);
				event.setWillDestroy(true);
			}
		}, this);
		
		for(int i = 0; i < 45; i++) {
			gui.setOption(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15), "", ChestGUI.NO_LORE);
		}
		String lore = "&eClick to equip";
		gui.setOption(10, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)3), "&bKit Diamond", lore);
		gui.setOption(12, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4), "&bKit Bard", lore);
		gui.setOption(14, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0), "&bKit Miner", lore);
		gui.setOption(16, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)12), "&bKit Archer", lore);
		gui.setOption(28, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5), "&bKit Starter", lore);
		gui.setOption(34, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14), "&bKit Rogue", lore);
		gui.open(p);
		
	}

}