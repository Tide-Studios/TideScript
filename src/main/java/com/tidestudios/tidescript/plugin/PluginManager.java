package com.tidestudios.tidescript.plugin;

import java.util.ArrayList;

public class PluginManager {
    /**
     * Contains all the plugins that TideScript can use
     * @apiNote Prevents unsafe injection
     */
    private static final ArrayList<Plugin> pluginsContainer = new ArrayList();
    /**
     * Executes plugin from the pluginContainer
     */
    public void executePlugins(){
        for (Plugin plugin : pluginsContainer) {
            plugin.enable();
        }
    }

    public void addPlugin(Plugin plugin){
        pluginsContainer.add(plugin);
    }
}
