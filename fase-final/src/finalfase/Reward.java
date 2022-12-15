/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalfase;

public class Reward {
    	// Parameters
	public String name;
	public String category;
	private int type;
	private int battlepass;
        private BattlePass bp;
	private int id;
	// Constructor
	public Reward(int id,String name, String category, int type, int battlepass) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.type = type;
		this.bp = bp;
	}
	// Gets and Sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getBattlepass() {
		return battlepass;
	}
	public void setBattlepass(int battlepass) {
		this.battlepass = battlepass;
	}
        public BattlePass getBp(){
            return bp;
        }
        public void setBp(BattlePass bp){
            this.bp = bp;
        }
	// Methods
    public String toString(){
        StringBuffer sb = new StringBuffer();
        String t = null;
        if(type == 0) {t = "Spray";}
        if(type == 1) {t = "Emote";}
        if(type == 2) {t = "Skin";}
        
        sb.append("ID: "+id+" Name: "+name+" Category: "+category+" Type: "+t+" BattlePass: "+battlepass);
        if(bp != null){
            sb.append("ID: "+bp.getId()+" Points: "+bp.getPoints()+" BattlePas Type: "+bp.getFreemium());
        }
        return sb.toString();
    }
}
