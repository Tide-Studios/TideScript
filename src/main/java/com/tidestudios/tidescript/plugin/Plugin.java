package com.tidestudios.tidescript.plugin;

import com.tidestudios.tidescript.logging.Logger;

public class Plugin {
    // Name of Plugin
    public String name;
    // Plugin logger
    public Logger logger;

    /**
     * Initialized
     */
    public boolean initialized;

    /**
     * Creates a new plugin in TideScript
     * @param name The name of the Plugin
     */
    public Plugin(String name){
        this.name = name;
        logger = new Logger(name);
        enable();
        onStart();
    }

    /**
     * Executes when the plugin starts up
     */
    public void onStart(){
        if(initialized){
            logger.info("Plugin started:"+name);
        }

    }

    /**
     * Enables the plugins
     */
    public void enable(){
        initialized = true;
    }

    /**
     * Disables the plugin
     */
    public void disable(){
        if(initialized == true){
            logger.info("Plugin disabled:"+name);
            initialized = false;
        }else{
            logger.error("Plugin: "+name+" is already disabled.");
        }
    }

    public enum PluginState {
        /**
         * If the plugin is enabled
         */
        ENABLED,
        /**
         * If the plugin is disabled
         */
        DISABLED
    }
}
