package com.tidestudios.tidescript.plugin;


public class TestPlugin extends Plugin{
    public TestPlugin(){
        super("TestPlugin");
    }

    @Override
    public void onStart() {
        logger.info("Hello");
        super.onStart();
    }
}
