import com.tidestudios.tidescript.core.Config;
import com.tidestudios.tidescript.core.TideScript;

public class Main{


    public static void main(String[] args)  {
        Config.EncryptionKey = "f9p8LTSn9rASu6ssOdbsOMb2tFRgt5zT";

       TideScript tideScript = new TideScript(Config.saveLogs,Config.plugins);


       tideScript.logger.critical("Hello");
       tideScript.disable();
    }
}
