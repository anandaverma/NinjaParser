package com.fiberlink.ninjaparser.input;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class InputBlock implements Runnable {

	protected BlockingQueue<String> queue = null;
	BatchFile bfile = new BatchFile();

	public InputBlock(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		if (bfile.validateInput("C:\\Users\\averma\\Downloads\\samplelogs")) {
			try {
				bfile.readInput("C:\\Users\\averma\\Downloads\\samplelogs",
						"SingleLine", queue);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
