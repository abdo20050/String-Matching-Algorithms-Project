import java.io.*;
import java.util.*;
public class OpenCSVFileWriter {
	List<String[]> dataIn = new ArrayList<String[]>();
	public void addData(String x, String y) {
		dataIn.add(new String[]{x,y});
	}
    public void creatCSVFile(String fName) {
    	try {
        File csvFile = new File(fName+".csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        //write header line here if you need.
        
        for (String[] data : dataIn) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i].replaceAll("\"","\"\""));
                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}