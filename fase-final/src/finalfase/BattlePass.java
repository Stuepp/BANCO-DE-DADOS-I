/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalfase;

public class BattlePass {
    	// Parameters
	private int points = 0;
	private int freemium; // Is the user using a free or pay version?
	private int id;
	// Constructor
	public BattlePass(int id, int points, int freemium) {
		this.id = id;
		this.points = points;
		this.freemium = freemium;
	}
	// Gets and Setters
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getFreemium() {
		return freemium;
	}
	public void setFreemium(int freemium) {
		this.freemium = freemium;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// methods
    public String toString(){
        StringBuffer sb = new StringBuffer();
        String t = null;
        if(freemium == 1) {
        	t = "ASSINANTE";
        }else {
        	t = "NORMAL";
        }
        sb.append("ID: "+id+" Points: "+points+" BattlePas Type: "+t);
        return sb.toString();
    }
}
