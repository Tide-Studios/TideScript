import com.tidestudios.tidescript.core.Config;
import com.tidestudios.tidescript.core.TideScript;

public class Main{


    public static void main(String[] args)  {
       TideScript tideScript = new TideScript(Config.saveLogs,Config.plugins);


       tideScript.logger.critical("Hello");
       tideScript.disable();
    }
}
