package com.audiomanager.controller;

import com.audiomanager.data.Song;
import com.audiomanager.exceptions.InvalidCommandException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rares on 19.03.2016.
 */
public class AudioManager {
    static List<Song> favorites = new ArrayList<>();
    static String currentDirectory = "/";

    public static void addFavorite(Song song) {
        favorites.add(song);
    }

    public static List<Song> getFavs() {
        return favorites;
    }

    public static void setCurrentDirectory(String dir) {
        currentDirectory = dir;
    }

    public static String getCurrentDirectory() {
        return currentDirectory;
    }

    boolean commandIsValid(String cmd[]) {
        try {
            if (!cmd[0].matches("list|cd|find|play|info|fav|report|pwd|yt")) {
                throw new InvalidCommandException("The command you entered is invalid!");
            }
        } catch (InvalidCommandException ex) {
            System.out.println("Invalid command name.");
            return false;
        }
        try {
            if ((cmd[0].equals("pwd") || cmd[0].equals("report")) && cmd.length != 1 || (!cmd[0].equals("pwd") && !cmd[0].equals("report")) && cmd.length != 2) {
                throw new InvalidCommandException("Invalid number of arguments");
            }
        } catch (InvalidCommandException ex) {
            if (cmd[0].equals("pwd") || cmd[0].equals("report")) {
                System.out.println("The command has no arguments!");
            } else {
                System.out.println("You must provide one argument to your command.");
            }
            return false;
        }
        return true;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print(AudioManager.getCurrentDirectory() + ":");
            String userInput;
            userInput = sc.nextLine();
            String[] command = userInput.split(" ", 2);
            if (commandIsValid(command)) {
                String methodName = command[0];
                Methods obj = new Methods();
                Method method = null;
                try {
                    if (command.length == 1) {
                        method = obj.getClass().getMethod(methodName);
                    } else {
                        method = obj.getClass().getMethod(methodName, String.class);
                    }
                } catch (NoSuchMethodException e) {
                    System.out.println("The method " + methodName + " doesn't exist.");
                }
                if (method != null) {
                    try {
                        if (command.length == 1) {
                            method.invoke(obj);
                        } else {
                            method.invoke(obj, command[1]);
                        }
                    } catch (IllegalAccessException e) {
                        System.out.println("Invalid access to method.");
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        System.out.println("Invocation Target Exception.");
                    }
                }
            }
        }
    }
}
