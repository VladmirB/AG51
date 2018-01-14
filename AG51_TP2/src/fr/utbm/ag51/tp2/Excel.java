package fr.utbm.ag51.tp2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.utbm.ag51.tp2.src.com.csvreader.CsvWriter;

public class Excel {
	public void Write(int n,int tp1, int tp2) {
		String outputFile = "TP2_Supprimer.csv";
		// before we open the file check to see if it already exists
				boolean alreadyExists = new File(outputFile).exists();
					
				try {
					// use FileWriter constructor that specifies open for appending
					CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
					
					// if the file didn't already exist then we need to write out the header line
					if (!alreadyExists)
					{
						csvOutput.write("n");
						csvOutput.write("FP");
						csvOutput.write("Tab");
						csvOutput.endRecord();
					}
					// else assume that the file already has the correct header line
					
					// write out a few records
					csvOutput.write(Integer.toString(n));
					csvOutput.write(Integer.toString(tp1));
					csvOutput.write(Integer.toString(tp2));
					csvOutput.endRecord();
					
			
					
					csvOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
		
	}

}
