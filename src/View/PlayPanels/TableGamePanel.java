package View.PlayPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TableGamePanel extends JPanel{

	Color color1= new Color(170,214,80);
	Color color2= new Color(162,208,72);
	
	Color color3= Color.BLUE;
	Color color4= Color.white;

	public TableGamePanel(int x, int y, int width, int height) {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
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