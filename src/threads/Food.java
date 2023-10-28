package threads;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import View.ObjectsPanel;
import View.SnakePanel;

public class Food extends Thread {

	Snake snake;
	ObjectsPanel ob;
	SnakePanel snakep;


	public Food(Snake snake, ObjectsPanel ob, SnakePanel snakep) {
		this.snake=snake;
		this.ob=ob;
		this.snakep= snakep;

	}

	@Override
	public void run() {
		while(snake.advance) {	
			try {
				for (int i = 0; i < 50; i++) {
					Thread.sleep(100);
					if (!snakep.isEat()) {
						snakep.setEat(true);
						break;
					}
				}
				ob.generarFood();
			} catch (InterruptedException e) {
			}
		}
	}
}
