package org.moogirc.jbomberman;

import java.io.File;
import javax.sound.sampled.*;

public class SoundManager extends Thread {
	private final int EXTERNAL_BUFFER_SIZE = 5242288;
	
	private String filename;
	private float position;
	
	public SoundManager(String filename) {
		this.setFilename(filename);
		this.setPosition(0.0f);
	}
	
	public SoundManager(String filename, float position) {
		this.setFilename(filename);
		this.setPosition(position);
	}
	
	public void run() {
		File soundFile = new File(getFilename());
		if(!soundFile.exists()) {
			System.err.println(getFilename() + " is missing");
			return;
		}
		
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine sourceLine = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		
		try {
			sourceLine = (SourceDataLine)AudioSystem.getLine(info);
			sourceLine.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		if(sourceLine.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl)sourceLine.getControl(FloatControl.Type.PAN);
			pan.setValue(position);
		}
		
		sourceLine.start();
		int bytesRead = 0;
		byte[] audioBuffer = new byte[EXTERNAL_BUFFER_SIZE];
		
		try {
			while (bytesRead != -1) {
				bytesRead = audioInputStream.read(audioBuffer, 0, audioBuffer.length);
				if (bytesRead >= 0)
					sourceLine.write(audioBuffer, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sourceLine.drain();
			sourceLine.close();
		}
	}

	private void setPosition(float position) {
		if(position > 1.0f)
			this.position = 1.0f;
		else if(position < -1.0f)
			this.position = -1.0f;
		else
			this.position = position;
	}

	public float getPosition() {
		return position;
	}

	private void setFilename(String filename) {
//		if(filename.startsWith("/") || filename.startsWith("../"))
//			this.filename = this.getClass().getResource(filename).toString();
//		else
			this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}
}
