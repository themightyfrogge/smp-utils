package io.github.themightyfrogge;

import org.bukkit.ChatColor;

public class Chat {

    public static String format(String str){
        return ChatColor.translateAlternateColorCodes('*', str);
    }
}
