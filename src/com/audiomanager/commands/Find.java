package com.audiomanager.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.audiomanager.controller.AudioManager;

/**
 * Created by rares on 20.03.2016.
 */
public class Find extends AbstractCommand {

    public void execute() {
        Finder fileVisitor = new Finder(getArgument());
        Path fileDir = Paths.get(AudioManager.getCurrentDirectory());
        try {
            Files.walkFileTree(fileDir, fileVisitor);
        } catch (IOException e) {
            System.out.println("Invalid path");
        } finally {
            System.out.println("Find command ended.");
        }
    }
}
