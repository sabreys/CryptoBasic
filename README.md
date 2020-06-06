# CryptoBasic

 Hi! This is **CryptoBasic** and it was my  first Java project. You can Decrypt/Encrypt your **Files** and **Folders** with AES algorithm.
 
İf you are just looking for an AES code, you can use **CryptBasic** package. Usage instruction is down below.
  
  
   ![UI](https://github.com/sabreys/CryptoBasic/blob/master/ui.PNG?raw=true)
# CryptBasic

This  Packages include AES decrypt/encrpyt codes.You can use directly this class for your encryption works.
   ```
   public static void encrypt(final String key, final File inputFile, final File outputFile) throws CryptoException
   
 public static void decrypt(final String key, final File inputFile, final File outputFile) throws CryptoException 
 
  private static void doCrypto(final int cipherMode, final String key, final File inputFile, final File outputFile) throws CryptoException
   ```

 - Import package.
     ```
      import CryptBasic.CryptoException;  
      import CryptBasic.KriptoLib;
    ```
 - You can call encrpyt or decrypt fuction now.(key size must be 16 charecter. you can use keycustumer function in Crypter class)
 
    ```
   KriptoLib.encrypt(YourKey, SourceFile , TargetFile); //if you use same file, you will overwrite to file. if you lost your key. you cant convert back.Be carefull !!!
     
   KriptoLib.decrypt(YourKey, SourceFile , TargetFile);
    ```

## Encryption For Folders

**KriptoGui.crypter** function  can detect file and folders. If folder selected, it will encrpyt all files in this folder.You can convert this function for your usage.Just add File,Key and Choice(true:encrpyt/false:decrypt) as a parameter.
