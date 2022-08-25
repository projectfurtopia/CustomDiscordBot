package io.github.projectfurtopia.bot.main;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

import io.github.projectfurtopia.bot.commands.EventPingReasign;

public class LaunchBot {

	public static void main(String[] args) {
		DiscordApi bot = new DiscordApiBuilder().setToken(args[0]).setAllIntents().login().join();
		bot.updateActivity(ActivityType.WATCHING, "For Slash Commands");
		bot.addMessageCreateListener(new EventPingReasign());
		System.out.println("Bot has connected to discord!\nYou can invite the bot by using the following url: https://discord.com/api/oauth2/authorize?client_id="+bot.getClientId()+"&permissions=8&scope=bot%20applications.commands");
	}

}
