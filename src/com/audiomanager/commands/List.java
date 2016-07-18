package com.audiomanager.commands;

import java.io.File;

/**
 * Created by rares on 20.03.2016.
 */
public class List extends AbstractCommand {
    public void execute() {
        File f;
        String[] paths;

        try {
            f = new File(getArgument());
            paths = f.list();
            for (String path : paths) {
                if (path.matches(getAudioFormat())) {
                    System.out.println(path);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid directory.");
        } finally {
            System.out.println("List command ended.");
        }
    }
}
