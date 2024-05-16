package com.tidestudios.tidescript.logging;


import com.tidestudios.tidescript.core.Config;
import com.tidestudios.tidescript.core.TideScript;
import com.tidestudios.tidescript.util.ColorUtil;
import com.tidestudios.tidescript.util.FileUtils;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



public class Logger {



    public static ArrayList previousLogs = new ArrayList();
    public String name;
    private SecretKey secretKey;
    public String currentLoggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/dd/y h:mm:s a"));
    public String FileLoggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M-dd-y-h-mm"));
    public Logger(String name){
        this.name = name;
    }

    public void setCurrentLoggingTime(){
        currentLoggingTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/dd/y h:mm:ss a"));
    }


    /**
     * Generates the a .txt file containing all the logs
     */
  @Test

    public void saveLogs(){
        if(TideScript.isInitialized()){
            File file = new File(TideScript.projectDirectory+"/TideScriptLog-"+FileLoggingTime+".txt");
            for(int i=0;i<previousLogs.size();i++){
                try {
                    if(TideScript.ConfigSettings.contains(Config.encryptedLogs)){

                    }else{

                        Files.write(file.toPath(),previousLogs);
                    }

                    //   Files.write(file.toPath(),previousLogs);
                } catch (IOException e) {
                    error(e.getMessage());
                }

            }
        }


    }
    public void trace(Object content){
            setCurrentLoggingTime();
            System.out.println(ColorUtil.ConsoleColors.WHITE+currentLoggingTime+" ["+name+"] "+"[TRACE] "+content+ColorUtil.ConsoleColors.RESET);
            addToLogs(currentLoggingTime+" ["+name+"] "+"[TRACE] "+content);


    }
    public void warn(Object content){

        setCurrentLoggingTime();
        System.out.println(ColorUtil.ConsoleColors.YELLOW+currentLoggingTime+" ["+name+"] "+"[WARN] "+content+ColorUtil.ConsoleColors.RESET);
        addToLogs(currentLoggingTime+" ["+name+"] "+"[WARN] "+content);
    }
    public static void addToLogs(Object log){
            Logger.previousLogs.add(log);


    }
    public void info(Object content){

            setCurrentLoggingTime();
            System.out.println(ColorUtil.ConsoleColors.BLUE+currentLoggingTime+" ["+name+"]"+" [INFO] "+content+ ColorUtil.ConsoleColors.RESET);
            addToLogs(currentLoggingTime+" ["+name+"] "+"[INFO] "+content);

    }
    public void error(Object content){

            setCurrentLoggingTime();
            System.out.println(ColorUtil.ConsoleColors.RED+currentLoggingTime+" ["+name+"]"+" [ERROR] "+content+ColorUtil.ConsoleColors.RESET);
            addToLogs(currentLoggingTime+" ["+name+"] "+"[ERROR] "+content);

    }
    public void critical(Object content){

            setCurrentLoggingTime();
            System.out.println(ColorUtil.ConsoleColors.RED_BOLD+currentLoggingTime+" ["+name+"] "+"[CRITICAL]"+content+ ColorUtil.ConsoleColors.RESET);
            addToLogs(currentLoggingTime+" ["+name+"] "+"[CRITICAL] "+content);


    }
    /**
    * @param logType The type of log is being printed
     *
    **/
    public void customLog(String logType, ColorUtil.ConsoleColors color, Object content, ColorUtil.ConsoleColors... extracolors){

            setCurrentLoggingTime();
            System.out.println(color+currentLoggingTime+extracolors+"["+name+"]"+"["+logType+"]"+content+ ColorUtil.ConsoleColors.RESET);
            addToLogs(currentLoggingTime+"["+name+"]"+logType+content);

    }

    }