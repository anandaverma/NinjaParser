package com.fiberlink.ninjaparser.transform;

import java.util.concurrent.BlockingQueue;

import com.fiberlink.ninjaparser.util.ApacheCombinedLogFormat;

public class TransformBlock implements Runnable {

	protected BlockingQueue<String> inputqueue = null;
	protected BlockingQueue<ApacheCombinedLogFormat> transformqueue = null;

	public TransformBlock(BlockingQueue<String> inputqueue,
			BlockingQueue<ApacheCombinedLogFormat> transformqueue) {
		this.inputqueue = inputqueue;
		this.transformqueue = transformqueue;

	}

	public void run() {
		try {
			while (true) {
				String event = inputqueue.take();
				ApacheCombinedLogFormat aclf = new ApacheCombinedLogFormat();
				ApacheTranform apachetransform = new ApacheTranform();
				aclf = apachetransform.apacheCombinedLogParser(event);
				transformqueue.put(aclf);
				//Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
