package Model;

public class Levels {

	private String level;
	private int initialVelocity;
	private int timeFood;
	private int timeBarrier;
	
	public Levels(String level, int initialVelocity, int timeFood, int timeBarrier) {
		
		this.level = level;
		this.initialVelocity = initialVelocity;
		this.timeFood = timeFood;
		this.timeBarrier = timeBarrier;
	}
	
	

	@Override
	public String toString() {
		return ""+level;
	}



	public String getLevel() {
		return level;
	}

	public int getInitialVelocity() {
		return initialVelocity;
	}

	public int getTimeFood() {
		return timeFood;
	}

	public int getTimeBarrier() {
		return timeBarrier;
	}



	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
