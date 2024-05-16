package com.tidestudios.tidescript.core;

import com.tidestudios.tidescript.logging.Logger;
import com.tidestudios.tidescript.plugin.PluginManager;
import com.tidestudios.tidescript.util.EncryptionUtil;

import java.util.ArrayList;

public class TideScript {


    public static boolean initialized;
    public static String projectDirectory;
    public static EncryptionUtil encryptionUtil;
    public static ArrayList ConfigSettings = new ArrayList(); // ConfigSettings

    public PluginManager pluginManager = new PluginManager(); // PluginManager
   public Logger logger = new Logger("CORE");;

    /**
     * @param config
     */
    public TideScript(int... config){


        if(initialized){
            logger.warn("TideScript already initialized.");
        }else{
            for(int i=0;i<config.length;i++){
                ConfigSettings.add(config[i]);
            }
            if(ConfigSettings.contains(Config.plugins)){
                logger.info("Setting [plugins]: enabled");
            }
            if(ConfigSettings.contains(Config.saveLogs)){
                logger.info("Setting [saveLogs]: enabled");
            }
            if(ConfigSettings.contains(Config.encryptedLogs)){
               encryptionUtil = new EncryptionUtil(Config.EncryptionKey,"AES");
            }
            projectDirectory = System.getProperty("user.dir");
            logger.info("projectDirectory set to: "+projectDirectory);
            // Loops all the config settings
            initialized = true;

            logger.info("TideScript fully initialized.");
        }
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public void disable(){
        if(TideScript.initialized){
            if(TideScript.ConfigSettings.contains(Config.saveLogs)){
                logger.saveLogs();
            }
        }
        logger.info("[TideGuard] Disabled");

    }

}
