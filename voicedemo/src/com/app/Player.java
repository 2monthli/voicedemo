package com.app;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//File f = new File("D:/lpfile/test/ÏîÄ¿/ws/voice/resources/1.wav");
		File f = new File(System.getProperty("java.class.path")+"/1.wav");
		try {
			AudioInputStream ais=AudioSystem.getAudioInputStream(f);
			AudioFormat af = ais.getFormat();
			System.out.println(af.getSampleRate());
			System.out.println(ais.getFrameLength());
			System.out.println("时长：（秒）"+ais.getFrameLength()/af.getSampleRate());
			DataLine.Info di=new DataLine.Info(SourceDataLine.class,af);
			SourceDataLine sdl=(SourceDataLine) AudioSystem.getLine(di);
			byte[] b = new byte[1024];
			int length=0;
			sdl.open(af);
			sdl.start();
			while((length=ais.read(b))>0){
				sdl.write(b, 0, length);
			}
			ais.close();
			sdl.drain();
			sdl.close();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("end");
	}

}
