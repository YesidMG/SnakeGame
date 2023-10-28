package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import threads.Barriers;
import threads.Food;
import threads.Snake;

public class MyFrame extends JFrame {

	private MenuPanel menu;
	private TableGamePanel table;
	private SnakePanel snake;
	private ObjectsPanel ob;
	private Barriers barrier;
	private Food food;
	Snake snakeMove;

	public MyFrame() {
		super("Fast and serpentine");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize((17*40)+16, (15*40)+120);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.initComponents();
		this.requestFocus(true);

		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP:
					snakeMove.addNewDirection("u");
					break;
				case KeyEvent.VK_DOWN:
					snakeMove.addNewDirection("d");
					break;
				case KeyEvent.VK_LEFT:
					snakeMove.addNewDirection("l");
					break;
				case KeyEvent.VK_RIGHT:
					snakeMove.addNewDirection("r");
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
		});
	}

	private void initComponents() {

		menu = new MenuPanel(0, 0, (17*40), 80);
		table= new TableGamePanel(0,80, 17*40, 15*40);
		snake= new SnakePanel(0,80, 17*40, 15*40);
		snakeMove = new Snake(snake);
		snakeMove.start();
		ob = new ObjectsPanel(0,80, 17*40, 15*40, snake);
		barrier = new Barriers(snakeMove, ob); 
		barrier.start();
		food = new Food(snakeMove, ob, snake); 
		food.start();

		this.add(menu);
		this.add(ob);
		this.add(snake);
		this.add(table);
		

	}



	public static void main (String args[]) {
		new MyFrame();
	}
}


