package io.github.projectfurtopia.bot.commands;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
public class EventPingReasign  implements MessageCreateListener{
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if (event.getMessageContent().equalsIgnoreCase(".eventpingrefresh")) {
			if (event.getMessage().getAuthor().isServerAdmin()) {
				//System.exit(0);
				Server server = event.getServer().orElse(null);
				Role evPing = server.getRoleById("1012437482400399391").orElse(null);
				server.getMembers().forEach(user -> user.addRole(evPing).join());
				event.getChannel().sendMessage("done");
			}
			else event.getChannel().sendMessage("You don't have admin, and therefore cannot run this command.");
		}
	}
}
