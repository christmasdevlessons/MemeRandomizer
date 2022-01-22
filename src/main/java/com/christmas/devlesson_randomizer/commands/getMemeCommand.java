package com.christmas.devlesson_randomizer.commands;

import com.christmas.devlesson_randomizer.DevLesson_Randomizer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
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

                TextComponent message = new TextComponent("Click here to get a Meme!");
                message.setFont("minecraft:default");
                message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click me!")));
                message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, mainclass.getMeme()));
                p.spigot().sendMessage(message);

            }
        }
        return true;
    }
}
