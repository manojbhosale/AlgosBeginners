package main.com.kumar.algos.queues;

public class Call {
	private final int _id;
	private final int _duration;
	private final long _startTime;
	public Call(int id, int duration) {
		assert duration >= 0 : "callTime can’t be < 0";
		_id = id;
		_duration = duration;
		_startTime = System.currentTimeMillis();
	}
	public String toString() {
		return "Call " + _id;
	}

	public void answer() {
		System.out.println(this + " answered; waited "
				+ (System.currentTimeMillis() - _startTime)
				+ " milliseconds");
		try {
			Thread.sleep(_duration);
		} catch (InterruptedException e) {
			// Ignore
		}
	}
}
