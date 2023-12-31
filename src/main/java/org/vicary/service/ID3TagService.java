package org.vicary.service;

import com.mpatric.mp3agic.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.vicary.model.FileResponse;
import org.vicary.model.ID3TagData;
import org.vicary.service.downloader.DownloaderManager;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ID3TagService {

    private final static Logger logger = LoggerFactory.getLogger(ID3TagService.class);

    private final TerminalExecutor terminalExecutor;

    private final DownloaderManager downloaderManager;

    public FileResponse addID3Tag(FileResponse fileResponse) {
        try {
            ID3TagData id3TagData = fileResponse.getId3TagData();
            File oldFile = fileResponse.getDownloadedFile().getFile();
            if (new Mp3File(oldFile).hasId3v2Tag()) {

                String parentFile = oldFile.getParent();
                String newFileName = id3TagData.getTitle() != null ?
                        downloaderManager.getFileNameFromTitle(id3TagData.getTitle(), "mp3") :
                        oldFile.getName();
                oldFile = terminalExecutor.renameFile(oldFile, oldFile.getName() + ".mp3");
                Mp3File mp3File = new Mp3File(oldFile);
                ID3v2 id3v2Tag;
                id3v2Tag = mp3File.getId3v2Tag();
                id3v2Tag.setTitle(id3TagData.getTitle());
                id3v2Tag.setArtist(id3TagData.getArtist());
                id3v2Tag.setAlbum(id3TagData.getAlbum());
                id3v2Tag.setYear(id3TagData.getReleaseYear());

                mp3File.save(parentFile + "/" + newFileName);
                File newFile = new File(parentFile + "/" + newFileName);
                terminalExecutor.removeFile(oldFile);

                fileResponse.getDownloadedFile().setFile(newFile);
                logger.info("Successfully added IG3v2 tag to file.");
            }
        } catch (IOException | InvalidDataException | UnsupportedTagException | NotSupportedException e) {
            logger.warn("Failed to add ID3Tag to file id '{}'", fileResponse.getServiceId());
        }
        return fileResponse;
    }
}
