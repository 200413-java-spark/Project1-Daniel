package project1.spark.io;

public class PlayersCSV {
	public String name;
	public int age;
	public String nationality;
	public String club;
	public int overall;
	public int potential;
	public int valueEuro;
	public int weakFoot;
	public int skillMove;
	public String position;
	public int pace;
	public int shooting;
	public int passing;
	public int dribbling;
	public int defending;
	public int physical;
	
	PlayersCSV(String name, String age, String nationality, String club, String overall, String potential,
		String valueEuro, String weakFoot, String skillMove, String position, String pace, String shooting,
		String passing, String dribbling, String defending, String physical) {
		
		this.name = name;
		this.age = Integer.parseInt(age);
		this.nationality = nationality;
		this.club = club;
		this.overall = Integer.parseInt(overall);
		this.potential = Integer.parseInt(potential);
		this.valueEuro = Integer.parseInt(valueEuro);
		this.weakFoot = Integer.parseInt(weakFoot);
		this.skillMove = Integer.parseInt(skillMove);
		this.position = position;
		this.pace = Integer.parseInt(pace);
		this.shooting = Integer.parseInt(shooting);
		this.passing = Integer.parseInt(passing);
		this.dribbling = Integer.parseInt(dribbling);
		this.defending = Integer.parseInt(defending);
		this.physical = Integer.parseInt(physical);
	}

}
