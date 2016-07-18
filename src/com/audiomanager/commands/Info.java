package com.audiomanager.commands;

import java.util.ArrayList;

import com.audiomanager.data.MetadataExtractor;
import org.apache.tika.metadata.Metadata;

/**
 * Created by rares on 20.03.2016.
 */
public class Info extends AbstractCommand {

    public void execute() {
        MetadataExtractor metadataExtractor = new MetadataExtractor();
        Metadata metadata = metadataExtractor.extract(arg);
        String[] metadataNames = metadata.names();

        for (String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }
}
