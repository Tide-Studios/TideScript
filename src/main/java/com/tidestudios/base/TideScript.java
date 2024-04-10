package com.tidestudios.base;

import com.tidestudios.logging.Logger;
import com.tidestudios.ui.Application;
import com.tidestudios.util.XMLParser;
import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class TideScript {
    public static boolean init;
    public static String projectDirectory;
    public Application application = new Application();
    int[] ConfigSettings;
   public Logger logger = new Logger("CORE");
    public TideScript(){

    }
    public void disable(){
        for (int configSetting : ConfigSettings) {
            if (configSetting == 1001) {
                logger.info("Setting [showUI]: disabling");
                application.dispose();

            } else if (configSetting == 1002) {

                logger.info("Saving logs...");
                logger.saveLogs();
                logger.info("Setting [saveLogs]: disabling");
            }
        }
    }
    public void init(int... config){
        if(init){
            logger.warn("TideScript already initialized.");
        }else{
            ConfigSettings = Arrays.stream(config).toArray(); // Converts all the config settings to an  Array
            projectDirectory = System.getProperty("user.dir");
            logger.info("projectDirectory set to: "+projectDirectory);
            logger.info(config);
            // Loops all the config settings
            for (int configSetting : ConfigSettings) {
                if (configSetting == 1001) {
                    logger.info("Setting [showUI]: enabled");
                    application.beginGUI();

                } else if (configSetting == 1002) {
                    logger.info("Setting [saveLogs] enabled");
                }
            }
            init = true;
            logger.info("TideScript fully initialized.");
        }

    }

    /**
     * Installs to a folder destination from the url.
     * @param  urlOrigin  an absolute URL giving the base location of the image
     * @param  folderPath the folder path of the package
     * @return      the image at the specified URL
     */
    public void installToFolder(String urlOrigin,String folderPath){
        try {
            
            FileUtils.copyURLToFile(new URL(urlOrigin),new File(folderPath+"/temp.zip"));

             new ZipFile(folderPath+"/temp.zip").extractAll(folderPath);
             FileUtils.delete(new File(folderPath+"/temp.zip"));
             logger.info("Succesfully installed the package");

        } catch (IOException e) {
          logger.error(e.getMessage());
        }
    }
    /**
     * Installs and updates your files based on .tidescript files
     * @param  configFile  file to download all the packages from
     * @return      the installion
     */
    public void installFromConfig(String configFile) {
        if(configFile.isEmpty()){
            logger.error("Config file path was not set.");
        }else{
            XMLParser xmlParser = new XMLParser();
            try {
                URL fileURL = new File(configFile).toURI().toURL();
                Document document = xmlParser.parser(fileURL);
                XMLParser.parseID(document);
            } catch (DocumentException e) {
               logger.error(e.getMessage());
            } catch (MalformedURLException e) {
               logger.error(e.getMessage());
            }
        }


    }
    public void installToFile(String urlOrigin,String pathname){
        try {

            FileUtils.copyURLToFile(new URL(urlOrigin),new File(pathname));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
