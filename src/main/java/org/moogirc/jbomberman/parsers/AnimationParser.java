package org.moogirc.jbomberman.parsers;

import java.io.*;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class AnimationParser {
	private static final int FILEHEADER_BYTE_ARRAY_LENGTH = 20;
	private static final int UINT32_BYTE_ARRAY_LENGTH = 4;
	private static final int UINT16_BYTE_ARRAY_LENGTH = 2;
	private static final int ITEMHEADER_BYTE_ARRAY_LENGTH = 8;
	private static final String FILETYPE = "CHFILEANI "; //include whitespace
	/**
	 * Reads a *.ani file given by the path and tries to parse it 
	 * to a slick animation object
	 * @param animationFilePath 
	 * @return a slick Animation
	 * @throws IOException 
	 */
	public static Animation readAnimationFile(String animationFilePath) throws IOException {
		Animation animation = new Animation();
		//Open binary stream
		File aniFile = new File(animationFilePath);
		if(!aniFile.exists() || aniFile.isDirectory()) throw new FileNotFoundException(animationFilePath);
		FileInputStream fis = new FileInputStream(aniFile);
		DataInputStream dis = new DataInputStream(fis);
		
		byte[] fileheader = new byte[FILEHEADER_BYTE_ARRAY_LENGTH];
		byte[] uint32 = new byte[UINT32_BYTE_ARRAY_LENGTH];
		byte[] uint16 = new byte[UINT16_BYTE_ARRAY_LENGTH];
		byte[] itemheader = new byte[ITEMHEADER_BYTE_ARRAY_LENGTH];
		
		//check image signature, must be "CHFILEANI " including space
		dis.read(fileheader);
		String fileType = new String(fileheader);
		if(!fileType.equals(FILETYPE)) throw new IOException("FileType: " + fileType);
		
		//find file length
		dis.read(uint32);
		long filelength = parseByteArrayToLong(uint32);
		//find file ID
		dis.read(uint16);
		long fileId = parseByteArrayToLong(uint16);
		
		long bytesread = 0;
		
		while(bytesread < filelength)
		{
			//check that there's enough space for header
			// 		(bytes read + 10 > file length)
			if(bytesread+10 > filelength)
				throw new IOException("Itemheader to short: " + (filelength - bytesread));
			bytesread += 10;
			
			//read block info
			dis.read(itemheader);
			String itemSignature = new String(itemheader);
			dis.read(uint32);
			long itemLength = parseByteArrayToLong(uint32);
			dis.read(uint16);
			long itemId = parseByteArrayToLong(uint16);
			long itemStart = bytesread;
			long itemEnd = itemStart + itemLength;
			
			if(itemEnd > filelength)
				throw new IOException("Unexpected end of file");
			
			if(itemSignature.equals("HEAD")) {
				
			} else if(itemSignature.equals("FRAM")) {
				
			} else if(itemSignature.equals("SEQ ")) {
				
			} else if(itemSignature.equals("PAL ")) {
				
			} else if(itemSignature.equals("TPAL")) {
				
			} else if(itemSignature.equals("CBOX")) {
				
			} else {
				
			}
		}
		/* 
		 * 
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
	private static Image parseByteArrayToImage(byte[] image) {
		return null;
	}
	
	/**
	 * parses a byte[] to long
	 * @param bytearray
	 * @return
	 */
	private static long parseByteArrayToLong(byte[] bytearray){
		long value = 0;
		for(int i = 0; i < bytearray.length; i++) {
			value += (bytearray[i] & 0xff) << (8*i);
		}
		return value;
	}
}
