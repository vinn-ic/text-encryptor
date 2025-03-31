import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		creatTxt obTxt = new creatTxt();
		decryptor obdescry = new decryptor();

		
		String strQuest;
		boolean loop = true;

			
		do{
			System.out.println("ENCRYPTOR-TEXT\ncreate a txt and encrypt it = 1\ndecrypt = 2");

			strQuest = read.nextLine();
			
			if(strQuest.equalsIgnoreCase("1")){
				obTxt.creattxt();
				obTxt.encryptorTxt();
			}else if(strQuest.equalsIgnoreCase("2")) {
				obdescry.DeCryptorTxt();
			}else if(strQuest.equalsIgnoreCase("exit")){
				loop = false;
			}else {
				System.out.println("[OPCAO INVALIDA]");
			}
		}while (loop);//while só da loop se for TRUE
		
		read.close();
	}
	}


