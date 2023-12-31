package org.vicary.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FileInfo {
    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("duration")
    private double duration;

    @SerializedName("artist")
    private String artist;

    @SerializedName("track")
    private String track;

    @SerializedName("album")
    private String album;

    @SerializedName("release_year")
    private String releaseYear;

    @SerializedName("uploader_url")
    private String uploaderURL;

    @SerializedName("is_live")
    private boolean isLive;

    @SerializedName("webpage_url")
    private String URL;

    @SerializedName("format")
    private String format;

    @SerializedName("thumbnails")
    private List<FileInfoThumbnail> thumbnails;

    public int getDuration() {
        return (int) Math.round(duration);
    }
}
