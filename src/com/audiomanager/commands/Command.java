package com.audiomanager.commands;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by rares on 19.03.2016.
 */
public interface Command {
    void execute();

    void setArgument(String arg);

    String getArgument();
}
