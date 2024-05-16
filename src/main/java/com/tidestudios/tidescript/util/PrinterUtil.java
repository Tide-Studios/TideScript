package com.tidestudios.tidescript.util;

import com.tidestudios.tidescript.logging.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PrinterUtil{
    private static Logger logger = new Logger("PrinterUtil");
    public static void print(File file){

        try {
            Desktop.getDesktop().print(file);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

}
