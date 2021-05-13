import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;

import java.io.FileNotFoundException;
import java.util.*;

public class BasedBot {

    public static void main(String[] args) throws FileNotFoundException {

        Keywords keywords = new Keywords();
        ArrayList<String> keywordList = keywords.getKeywords();

        final DiscordClient client = DiscordClient.create("TOKEN");
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            List<String> msgAsList = Arrays.asList(message.getContent().toLowerCase(Locale.ROOT).split("\\s+"));
            System.out.println("disjoint function: " + Collections.disjoint(msgAsList, keywordList));

            User user = new User(gateway, message.getUserData());
            if(!user.isBot()) {
                if (!Collections.disjoint(msgAsList, keywordList)) {
                    final MessageChannel channel = message.getChannel().block();
                    channel.createMessage("Based.").block();
                }
            }
        });

        gateway.onDisconnect().block();
    }
}

