package CORPS;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import LECTEURS.ImageReader;
import LECTEURS.PDFReader;
import LECTEURS.TextReader;
import LECTEURS.VideoReader;
import NETWORKS.Client;
import javax.swing.JButton;

public class MACHINE {

	private JFrame frame;

	private PanOrdin panel = new PanOrdin();
	private LabFile labelfic = new LabFile();
	private LabParam labelparam = new LabParam();
	private JLabel labelconnect = new JLabel();
	private JLabel labelreseau = new JLabel();
	private JPanel panel_1 = new JPanel();
	private JPanel panel_2 = new JPanel();
	private boolean miova = false;
	private boolean miova1 = false;
	private boolean mitsatoka = false;
	private boolean mitsatoka1 = false;
	private JPanel panel_3 = new JPanel();
	private JTextArea textArea = new JTextArea();
	private String extension;
	@SuppressWarnings("unused")
	private String filename;
	private Canvas canvas = new Canvas();

	protected Client clientInstance;
	private JPanel panel_4 = new JPanel();
	private final JLabel lblNewLabel = new JLabel();
	private JLabel lblPower = new JLabel("Brancher");
	private  JButton btnPow = new JButton("OFF");
	private  SaryPan panel_5 = new SaryPan();
	private LabPrise0 lblPrise = new LabPrise0();
	private JFrame f = new JFrame();
	private String filePath;
	//private JLabel lblTrinito = new JLabel("trinito");
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MACHINE window = new MACHINE();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public MACHINE() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(-35, 0, 586, 772);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JPanel panel = new JPanel();
		panel.setBounds(4, 15, 571, 732);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//JLabel label = new JLabel("1");
		labelfic.setBounds(355, 477, 28, 22);
		labelfic.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				try
				{
					labelListener();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
	
		});
		//panel.add(labelfic);
		
		//JLabel label_1 = new JLabel("2");
		labelparam.setBounds(398, 474, 29, 28);
		//panel.add(labelparam);
		
		//JLabel label_2 = new JLabel("3");
		labelconnect.setBounds(426, 473, 30, 28);
		ImageIcon con = new ImageIcon("IMAGES/esT.png");
		labelconnect.setIcon(con);
		labelconnect.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0)
					{
					
						if(miova == true)
						{
		            		miova = false;
		            		labelconnect.repaint();
		            		ImageIcon con1 = new ImageIcon("IMAGES/esT.png");
		            		labelconnect.setIcon(con1);							
							ImageIcon img = new ImageIcon("IMAGES/alert.png");
		            		JOptionPane.showMessageDialog(frame, "La connection va arreter maintenant ", "Message" , JOptionPane.WARNING_MESSAGE,img);
		            		clientInstance = null ;
						}
						else
						{
							if(miova1 == true)
							{
								miova = true;
								
								labelconnect.repaint();
								
								
								
								try
								{
									Client client = new Client("127.0.0.1", 6620);
									clientInstance = client ;
									ImageIcon con = new ImageIcon("IMAGES/esT1.png");
									labelconnect.setIcon(con);
									boolean bool = client.getInput().readBoolean();
									System.out.println(bool);
									if(bool == true){
									ImageIcon image = new ImageIcon("IMAGES/message.png");
									JOptionPane.showMessageDialog(frame, "le projecteur TRINITO a bien connecte .", "Message" , JOptionPane.INFORMATION_MESSAGE,image);
									}
									else
									{
										ImageIcon image = new ImageIcon("IMAGES/message.png");
										JOptionPane.showMessageDialog(frame, "le projecteur TRINITO pas encore connecte connecte .", "Message" , JOptionPane.INFORMATION_MESSAGE,image);
										
									}
								}
								catch (IOException e)
								{
									JOptionPane.showMessageDialog(frame, e.getMessage(), "Erreur" , JOptionPane.ERROR_MESSAGE);
									
								}								
							}
							else
							{
								ImageIcon imge = new ImageIcon("IMAGES/erreur.png");
								JOptionPane.showMessageDialog(frame, "Activer d'abord le reseau !!!", "Erreur" , JOptionPane.ERROR_MESSAGE,imge);
							}
						}
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) 
					{
						
					}

					@Override
					public void mouseExited(MouseEvent arg0)
					{
						//ImageIcon con = new ImageIcon("esT.png");
						//lblConnection.setIcon(con);
					}

					@Override
					public void mousePressed(MouseEvent arg0) {}

					@Override
					public void mouseReleased(MouseEvent arg0) {}
			
				});
		//panel.add(labelconnect);
		
		//JLabel label_3 = new JLabel("4");
		labelreseau.setBounds(460, 474, 29, 26);
		ImageIcon seau = new ImageIcon("IMAGES/res1.png");
		labelreseau.setIcon(seau);
		labelreseau.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				
				
				if(miova1 == true)
				{
					JOptionPane.showMessageDialog(frame, "Voulez vous couper le reseau ? ", "Message" ,JOptionPane.QUESTION_MESSAGE);
            		miova1 = false;
            		labelreseau.repaint();
    				ImageIcon res1 = new ImageIcon("IMAGES/res1.png");
    				labelreseau.setIcon(res1);												
				}
				else
				{
					miova1 = true;
					
					labelreseau.repaint();
    				ImageIcon res = new ImageIcon("IMAGES/res11.png");
    				labelreseau.setIcon(res);
					
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				//ImageIcon res1 = new ImageIcon("res11.png");
				//lblReseau.setIcon(res1);
			}

			@Override
			public void mouseExited(MouseEvent arg0)
			{
					
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		//panel.add(labelreseau);
		
		//JPanel panel_1 = new JPanel();
		panel_1.setBounds(76, 200, 410, 270);
		//panel.add(panel_1);
		panel_1.setLayout(null);
		
		//JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 410, 20);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFermeture = new JLabel();
		lblFermeture.setBounds(380, 0, 20, 20);
		ImageIcon icon = new ImageIcon("IMAGES/fermeture.png");
		lblFermeture.setIcon(icon);
		lblFermeture.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				panel.removeAll();
            	panel.repaint();
            	panel.add(labelparam);
            	panel.add(labelconnect);
            	panel.add(labelreseau);
            	panel.add(labelfic);
            	
            	panel.add(panel_5);
            	panel.add(lblPower);          	
            	panel.add(btnPow);
            	
            	 VideoReader test = new VideoReader( f, canvas, filePath);
          	     test.play(false);
			}

			@Override
			public void mouseEntered(MouseEvent arg0)
			{
				ImageIcon icon1 = new ImageIcon("IMAGES/fermeture1.png");
				lblFermeture.setIcon(icon1);
			}

			@Override
			public void mouseExited(MouseEvent arg0)
			{
				ImageIcon icon2 = new ImageIcon("IMAGES/fermeture.png");
				lblFermeture.setIcon(icon2);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		panel_2.add(lblFermeture);
		panel_3.setBounds(0, 22, 410, 248);
		
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		textArea.setBounds(0, 0, 410, 248);
		textArea.setEditable(false);
		
		panel_3.add(textArea);
		lblNewLabel.setBounds(0, 0, 410, 248);
		
		panel_3.add(lblNewLabel);
		
		//JPanel panel_4 = new JPanel();
		panel_4.setBounds(74, 198, 414, 304);
		panel_4.setBackground(Color.black);
		panel.add(panel_4);
		
		//JLabel lblPower = new JLabel("Brancher");
		lblPower.setBounds(110, 62, 70, 14);
		lblPower.setForeground(Color.BLACK);
		lblPower.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(mitsatoka == true)
				{
					mitsatoka = false;
					
					panel.removeAll();
					panel.repaint();
					panel.add(lblPower);
					lblPower.setText("Brancher");
					lblPower.setForeground(Color.BLACK);
					panel.add(panel_4);
					
					panel.add(panel_5);
					panel_5.removeAll();
					panel_5.repaint();
					
	            	panel.add(btnPow);
	            	btnPow.setText("OFF");
	            	btnPow.setForeground(Color.BLACK);
	            	btnPow.setBackground(Color.GRAY);
				}
				else
				{
					mitsatoka = true;
					panel_5.removeAll();
					panel_5.repaint();
					panel_5.add(lblPrise);
					
					panel.add(lblPower);
					lblPower.setText("Debrancher");
					lblPower.setForeground(Color.RED);
					
					btnPow.setForeground(Color.RED);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
	
		});
		panel.add(lblPower);
		
		btnPow.setBounds(465, 548, 74, 23);
		btnPow.setForeground(Color.BLACK);
		btnPow.setBackground(Color.GRAY);
		btnPow.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(mitsatoka == true)
				{
					if(mitsatoka1 == true)
					{
						mitsatoka1 = false;
						
						panel.removeAll();
						panel.repaint();
						panel.add(panel_4);
						
						panel.add(panel_5);
		            	panel.add(lblPower);
		            	
		            	panel.add(btnPow);
		            	btnPow.setText("OFF");
		            	btnPow.setForeground(Color.RED);
		            	btnPow.setBackground(Color.GRAY);
		            	
		            	try {
							PROJECTEUR_ECRAN pan = new PROJECTEUR_ECRAN();
							pan.mamafa();
						} catch (Throwable e) {
							e.printStackTrace();
						}
		            	
					}
					else
					{
						mitsatoka1 = true;
						
						panel.removeAll();
						panel.repaint();
						
						panel.add(btnPow);
						btnPow.setText("ON");
						btnPow.setForeground(Color.RED);
						btnPow.setBackground(Color.GREEN);
						
						panel.add(labelparam);
		            	panel.add(labelconnect);
		            	panel.add(labelreseau);
		            	panel.add(labelfic);
		            	
		            	panel.add(panel_5);
		            	panel.add(lblPower);
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
	
		});
		panel.add(btnPow);
		
		panel_5.setBounds(78, 90, 94, 26);	
		panel.add(panel_5);
		panel_5.setLayout(null);
		lblPrise.setBounds(0, 2, 94, 26);
		
		//panel_5.add(lblPrise);
		
		//Canvas canvas = new Canvas();
		canvas.setBounds(0, 0, 410, 248);
		canvas.setBackground(Color.BLACK);
		//panel_3.add(canvas);
		
		
		try
		{
			for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if("Windows".equals(info.getName())){
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					
					break;
				}
			}
		}catch(Exception e)
		{ }
	}
	
	private void labelListener() throws IOException 
	{
		JFileChooser chooser = new JFileChooser("D:/Java Project/Directory") ;
		chooser.setPreferredSize(new Dimension(408,238));
        Integer result = chooser.showOpenDialog(frame);
        
        if (result == JFileChooser.APPROVE_OPTION) 
        { 
            File file = chooser.getSelectedFile() ;            
			this.filePath = file.getAbsolutePath() ;
            //MyFileReader fileReader = new MyFileReader(filePath);
            //String content = fileReader.readFile();            
            
            Integer pos1 = filePath.lastIndexOf(".") ;
            
            try
            {
                this.extension = filePath.substring(pos1).toLowerCase() ;
            } catch (Exception ArrayIndexOutOfBoundsException) 
            {
                System.err.println("Pas d'index choisi");
            }
            
            
            if(     ".txt".equals(this.getExtension()) ||
                    ".html".equals(this.getExtension()) ||
                    ".java".equals(this.getExtension()) ||
                    ".py".equals(this.getExtension()) ||
                    ".doc".equals(this.getExtension()) ||
                    ".docx".equals(this.getExtension()) ||
                    ".htm".equals(this.getExtension())) 
            {
            	panel.removeAll();
            	panel.repaint();
            	
            	panel.add(panel_1);
            	panel_3.removeAll();
            	panel_3.repaint();
            	panel_3.add(textArea);
            	TextReader textReader = new TextReader(); 
            	String content = textReader.readText(filePath);
            	textArea.setText(content);
            	
            	panel.add(labelparam);
            	panel.add(labelconnect);
            	panel.add(labelreseau);
            	panel.add(labelfic);
            	
            	panel.add(panel_5);
            	panel.add(lblPower);          	
            	panel.add(btnPow);
            	
            	
            	//this.clientInstance.getOutput().writeUTF(content) ;
	            try{    
            	this.clientInstance.getOutput().writeUTF(filePath) ;
	                System.out.println("Test0") ;
	            }catch(Exception e)
	            {
	            	System.out.println(e.getMessage());
	            }
	                //client.getOutput().writeBoolean(true) ;
            }
            else 
            {
            	 if (".pdf".equals(this.getExtension()))
                 {    
            		 panel.removeAll();
                 	 panel.repaint();
                 	 
                 	 panel.add(panel_1);
                 	 panel_3.removeAll();
                 	 panel_3.repaint();
                 	 panel_3.add(textArea);
                	 PDFReader pdfReader = new PDFReader() ;
                	 String content1 = pdfReader.readPdf(filePath);
                	 textArea.setText(content1);
                 	 
                 	 panel.add(labelparam);
                 	 panel.add(labelconnect);
                 	 panel.add(labelreseau);
                 	 panel.add(labelfic);
                 	 
                 	 panel.add(panel_5);
                	 panel.add(lblPower);          	
                	 panel.add(btnPow);
                 	 
                 	 
                 	try{    
                    	this.clientInstance.getOutput().writeUTF(filePath) ;
        	                System.out.println("Test1") ;
        	            }catch(Exception e)
        	            {
        	            	System.out.println(e.getMessage());
        	            }
                                        
                 }
            	 else
            	 {
            		 if (	".jpg".equals(this.getExtension()) ||
                             ".jpeg".equals(this.getExtension()) ||
                             ".png".equals(this.getExtension()) ||
                             ".gif".equals(this.getExtension()) ||
                             ".ico".equals(this.getExtension())

                         )
            		 {
            			 panel.removeAll();
                     	 panel.repaint();
                     	 panel.add(panel_1);
                     	 panel_3.removeAll();
                   	     panel_3.repaint();
                   	     panel_3.add(lblNewLabel);
                    	 ImageReader read = new ImageReader();
   	            	     ImageIcon icon1 = read.readImage(filePath);
   	            	     lblNewLabel.setIcon(icon1);
                     	 panel.add(labelparam);
                     	 panel.add(labelconnect);
                     	 panel.add(labelreseau);
                     	 panel.add(labelfic);
                     	 panel.add(panel_5);
                    	 panel.add(lblPower);          	
                    	 panel.add(btnPow);
                     	 
                     	
                     	try{    
                        	this.clientInstance.getOutput().writeUTF(filePath) ;
            	                System.out.println("Test2") ;
            	            }catch(Exception e)
            	            {
            	            	System.out.println(e.getMessage());
            	            }
                     	 
            		 }
            		 else
            		 {
            			 if(
                         		".mp4".equals(this.getExtension()) ||
                         		".mp3".equals(this.getExtension()) ||
                         		".avi".equals(this.getExtension()) 
                         		
                     	  )
            			 {
            				 try{    
                             	this.clientInstance.getOutput().writeUTF(filePath) ;
                 	                System.out.println("Test3") ;
                 	            }catch(Exception e)
                 	            {
                 	            	System.out.println(e.getMessage());
                 	            }
            				 panel.removeAll();
                         	 panel.repaint();
                         	 panel.add(panel_1);
                         	 panel_3.removeAll();
                        	 panel_3.repaint();
                        	 panel_3.add(canvas);                       	 
                      	     VideoReader test = new VideoReader( f, canvas, filePath);
                      	     test.play(true);
                         	 panel.add(labelparam);
                         	 panel.add(labelconnect);
                         	 panel.add(labelreseau);
                         	 panel.add(labelfic);
                          	 
                          	 panel.add(panel_5);
                        	 panel.add(lblPower);          	
                        	 panel.add(btnPow);
                          	 
                          	 
                         	 //test.play();
                         	
                         	
            			 }
            		 }
            	 }
            }
        }
	}
	
	
	
	public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getExtension() {
        return extension;
    }
}

class PanOrdin extends JPanel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/ordinateur.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class LabFile extends JLabel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/file.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class LabParam extends JLabel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/parametre1.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class LabFermet extends JLabel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/fermeture.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class LabPrise0 extends JLabel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/priseM.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class SaryPan extends JPanel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/priseM1.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}
