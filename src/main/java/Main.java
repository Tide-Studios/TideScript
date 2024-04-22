import com.tidestudios.tidescript.core.Config;
import com.tidestudios.tidescript.core.TideScript;

public class Main{


    public static void main(String[] args)  {
        TideScript tideScript = new TideScript();
        tideScript.initialize();
        int runs = 100 * 1000;
        long start = System.nanoTime();
        for(int i=0;i< runs;i++)
            tideScript.logger.info("Hello World! "+i);
        long time = System.nanoTime() - start;
        System.out.printf("Average log time was %,d ns%n", time/runs);

    }
}
