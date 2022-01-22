package com.christmas.devlesson_randomizer;

import com.christmas.devlesson_randomizer.commands.getMemeCommand;
import com.christmas.devlesson_randomizer.commands.reloadCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//meme1: https://cdn.discordapp.com/attachments/777538152394129438/934497296282968114/redditsave.com_i_shidded-useisfqt00d81.mp4
//meme2: https://cdn.discordapp.com/attachments/777538152394129438/934497307947307038/zd6krqj05wc81.jpg
//mem3:https://cdn.discordapp.com/attachments/777538152394129438/934497326658117712/redditsave.com_windows_user_detected-ji4z11uvpuc81.mp4
public final class DevLesson_Randomizer extends JavaPlugin {
    private static DevLesson_Randomizer plugin = null;
    FileConfiguration config = null;
    List<String> memes = new ArrayList<>();
    Integer memecount;
    Random rand = new Random();

    @Override
    public void onEnable() {
        plugin = this;
        config = this.getConfig();

        getCommand("getmeme").setExecutor(new getMemeCommand());
        getCommand("reloadmemes").setExecutor(new reloadCommand());
        // Plugin startup logic
        config.options().copyDefaults();
        saveDefaultConfig();

        memes = config.getStringList("config.memes"); // meme list, so all memes in an arraylist: 'meme1, meme2, etc'
        memecount = memes.size(); // amount of memes in there 3, 2 or 1


    }

    public String getMeme(){
        int randval = rand.nextInt(memecount); //0-memecount ; +1 because nextInt will never generate the max value i give it :(
        // let's say memecount is 5
        // the randomizer would put randval on a scale from 0 to 4
        // returns value of 1 -5 with a +1
        return memes.get(randval);
        

    }
    public static DevLesson_Randomizer getPlugin(){
        return plugin;
    }
    public void setMemes(List<String> memelist){
        memes = memelist;
    }
    public  FileConfiguration getmainConfig(){
        return config;
    }

}
