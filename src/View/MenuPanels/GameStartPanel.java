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

public class GameStartPanel extends JPanel{

	private MenuBoton playStart;
	private MenuBoton backToMenu;
	private JtextPlaceHolder name;
	private JLabel difycultiLabel;
	private JComboBox<String> levels;

	public GameStartPanel(int x, int y, int width, int height, ActionListener listener)  {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	private void initComponents(ActionListener listener)  {

		name = new JtextPlaceHolder("Put a name", (int)(this.getWidth()*0.2), (int)(this.getHeight()*0.26), (int)(this.getWidth()*0.6), (int)(this.getHeight()*0.08), getForeground(), getBackground());
		this.add(name);

		difycultiLabel = new JLabel("SELECT THE DIFFICULTY");
		difycultiLabel.setBounds((int)(this.getWidth()*0.25), (int)(this.getHeight()*0.4), (int)(this.getWidth()*0.53), (int)(this.getHeight()*0.111));
		difycultiLabel.setFont(new Font("Arial", Font.BOLD, 21));
		difycultiLabel.setOpaque(false);
		this.add(difycultiLabel);
		
		
		levels = new JComboBox<>();
		levels.setBounds((int)(this.getWidth()*0.3), (int)(this.getHeight()*0.55), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		this.add(levels);

		playStart = new MenuBoton("PLAY",(int)(this.getWidth()*0.2), (int)(this.getHeight()*0.7), (int)(this.getWidth()*0.6), (int)(this.getHeight()*0.111));
		playStart.setActionCommand("playStart");
		playStart.addActionListener(listener);
		this.add(playStart);

		backToMenu = new MenuBoton("BACK TO MENU",(int)(this.getWidth()*0.2), (int)(this.getHeight()*0.85), (int)(this.getWidth()*0.6), (int)(this.getHeight()*0.111));
		backToMenu.setActionCommand("backToMenu1");
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
