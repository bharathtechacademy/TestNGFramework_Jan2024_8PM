package com.creatio.crm.framework.utilies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {

	public static String getText(String filePath) {
		String text = "";
		try {
			//Read the File
			FileInputStream fis = new FileInputStream(filePath);
			
			//Load pdf file into PDDocument class to analyze the PDF file
			PDDocument document = PDDocument.load(fis);
							
			//Copy the text from PDF 
			PDFTextStripper pdf = new PDFTextStripper();
			
			
			//Set page numbers to get text from specific page
//			pdf.setStartPage(2);
//			pdf.setEndPage(2);
			
			//Copy the text
			text =pdf.getText(document);			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return text;
	}

}
