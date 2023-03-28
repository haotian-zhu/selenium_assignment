package com.example.seleniumassignment;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class URLDownloader {

    public static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    public static void downloadURL(String urlString, String fileName) throws IOException {
        URL url = new URL(urlString);
        try (InputStream inp = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(inp);
             FileOutputStream fops = new FileOutputStream(fileName)){

            byte[] d = new byte[1024];
            int i;
            while ((i = bis.read(d, 0, 1024)) != -1){
                fops.write(d, 0, i);
            }
        }
    }

}
