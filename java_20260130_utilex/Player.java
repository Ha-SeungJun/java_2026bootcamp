package java_20260130_utilex;

public class Player implements Comparable<Player>{
	private String id;
	private String pw;
	private String name;
	private int win;
	private int loss;
	private int draw;
	private double rate;
	private int total = 0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;

	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
		this.total = this.win+this.loss +this.draw;
		if (this.total != 0) {this.rate = (double)this.win/this.total;}
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
		this.total = this.win+this.loss +this.draw;
		if (this.total != 0) {this.rate = (double)this.win/this.total;}
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
		this.total = this.win+this.loss +this.draw;
		if (this.total != 0) {this.rate = (double)this.win/this.total;}
	}
	public double getRate() {
		return this.rate;
	}
	@Override
	public int compareTo(Player o) {
		// TODO Auto-generated method stub
		if(o.rate < rate)return 1;
		else if(o.rate > rate) return -1;
		else return 0;
	}
}
