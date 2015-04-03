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
	static Clip click;
	static Clip click2;
	static Clip playButton;
	
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
	
	public static void clickAudio(){
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/click.wav"));
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("unsupported line");
				System.exit(0);
			}
			click = (Clip) AudioSystem.getLine(info);
			click.open(ais);
			click.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void clickAudio2(){
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/click2.wav"));
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("unsupported line");
				System.exit(0);
			}
			click2 = (Clip) AudioSystem.getLine(info);
			click2.open(ais);
			click2.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void playButton(){
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/playButton.wav"));
			AudioFormat af = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, af);
			
			if (!AudioSystem.isLineSupported(info)) {
				System.out.println("unsupported line");
				System.exit(0);
			}
			playButton = (Clip) AudioSystem.getLine(info);
			playButton.open(ais);
			playButton.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
