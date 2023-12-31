package org.vicary.api_object.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.vicary.api_object.ApiObject;
import org.vicary.api_object.games.CallbackGame;
import org.vicary.api_object.other.LoginUrl;
import org.vicary.api_object.chat.SwitchInlineQueryChosenChat;
import org.vicary.api_object.other.WebAppInfo;

@Getter
@ToString
@EqualsAndHashCode
public class InlineKeyboardButton implements ApiObject {
    @JsonProperty("text")
    private String text;

    @JsonProperty("url")
    private String url;

    @JsonProperty("callback_data")
    private String callbackData;

    @JsonProperty("web_app")
    private WebAppInfo webApp;

    @JsonProperty("login_url")
    private LoginUrl loginUrl;

    @JsonProperty("switch_inline_query")
    private String switchInlineQuery;

    @JsonProperty("switch_inline_query_current_chat")
    private String switchInlineQueryCurrentChat;

    @JsonProperty("switch_inline_query_chosen_chat")
    private SwitchInlineQueryChosenChat switchInlineQueryChosenChat;

    @JsonProperty("callback_game")
    private CallbackGame callbackGame;

    @JsonProperty("pay")
    private Boolean pay;

    private InlineKeyboardButton() {
    }
}
