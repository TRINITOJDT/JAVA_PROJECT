package LECTEURS;

import javax.swing.ImageIcon;

public class ImageReader 
{
	public ImageIcon readImage(String path)
    {
        ImageIcon image = new ImageIcon(path) ;
        
        return image ;
    }

}
