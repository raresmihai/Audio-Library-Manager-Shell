package com.audiomanager.controller;

import com.audiomanager.commands.*;

/**
 * Created by rares on 20.03.2016.
 */
public class Methods {

    public void list(String argument) {
        AbstractCommand listCmd = new List();
        if (argument.equals(".")) {
            argument = AudioManager.getCurrentDirectory();
        }
        listCmd.setArgument(argument);
        listCmd.execute();
    }

    /**
     * @param argument The new path
     */
    public void cd(String argument) {
        /**
         * if it's a full path change it
         * else add the new path to the current directory
         */
        if (argument.matches("/(.*)")) {
            AudioManager.setCurrentDirectory(argument);
        } else {
            if (AudioManager.getCurrentDirectory().equals("/")) {
                AudioManager.setCurrentDirectory(AudioManager.getCurrentDirectory() + argument);
            } else {
                AudioManager.setCurrentDirectory(AudioManager.getCurrentDirectory() + "/" + argument);
            }
        }

    }

    public void pwd() {
        System.out.println(AudioManager.getCurrentDirectory());
    }

    public void find(String argument) {
        AbstractCommand findCmd = new Find();
        findCmd.setArgument(argument);
        findCmd.execute();
    }

    public void play(String argument) {
        AbstractCommand playCmd = new Play();
        if (!argument.matches("/(.*)")) {
            argument = AudioManager.getCurrentDirectory() + "/" + argument;
        }
        playCmd.setArgument(argument);
        playCmd.execute();
    }

    public void info(String argument) {
        AbstractCommand infoCmd = new Info();
        if (!argument.matches("/(.*)")) {
            argument = AudioManager.getCurrentDirectory() + "/" + argument;
        }
        infoCmd.setArgument(argument);
        infoCmd.execute();
    }

    public void fav(String argument) {
        AbstractCommand favCmd = new Favorite();
        if (!argument.matches("/(.*)")) {
            argument = AudioManager.getCurrentDirectory() + "/" + argument;
        }
        favCmd.setArgument(argument);
        favCmd.execute();
    }

    public void report() {
        AbstractCommand reportCmd = new Report();
        reportCmd.execute();
    }

    public void yt(String argument) {
        AbstractCommand youtubeDownloader = new YoutubeDownloader();
        youtubeDownloader.setArgument(argument);
        youtubeDownloader.execute();
    }
}
