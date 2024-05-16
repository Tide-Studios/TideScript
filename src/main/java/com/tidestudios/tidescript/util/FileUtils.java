package com.tidestudios.tidescript.util;

import com.tidestudios.tidescript.logging.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileUtils {
    private static Logger logger = new Logger("FileUtils");
    public static void writeStringToFile(String content, File file){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file); // Creates a file outputStream
            fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8)); // Writes content to a file with
            fileOutputStream.close(); // Closes the stream
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static void writeArrayListToFile(ArrayList list, File file){
            try{
                FileOutputStream fileOutputStream = new FileOutputStream(file); // Creates a outputStream
                byte[] newLine = "\n".getBytes(StandardCharsets.UTF_8); // Creates a new line to bytes in UTF_8
                for(int i=0;i<list.size();i++){
                    fileOutputStream.write(list.get(i).toString().getBytes(StandardCharsets.UTF_8)); // Gets the byte of the String from the ArrayList in UTF_8
                    fileOutputStream.write(newLine);
                }
                fileOutputStream.close();
            }catch (IOException e){

            }
    }
}
