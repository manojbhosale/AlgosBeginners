package main.com.kumar.algos.queues;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public final class CallCenterSimulator {
	private static final int NUMBER_OF_ARGS = 4;
	private static final int NUMBER_OF_AGENTS_ARG = 0;
	private static final int NUMBER_OF_CALLS_ARG = 1;
	private static final int MAX_CALL_DURATION_ARG = 2;
	private static final int MAX_CALL_INTERVAL_ARG = 3;

	private CallCenterSimulator() {
	}

	public static void main(String args[]) throws IOException{

		assert args != null: "args cant be null !!";

		/*if(args.length != NUMBER_OF_ARGS){
			System.out.println("Usage: CallGenerator <numberOfAgents>"
					+ " <numberOfCalls> <maxCallDuration>"
					+ " <maxCallInterval>");
			System.exit(-1);
		}*/

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		System.out.print("Enter something : ");
		String input = br.readLine();
		String[] splited = input.split("\\s");


		CallCenter callCenter =
				//new CallCenter(Integer.parseInt(args[NUMBER_OF_AGENTS_ARG]));
				new CallCenter(Integer.parseInt(splited[0]));

		CallGenerator generator =
				new CallGenerator(callCenter,
						Integer.parseInt(splited[1]),
						Integer.parseInt(splited[2]),
						Integer.parseInt(splited[3]));
		callCenter.open();
		try {
			generator.generateCalls();
		} finally {
			callCenter.close();
		}
	}
}

