package threads;

import java.util.LinkedList;
import View.ControllerFrame.MyFrame;
import View.PlayPanels.SnakePanel;

public class Snake extends Thread {

	private MyFrame frame;
	private SnakePanel snake;
	private boolean advance;
	private LinkedList<String> movimientos ;
	private String direction;
	private int size;
	private int initialVelocity;
	private int advanceVelocity;

	public Snake(SnakePanel snake, MyFrame frame,int initialVelocity) {
		this.snake=snake;
		this.frame = frame;
		advance = true;
		movimientos = new LinkedList<>();
		direction="r";
		size=0;
		this.initialVelocity = initialVelocity;
		advanceVelocity =initialVelocity;
	}

	@Override
	public void run() {
		
		advanceVelocity = initialVelocity;
		
		while(advance) {			
			if(movimientos.isEmpty()) {
				advance=snake.avanzar(direction);
			}else {
				direction=movimientos.removeFirst();
				advance=snake.avanzar(direction);
			}
			try {	if(initialVelocity-size != advanceVelocity) {
				advanceVelocity=initialVelocity-size;
			}
			if(advanceVelocity <= (initialVelocity-50)) {
				advanceVelocity -=size;
			}
			Thread.sleep(advanceVelocity);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		frame.showRePlayMenu();
	}

	public void addNewDirection(String newDirection) {
		if(movimientos.isEmpty()) {
			if(movComprovate(direction, newDirection)) {
				movimientos.offer(newDirection);
			}
		}else {
			if(movComprovate(movimientos.get(movimientos.size()-1), newDirection)) {
				movimientos.offer(newDirection);
			}
		}
	}

	private boolean movComprovate(String direction1,String direction2) {
		boolean action=false;
		if((direction1.equals("r")|| direction1.equals("l"))&&(direction2.equals("u")||direction2.endsWith("d"))) {
			action=true;

		}else if((direction1.equals("u")|| direction1.equals("d"))&&(direction2.equals("l")||direction2.endsWith("r"))) {
			action=true;
		}
		return action;
	}



	public boolean isAdvance() {
		return advance;
	}
	public void setAdvance(boolean advance) {
		this.advance = advance;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public int getInitialVelocity() {
		return initialVelocity;
	}

	public void setInitialVelocity(int initialVelocity) {
		this.initialVelocity = initialVelocity;
	}

	public int getAdvanceVelocity() {
		return advanceVelocity;
	}

	public void setAdvanceVelocity(int advanceVelocity) {
		this.advanceVelocity = advanceVelocity;
	}
	
	

}
