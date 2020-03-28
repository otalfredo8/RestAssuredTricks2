package utilities;

import builders.PojoCredentials;
import org.apache.commons.lang3.RandomStringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import java.util.Random;

public class JavaUtilFunctions {

public static boolean isMoreThanZeroAndLessThan1000(long l){
    return (l >= 0 && l <= 1000);
}

public static String randonNumStr (){
    Random r = new Random(100);
    return r.toString();
}

public static String randomString (){
    return RandomStringUtils.randomAlphabetic(10);
}

public static int randomNum (int num){
    Random random = new Random();
    int ran = random.nextInt(num);
    return ran;
}

public static String credentialsEnconderB64 (final String username, final String password){
        String cred = username + ":" + password;
        try {
            cred = java.util.Base64.getEncoder().encodeToString(cred.getBytes());
        }catch (NullPointerException e){
            e.fillInStackTrace();
        }
        return cred;
    }
    //Encripted Message
    public static String messageDigestHash(byte[] inputBytes, String algorithm){
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        }catch (NoSuchAlgorithmException e){
            e.fillInStackTrace();
        }
    return hashValue;
    }

//Message and Key into a MAC
public static String hmacConversion (final String message, final String secret){

    String hash = null;
    try {
        Mac sha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256.init(secretKeySpec);
        hash = Base64.encodeBase64String(sha256.doFinal(message.getBytes()));
    }catch (NoSuchAlgorithmException e){
        e.fillInStackTrace();
    }catch (InvalidKeyException e){
        e.fillInStackTrace();
    }
    return hash;
 }


}
