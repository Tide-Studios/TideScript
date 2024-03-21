import com.tidestudios.base.TideScript;
import com.tidestudios.util.XMLParser;
import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String args[])  {
        TideScript tideScript = new TideScript();
        tideScript.init();
        tideScript.installFromConfig("");

      //  tideScript.installFromConfig("");
    }
}
