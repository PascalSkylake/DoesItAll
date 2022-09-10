package dev.pascan.commands.music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeAudioSourceManager;
import dev.pascan.Constants;
import org.javacord.api.audio.AudioConnection;
import org.javacord.api.audio.AudioSource;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class AudioManagerCommand implements MessageCreateListener {
    AudioManager manager;
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        /*
        if (event.getMessageContent().startsWith(Constants.prefix + "play") || event.getMessageContent().startsWith("!p")) {
            new Play(event);
        } else if (event.getMessageContent().startsWith("!skip") || event.getMessageContent().startsWith("!s")) {
            new Skip(event);
        } else if (event.getMessageContent().startsWith("!stop") || event.getMessageContent().startsWith("!st")) {
            new Stop(event);
        } else if (event.getMessageContent().startsWith("!pause") || event.getMessageContent().startsWith("!pa")) {
            new Pause(event);
        } else if (event.getMessageContent().startsWith("!resume")) {
            new Resume(event);
        } else if (event.getMessageContent().startsWith("!pn")) {
            new PlayNow(event);
        } else if (event.getMessageContent().startsWith("!queue") || event.getMessageContent().startsWith("!q")) {
            new Queue(event);
        } else if (event.getMessageContent().startsWith("!volume")) {
            new Volume(event);
        } else if (event.getMessageContent().startsWith("!np")) {
            new NowPlaying(event);
        } else if (event.getMessageContent().startsWith("!loop")) {
            new Loop(event);
        } else if (event.getMessageContent().startsWith("fs")) {
            new ForceSkip(event);
        } else {
            new MusicHelp(event);
        }

         */
    }

    public void closeConnection(Server server) {
        for (ServerVoiceChannel channel : server.getVoiceChannels()) {
            if (channel.isConnected(server.getApi().getClientId())) {
                channel.disconnect();
                return;
            }
        }
    }

    public AudioConnection connectToChannel(MessageCreateEvent event) {
        for (ServerVoiceChannel channel : event.getServer().get().getVoiceChannels()) {
            if (channel.isConnected(event.getMessageAuthor().getId())) {
                channel.connect().thenAccept(audioConnection -> {

                });
            }
        }
        event.getMessage().reply("You are not connected to a voice channel.");
        return null;
    }
}
