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
	static boolean firstTimeMusicPlay = false;
	static boolean firstTimeMusicChooser = false;
	static boolean firstTimeMainMenu = false;
	static boolean generalAudio = true;
	
	public static void musicPlay(){
		if(generalAudio){
			try {
				if(firstTimeMusicPlay == false){
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
					firstTimeMusicPlay = true;
				}
				musicPlay.setFramePosition(0);
				musicPlay.start();
				musicPlay.loop(Clip.LOOP_CONTINUOUSLY);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void stopMusicPlay(){
		if(generalAudio){
			musicPlay.stop();
		}
	}
	
	public static void musicMainMenu(){
		if(generalAudio){
			try {
				if(firstTimeMainMenu==false){
					AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/mainMenu.wav"));
					AudioFormat af = ais.getFormat();
					DataLine.Info info = new DataLine.Info(Clip.class, af);
					
					if (!AudioSystem.isLineSupported(info)) {
						System.out.println("unsupported line");
						System.exit(0);
					}
					musicMainMenu = (Clip) AudioSystem.getLine(info);
					musicMainMenu.open(ais);
					firstTimeMainMenu = true;
				}
				
				musicMainMenu.setFramePosition(0);
				musicMainMenu.start();
				musicMainMenu.loop(Clip.LOOP_CONTINUOUSLY);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void stopMusicMainMenu(){
		if(generalAudio){
			try {
				musicMainMenu.stop();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void stopMusicChooser(){
		if(generalAudio){
			try {
				musicChooser.stop();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void musicChooser(){
		if(generalAudio){
			try {
				if(firstTimeMusicChooser == false){
					AudioInputStream ais = AudioSystem.getAudioInputStream(new File("audio/chooserMenu.wav"));
					AudioFormat af = ais.getFormat();
					DataLine.Info info = new DataLine.Info(Clip.class, af);
					
					if (!AudioSystem.isLineSupported(info)) {
						System.out.println("unsupported line");
						System.exit(0);
					}
					musicChooser = (Clip) AudioSystem.getLine(info);
					musicChooser.open(ais);
					firstTimeMusicChooser = true;
				}
				
				musicChooser.setFramePosition(0);
				musicChooser.start();
				musicChooser.loop(Clip.LOOP_CONTINUOUSLY);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void clickAudio(){
		if(generalAudio){
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
	}
	
	
	public static void clickAudio2(){
		if(generalAudio){
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
	}
	
	public static void playButton(){
		if(generalAudio){
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
				
				//controllo volume
				FloatControl audioPlayControl = (FloatControl) playButton.getControl(FloatControl.Type.MASTER_GAIN);
				audioPlayControl.setValue(-10.0f);
				
				playButton.start();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public static void audioOn() {
		generalAudio=true;
	}

	public static void audioOff() {
		AudioProvider.stopMusicMainMenu();
		generalAudio=false;
	}

}
