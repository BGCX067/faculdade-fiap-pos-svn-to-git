package br.com.sulamerica;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;

import org.apache.commons.collections.map.HashedMap;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DocumentException, IOException
    {
    	VelocityEngine ve = new VelocityEngine();  
    	ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
    	ve.setProperty("classpath.resource.loader.class",ClasspathResourceLoader.class.getName());
    	ve.init();
        ve.init();  
  
        VelocityContext context = new VelocityContext();  
        
  
        Template t = ve.getTemplate("template.vm");  
        
        StringWriter writer = new StringWriter();  
        
        
        context.put("variavel", "Teste Barbero");
        
        // mistura o contexto com o template  
        t.merge(context, writer);  
        
        
        Document document = new Document();
        // step 2
        PdfWriter writer3 = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
        // step 3
        document.open();
        
        // step 4
        InputStream stream = new ByteArrayInputStream(writer.toString().getBytes());

       
		XMLWorkerHelper.getInstance().parseXHtml(writer3, document,  stream);
        
        //step 5
        
         document.close();
         
        String pdftoText = pdftoText("pdf.pdf");
        
        System.out.println(pdftoText);
        
    }
    
    public static String pdftoText(String fileName) {
    	 PDFParser parser;
    	     String parsedText;
    	     PDFTextStripper pdfStripper;
    	     PDDocument pdDoc = null;
    	     COSDocument cosDoc = null;
    	     PDDocumentInformation pdDocInfo;
    	
    	   
    	         File f = new File(fileName);
    	   
    	         if (!f.isFile()) {
    	             System.out.println("File " + fileName + " does not exist.");
    	             return null;
    	         }
    	   
    	         try {
    	             parser = new PDFParser(new FileInputStream(f));
    	         } catch (Exception e) {
    	             System.out.println("Unable to open PDF Parser.");
    	             return null;
    	         }
    	   
    	         try {
    	             parser.parse();
    	             cosDoc = parser.getDocument();
    	             pdfStripper = new PDFTextStripper();
    	             pdDoc = new PDDocument(cosDoc);
    	             parsedText = pdfStripper.getText(pdDoc);
    	         } catch (Exception e) {
    	             System.out.println("An exception occured in parsing the PDF Document.");
    	             e.printStackTrace();
    	             try {
    	                    if (cosDoc != null) cosDoc.close();
    	                    if (pdDoc != null) pdDoc.close();
    	                } catch (Exception e1) {
    	                e.printStackTrace();
    	             }
    	             return null;
    	         }
    	         System.out.println("Done.");
    	         return parsedText;
    	     }
}
