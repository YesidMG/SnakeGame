package threads;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import View.SnakePanel;

public class Snake extends Thread {

	SnakePanel snake;
	boolean advance = true;
	LinkedList<String> movimientos = new LinkedList<>();
	String direction="r";

	public Snake(SnakePanel snake) {
		this.snake=snake;
	}

	@Override
	public void run() {
		while(advance) {			
			if(movimientos.isEmpty()) {
				advance=snake.avanzar(direction);
			}else {
				direction=movimientos.removeFirst();
				advance=snake.avanzar(direction);
			}
			try {		
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(snake, "Game over");
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
	
	

}
