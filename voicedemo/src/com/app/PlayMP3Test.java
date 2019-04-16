package com.app;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayMP3Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String filename="C:\\Users\\Public\\Music\\Sample Music\\Kalimba.mp3";
		 try {
			 BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
			 Player player = new Player(buffer);
			 player.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
