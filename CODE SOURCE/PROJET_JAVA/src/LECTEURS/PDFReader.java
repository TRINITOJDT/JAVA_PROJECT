package LECTEURS;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PDFReader
{

	public String readPdf(String path) throws IOException 
	{
        PdfReader reader ;
        Integer pageNumber ;
        String content ;

        reader = new PdfReader(path) ;
        pageNumber = reader.getNumberOfPages() ;
        content = "" ;
        
        if (pageNumber == 1) 
        {          
            content = PdfTextExtractor.getTextFromPage(reader, pageNumber) ;           
        }
        else
        {            
            for (int i = 1; i <= pageNumber; i++)
            {            
                content = content + PdfTextExtractor.getTextFromPage(reader, i)  + "\n" ;
            }            
        }       
        reader.close() ;

        return content ;
    }

}
