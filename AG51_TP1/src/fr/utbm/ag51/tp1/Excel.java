package fr.utbm.ag51.tp1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.utbm.ag51.tp1.src.com.csvreader.CsvWriter;

public class Excel {
	public void Write(int n,int tp1, int tp2,int tp3,int tp4,int tp5,int tp6,int tp7) {
		String outputFile = "TP1.csv";
		// before we open the file check to see if it already exists
				boolean alreadyExists = new File(outputFile).exists();
					
				try {
					// use FileWriter constructor that specifies open for appending
					CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
					
					// if the file didn't already exist then we need to write out the header line
					if (!alreadyExists)
					{
						csvOutput.write("n");
						csvOutput.write("Selection");
						csvOutput.write("insertion");
						csvOutput.write("bulles");
						csvOutput.write("shell");
						csvOutput.write("rapide");
						csvOutput.write("fusion");
						csvOutput.write("tas");
						csvOutput.endRecord();
					}
					// else assume that the file already has the correct header line
					
					// write out a few records
					csvOutput.write(Integer.toString(n));
					csvOutput.write(Integer.toString(tp1));
					csvOutput.write(Integer.toString(tp2));
					csvOutput.write(Integer.toString(tp3));
					csvOutput.write(Integer.toString(tp4));
					csvOutput.write(Integer.toString(tp5));
					csvOutput.write(Integer.toString(tp6));
					csvOutput.write(Integer.toString(tp7));
					
					csvOutput.endRecord();
					
			
					
					csvOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		
	}

}
