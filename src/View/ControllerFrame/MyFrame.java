package View.ControllerFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Levels;
import Model.ReadFile;
import View.MenuPanels.GameReStartPanel;
import View.MenuPanels.GameStartPanel;
import View.MenuPanels.HistoryPanel;
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

	private ReadFile file;
	private HistoryPanel history;
	private MenuPanel menu;
	private ScorePanel scorePanel;
	private TableGamePanel table;
	private SnakePanel snake;
	private ObjectsPanel ob;
	private GameStartPanel startGame;
	private GameReStartPanel reStartGame;
	private Barriers barrier;
	private Food food;
	private Snake snakeMove;
	private Score score;
	private int actualmenu;

	public MyFrame()  {
		super("Fast and serpentine");
		this.setIconImage(new ImageIcon("images/logo.jpeg").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize((17*40)+16, (15*40)+120);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.initComponents();
		this.requestFocus(true);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.repaint();
	}

	private void initComponents()  {
		file = new ReadFile();
		try {
			file.readFiles();
		} catch (IOException e) {
			e.printStackTrace();}
		actualmenu=0;
		menu = new MenuPanel(0,0, this.getWidth(),this.getHeight(), this);
		this.add(menu);
		history = new HistoryPanel((int)(this.getWidth()*0.15),(int)(this.getHeight()*0.15), (int)(this.getWidth()*0.7),
				(int)(this.getHeight()*0.7), file.getLevels(),file.getEasyHistory(),file.getMediumHistory(),file.getAdvancedHistory(),this);
		startGame = new GameStartPanel((int)(this.getWidth()*0.15),(int)(this.getHeight()*0.15), (int)(this.getWidth()*0.7),(int)(this.getHeight()*0.7), file.getLevels(),this);
		reStartGame = new GameReStartPanel((int)(this.getWidth()*0.15),(int)(this.getHeight()*0.15), (int)(this.getWidth()*0.7),(int)(this.getHeight()*0.7), file.getLevels(),this);
		scorePanel = new ScorePanel(0, 0, (17*40), 80);
		table= new TableGamePanel(0,80, 17*40, 15*40);
		snake= new SnakePanel(0,80, 17*40, 15*40);
		ob = new ObjectsPanel(0,80, 17*40, 15*40, snake);
	}

	public void showPlayMenu () {
		actualmenu=1;
		this.remove(menu);
		this.add(startGame);
		this.add(scorePanel);
		this.add(table);
		this.revalidate();
		this.repaint();
	}

	public void showRePlayMenu () {
		actualmenu=2;
		score.setNamePlayer(startGame.getNamePlayer().getText());
		String [] results = file.comprobate(score.getNamePlayer(), startGame.getLevels().getSelectedItem().toString(), Integer.parseInt(scorePanel.getScore().getText()));
		if(results[0].equals("s")) {
			history.updateTables(results[1], file.selectorList(results[1]));
		}
		reStartGame.showScores(""+score.getScore(), results[2], results[3]);
		this.remove(snake);
		this.remove(ob);
		this.remove(table);
		this.remove(scorePanel);
		this.add(reStartGame);
		this.add(scorePanel);
		this.add(table);
		this.revalidate();
		this.repaint();
	}

	public void showHistory () {
		actualmenu=3;
		this.remove(menu);
		this.add(history);
		this.add(scorePanel);
		this.add(table);
		this.revalidate();
		this.repaint();
	}

	public void play() {
		boolean bander=true;
		String namePlayed;
		if(actualmenu==1) {
			namePlayed = startGame.getNamePlayer().getText().replace(" ", "");
			if(namePlayed.equals("")||namePlayed.equals(null)) {
				bander= false;
			}else {
				reStartGame.getLevels().setSelectedIndex(startGame.getLevels().getSelectedIndex());
				reStartGame.getNamePlayed().setText(startGame.getNamePlayer().getText());
				this.remove(startGame);}

		}else if(actualmenu==2) {
			namePlayed = reStartGame.getNamePlayed().getText().replace(" ", "");
			if(namePlayed.equals("")||namePlayed.equals(null)) {
				bander= false;
			}else {
				startGame.getLevels().setSelectedIndex(reStartGame.getLevels().getSelectedIndex());
				startGame.getNamePlayer().setText(reStartGame.getNamePlayed().getText());
				this.remove(reStartGame);}
		}
		if(bander) {
			reset();
			this.remove(table);
			this.add(ob);
			this.add(snake);
			this.add(table);
			this.repaint();
			this.revalidate();	
		}else {
			JOptionPane.showMessageDialog(null, "you need to put a name", "warning", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void reset() {
		snake.initComponents();
		scorePanel.reStart();
		Levels lv = (Levels) startGame.getLevels().getSelectedItem();
		snakeMove = new Snake(snake, this, lv.getInitialVelocity());
		snakeMove.start();
		barrier = new Barriers(snakeMove, ob, lv.getTimeBarrier()); 
		food = new Food(snakeMove, ob, snake, lv.getTimeFood()); 
		barrier.start();
		food.start();
		score = new Score(snakeMove, food, scorePanel);
		score.start();
		this.revalidate();
		this.repaint();
	}

	public void backToMenu () {
		if(actualmenu==1) {
			this.remove(startGame);
		}else if(actualmenu==2) {
			this.remove(reStartGame);
		}else {
			this.remove(history);
		}
		this.remove(table);
		this.remove(scorePanel);
		this.add(menu);
		this.revalidate();
		this.repaint();
	}



	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		try {
			switch (source) {
			case "playMenu": {	
				showPlayMenu();
				break;
			}
			case "play": {	
				play();
				break;
			}
			case "backToMenu": {	
				backToMenu();
				break;
			}
			case "history": {	
				showHistory();
				break;
			}
			case "changeTable": {	
				history.changeTable();
				break;
			}
			}}catch (Exception e) {
			}	


	}
	public static void main (String args[]) {
		new MyFrame();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(snakeMove.isAlive()) {
			switch (keyCode) {
			case KeyEvent.VK_W:
				snakeMove.addNewDirection("u");
				break;
			case KeyEvent.VK_S:
				snakeMove.addNewDirection("d");
				break;
			case KeyEvent.VK_A:
				snakeMove.addNewDirection("l");
				break;
			case KeyEvent.VK_D:
				snakeMove.addNewDirection("r");
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}