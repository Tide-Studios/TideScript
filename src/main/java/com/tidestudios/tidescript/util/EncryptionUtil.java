package com.tidestudios.tidescript.util;

import com.tidestudios.tidescript.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class EncryptionUtil {

    private final Key key;
    private static final int IV_LENGTH = 12;
    private static final int T_LEN = 96;
    Logger logger = new Logger("ENCRYPTION");
    public EncryptionUtil(String pwdKey, String algorithm) {
        final byte[] decodedPwd = Base64.getDecoder().decode(pwdKey);
        this.key = new SecretKeySpec(decodedPwd, algorithm);
    }

public static String generateKey(int length){
        byte[] key = new byte[length];
    try {
        SecureRandom.getInstanceStrong().nextBytes(key);
        return ""+key;
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
    public String encrypt(String text)  {
        byte[] iv = new byte[IV_LENGTH];
        (new SecureRandom()).nextBytes(iv);

        Cipher cipher;
        GCMParameterSpec ivSpec = new GCMParameterSpec(T_LEN, iv);
        byte[] ciphertext;
        try {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
            ciphertext = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException |
                 BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }

        byte[] encrypted = new byte[iv.length + ciphertext.length];
        System.arraycopy(iv, 0, encrypted, 0, iv.length);
        System.arraycopy(ciphertext, 0, encrypted, iv.length, ciphertext.length);

        return Base64.getEncoder().encodeToString(encrypted);
    }
    public String decrypt(String encryptedText) {
        byte[] decoded = Base64.getDecoder().decode(encryptedText);

        byte[] iv = Arrays.copyOfRange(decoded ,0 , IV_LENGTH);

        Cipher cipher;
        byte[] decryptedText;
        GCMParameterSpec ivSpec = new GCMParameterSpec(T_LEN, iv);
        try {
            cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
            decryptedText = cipher.doFinal(Arrays.copyOfRange(decoded, IV_LENGTH, decoded.length));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException |
                 InvalidKeyException | InvalidAlgorithmParameterException e) {
            throw new RuntimeException(e);
        }

        return new String(decryptedText, StandardCharsets.UTF_8);
    }
}
