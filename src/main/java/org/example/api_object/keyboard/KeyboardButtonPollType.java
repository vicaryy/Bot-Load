package org.example.api_object.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.example.api_object.ApiObject;

@Getter
@ToString
@EqualsAndHashCode
public class KeyboardButtonPollType implements ApiObject {
    @JsonProperty("type")
    private String type;

    private KeyboardButtonPollType() {
    }
}
