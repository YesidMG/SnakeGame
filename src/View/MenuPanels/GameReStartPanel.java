package View.MenuPanels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Levels;
import View.Components.JtextPlaceHolder;
import View.Components.MenuBoton;

public class GameReStartPanel extends JPanel{

	private MenuBoton playStart;
	private MenuBoton backToMenu;
	private JtextPlaceHolder namePlayed;
	private JLabel difycultiLabel;
	private JLabel scoreTittle;
	private JLabel score;
	private JLabel bestScoreTittle;
	private JLabel bestScore;
	private JLabel theBestScoreTittle;
	private JLabel theBestScore;
	private JLabel lost;


	private JComboBox<Levels> levels;

	public GameReStartPanel(int x, int y, int width, int height,ArrayList<Levels> lvs, ActionListener listener)  {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener, lvs);
	}

	private void initComponents(ActionListener listener, ArrayList<Levels> lvs)  {

		namePlayed = new JtextPlaceHolder("Put a name", (int)(this.getWidth()*0.2), (int)(this.getHeight()*0.26), (int)(this.getWidth()*0.6), (int)(this.getHeight()*0.08), getForeground(), getBackground());
		this.add(namePlayed);

		lost = new JLabel("YOU LOST");
		lost.setBounds((int)(this.getWidth()*0.35), (int)(this.getHeight()*0.34), (int)(this.getWidth()*0.3), (int)(this.getHeight()*0.111));
		lost.setFont(new Font("Arial", Font.BOLD, 21));
		lost.setOpaque(false);
		this.add(lost);
		
		scoreTittle = new JLabel("You Score:");
		scoreTittle.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.43), (int)(this.getWidth()*0.3), (int)(this.getHeight()*0.111));
		scoreTittle.setFont(new Font("Arial", Font.PLAIN, 21));
		scoreTittle.setOpaque(false);
		this.add(scoreTittle);
		
		score = new JLabel("0");
		score.setBounds((int)(this.getWidth()*0.52), (int)(this.getHeight()*0.43), (int)(this.getWidth()*0.3), (int)(this.getHeight()*0.111));
		score.setFont(new Font("Arial", Font.PLAIN, 21));
		score.setOpaque(false);
		this.add(score);
		
		bestScoreTittle = new JLabel("You best Score:");
		bestScoreTittle.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.5), (int)(this.getWidth()*0.35), (int)(this.getHeight()*0.111));
		bestScoreTittle.setFont(new Font("Arial", Font.PLAIN, 21));
		bestScoreTittle.setOpaque(false);
		this.add(bestScoreTittle);
		
		bestScore = new JLabel("0");
		bestScore.setBounds((int)(this.getWidth()*0.52), (int)(this.getHeight()*0.5), (int)(this.getWidth()*0.35), (int)(this.getHeight()*0.111));
		bestScore.setFont(new Font("Arial", Font.PLAIN, 21));
		bestScore.setOpaque(false);
		this.add(bestScore);
		
		theBestScoreTittle = new JLabel("The best Score:");
		theBestScoreTittle.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.57), (int)(this.getWidth()*0.35), (int)(this.getHeight()*0.111));
		theBestScoreTittle.setFont(new Font("Arial", Font.PLAIN, 21));
		theBestScoreTittle.setOpaque(false);
		this.add(theBestScoreTittle);
		
		theBestScore = new JLabel("0");
		theBestScore.setBounds((int)(this.getWidth()*0.52), (int)(this.getHeight()*0.57), (int)(this.getWidth()*0.35), (int)(this.getHeight()*0.111));
		theBestScore.setFont(new Font("Arial", Font.PLAIN, 21));
		theBestScore.setOpaque(false);
		this.add(theBestScore);

		difycultiLabel = new JLabel("SELECT THE DIFFICULTY");
		difycultiLabel.setBounds((int)(this.getWidth()*0.25), (int)(this.getHeight()*0.64), (int)(this.getWidth()*0.53), (int)(this.getHeight()*0.111));
		difycultiLabel.setFont(new Font("Arial", Font.BOLD, 21));
		difycultiLabel.setOpaque(false);
		this.add(difycultiLabel);

		levels = new JComboBox<>();
		levels.setBounds((int)(this.getWidth()*0.3), (int)(this.getHeight()*0.75), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		for(Levels level: lvs) {
			levels.addItem(level);
		}
		this.add(levels);

		playStart = new MenuBoton("REPLAY",(int)(this.getWidth()*0.104), (int)(this.getHeight()*0.87), (int)(this.getWidth()*0.386), (int)(this.getHeight()*0.111));
		playStart.setActionCommand("play");
		playStart.addActionListener(listener);
		this.add(playStart);

		backToMenu = new MenuBoton("MENU",(int)(this.getWidth()*0.55), (int)(this.getHeight()*0.87), (int)(this.getWidth()*0.38), (int)(this.getHeight()*0.111));
		backToMenu.setActionCommand("backToMenu");
		backToMenu.addActionListener(listener);
		this.add(backToMenu);

	}
	
	public void showScores(String score,String bestScore, String thebest ) {
		this.score.setText(score);
		this.bestScore.setText(bestScore);
		this.theBestScore.setText(thebest);
		this.revalidate();
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		super.paintComponent(g2);
		ImageIcon ic= new ImageIcon("images/startmenu.jpg");
		Icon icon= new ImageIcon(ic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)) ;
		icon.paintIcon(this, g2, 0, 0);
	}

	public JComboBox<Levels> getLevels() {
		return levels;
	}

	public void setLevels(JComboBox<Levels> levels) {
		this.levels = levels;
	}

	public JtextPlaceHolder getNamePlayed() {
		return namePlayed;
	}

	public void setNamePlayed(JtextPlaceHolder namePlayed) {
		this.namePlayed = namePlayed;
	}

	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	public JLabel getBestScore() {
		return bestScore;
	}

	public void setBestScore(JLabel bestScore) {
		this.bestScore = bestScore;
	}

	public JLabel getTheBestScore() {
		return theBestScore;
	}

	public void setTheBestScore(JLabel theBestScore) {
		this.theBestScore = theBestScore;
	}

	
	
	
	

}
