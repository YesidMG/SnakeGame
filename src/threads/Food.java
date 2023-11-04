package threads;

import View.PlayPanels.ObjectsPanel;
import View.PlayPanels.SnakePanel;

public class Food extends Thread {

	private Snake snake;
	private ObjectsPanel ob;
	private SnakePanel snakep;
	private int foodEat;
	private double timeToEat;
	private int timeSleep;

	public Food(Snake snake, ObjectsPanel ob, SnakePanel snakep, int timeSleep) {
		this.snake=snake;
		this.ob=ob;
		this.snakep= snakep;
		foodEat=0;
		timeToEat=0;
		this.timeSleep = timeSleep;
	}

	@Override
	public void run() {
		while(snake.isAlive()) {	
			try {
				for (int i = 0; i < (timeSleep*10); i++) {
					Thread.sleep(100);
					if (!snakep.isEat()) {
						foodEat++;
						snake.setSize(foodEat);
						if(Math.round(((timeSleep-(double)i/10.0)))==0) {
							timeToEat=1;	
						}else {
							timeToEat=Math.round(((timeSleep-(double)i/10.0)));
						}
						snakep.setEat(true);
						break;
					}
				}
				ob.generarFood();

			} catch (InterruptedException e) {
			}
		}
	}



	public int getFoodEat() {
		return foodEat;
	}
	public void setFoodEat(int foodEat) {
		this.foodEat = foodEat;
	}
	public double getTimeToEat() {
		return timeToEat;
	}
	public void setTimeToEat(int timeToEat) {
		this.timeToEat = timeToEat;
	}
}
