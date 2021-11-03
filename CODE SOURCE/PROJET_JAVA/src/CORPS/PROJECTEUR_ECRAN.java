package CORPS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import LECTEURS.ImageReader;
import LECTEURS.PDFReader;
import LECTEURS.TextReader;
import LECTEURS.VideoReader;
import NETWORKS.Server;
import java.awt.Canvas;

public class PROJECTEUR_ECRAN 
{

	private static boolean TRUE ;

	private JFrame frame;
	
	private JPanel panel = new JPanel();
	private Pan40 panel_1 = new Pan40();
	private static JPanel panel_3 = new JPanel();
	private static JLabel lblNewLabel = new JLabel();
	private Pan50 panel_5 = new Pan50();
	private JButton btnOff = new JButton("OFF");
	private  Bout20 button_1 = new Bout20("<<");
	private  Bout20 button_2 = new Bout20("up");
	private  Bout20 button_3 = new Bout20(">>");
	private  Bout20 button_4 = new Bout20("do");
	private Lan30 lblLumiere = new Lan30();
	private JLabel lblBrancher = new JLabel("Brancher");
	private JLabel lblPrise = new JLabel("prise");
	private static JTextArea textArea = new JTextArea();
	private static JTextArea textArea_1 = new JTextArea();
	private static JTextArea textArea_2 = new JTextArea();
	private static Canvas canvas = new Canvas();
	private static JFrame f = new JFrame();
	private static boolean mandeha = false;
	private static boolean mandeha1 = false;
	private static boolean velona = false;
	private final LanFil lblFil = new LanFil();
	private static String extension;
	private static String path;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PROJECTEUR_ECRAN window = new PROJECTEUR_ECRAN();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		

		try 
		{
            System.out.println("mandeha vooooooooo tsara");

			Server server = new Server(6620);
			server.runServer() ;
			
			Boolean runServer = true ;
			
	        while(runServer)
	        {
	        	
	        	if (mandeha == true) 
	        	{
	        		
	        		//if (TRUE) 
	        		//{
	        			server.getOutput().writeBoolean(TRUE = true) ;
	        		//}
	        		
	        		
	        		String chemin = server.getInput().readUTF() ;
	        		System.out.println(chemin);
	        		
	        		Integer pos = chemin.lastIndexOf(".") ;
	                try{
	                	extension = chemin.substring(pos).toLowerCase() ;
	                }catch(Exception ArrayIndexOutOfBoundsException) 
	                {
	                    System.err.println("Pas d'index choisi");
	                }
	                
	                if(     ".txt".equals(extension) ||
		        			".doc".equals(extension) ||
		        			".docx".equals(extension) ||
		        			".html".equals(extension) ||
		        			".java".equals(extension) ||
		        			".py".equals(extension) ||
		        			".htm".equals(extension))
		            	{
	                	    panel_3.removeAll();
	                	    panel_3.repaint();
	                	    panel_3.add(textArea_2);
		            		TextReader read = new TextReader();
		            		String content = read.readText(chemin);
		            		textArea_2.setBackground(Color.WHITE);
		            		textArea_2.setText(content);
		            	}
		            	else
		            	{
		            		if(		".pdf".equals(extension) )
		            		{
		            			panel_3.removeAll();
		            			panel_3.repaint();
		            			panel_3.add(textArea_2);
		            			PDFReader readerT = new PDFReader();
		            			String texte = readerT.readPdf(chemin);
		            			textArea_2.setBackground(Color.WHITE);
		            			textArea_2.setText(texte);
		            		}
		            		else
		            		{
		            			if(		".mp4".equals(extension)||
		            					".avi".equals(extension)||
		                    			".mkv".equals(extension) )       			
		                    	{
		            				panel_3.removeAll();
			                	    panel_3.repaint();
			                	    panel_3.add(canvas);
			                	   
		                        	VideoReader video = new VideoReader(f,canvas,chemin);
		                        	video.play(true);
		                    	}
		                        else
		                        {
		            	            if(		".jpg".equals(extension) ||
		            	            		".png".equals(extension) ||
		            	        			".jpeg".equals(extension) ||
		            	        			".gif".equals(extension) ||
		            	        			".ico".equals(extension) )	        			
		            	            {
		            	            	panel_3.removeAll();
		            	            	panel_3.repaint();
		            	            	panel_3.add(lblNewLabel);
		            	            	ImageReader read = new ImageReader();
		            	            	ImageIcon icon = read.readImage(chemin);
		            	            	lblNewLabel.setIcon(icon);
		            	            	
		            	            }
		            		}
		            	}
	            	}
	        	
	        	} 
	        	else
	        	{
	        		server.getOutput().writeBoolean(TRUE == false) ;
	        	}
	        }
		} 
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	public void mamafa()
	{
		panel_3.removeAll();
		panel_3.repaint();
		panel_3.setBackground(Color.LIGHT_GRAY);
	}
	

	public PROJECTEUR_ECRAN() throws Throwable 
	{
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(541, 0, 845, 772);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//JPanel panel = new JPanel();
		panel.setBounds(240, 121, 170, 243);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Lan30 lblLumiere = new Lan30();
		lblLumiere.setBounds(0, 0, 170, 243);
		//panel.add(lblLumiere);
		
		//Pan40 panel_1 = new Pan40();
		panel_1.setBounds(20, 194, 245, 170);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//JButton btnOff = new JButton("off");
		btnOff.setBounds(10, 11, 56, 23);
		btnOff.setBackground(Color.GRAY);
		btnOff.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(velona == true)
				{
					if (mandeha == true) {
						mandeha = false;
						textArea.setBackground(Color.BLACK);
						textArea_2.setBackground(Color.LIGHT_GRAY);
						btnOff.repaint();
						btnOff.setText("OFF");
						btnOff.setBackground(Color.GRAY);
						
						panel.removeAll();
						panel.repaint();
						
						panel_3.removeAll();
						panel_3.repaint();
						panel_3.setBackground(Color.LIGHT_GRAY);
					}
					else
					{
						mandeha = true;
						textArea.setBackground(Color.RED);
						panel_3.removeAll();
						panel_3.repaint();
						panel_3.setBackground(Color.WHITE);
						//textArea_2.setBackground(Color.WHITE);
						btnOff.repaint();
						btnOff.setText("ON");
						btnOff.setBackground(Color.CYAN);
						
						panel.removeAll();
						panel.repaint();
						panel.add(lblLumiere);
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
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) 
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0)
			{
				
			}
	
		});
		panel_1.add(btnOff);
		
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(70, 18, 7, 7);
		textArea.setBackground(Color.BLACK);
		panel_1.add(textArea);
		
		//JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(142, 27, 5, 30);
		textArea_1.setBackground(Color.BLACK);
		panel_1.add(textArea_1);
		
		button_1.setBounds(9, 79, 25, 23);
		panel_1.add(button_1);
		
		//JButton button_2 = new JButton("2");
		button_2.setBounds(35, 55, 25, 23);
		panel_1.add(button_2);
		
		//JButton button_3 = new JButton("3");
		button_3.setBounds(61, 79, 25, 23);
		panel_1.add(button_3);
		
		//JButton button_4 = new JButton("4");
		button_4.setBounds(35, 103, 25, 23);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setBounds(35, 79, 25, 23);
		panel_1.add(button_5);
		
		Pan10 panel_2 = new Pan10();
		panel_2.setBounds(408, 100, 400, 287);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		//JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 16, 385, 251);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		//JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(0, 0, 385, 251);
		//panel_3.add(textArea_2);
		
		//JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 2, 385, 251);
		//panel_3.add(lblNewLabel);
		
		//Canvas canvas = new Canvas();
		canvas.setBounds(0, 0, 385, 251);
		//panel_3.add(canvas);
		
		Pan20 panel_4 = new Pan20();
		panel_4.setBounds(486, 387, 205, 240);
		frame.getContentPane().add(panel_4);
		
		//Pan50 panel_5 = new Pan50();
		panel_5.setBounds(40, 345, 278, 200);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		//JLabel lblPrise = new JLabel("prise");
		lblPrise.setBounds(150, 160, 46, 14);
		lblPrise.setForeground(Color.BLUE);
		panel_5.add(lblPrise);
		
		//JLabel lblBrancher = new JLabel("brancher");
		lblBrancher.setBounds(150, 188, 70, 14);
		lblBrancher.setForeground(Color.BLACK);
		lblBrancher.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0)
					{
						if (mandeha1 == true) {
							mandeha1 = false;
							
							panel_5.removeAll();
							panel_5.repaint();
							panel_5.add(lblPrise);
							lblBrancher.setText("Brancher");
							lblBrancher.setForeground(Color.BLACK);
							panel_5.add(lblBrancher);
							
							textArea_1.setBackground(Color.BLACK);
							velona = false;
							
							textArea.setBackground(Color.WHITE);
							btnOff.repaint();
							btnOff.setText("OFF");
							btnOff.setBackground(Color.GRAY);
							
							panel.removeAll();
							panel.repaint();
							
							panel_3.removeAll();
							panel_3.repaint();
							panel_3.setBackground(Color.LIGHT_GRAY);
							
						}
						else
						{
							mandeha1 = true;
							//btnOff.repaint();
							//panel.repaint();
							panel_5.removeAll();
							panel_5.repaint();
							panel_5.add(lblFil);
							lblBrancher.setText("Debrancher");
							lblBrancher.setForeground(Color.RED);
							panel_5.add(lblBrancher);
							panel_5.add(lblPrise);
							
							textArea_1.setBackground(Color.RED);
							
							velona = true;							
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
		panel_5.add(lblBrancher);
		lblFil.setBounds(83, 135, 20, 56);
		
		//panel_5.add(lblFil);
		
		
	}
	
	public boolean getmiova2()
	{
		return true ;
	}
	
	public String getextension()
	{
		return extension;
		
	}
	public String getpath()
	{
		return path;
	}
}

@SuppressWarnings("serial")
class Pan10 extends JPanel
{
	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/ecran1.jpg"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


@SuppressWarnings("serial")
class Pan20 extends JPanel
{
	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/tige1.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class Lan30 extends JLabel
{
	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/lampe2.jpg"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class LanFil extends JLabel
{
	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/fil1.jpg"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class Pan40 extends JPanel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/pro2.png"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class Pan50 extends JPanel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		try{
			Image img = ImageIO.read(new File("IMAGES/prise.jpg"));
		g.drawImage(img,0,0,this);
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}

class Bout20 extends JButton
{
	private static final long serialVersionUID = 1L;
	private String name;
	@SuppressWarnings("unused")
	private Graphics2D g2d;
	public Bout20(String str)
	{
		this.name = str;
	}
	public void paintComponent(Graphics g1)
	{
		Graphics2D g2d = (Graphics2D)g1;
		GradientPaint gp = new GradientPaint(0,0,Color.CYAN,0,30,Color.BLUE);
		g2d.setPaint(gp);
		g2d.fillRect(0,0,this.getWidth(),this.getHeight());
		g2d.setColor(Color.WHITE);
		g2d.drawString(this.name, this.getWidth()/2-(this.getWidth()/2/4), this.getHeight()/2+5);
	}
}

class BoutonON extends JButton
{
	private static final long serialVersionUID = 1L;
	private String name;
	@SuppressWarnings("unused")
	private Graphics2D g2d;
	public BoutonON(String str)
	{
		this.name = str;
	}
	public void paintComponent(Graphics g1)
	{
		Graphics2D g2d = (Graphics2D)g1;
		GradientPaint gp = new GradientPaint(0,0,Color.GREEN,0,30,Color.BLUE);
		g2d.setPaint(gp);
		g2d.fillRect(0,0,this.getWidth(),this.getHeight());
		g2d.setColor(Color.WHITE);
		g2d.drawString(this.name, this.getWidth()/2-(this.getWidth()/2/4), this.getHeight()/2+5);
	}
}
