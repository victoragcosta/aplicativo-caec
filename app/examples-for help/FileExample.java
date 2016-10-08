package examples;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	
	static String filePath, parentDirectory;
	static File randomDir, randomFile;
	

	public static void main(String[] args) {
		
		Date time = new Date();
		SimpleDateFormat formated = 
				new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.E");
		randomFile = new File("Produtos."+ formated.format(time) + ".txt");
		try{
			randomFile.createNewFile();
			filePath = randomFile.getCanonicalPath();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		if(randomFile.exists()){
			System.out.println("File Exists");
			System.out.println("File Readable " + randomFile.canRead());
			System.out.println("File Writable " + randomFile.canWrite());
			System.out.println("File Executable " + randomFile.canExecute());
			System.out.println("File Location " + filePath);
			System.out.println("File Name " + randomFile.getName());
			
		}
	}
}
