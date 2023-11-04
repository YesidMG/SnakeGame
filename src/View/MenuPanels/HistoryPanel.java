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
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Levels;
import Model.UserHistoryScore;
import View.Components.JtextPlaceHolder;
import View.Components.MenuBoton;

public class HistoryPanel extends JPanel{

	private MenuBoton backToMenu;
	private JLabel difycultiLabel;
	private JComboBox<Levels> levels;
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel model;
	private PriorityQueue<UserHistoryScore> easyHistory;
	private PriorityQueue<UserHistoryScore> mediumHistory;
	private PriorityQueue<UserHistoryScore> advancedHistory;


	public HistoryPanel(int x, int y, int width, int height,ArrayList<Levels> lvs,PriorityQueue<UserHistoryScore> easy,PriorityQueue<UserHistoryScore> medium,PriorityQueue<UserHistoryScore> advanced ,ActionListener listener)  {
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.easyHistory = easy;
		this.mediumHistory= medium;
		this.advancedHistory = advanced;
		this.initComponents(listener,lvs);
	}

	private void initComponents(ActionListener listener, ArrayList<Levels> lvs)  {

		difycultiLabel = new JLabel("DIFFICULTY HISTORY: ");
		difycultiLabel.setBounds((int)(this.getWidth()*0.06), (int)(this.getHeight()*0.285), (int)(this.getWidth()*0.53), (int)(this.getHeight()*0.111));
		difycultiLabel.setFont(new Font("Arial", Font.BOLD, 19));
		difycultiLabel.setOpaque(false);
		this.add(difycultiLabel);

		levels = new JComboBox<>();
		levels.setBounds((int)(this.getWidth()*0.55), (int)(this.getHeight()*0.3), (int)(this.getWidth()*0.3), (int)(this.getHeight()*0.08));
		for(Levels level: lvs) {
			levels.addItem(level);
		}
		levels.setActionCommand("changeTable");
		levels.addActionListener(listener);
		this.add(levels);

		model = new DefaultTableModel();
		String [] columns = new String[] {"Name","Score","Date"};
		model.setColumnIdentifiers(columns);
		for(UserHistoryScore user: easyHistory) {
			String [] u = new String[] {user.getName(),""+user.getBestScore(),user.getDateScore()};
			model.addRow(u);
		}
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setBounds((int)(this.getWidth()*0.08), (int)(this.getHeight()*0.4), (int)(this.getWidth()*0.84), (int)(this.getHeight()*0.4));
		this.add(scroll);

		backToMenu = new MenuBoton("BACK TO MENU",(int)(this.getWidth()*0.2), (int)(this.getHeight()*0.85), (int)(this.getWidth()*0.6), (int)(this.getHeight()*0.111));
		backToMenu.setActionCommand("backToMenu");
		backToMenu.addActionListener(listener);
		this.add(backToMenu);

	}

	public void changeTable() {
		model.setRowCount(0);
		if(levels.getSelectedItem().toString().equals("easy")) {
			for(UserHistoryScore user: easyHistory) {
				String [] u = new String[] {user.getName(),""+user.getBestScore(),user.getDateScore()};
				model.addRow(u);
			}
		}else if(levels.getSelectedItem().toString().equals("medium")) {
			for(UserHistoryScore user: mediumHistory) {
				String [] u = new String[] {user.getName(),""+user.getBestScore(),user.getDateScore()};
				model.addRow(u);
			}
		}else {
			for(UserHistoryScore user: advancedHistory) {
				String [] u = new String[] {user.getName(),""+user.getBestScore(),user.getDateScore()};
				model.addRow(u);
			}
		}
		repaint();
		revalidate();
	}
	
	public void updateTables(String level, PriorityQueue<UserHistoryScore> list) {
		if(level.equals("easy")) {
			this.easyHistory = list;
		}else if(level.equals("medium")) {
			this.mediumHistory= list;
		}else {
			this.advancedHistory = list;
		}
		this.changeTable();
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



}
