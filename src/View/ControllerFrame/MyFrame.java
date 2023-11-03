package View.ControllerFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import View.MenuPanels.MenuPanel;
import View.PlayPanels.ObjectsPanel;
import View.PlayPanels.ScorePanel;
import View.PlayPanels.SnakePanel;
import View.PlayPanels.TableGamePanel;
import threads.Barriers;
import threads.Food;
import threads.Score;
import threads.Snake;

public class MyFrame extends JFrame implements ActionListener,KeyListener {

	private MenuPanel menu;
	private ScorePanel scorePanel;
	private TableGamePanel table;
	private SnakePanel snake;
	private ObjectsPanel ob;

	private Barriers barrier;
	private Food food;
	private Snake snakeMove;
	private Score score;

	public MyFrame()  {
		super("Fast and serpentine");
		this.setIconImage(new ImageIcon("images/logo.jpeg").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize((17*40)+16, (15*40)+120);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.initComponents(this);
		this.requestFocus(true);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();

		this.repaint();

	}

	private void initComponents(ActionListener listener)  {

		menu = new MenuPanel(0,0, this.getWidth(),this.getHeight(), listener);
		this.add(menu);


		scorePanel = new ScorePanel(0, 0, (17*40), 80);
		table= new TableGamePanel(0,80, 17*40, 15*40);

		snake= new SnakePanel(0,80, 17*40, 15*40);
		snakeMove = new Snake(snake);
		//		snakeMove.start();
		ob = new ObjectsPanel(0,80, 17*40, 15*40, snake);
		//		
		barrier = new Barriers(snakeMove, ob); 
		//		barrier.start();
		food = new Food(snakeMove, ob, snake); 
		//		food.start();
		score = new Score(snakeMove, food, scorePanel);
		//		score.start();
		//
		//		this.add(ob);
		//		this.add(snake);
		//		this.add(scorePanel);
		//		this.add(table);
	}

	public void showPlayMenu () {
		this.remove(menu);;
		this.add(ob);
		this.add(snake);
		this.add(scorePanel);
		this.add(table);
		
		
		
		
		
		
		snakeMove.start();
		barrier.start();
		food.start();
		score.start();

		
		//		this.add(scorePanel);
		//		this.add(table);
		//mientras



		this.revalidate();
		this.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		try {
			switch (source) {
			case "play": {	
				this.showPlayMenu();
				break;
			}
			}}catch (Exception e) {
			}	


	}
	public static void main (String args[]) {
		new MyFrame();
	}

	@Override
	public void keyTyped(KeyEvent e) {


	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(snakeMove.isAlive()) {
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}