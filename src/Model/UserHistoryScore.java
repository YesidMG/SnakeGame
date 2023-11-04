package Model;

public class UserHistoryScore implements Comparable<UserHistoryScore> {
	
	private String name;
	private String level;
	private int bestScore;
	private String dateScore;
	
	public UserHistoryScore(String name, String level, int bestScore, String dateScore) {
		this.name = name;
		this.level = level;
		this.bestScore = bestScore;
		this.dateScore = dateScore;
	}
	
	@Override
	public int compareTo(UserHistoryScore o) {
		if(this.bestScore > o.getBestScore())return-1;
		if(this.bestScore < o.getBestScore())return 1;
		if(this.bestScore == o.getBestScore())return 1;
		return 0;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	public String getDateScore() {
		return dateScore;
	}

	public void setDateScore(String dateScore) {
		this.dateScore = dateScore;
	}

}
