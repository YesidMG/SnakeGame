package threads;

import View.PlayPanels.ObjectsPanel;

public class Barriers extends Thread {

	private Snake snake;
	private ObjectsPanel ob;
	private int timeSleep;

	public Barriers(Snake snake, ObjectsPanel ob, int timeSleep) {
		this.snake=snake;
		this.ob=ob;
		this.timeSleep = timeSleep;
	}

	@Override
	public void run() {
		while(snake.isAlive()) {		
			ob.generarBarrier();
			try {		
				Thread.sleep((timeSleep*1000));
			}catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
