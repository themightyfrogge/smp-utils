package io.github.themightyfrogge.commands.manager;

import io.github.themightyfrogge.Main;
import org.bukkit.command.CommandSender;

public abstract class CommandModule {

    public String label;
    public int minArgs;
    public int maxArgs;

    /**
     * @param label - The label of the command.
     * @param minArgs - The minimum amount of arguments.
     * @param maxArgs - The maximum amount of arguments.
     */
    public CommandModule(String label, int minArgs, int maxArgs)
    {
        this.label = label;
        this.minArgs = minArgs;
        this.maxArgs = maxArgs;

        Main.instance.getCommand(label).setExecutor(new CmdExecutor());
        Main.commands.put(label, this);
    }

    //This method will process the command.
    public abstract void run(CommandSender sender, String[] args);

}
