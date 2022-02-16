package io.github.themightyfrogge.commands;

import io.github.themightyfrogge.Chat;
import io.github.themightyfrogge.Main;
import io.github.themightyfrogge.commands.manager.CommandModule;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Help extends CommandModule {

    Plugin plugin = new Main();

    public Help(){
        super("smputils", 0, 0);
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if(args.length == 0){
            sender.sendMessage(Chat.format(
                    "*7----- *2*lfHelp *2Index *7-----\n"
                        + "*2/smputils &7| *fShows the Help Index\n"
                        + "*2/smputils *ainfo *7| *fSome information about this plugin."
                        + "*2/smputils *agrace &7| *fGrace period feature."
            ));
            if(!(sender instanceof Player) || sender.hasPermission("smputils.admin")){
                sender.sendMessage(Chat.format(
                        "*7----- *c*lAdministrator *cIndex *7-----\n"
                            + "*2/smputils *agrace [d/hh/mm] *7| *fSet-up a grace period.\n"
                            + "*fEXAMPLE -> /smputils grace 13h\n"
                            + "*2/smputils *aannounce [message] *7| *fAnnounces a message in a cool look."
                            + "*fEXAMPLE -> /smputils announce your mother."

                ));
            }
        }else if(args.length > 0){
            if(args.length == 1){
                switch (args[0].toLowerCase()){
                    case "info":
                        sender.sendMessage(Chat.format(
                                "*2*lSMP Utils&f, A plugin that makes managing SMPs easier.\n"
                                    + "*bVersion: *e" + plugin.getDescription().getVersion() +  "*b, Running on: *e" + Bukkit.getBukkitVersion()));
                        break;
                }
            }else if(args.length > 2){
                if(args[0].equalsIgnoreCase("grace") &&
                        args[2].equalsIgnoreCase("minute") || args[2].equalsIgnoreCase("hour") || args[2].equalsIgnoreCase("day")){
                    if(isInt(args[1])){
                        sender.sendMessage(Chat.format("*aGrace period started with a time of *e" + args[2] + args[1] + "(s)*a!"));
                    }else{
                        sender.sendMessage(Chat.format("*cTime needs to be a number fish head."));
                    }
                }
            }
        }
    }
}
