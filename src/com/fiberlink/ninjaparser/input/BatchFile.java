package com.fiberlink.ninjaparser.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

/**
 * @author averma
 * @category input
 * This class deals with batch input
 */
public class BatchFile implements Input{
	
	public boolean validateInput ( String path ) {
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("file/folder doesn't exists");
			return false;
		}
		else if (!file.canRead()) {
			 System.out.println("can't read file: " + file.getAbsolutePath());
			 return false;
		}
		return true;
	}
	
	public void readInput ( String path, String type, BlockingQueue<String> queue ) throws IOException, InterruptedException {
		File file = new File(path);
		if (file.isFile()) {
			System.out.println(file.getAbsolutePath());
		}
		if (file.isDirectory()) {
			for (File f: file.listFiles()) {
				if(f.isDirectory()) {
					readInput(f.getPath(), type, queue);
				}
				else {
					BufferedReader br = new BufferedReader(new FileReader(f));
					String line;
					while((line = br.readLine()) != null) {
						// push to queue
						//System.out.println(queue.size());
						pushInput(line, queue);
					}
					br.close();
				}
			}
		}
	}
	
	public void pushInput ( String event, BlockingQueue<String> queue ) {
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
