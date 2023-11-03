package threads;

import View.PlayPanels.ObjectsPanel;

public class Barriers extends Thread {

	Snake snake;
	ObjectsPanel ob;

	public Barriers(Snake snake, ObjectsPanel ob) {
		this.snake=snake;
		this.ob=ob;
	}

	@Override
	public void run() {
		while(snake.isAlive()) {		
			ob.generarBarrier();
			try {		
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
