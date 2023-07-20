package org.example.api_request.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.api_object.User;
import org.example.api_object.chat.chat_member.ChatMember;
import org.example.api_request.ApiRequestList;
import org.example.end_point.EndPoint;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Builder
public class GetChatAdministrators implements ApiRequestList<ChatMember> {
    /**
     * Use this method to get a list of administrators in a chat, which aren't bots.
     *
     * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channelusername)
     */
    @NonNull
    @JsonProperty("chat_id")
    private String chatId;

    @Override
    public ChatMember getReturnObject() {

        //TODO - WILL NOT WORK CUH

        return new ChatMember() {
            @Override
            public String getStatus() {
                return null;
            }

            @Override
            public User getUser() {
                return null;
            }
        };
    }

    @Override
    public String getEndPoint() {
        return EndPoint.GET_CHAT_ADMINISTRATORS.getPath();
    }

    @Override
    public void checkValidation() {
        if (chatId.isEmpty()) throw new IllegalArgumentException("chatId cannot be empty.");
    }
}
