package NETWORKS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{

	private DataInputStream input ;
    private DataOutputStream output ;
    private final ServerSocket server ;
    private Socket socket ;
	
	public Server(Integer port) throws IOException
	{       
        this.server = new ServerSocket(port) ;   
    }
    
    public DataOutputStream getOutput() 
    {        
        return this.output ;       
    }
    
    public DataInputStream getInput()
    {       
        return this.input ;        
    }
    
    public void runServer() throws IOException
    {        
        this.socket = this.server.accept() ;
        
        this.input = new DataInputStream(this.socket.getInputStream()) ;
        this.output = new DataOutputStream(this.socket.getOutputStream()) ;
      
    }
    
    public Boolean closeServer() throws IOException 
    {        
        this.server.isClosed();
        
        return true ;        
    }

    public ServerSocket getServer()
    {
        return server;
    }
}
