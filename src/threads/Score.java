package threads;

import View.PlayPanels.ScorePanel;

public class Score extends Thread {

	Snake snake;
	Food food;
	int foodEat=0;
	int time=0;
	int score;
	int velocity=200;
	ScorePanel scorePanel;

	public Score(Snake snake, Food food, ScorePanel scorePanel) {
		this.snake=snake;
		this.food = food;
		this.scorePanel = scorePanel;
	}

	@Override
	public void run() {
		while(snake.isAlive()) {	
			try {
				if(velocity-snake.getVelocity() != Integer.parseInt(scorePanel.getVelocity().getText())) {
					scorePanel.getVelocity().setText(""+(velocity-snake.getVelocity()));
				}
				Thread.sleep(100);
				time++;
				if(time%10==0) {
					scorePanel.getTime().setText(""+(time/10));
				}
				if(foodEat!=food.getFoodEat()) {
					foodEat=food.getFoodEat();
					scorePanel.getFoodConsumed().setText(""+foodEat);
					score += food.getTimeToEat();
					scorePanel.getScore().setText(""+score);	




				}

			} catch (InterruptedException e) {
			}
		}
	}
}
