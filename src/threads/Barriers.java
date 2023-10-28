package threads;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import View.ObjectsPanel;
import View.SnakePanel;

public class Barriers extends Thread {

	Snake snake;
	ObjectsPanel ob;
	
	

	public Barriers(Snake snake, ObjectsPanel ob) {
		this.snake=snake;
		this.ob=ob;
	}

	@Override
	public void run() {
		while(snake.advance) {		
			ob.generarBarrier();
			try {		
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}



}
