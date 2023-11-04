package threads;


import View.PlayPanels.ObjectsPanel;
import View.PlayPanels.SnakePanel;

public class Food extends Thread {

	Snake snake;
	ObjectsPanel ob;
	
	SnakePanel snakep;
	int foodEat=0;
	double timeToEat=0;

	public Food(Snake snake, ObjectsPanel ob, SnakePanel snakep) {
		this.snake=snake;
		this.ob=ob;
		this.snakep= snakep;
	
	}

	@Override
	public void run() {
		while(snake.isAlive()) {	
			try {
				for (int i = 0; i < 20; i++) {
					Thread.sleep(100);
					if (!snakep.isEat()) {
						foodEat++;
						snake.setSize(foodEat);
						if(Math.round(((2-(double)i/10.0)))==0) {
							timeToEat=1;	
						}else {
							timeToEat=Math.round(((2-(double)i/10.0)));
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
