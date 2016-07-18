package com.audiomanager.commands;

import com.github.axet.vget.AppManagedDownload;

/**
 * Created by rares on 24.03.2016.
 */
public class YoutubeDownloader extends AbstractCommand{
    public void execute() {
        AppManagedDownload.main(new String[] {arg,""});
    }
}
