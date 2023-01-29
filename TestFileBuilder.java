//Class to create txt files that used for testing the algorithms
import java.lang.Math;
import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;  
public class TestFileBuilder {
	int n; //number of char in file
	String fName;//name of the file
	String data=""; //Data Stream that will be written in the file
	public TestFileBuilder(int n, String fName) {
		this.n = n;
		this.fName = fName;
	}
	public TestFileBuilder() {
		
	}
	public void createNewFile() throws Exception{
		try{
			File file;//FileOpject that will be created
			file = new File(fName+".txt");
			boolean result = file.createNewFile();  //creates a new file  
			if(result)      // test if successfully created a new file  
			{  
				System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
			}  
			else  
			{  
				System.out.println("File already exist at location: "+file.getCanonicalPath());  
			}  
		}
		catch (IOException e)   
		{  
			throw e;
		}   
	}
	public void creatTestData() throws Exception {
		try {
			for(int i = 0; i < n; i++) {
				int max = 122,min =97;
				byte random_int = (byte)Math.floor(Math.random() * (max-min  + 1)+min );
				char random_char = (char)random_int;// convert random number to char
				data = data + random_char;// to add random char to the data String
			}
		}	
		catch(Exception e) {
			throw e;
		}
	}
	public void writeToFile() throws IOException {
		try {
		      FileWriter myWriter = new FileWriter(fName+".txt");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    }catch(IOException e) {
		    	throw e;
		    }
	}
	public void buildTestFile(int n,String  fName) {
		this.n = n;
		this.fName = fName;
		try {
			creatTestData();
			createNewFile();
			writeToFile();
		} catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	   }
		
	}
}
