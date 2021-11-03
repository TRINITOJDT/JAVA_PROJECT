package LECTEURS;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import CORPS.MACHINE;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

@SuppressWarnings("unused")
public class VideoReader
{

	//private JFrame f = new JFrame();
	private EmbeddedMediaPlayer emp;

	public VideoReader(JFrame f ,Canvas c, String lalana) 
	{
		
		//JFrame f = new JFrame();
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);			
		MediaPlayerFactory mpf = new MediaPlayerFactory();			
		this.emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
		this.emp.setVideoSurface(mpf.newVideoSurface(c));						
		this.emp.setEnableMouseInputHandling(true);			
		this.emp.setEnableKeyInputHandling(false);					
		this.emp.prepareMedia(lalana);
		
	}
	
	public void play(boolean v)
	{
		if(v == true)
		{
			
			this.emp.play() ;
			this.emp.setVolume(50);
		}
		else
		{
			this.emp.stop();
		}
	}

}
