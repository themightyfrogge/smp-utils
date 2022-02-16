package io.github.themightyfrogge.data;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerData {

    public void makePlayerData(Player player){
        File file = new File("./plugins/SMP-Utils/playerdata/" + player.getUniqueId().toString() + ".yml");
        if(file.exists()) return;
        else{
            try {
                file.mkdirs();
                file.createNewFile();
                Configuration config = YamlConfiguration.loadConfiguration(file);

                //Placeholders for now.
                config.set("kills", 0);
                config.set("status", null);
                config.set("warnings", 0);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }
}
