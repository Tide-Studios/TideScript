package com.tidestudios.base;

import com.tidestudios.logging.Logger;

import com.tidestudios.util.XMLParser;
import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

public class TideScript {
    public static boolean init;
   public Logger logger = new Logger("CORE");
    public TideScript(){

    }
    public void init(){
        if(init){
            logger.warn("Tidescript already initialized.");
        }else{
            init = true;
            logger.info("Tidescript initialized");
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
        XMLParser xmlParser = new XMLParser();
        try {
            URL fileURL = new File(configFile).toURI().toURL();
            Document document = xmlParser.parser(fileURL);
            XMLParser.parseID(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
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
