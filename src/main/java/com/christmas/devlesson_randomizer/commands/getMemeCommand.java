package com.christmas.devlesson_randomizer.commands;

import com.christmas.devlesson_randomizer.DevLesson_Randomizer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getMemeCommand implements CommandExecutor {
    DevLesson_Randomizer mainclass = DevLesson_Randomizer.getPlugin();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("randomizer.getmeme")){
                p.sendMessage(mainclass.getMeme());

            }
        }
        return true;
    }
}
