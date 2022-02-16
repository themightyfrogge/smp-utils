package io.github.themightyfrogge.commands.manager;

import io.github.themightyfrogge.Chat;
import io.github.themightyfrogge.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdExecutor implements CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandModule module = Main.commands.get(label);
        if (Main.commands.containsKey(label)) {
            if (args.length >= module.minArgs && args.length <= module.maxArgs) {
                module.run(sender, args);
            } else {
                sender.sendMessage(Chat.format("*cCommand must be either larger than *n" + module.minArgs + "*c or smaller than *n" + module.maxArgs + "*c!"));
            }
        }
        return false;
    }
}