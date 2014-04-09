package com.fiberlink.ninjaparser.driver;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.fiberlink.ninjaparser.input.InputBlock;
import com.fiberlink.ninjaparser.output.OutputBlock;
import com.fiberlink.ninjaparser.transform.TransformBlock;
import com.fiberlink.ninjaparser.util.ApacheCombinedLogFormat;

/*
 * this class serve as the starting point
 */
public class Driver {

	public static void main(String[] args) throws IOException, InterruptedException {
		BlockingQueue<String> inputqueue = new ArrayBlockingQueue<String>(10);
		BlockingQueue<ApacheCombinedLogFormat> tranformqueue = new ArrayBlockingQueue<ApacheCombinedLogFormat>(10);
		
		// input section
		InputBlock input = new InputBlock(inputqueue);
		new Thread(input).start();
		//transform section 
		TransformBlock transform = new TransformBlock(inputqueue, tranformqueue);
		new Thread(transform).start();
		//output section
		OutputBlock output = new OutputBlock(tranformqueue);
		new Thread(output).start();
		Thread.sleep(1000);
	}

}
