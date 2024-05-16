package com.tidestudios.tidescript.core;



public class Config {
    /**
     * This setting tells TideScript to save logs on TideScript shutdown
     */
    public static final int saveLogs = 1001;
    /**
     * This setting tells TideScript to encrypt logs on TideScript shutdown
     * @apiNote Must have saveLogs enabled for this setting to work
     */
    public static final int encryptedLogs = 1002;
    /**
     * Tells if you want plugins in TideScript
     */
    public static final int plugins= 1003;

    public static String EncryptionKey;

}
