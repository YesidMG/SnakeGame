package View.MenuPanels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.Components.MenuBoton;

public class MenuPanel extends JPanel{

	private MenuBoton play;
	private MenuBoton viewHistory;

	public MenuPanel(int x, int y, int width, int height, ActionListener listener)  {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	private void initComponents(ActionListener listener)  {

		play = new MenuBoton("PLAY",(int)(this.getWidth()*0.104), (int)(this.getHeight()*0.75), (int)(this.getWidth()*0.386), (int)(this.getHeight()*0.111));
		play.setActionCommand("play");
		play.addActionListener(listener);
		this.add(play);

		viewHistory = new MenuBoton("VIEW HISTORY",(int)(this.getWidth()*0.55), (int)(this.getHeight()*0.75), (int)(this.getWidth()*0.38), (int)(this.getHeight()*0.111));
		viewHistory.setActionCommand("history");
		viewHistory.addActionListener(listener);
		this.add(viewHistory);

	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		super.paintComponent(g2);
		ImageIcon ic= new ImageIcon("images/menuSnale.jpeg");
		Icon icon= new ImageIcon(ic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)) ;
		icon.paintIcon(this, g2, 0, 0);
	}

}
