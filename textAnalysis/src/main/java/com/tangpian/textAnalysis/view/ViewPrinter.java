package com.tangpian.textAnalysis.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class ViewPrinter<T extends View> {
	public void print(TreeSet<T> views, String outputFile) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					outputFile));
			// print first line
			writer.write(views.first().printTableTitle());

			// print
			for (T view : views) {
				String line = view.printLine();
				writer.write(line.toString() + "\n");
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
