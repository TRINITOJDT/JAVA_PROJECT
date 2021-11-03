package LECTEURS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader
{

	public String readText(String path) throws FileNotFoundException, IOException 
    {      
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(path)) ;
        
        String fileContent ;
        String content = "" ;

        while((fileContent = reader.readLine()) != null)
        {
            content = content + fileContent + "\n" ;
        }

        return content ;

    }
}
