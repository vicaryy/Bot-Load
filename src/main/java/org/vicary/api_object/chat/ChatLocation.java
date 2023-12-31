package org.vicary.api_object.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.vicary.api_object.ApiObject;
import org.vicary.api_object.Location;

@Getter
@ToString
@EqualsAndHashCode
public class ChatLocation implements ApiObject {
    @JsonProperty("location")
    private Location location;

    @JsonProperty("address")
    private String address;

    private ChatLocation() {
    }
}
