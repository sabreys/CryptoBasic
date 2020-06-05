package kriptoGui;
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

import java.io.File;
import java.util.Scanner;

import CryptBasic.CryptoException;
import CryptBasic.KriptoLib;

public class Crypter {

	public static File Dosya; //choosed file 
	public static String Key; //given  key 
	public static boolean cho; //chooice type true: encrypt, false:decrypt
	
	
/**
 * this fuction called from gui buttons.This buttons change static fields before that call and this is NOT  good way. Send you choice with parameters. This a wrong usage.
 * I did not fix this because I want to show wrong usage.
 *  if  you choose a path(folder) this function decrypt/encrypt all files in this folder. So be careful and don't forget the key. if you lost, God help you.
 */
	public static void crpyto() {

		File[] directoryListing = Dosya.listFiles();// for all in folder

		boolean isDirectory = Dosya.isDirectory(); // Check if it's a directory
		boolean isFile = Dosya.isFile();

		if (isDirectory) {
			if (directoryListing != null) {
				if (Dosya.list().length == 0)
					System.out.println("empty");
				for (File child : directoryListing) {

					try {
						Key = keycustomer(Key);
						if (cho)
							KriptoLib.encrypt(Key, child, child);
						else if (cho == false) {
							KriptoLib.decrypt(Key, child, child);
						}

					} catch (CryptoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("File is empty");
			}

		} else if (isFile) {
			try {
				Key = keycustomer(Key);

				if (cho)
					KriptoLib.encrypt(Key, Dosya, Dosya);
				else if (cho == false) {
					KriptoLib.decrypt(Key, Dosya, Dosya);
				}

			} catch (CryptoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	
	/**
	 * This function formats the key. if its shorter than 16,it will complete with 0. if it is too long, it will trim the key.
	 * 
	 * @param key 
	 * @return formatted key
	 */
	static String keycustomer(String key) {
		if (key.length() < 16) {
			while (key.length() < 16) {
				key += "0";
			}
			System.out.println(key);
		} else if (key.length() > 16)
			key = key.substring(0, 16);
		System.out.println(key);
		return key;

	}
}
