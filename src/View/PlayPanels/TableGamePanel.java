package View.PlayPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TableGamePanel extends JPanel{

	private Color color1;
	private Color color2;
	
	public TableGamePanel(int x, int y, int width, int height) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		color1= new Color(170,214,80);
		color2= new Color(162,208,72);
		this.initComponents();
	}

	private void initComponents() {}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 17; j++) {
				if(i%2 ==0) {
					if(j%2==0) {
						g2.setColor(color1);
					}else {
						g2.setColor(color2);
					}
				}else {
					if(j%2==0) {
						g2.setColor(color2);
					}else {
						g2.setColor(color1);
					}
				}
				g2.fillRect(40*j, 40*i, 40, 40);
			} 
		}
	}
}