import com.tidestudios.base.Config;
import com.tidestudios.base.TideScript;

public class Main{


    public static void main(String args[])  {

        TideScript tideScript = new TideScript();
      tideScript.init(Config.showUI,Config.saveLogs);
      tideScript.disable();

    }
}
