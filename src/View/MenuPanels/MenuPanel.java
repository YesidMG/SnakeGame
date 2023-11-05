package View.MenuPanels;

import java.awt.Font;
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
	private JLabel logo;
	private JLabel studentName;
	private JLabel id;
	private JLabel faculatad;
	private JLabel school;
	private JLabel year;
	private JLabel course;


	public MenuPanel(int x, int y, int width, int height, ActionListener listener)  {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	private void initComponents(ActionListener listener)  {

		logo = new JLabel();
		logo.setBounds((int)(this.getWidth()*0.02), (int)(this.getHeight()*0.02), (int)(this.getWidth()*0.25), (int)(this.getHeight()*0.111));
		this.setImageLabel(logo, "images/logouptc.png");
		this.add(logo);

		studentName = new JLabel("Yesid Alejandro Martinez Guerrero");
		studentName.setBounds((int)(this.getWidth()*0.28), (int)(this.getHeight()*0.01), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		studentName.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(studentName);

		id = new JLabel("202212497");
		id.setBounds((int)(this.getWidth()*0.7), (int)(this.getHeight()*0.01), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		id.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(id);

		faculatad = new JLabel("Facultad: Ingenieria");
		faculatad.setBounds((int)(this.getWidth()*0.28), (int)(this.getHeight()*0.04), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		faculatad.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(faculatad);

		school = new JLabel("Escuela: Sistemas");
		school.setBounds((int)(this.getWidth()*0.5), (int)(this.getHeight()*0.04), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		school.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(school);

		course = new JLabel("Curso: Programacion III");
		course.setBounds((int)(this.getWidth()*0.7), (int)(this.getHeight()*0.04), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		course.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(course);
		
		year = new JLabel("2023");
		year.setBounds((int)(this.getWidth()*0.28), (int)(this.getHeight()*0.07), (int)(this.getWidth()*0.4), (int)(this.getHeight()*0.08));
		year.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(year);

		play = new MenuBoton("PLAY",(int)(this.getWidth()*0.104), (int)(this.getHeight()*0.75), (int)(this.getWidth()*0.386), (int)(this.getHeight()*0.111));
		play.setActionCommand("playMenu");
		play.addActionListener(listener);
		this.add(play);

		viewHistory = new MenuBoton("VIEW HISTORY",(int)(this.getWidth()*0.55), (int)(this.getHeight()*0.75), (int)(this.getWidth()*0.38), (int)(this.getHeight()*0.111));
		viewHistory.setActionCommand("history");
		viewHistory.addActionListener(listener);
		this.add(viewHistory);

	}

	private void setImageLabel(JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
		labelName.setIcon(icon);
		this.repaint();
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
