package org.golde.bukkit.redhcf;

import java.util.ArrayList;
import java.util.List;

public class ColorFormatter {

	public static String[] color(String... chat) {
		List<String> newString = new ArrayList<String>();
		for(String c:chat) {
			c = doColoring(c);
			newString.add(c);
		}
		return newString.toArray(new String[0]);
	}
	
	public static String color(String chat) {
		return doColoring(chat);
	}
	
	private static String doColoring(String s) { //bad way of doing it but oh well.
		s = s.replace("&0", "§0");
		s = s.replace("&1", "§1");
		s = s.replace("&2", "§2");
		s = s.replace("&3", "§3");
		s = s.replace("&4", "§4");
		s = s.replace("&5", "§5");
		s = s.replace("&6", "§6");
		s = s.replace("&7", "§7");
		s = s.replace("&8", "§8");
		s = s.replace("&9", "§9");
		
		s = s.replace("&a", "§a");
		s = s.replace("&b", "§b");
		s = s.replace("&c", "§c");
		s = s.replace("&d", "§d");
		s = s.replace("&e", "§e");
		s = s.replace("&f", "§f");
		
		s = s.replace("&l", "§l");
		s = s.replace("&m", "§m");
		s = s.replace("&n", "§n");
		s = s.replace("&o", "§o");
		s = s.replace("&k", "§k");
		s = s.replace("&r", "§r");
		
		return s;
	}
	
}
