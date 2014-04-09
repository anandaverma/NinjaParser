package com.fiberlink.ninjaparser.output;

import java.util.concurrent.BlockingQueue;

import com.fiberlink.ninjaparser.util.ApacheCombinedLogFormat;

public class OutputBlock implements Runnable {
	
	BlockingQueue<ApacheCombinedLogFormat> tranformqueue = null;
	
	public OutputBlock(BlockingQueue<ApacheCombinedLogFormat> transformqueue) {
		this.tranformqueue = transformqueue;
	}
	
	public void run () {
		ApacheCombinedLogFormat aclf = new ApacheCombinedLogFormat();
		try {
			while (true) {
				aclf = tranformqueue.take();
				System.out.println(aclf.toString());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
