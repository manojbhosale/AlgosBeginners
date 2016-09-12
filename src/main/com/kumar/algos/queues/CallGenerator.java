package main.com.kumar.algos.queues;

public class CallGenerator {
	
	private final CallCenter _callCenter;
	private final int _numberOfCalls;
	
	private final int _maxCallDuration;
	private final int _maxCallInterval;
	
	public CallGenerator(CallCenter callCenter, int numberOfCalls, int maxCallDuration, int maxCallInterval){
		
		assert callCenter != null : "callCenter can’t be null";
		assert numberOfCalls > 0 : "numberOfCalls can’t be < 1";
		assert maxCallDuration > 0 : "maxCallDuration can’t be < 1";
		assert maxCallInterval > 0 : "maxCallInterval can’t be < 1";
		
		_callCenter = callCenter;
		_numberOfCalls = numberOfCalls;
		_maxCallDuration = maxCallDuration;
		_maxCallInterval = maxCallInterval;
	}
	public void generateCalls(){
		for(int i = 0; i < _numberOfCalls ; ++i){
			sleep();
			_callCenter.accept(new Call(i, (int)Math.random() * _maxCallDuration));
		}
	}
	
	public void sleep(){
		try{
			Thread.sleep((int)Math.random() * _maxCallInterval);
		}catch(InterruptedException e){
			//ignore
		}
	}

}
