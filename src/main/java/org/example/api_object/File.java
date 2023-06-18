package org.example.api_object;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class File implements ApiObject {
    @JsonProperty("file_id")
    private String fileId;

    @JsonProperty("file_unique_id")
    private String fileUniqueId;

    @JsonProperty("file_size")
    private Integer fileSize;

    @JsonProperty("file_path")
    private String filePath;

    private File() {
    }
}
