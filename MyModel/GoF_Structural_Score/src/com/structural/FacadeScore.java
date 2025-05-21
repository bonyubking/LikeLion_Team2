package com.structural;

class ScoreService{
	private Score score;
	private WithGradeScore withGrade = new WithGradeScore(null);
	
	public ScoreService(int k, int e, int m) {
		score = new Score(k,e,m);
	}
	public void print() {
		System.out.println(score.getTotal());
		System.out.println(score.getAverage());
		System.out.println(withGrade.getReport());
	}
	
}

public class FacadeScore {
	public void printReport() {
		
	}
}




