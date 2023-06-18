package org.example.api_object.video;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.example.api_object.ApiObject;

@Getter
@ToString
@EqualsAndHashCode
public class VideoChatEnded implements ApiObject {
    @JsonProperty("duration")
    private Integer duration;

    private VideoChatEnded() {
    }
}
