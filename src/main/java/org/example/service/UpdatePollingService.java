package org.example.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.example.api_object.Update;
import org.example.api_request.commands.SetMyCommands;
import org.example.service.bot_response.TextResponse;
import org.example.service.bot_response.YoutubeResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePollingService {
    private final RequestService sender;
    private final MessageEntityService messageEntityService;
    private final TextResponse textResponse;
    private final YoutubeResponse youtubeResponse;

    public void updateReceiver(Update update) {
        messageEntityService.save(update);
        System.out.println(update);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(update));

        String text = update.getMessage().getText();

        if (text.startsWith("https://www.youtube.com/watch?v") || text.startsWith("https://youtu.be/"))
            youtubeResponse.response(update);

//        if (text != null && !text.startsWith("/"))
//            textResponse.response(update);
    }
}
