package com.tidestudios.logging;


import com.tidestudios.base.TideScript;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Logger {



    public static ArrayList previousLogs = new ArrayList();
    public String name;
    public String currentLoggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/dd/y h:mm:s a"));
    public String FileLoggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M-dd-y-h-mm"));
    public Logger(String name){
        this.name = name;
    }

    public void setCurrentLoggingTime(){
        currentLoggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/dd/y h:mm:s a"));
    }

    public void saveLogs(){
        for(int i=0;i<previousLogs.size();i++){

                System.out.println(TideScript.projectDirectory);
                File file = new File(TideScript.projectDirectory+"/TideScriptLog-"+FileLoggingTime+".txt");

            try {
                Files.write(file.toPath(),previousLogs);
            } catch (IOException e) {
                error(e.getMessage());
            }


        }

    }
    public void trace(Object content){
        setCurrentLoggingTime();
        System.out.println(LoggerColors.WHITE+currentLoggingTime+" ["+name+"] "+"[TRACE] "+content+LoggerColors.RESET);
        addToLogs(currentLoggingTime+" ["+name+"] "+"[TRACE] "+content);
    }
    public void warn(Object content){
        setCurrentLoggingTime();
        System.out.println(LoggerColors.YELLOW+currentLoggingTime+" ["+name+"] "+"[WARN] "+content+LoggerColors.RESET);
        addToLogs(currentLoggingTime+" ["+name+"] "+"[WARN] "+content);
    }
    public static void addToLogs(Object log){
        Logger.previousLogs.add(log);
    }
    public void info(Object content){
        setCurrentLoggingTime();
        System.out.println(LoggerColors.BLUE+currentLoggingTime+" ["+name+"]"+" [INFO] "+content+LoggerColors.RESET);
        addToLogs(currentLoggingTime+" ["+name+"] "+"[INFO] "+content);
    }
    public void error(Object content){
        setCurrentLoggingTime();
        System.out.println(LoggerColors.RED+currentLoggingTime+" ["+name+"]"+" [ERROR] "+content+LoggerColors.RESET);
        addToLogs(currentLoggingTime+" ["+name+"] "+"[ERROR] "+content);
    }
    public void critical(Object content){
        setCurrentLoggingTime();
        System.out.println(LoggerColors.RED+currentLoggingTime+LoggerColors.RED_BACKGROUND+"["+name+"] "+"[CRITICAL]"+content+LoggerColors.RESET);
        addToLogs(currentLoggingTime+" ["+name+"] "+"[CRITICAL] "+content);
    }
    public static class LoggerColors{
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        public static final String RED_BACKGROUND = "\033[41m";    // RED
        public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }


}

