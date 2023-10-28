package View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MenuPanel extends JPanel{
	
	public MenuPanel(int x, int y, int width, int height) {
		this.setBackground(new Color(255, 223, 186)); 
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents();
	}
	
	private void initComponents() {}
	

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
}
