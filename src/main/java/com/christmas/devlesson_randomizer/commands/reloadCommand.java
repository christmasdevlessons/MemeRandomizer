package com.christmas.devlesson_randomizer.commands;

import com.christmas.devlesson_randomizer.DevLesson_Randomizer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class reloadCommand implements CommandExecutor {
    DevLesson_Randomizer mainclass = DevLesson_Randomizer.getPlugin();
    FileConfiguration config = mainclass.getmainConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("randomizer.reload")){
                // reload thing code stuff yes E
                mainclass.reloadConfig();
                mainclass.setMemes(config.getStringList("config.memes"));

            }
        }else{
            mainclass.setMemes(config.getStringList("config.memes"));
        }
        return true;
    }
}
