package CryptBasic;
/**
 * CRIYPTOBASIC
 * this program decrypts and encrypts files and folders with AES algorithm.
 * This is my first Java project. After this,I learned android and I was hired for 2 project in one year.
 * The hardest part is the beginning.
 * 
* @author  Sabrey Scatman
* @version 1.0
* @since   2019-05-06 
*/
import java.security.Key;
import java.io.IOException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;



/**
 * This class for  encrypt/decrypt files  with aes. You can use this package directly for you projects.
 * @author Sabrey Scatman
 *
 */
public class KriptoLib
{
 private static final String ALGORITHM = "AES";
 private static final String TRANSFORMATION = "AES";
 
 public static void encrypt(final String key, final File inputFile, final File outputFile) throws CryptoException {
     doCrypto(1, key, inputFile, outputFile);
 }
 
 public static void decrypt(final String key, final File inputFile, final File outputFile) throws CryptoException {
     doCrypto(2, key, inputFile, outputFile);
 }
 
 private static void doCrypto(final int cipherMode, final String key, final File inputFile, final File outputFile) throws CryptoException {
     try {
         final Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
         final Cipher cipher = Cipher.getInstance("AES");
         cipher.init(cipherMode, secretKey);
         final FileInputStream inputStream = new FileInputStream(inputFile);
         final byte[] inputBytes = new byte[(int)inputFile.length()];
         inputStream.read(inputBytes);
         final byte[] outputBytes = cipher.doFinal(inputBytes);
         final FileOutputStream outputStream = new FileOutputStream(outputFile);
         outputStream.write(outputBytes);
         inputStream.close();
         outputStream.close();
     }
     catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException ex3) {
         
         
      throw new CryptoException("Error encrypting/decrypting file", ex3);
     }
 }
}
