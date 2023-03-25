package com.example.seleniumassignment;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class URLDownloader {

    public static void main(String[] args) {
        String url = "https://nuflex.northeastern.edu/wp-content/uploads/2020/11/Hybrid_Nuflex_Classroom.pdf#_ga=2.180167276.990139895.1679725768-131279991.1679725763";

        try {
            downloadUsingNIO(url, "/Users/haotian/Downloads/downloaded.pdf");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
