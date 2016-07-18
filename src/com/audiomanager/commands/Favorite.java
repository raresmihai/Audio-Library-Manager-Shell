package com.audiomanager.commands;

import com.audiomanager.data.MetadataExtractor;
import com.audiomanager.data.Song;
import org.apache.tika.metadata.Metadata;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by rares on 20.03.2016.
 */
public class Favorite extends AbstractCommand implements java.io.Serializable {
    public void execute() {
        if (!arg.matches(getAudioFormat())) {
            System.out.println("Invalid file!");
        } else {
            MetadataExtractor metadataExtractor = new MetadataExtractor();
            Metadata metadata = metadataExtractor.extract(arg);
            String title = metadata.get("title");
            String author = metadata.get("Author");
            String album = metadata.get("xmpDM:album");
            String duration = metadata.get("xmpDM:duration");
            String genre = metadata.get("xmpDM:genre");
            Song song = new Song(title, author, album, duration, genre);

            java.util.List<Song> favs = new ArrayList<>();
            File file = new File("favorites");
            boolean songNotInFav = true;
            if (file.length() > 0) {
                try {
                    FileInputStream fileIn = new FileInputStream("favorites");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    favs = (java.util.List<Song>) in.readObject();
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    System.out.println("Error at deserialization!");
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("Song class not found");
                    return;
                }

                for (Song favSong : favs) {
                    if (favSong.getSongName().equals(song.getSongName())) {
                        songNotInFav = false;
                    }
                }
            }

            if (songNotInFav) {
                favs.add(song);
                try {
                    FileOutputStream fileOut =
                            new FileOutputStream("favorites");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(favs);
                    out.close();
                    fileOut.close();
                    System.out.println("Updated favorites list");
                } catch (IOException i) {
                    System.out.println("Error when serializing object.");
                }
            } else {
                System.out.println("Song already in your favorites list!");
            }
        }
    }
}

