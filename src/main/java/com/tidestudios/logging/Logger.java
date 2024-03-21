package com.tidestudios.logging;



import java.sql.Time;
import java.util.ArrayList;


public class Logger {

    public static ArrayList previousLogs = new ArrayList();
    public static ArrayList previousLogsType = new ArrayList();
    public static  ArrayList previousLogName = new ArrayList();

    public static int consoleLogged = 0;
    public static int logs;
    public String name;



    /*Types
    1 = Trace
    2 = Debug
    3 = Info
    4 = Error
    5 = Fatal
    */
    public Logger(String name){
        this.name = name;
    }

    public void consoleLog(String content, int type){

        if(type == 1){
            previousLogs.add(content);
            previousLogsType.add("TRACE");
            previousLogName.add(name);
        }else if(type == 2){
            previousLogs.add(content);
            previousLogsType.add("DEBUG");
            previousLogName.add(name);

        }else if(type == 3){
            previousLogs.add(content);
            previousLogsType.add("INFO");
            previousLogName.add(name);
        }else if(type == 4){
            previousLogs.add(content);
            previousLogsType.add("ERROR");
            previousLogName.add(name);
        }else if(type == 5){
            previousLogs.add(content);
            previousLogsType.add("FATAL");
            previousLogName.add(name);
        }
        consoleLogged++;

    }
    public void trace(String content){
        System.out.println(LoggerColors.WHITE+"["+name+"] "+"[TRACE] "+content+LoggerColors.RESET);
    }
    public void warn(String content){
        System.out.println(LoggerColors.YELLOW+"["+name+"] "+"[WARN] "+content+LoggerColors.RESET);
    }
    public void info(String content){
        System.out.println(LoggerColors.BLUE+"["+name+"]"+" [INFO] "+content+LoggerColors.RESET);
    }
    public void error(String content){
        System.out.println(LoggerColors.RED+"["+name+"]"+" [ERROR] "+content+LoggerColors.RESET);
    }
    public void critical(String content){

        System.out.println(LoggerColors.RED+LoggerColors.RED_BACKGROUND+"["+name+"] "+"[CRITICAL]"+content+LoggerColors.RESET);
    }



}

