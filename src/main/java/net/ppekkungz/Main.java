package net.ppekkungz;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.ppekkungz.commands.*;
import net.ppekkungz.commands.music.*;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(Dotenv.load().get("TOKEN")).build();
        jda.getPresence().setActivity(Activity.watching("https://dimension-studio.online"));
        jda.addEventListener(new Listeners());

        CommandManager manager = new CommandManager();
        manager.add(new Sum());
        manager.add(new Embed());
//        manager.add(new Buttons());
//        manager.add(new Modals());
//        manager.add(new Mute());
//        manager.add(new Staff());
//        manager.add(new UnStaff());
//        manager.add(new Unmute());
        manager.add(new Play());
        manager.add(new Skip());
        manager.add(new Stop());
        manager.add(new NowPlaying());
        manager.add(new Queue());
        manager.add(new Repeat());
        jda.addEventListener(manager);
    }
}