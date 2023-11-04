package View.MenuPanels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.Components.JtextPlaceHolder;
import View.Components.MenuBoton;

public class GameReStartPanel extends JPanel{

	private MenuBoton playStart;
	private MenuBoton backToMenu;
	private JtextPlaceHolder name;
	private JLabel difycultiLabel;
	private JLabel score;
	private JLabel bestScore;
	private JLabel theBestScore;
	private JLabel lost;


	private JComboBox<String> levels;

	public GameReStartPanel(int x, int y, int width, int height, ActionListener listener)  {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	private void initComponents(ActionListener listener)  {

		name = new JtextPlaceHolder("Put a name", (int)(this.getWidth()*0.2), (int)(this.getHeight()*0.26), (int)(this.getWidth()*0.6), (int)(this.getHeight()*0.08), getForeground(), getBackground());
		this.add(name);

		lost = new JLabel("YOU LOST");
		lost.setBounds((int)(this.getWidth()*0.35), (int)(this.getHeight()*0.34), (int)(this.getWidth()*0.3), (int)(this.getHeight()*0.111));
		lost.setFont(new Font("Arial", Font.BOLD, 21));
		lost.setOpaque(false);
		this.add(lost);
		
		score = new JLabel("You Score:");
		score.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.43), (int)(this.getWidth()*0.3), (int)(this.getHeight()*0.111));
		score.setFont(new Font("Arial", Font.PLAIN, 21));
		score.setOpaque(false);
		this.add(score);
		
		bestScore = new JLabel("You best Score:");
		bestScore.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.5), (int)(this.getWidth()*0.35), (int)(this.getHeight()*0.111));
		bestScore.setFont(new Font("Arial", Font.PLAIN, 21));
		bestScore.setOpaque(false);
		this.add(bestScore);
		
		theBestScore = new JLabel("The best Score:");
		theBestScore.setBounds((int)(this.getWidth()*0.15), (int)(this.getHeight()*0.57), (int)(this.getWidth()*0.35), (int)(this.getHeight()*0.111));
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
		this.add(levels);

		playStart = new MenuBoton("REPLAY",(int)(this.getWidth()*0.104), (int)(this.getHeight()*0.87), (int)(this.getWidth()*0.386), (int)(this.getHeight()*0.111));
		playStart.setActionCommand("playReStart");
		playStart.addActionListener(listener);
		this.add(playStart);

		backToMenu = new MenuBoton("MENU",(int)(this.getWidth()*0.55), (int)(this.getHeight()*0.87), (int)(this.getWidth()*0.38), (int)(this.getHeight()*0.111));
		backToMenu.setActionCommand("backToMenu2");
		backToMenu.addActionListener(listener);
		this.add(backToMenu);

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		super.paintComponent(g2);
		ImageIcon ic= new ImageIcon("images/startmenu.jpg");
		Icon icon= new ImageIcon(ic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)) ;
		icon.paintIcon(this, g2, 0, 0);
	}

}
