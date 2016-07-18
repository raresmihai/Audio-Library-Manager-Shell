package com.audiomanager.commands;

import java.io.*;

import com.audiomanager.data.Song;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

/**
 * Created by rares on 20.03.2016.
 */
public class Report extends AbstractCommand {

    public void execute() {
        java.util.List<Song> favs = null;
        try {
            FileInputStream fileIn = new FileInputStream("favorites");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            favs = (java.util.List<Song>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("Error at deserialization!");
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Song class not found");
            return;
        }

        if (favs != null) {
            VelocityEngine ve = new VelocityEngine();
            ve.init();
            Template t = ve.getTemplate("report.vm");
            VelocityContext context = new VelocityContext();
            context.put("songList", favs);
            StringWriter writer = new StringWriter();
            t.merge(context, writer);

            try (PrintStream out = new PrintStream(new FileOutputStream("report.xml"))) {
                out.print(writer.toString());
                System.out.println("Report created!");
            } catch (FileNotFoundException e) {
                System.out.println("report.xml not found!");
            }
        }
    }
}
