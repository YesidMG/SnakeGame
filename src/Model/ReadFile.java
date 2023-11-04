package Model;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.PriorityQueue;

import javax.swing.JFileChooser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ReadFile {

	private JsonReader reader;
	private JFileChooser fileChooser ;

	private ArrayList<Levels> levels;
	private ArrayList<UserHistoryScore> allHistory;
	private PriorityQueue<UserHistoryScore> easyHistory;
	private PriorityQueue<UserHistoryScore> mediumHistory;
	private PriorityQueue<UserHistoryScore> advancedHistory;

	public ReadFile() {
		levels = new ArrayList<>();
		allHistory = new ArrayList<>();
		easyHistory = new PriorityQueue<>();
		mediumHistory = new PriorityQueue<>();
		advancedHistory = new PriorityQueue<>();

	}

	public void readFiles()throws  IOException {

		reader= new Gson().newJsonReader(new FileReader("data/levels.json"));
		Levels[] ls = new Gson().fromJson(reader, Levels[].class);
		for (int i = 0; i < ls.length; i++) {
			levels.add(ls[i]);}

		reader= new Gson().newJsonReader(new FileReader("data/history.json"));
		UserHistoryScore [] his = new Gson().fromJson(reader, UserHistoryScore[].class);
		for (int i = 0; i < his.length; i++) {
			allHistory.add(his[i]);
			if(his[i].getLevel().equals("easy")) {
				easyHistory.add(his[i]);
			} else if(his[i].getLevel().equals("medium")) {
				mediumHistory.add(his[i]);
			}else {
				advancedHistory.add(his[i]);
			}		
		}	
		reader.close();
	}

	public void writeUserHistory()throws  IOException {
		//		ArrayList<UserHistoryScore> users = new ArrayList<>();
		//		users.add(new UserHistoryScore("Dana", "easy", 106, "04-November-2023 02:22:55"));
		//		users.add(new UserHistoryScore("carlos", "medium", 39, "02-November-2023 14:22:50"));
		//		users.add(new UserHistoryScore("fabio", "advanced", 39, "03-November-2023 08:55:21"));
		//		users.add(new UserHistoryScore("Danluaa", "easy", 73, "04-November-2023 07:12:05"));

		PrintWriter print = new PrintWriter("data/history.json");
		GsonBuilder bilder = new GsonBuilder();
		bilder.setPrettyPrinting();
		String json = bilder.create().toJson(allHistory);
		print.write(json);
		print.close();
	}


	public String[] comprobate(String name,String level, int points) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm",Locale.ENGLISH);
		String nowStr = now.format(formatter);
		ArrayList<UserHistoryScore> listselected = new ArrayList<>(this.selectorList(level));
		String update="n";
		String maxLocalScore="";
		int count=-1;
		for(int i = 0; i<listselected.size(); i++) {
			if(listselected.get(i).getName().equals(name)) {
				count =i;
				break;
			}
		}if(count==-1) {
			update ="s";
			maxLocalScore = ""+points;
			UserHistoryScore newUser = new UserHistoryScore(name, level, points, nowStr);
			this.allHistory.add(newUser);
			this.selectorList(level).add(newUser);
			this.updateTable(level);
			try {
				this.writeUserHistory();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			if(listselected.get(count).getBestScore()< points) {
				update="s";
				maxLocalScore = ""+points;
				for (int i = 0; i < allHistory.size() ; i++ ) {
					if(allHistory.get(i).getName().equals(name) && allHistory.get(i).getLevel().equals(level)) {
						allHistory.get(i).setDateScore(nowStr);
						allHistory.get(i).setBestScore(points);
						break;
					}
				}
				this.updateTable(level);
				try {
					this.writeUserHistory();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				maxLocalScore = ""+listselected.get(count).getBestScore();
			}
		}
		//Primera variable se acualizo (y) o no se actualizo (n) la lista, segunda variable cual lista actualizo (en caso de actualizar)
		//tercera variable, puntaje maximo existente, ultima variable, puntaje maximo global
		return new String[] {update,level,maxLocalScore, ""+this.selectorList(level).peek().getBestScore()};
	}


	public PriorityQueue<UserHistoryScore> selectorList(String level){
		if(level.equals("easy")) {
			return this.easyHistory;
		}else if(level.equals("medium")) {
			return this.mediumHistory;
		}else {
			return this.advancedHistory;
		}
	}

	public void updateTable(String level) {
		if(level.equals("easy")) {
			easyHistory = new PriorityQueue<>();
			for(UserHistoryScore user:allHistory) {
				if(user.getLevel().equals("easy")) {
					easyHistory.add(user);
				}
			}
		}else if(level.equals("medium")) {
			mediumHistory = new PriorityQueue<>();
			for(UserHistoryScore user:allHistory) {
				if(user.getLevel().equals("medium")) {
					mediumHistory.add(user);
				}
			}
		}else {

			advancedHistory = new PriorityQueue<>();
			for(UserHistoryScore user:allHistory) {
				if(user.getLevel().equals("advanced")) {
					advancedHistory.add(user);
				}
			}

		}
	}

	public ArrayList<Levels> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Levels> levels) {
		this.levels = levels;
	}

	public ArrayList<UserHistoryScore> getAllHistory() {
		return allHistory;
	}

	public void setAllHistory(ArrayList<UserHistoryScore> allHistory) {
		this.allHistory = allHistory;
	}

	public PriorityQueue<UserHistoryScore> getEasyHistory() {
		return easyHistory;
	}

	public void setEasyHistory(PriorityQueue<UserHistoryScore> easyHistory) {
		this.easyHistory = easyHistory;
	}

	public PriorityQueue<UserHistoryScore> getMediumHistory() {
		return mediumHistory;
	}

	public void setMediumHistory(PriorityQueue<UserHistoryScore> mediumHistory) {
		this.mediumHistory = mediumHistory;
	}

	public PriorityQueue<UserHistoryScore> getAdvancedHistory() {
		return advancedHistory;
	}

	public void setAdvancedHistory(PriorityQueue<UserHistoryScore> advancedHistory) {
		this.advancedHistory = advancedHistory;
	}







}
