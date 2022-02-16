package io.github.themightyfrogge;

import io.github.themightyfrogge.commands.Help;
import io.github.themightyfrogge.commands.manager.CommandModule;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin {

    public static Main instance;
    public static HashMap<String, CommandModule> commands;

    public void onEnable(){
        instance = this;
        commands = new HashMap<String, CommandModule>();
        registerCommands();
    }

    public void onDisable(){
        instance = null;
        commands.clear();
    }

    private void registerCommands() {
        new Help();
    }
}
