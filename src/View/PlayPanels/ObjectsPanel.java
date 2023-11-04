package View.PlayPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ConcurrentModificationException;
import java.util.Random;
import javax.swing.JPanel;

public class ObjectsPanel extends JPanel{

	private SnakePanel snakebody;
	private Color ColorFood;
	private Color Colorbarrier;
	private int [] barrierLocation;
	private int [] foodLocation;


	public ObjectsPanel(int x, int y, int width, int height, SnakePanel snakebody) {
		this.setOpaque(false);
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.snakebody = snakebody;
		ColorFood= Color.red;
		Colorbarrier= Color.DARK_GRAY;
		this.initComponents();
	}

	private void initComponents() {
		this.generarBarrier();
		this.generarFood();
	}

	public void generarFood() {	
		try {
			Random random = new Random();
			boolean correctLocation = true;
			int [] coordenates = {random.nextInt(17)*40,random.nextInt(14)*40};
			if(barrierLocation[0] == coordenates[0] && barrierLocation[1] == coordenates[1]) {
				correctLocation = false;
				this.generarFood();
			}else {
				for(int [] body : snakebody.getSnakeBody()) {
					if(body[0] == coordenates[0] && body[1] == coordenates[1]) {
						correctLocation = false;
						this.generarFood();
						break;
					}
				}
			}
			if(correctLocation) {
				foodLocation = coordenates;
				snakebody.setFood(foodLocation);
				this.repaint();
			}
		} catch (ConcurrentModificationException e) {
			this.generarFood();
			
		}
	}

	public void generarBarrier() {
		try {
			Random random = new Random();
			boolean correctLocation = true;
			int [] coordenates = {random.nextInt(17)*40,random.nextInt(14)*40};
			if(foodLocation!=null) {
				if(foodLocation[0] == coordenates[0] && foodLocation[1] == coordenates[1]) {
					correctLocation = false;
					this.generarBarrier();
				}
			}else {
				for(int [] body : snakebody.getSnakeBody()) {
					if(body[0] == coordenates[0] && body[1] == coordenates[1]) {
						correctLocation = false;
						this.generarBarrier();
						break;
					}
				}
			}
			if(correctLocation) {
				barrierLocation = coordenates;
				snakebody.setBarrier(barrierLocation);
				this.repaint();
			}

		} catch (ConcurrentModificationException e) {
			this.generarBarrier();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Colorbarrier);
		g.fillRoundRect(barrierLocation [0], barrierLocation [1], 40, 40,0, 0);
		g.setColor(ColorFood);
		g.fillRoundRect(foodLocation [0], foodLocation [1], 40, 40,50, 50);
	}

	public int[] getBarrierLocation() {
		return barrierLocation;
	}

	public void setBarrierLocation(int[] barrierLocation) {
		this.barrierLocation = barrierLocation;
	}




}