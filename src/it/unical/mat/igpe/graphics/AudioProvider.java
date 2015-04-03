package it.unical.mat.igpe.graphics;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class AudioProvider {
	
	static Clip musicMainMenu;
	static Clip musicChooser;
	static Clip musicPlay;
	
	public static void musicPlay(){
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/playAudio.wav"));
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("unsupported line");
				System.exit(0);
			}
			musicPlay = (Clip) AudioSystem.getLine(info);
			musicPlay.open(ais);
			
			//controllo volume
			FloatControl audioPlayControl = (FloatControl) musicPlay.getControl(FloatControl.Type.MASTER_GAIN);
			audioPlayControl.setValue(-10.0f);
			
			musicPlay.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void musicMainMenu(){
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/mainMenu.wav"));
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("unsupported line");
				System.exit(0);
			}
			musicMainMenu = (Clip) AudioSystem.getLine(info);
			musicMainMenu.open(ais);
			musicMainMenu.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void stopMusicMainMenu(){
		try {
			musicMainMenu.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void stopMusicChooser(){
		try {
			musicChooser.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void musicChooser(){
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/chooserMenu.wav"));
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("unsupported line");
				System.exit(0);
			}
			musicChooser = (Clip) AudioSystem.getLine(info);
			musicChooser.open(ais);
			musicChooser.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
