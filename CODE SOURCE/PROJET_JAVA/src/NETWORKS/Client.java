package NETWORKS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client 
{

	private DataInputStream input ;
    private DataOutputStream output ;
    private final Socket client ;
	
	public Client(String host , Integer port) throws UnknownHostException, IOException
	{        
        Socket socket = new Socket(host , port) ;
        
        this.client = socket ;
        this.input = new DataInputStream(this.client.getInputStream()) ;
        this.output = new DataOutputStream(this.client.getOutputStream()) ;        
    }
    
    public DataOutputStream getOutput() 
    {        
        return this.output ;        
    }
    
    public DataInputStream getInput()
    {        
        return this.input ;        
    }
    
    public Boolean closeServer() throws IOException 
    {       
        this.client.close() ;       
        return false ;        
    }
}
