package org.moogirc.jbomberman.parsers;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class AnimationParser {
	/**
	 * Reads a *.ani file given by the path and tries to parse it 
	 * to a slick animation object
	 * @param animationFilePath 
	 * @return a slick Animation
	 */
	public static Animation readAnimationFile(String animationFilePath) {
		Animation animation = new Animation();
		/*
		 * Open binary stream
		 * check image signature, must be "CHFILEANI " including space
		 * find file length
		 * find file ID
		 * check that there's enough space for header
		 * 		(bytes read + 10 > file length)
		 * Read block type
		 * "HEAD" Read past this block, do nothing(?)
		 * "FRAM" Parse frame
		 * "SEQ " parse sequence
		 * "PAL " read past this block, do nothing(?)
		 * "TPAL" read past this block, do nothing(?)
		 * "CBOX" read past this block, do nothing(?)
		 * default read past this item.
		 */
		return null;
	}
	
	/**
	 * parse a byte array to an Slick Image
	 * @param image
	 * @return Slick Image
	 */
	private static Image parseImage(byte[] image) {
		return null;
	}
	
	/**
	 * parses a byte[] to long
	 * @param bytearray
	 * @return
	 */
	private static long parseByteArrayToLongMostSignificant(byte[] bytearray){
		long value = 0;
		for(int i = 0; i < bytearray.length; i++) {
			value += (bytearray[i] & 0xff) << (8*i);
		}
		return value;
	}
}
