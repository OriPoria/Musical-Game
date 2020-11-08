package game;

public class MyGameDetails implements GameDetails{

	private int score = 0;
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void setScore(int score) {
		this.score = score;
		System.out.println("set new score: " + score);
		
	}

}
