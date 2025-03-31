
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.nio.file.Files;// escluir o arquivo .TXT criado e mander só o .encryptrf
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class creatTxt {
	public String creattxt() {
		Scanner read = new Scanner(System.in);
		
		String nameTxt = "textNoEncryptedSys.Txt";
		String diretorioS = "F:\\encryptor\\txt\\";
		String path = diretorioS + nameTxt;
		
		String text;
		
		try (FileWriter writer = new FileWriter(path)){
			
			System.out.print("oque você quer escrever>>");
			
			text = read.nextLine();
			writer.write(text);
			System.out.println("dados escritos com sucesso em: " + path);
			
			
			
		}catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		
		return nameTxt;
	}


	private static final String ALGORITHM = "AES";
	
	public void encryptorTxt() {
		Scanner read = new Scanner(System.in);
		try {
			String path = "F:\\encryptor\\txt\\";
			String pathTxt = "F:\\encryptor\\txt\\textNoEncryptedSys.Txt";
			System.out.print("nome do arquivo .encrypted>>");
			String nameTxtCry = read.nextLine();
			String inputFile = path + "textNoEncryptedSys.txt";
			String outputFile = path + nameTxtCry + ".encrypted";
			
			SecretKey secretKey = generateKey();
			System.out.printf("key gerada>> %s%n", Base64.getEncoder().encodeToString(secretKey.getEncoded()));			 
			 encryptFile(inputFile, outputFile, secretKey);
			 
			System.out.println("arquivo criptografado!");

			File arquivoTxt = new File(pathTxt);
			arquivoTxt.delete();
			System.out.println("arquivo .txt excluido!");



			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }
	
	  public static void encryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.ENCRYPT_MODE, key);
	        
	        byte[] fileBytes = Files.readAllBytes(Paths.get(inputFile));
	        byte[] encryptedBytes = cipher.doFinal(fileBytes);
	        
	        Files.write(Paths.get(outputFile), encryptedBytes, StandardOpenOption.CREATE);
	    }
}