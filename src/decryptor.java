import javax.crypto.spec.SecretKeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

import java.util.Scanner;

public class decryptor {
	Scanner read = new Scanner(System.in);
	public void DeCryptorTxt() {
		try {
			String path = "F:\\encryptor\\txt\\";
			System.out.println("diretorio do arquivo .encrypted");
			String encryptedFile = read.nextLine();
			String decryptedFile = path + "arquivo_descriptografado.txt";
			
			String keyTxt;
			
			System.out.println("key>>");
			keyTxt = read.nextLine();
			
			String savedKeyBase64 = keyTxt;
			
			byte[] keyBytes = Base64.getDecoder().decode(savedKeyBase64);
			SecretKey key = new SecretKeySpec(keyBytes, "AES");
			
			decryptFile(encryptedFile, decryptedFile, key);
			System.out.println("arquivo descriptografado com sucesso");
			
		}catch (Exception e) { 
			System.err.println("[ERRO] erro ao dscriptografar");
			
		}
		
		
	}
	public static void decryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
	    Cipher cipher = Cipher.getInstance("AES");
	    cipher.init(Cipher.DECRYPT_MODE, key);
	    
	    byte[] encryptedBytes = Files.readAllBytes(Paths.get(inputFile));
	    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
	    
	    Files.write(Paths.get(outputFile), decryptedBytes, StandardOpenOption.CREATE);
	}
}
