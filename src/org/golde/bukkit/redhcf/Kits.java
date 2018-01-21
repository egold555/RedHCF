package org.golde.bukkit.redhcf;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Kits {

	private static final int PROTECTION = 2;
	private static final int FEATHER_FALLING = 4;
	private static final int SHARPNESS = 2;
	private static final int FIRE_ASPECT = 1;
	private static final int FLAME = 2;
	private static final int POWER = 4;
	private static final int FOOD_LEVEL = 20;
	private static final float SATURATION = 20;
	private static final Material FOOD = Material.COOKED_BEEF;

	public static void giveKitStarter(final Player p) {
		final PlayerInventory inv = p.getInventory();
		inv.clear();
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(FOOD_LEVEL);
		p.setSaturation(SATURATION);
		inv.setItem(8, new ItemStack(FOOD, 64));
		inv.setItem(0, new ItemStack(Material.FISHING_ROD));
		inv.setItem(1, new ItemStack(Material.ENDER_PEARL, 16));
	}

	public static void giveMinerKit(final Player p) {
		final PlayerInventory inv = p.getInventory();
		inv.clear();
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(FOOD_LEVEL);
		p.setSaturation(SATURATION);
		final ItemStack helmet = new ItemStack(Material.IRON_HELMET);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		helmet.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
		chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		chest.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack leggings = new ItemStack(Material.IRON_LEGGINGS);
		leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, FEATHER_FALLING);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		inv.setHelmet(helmet);
		inv.setChestplate(chest);
		inv.setLeggings(leggings);
		inv.setBoots(boots);
		inv.setItem(8, new ItemStack(FOOD, 64));
		inv.setItem(2, new ItemStack(Material.ANVIL, 1));
		final ItemStack pic = new ItemStack(Material.DIAMOND_PICKAXE);
		pic.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		pic.addUnsafeEnchantment(Enchantment.DIG_SPEED, 3);
		inv.setItem(0, pic);
		inv.setItem(1, pic);
	}

	public static void giveRogueKit(final Player p) {
		final PlayerInventory inv = p.getInventory();
		inv.clear();
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(FOOD_LEVEL);
		p.setSaturation(SATURATION);
		final ItemStack helmet = new ItemStack(Material.CHAINMAIL_HELMET);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		helmet.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		chest.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack leggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, FEATHER_FALLING);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, SHARPNESS);
		sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, FIRE_ASPECT);
		final ItemStack pot = new ItemStack(Material.POTION, 1, (short)16421);
		inv.setHelmet(helmet);
		inv.setChestplate(chest);
		inv.setLeggings(leggings);
		inv.setBoots(boots);
		inv.setItem(0, sword);
		inv.setItem(1, new ItemStack(Material.ENDER_PEARL, 16));
		inv.setItem(7, new ItemStack(Material.QUARTZ, 32));
		inv.setItem(8, new ItemStack(FOOD, 64));
		for (int i = 0; i < 35; ++i) {
			inv.addItem(new ItemStack[] { pot });
		}
	}

	public static void giveDiamondKit(final Player p) {
		final PlayerInventory inv = p.getInventory();
		inv.clear();
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(FOOD_LEVEL);
		p.setSaturation(SATURATION);
		final ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		helmet.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
		chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		chest.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
		leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, FEATHER_FALLING);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, SHARPNESS);
		sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, FIRE_ASPECT);
		final ItemStack pot = new ItemStack(Material.POTION, 1, (short)16421);
		final ItemStack swp = new ItemStack(Material.POTION, 1, (short)8226);
		final ItemStack frp = new ItemStack(Material.POTION, 1, (short)8259);
		inv.setHelmet(helmet);
		inv.setChestplate(chest);
		inv.setLeggings(leggings);
		inv.setBoots(boots);
		inv.setItem(0, sword);
		inv.setItem(1, new ItemStack(Material.ENDER_PEARL, 16));
		inv.setItem(2, frp);
		inv.setItem(7, swp);
		inv.setItem(8, new ItemStack(FOOD, 64));
		inv.setItem(9, swp);
		inv.setItem(18, swp);
		inv.setItem(27, swp);
		for (int i = 0; i < 35; ++i) {
			inv.addItem(new ItemStack[] { pot });
		}
	}

	public static void giveBardKit(final Player p) {
		final PlayerInventory inv = p.getInventory();
		inv.clear();
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(FOOD_LEVEL);
		p.setSaturation(SATURATION);
		final ItemStack helmet = new ItemStack(Material.GOLD_HELMET);
		helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		helmet.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE);
		chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		chest.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack leggings = new ItemStack(Material.GOLD_LEGGINGS);
		leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, FEATHER_FALLING);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, SHARPNESS);
		sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, FIRE_ASPECT);
		final ItemStack pot = new ItemStack(Material.POTION, 1, (short)16421);
		final ItemStack bpowder = new ItemStack(Material.BLAZE_POWDER, 32);
		final ItemStack sugar = new ItemStack(Material.SUGAR, 32);
		final ItemStack feather = new ItemStack(Material.FEATHER, 32);
		final ItemStack ironbar = new ItemStack(Material.IRON_INGOT, 32);
		inv.setHelmet(helmet);
		inv.setChestplate(chest);
		inv.setLeggings(leggings);
		inv.setBoots(boots);
		inv.setItem(0, sword);
		inv.setItem(1, new ItemStack(Material.ENDER_PEARL, 16));
		inv.setItem(4, bpowder);
		inv.setItem(5, sugar);
		inv.setItem(6, feather);
		inv.setItem(7, ironbar);
		inv.setItem(8, new ItemStack(FOOD, 64));
		for (int i = 0; i < 35; ++i) {
			inv.addItem(new ItemStack[] { pot });
		}
	}

	public static void giveArcherKit(final Player p) {
		final PlayerInventory inv = p.getInventory();
		inv.clear();
		p.setHealth(20.0);
		p.setFireTicks(0);
		p.setFoodLevel(FOOD_LEVEL);
		p.setSaturation(SATURATION);
		final ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
		helmet.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		helmet.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
		chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		chest.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		leggings.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, FEATHER_FALLING);
		boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, PROTECTION);
		boots.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
		sword.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
		sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, SHARPNESS);
		sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, FIRE_ASPECT);
		final ItemStack bow = new ItemStack(Material.BOW);
		bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, POWER);
		bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, FLAME);
		final ItemStack pot = new ItemStack(Material.POTION, 1, (short)16421);
		inv.setHelmet(helmet);
		inv.setChestplate(chest);
		inv.setLeggings(leggings);
		inv.setBoots(boots);
		inv.setItem(0, sword);
		inv.setItem(1, new ItemStack(Material.ENDER_PEARL, 16));
		inv.setItem(7, new ItemStack(Material.SUGAR, 32));
		inv.setItem(2, bow);
		inv.setItem(8, new ItemStack(FOOD, 64));
		inv.setItem(17, new ItemStack(Material.ARROW, 64));
		for (int i = 0; i < 36; ++i) {
			inv.addItem(new ItemStack[] { pot });
		}
	}

}
