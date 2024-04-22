package com.tidestudios.tidescript.core;

import com.tidestudios.tidescript.logging.Logger;

import java.util.Arrays;

public class TideScript {
    public static boolean initialized;
    public static String projectDirectory;

    int[] ConfigSettings;
   public Logger logger = new Logger("CORE");
    public TideScript(){

    }
    public void disable(){
        if(TideScript.initialized){
            for (int configSetting : ConfigSettings) {
                 if (configSetting == 1002) {

                    logger.info("Saving logs...");
                    logger.saveLogs();
                    logger.info("Setting [saveLogs]: disabling");
                }
            }
        }
        logger.info("[TideGuard] Disabled");

    }
    public void initialize(int... config){
        if(initialized){
            logger.warn("TideScript already initialized.");
        }else{
            ConfigSettings = Arrays.stream(config).toArray(); // Converts all the config settings to an  Array
            projectDirectory = System.getProperty("user.dir");
            logger.info("projectDirectory set to: "+projectDirectory);
            // Loops all the config settings
            for (int configSetting : ConfigSettings) {
                 if (configSetting == 1002) {
                    logger.info("Setting [saveLogs] enabled");
                }
            }
            initialized = true;
            logger.info("TideScript fully initialized.");
        }

    }
}
