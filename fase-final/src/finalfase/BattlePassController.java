/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalfase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author Stuepp
 */
public class BattlePassController {
    static Scanner s = new Scanner(System.in);
	
    public void givePoints(Connection con) throws SQLException {
    	System.out.println("Choose the ammount of points you want");
    	int points = s.nextInt();
        
    	BattlePassModel.addPoints(points,con);
    }
    public void createBattlePass(Connection con) throws SQLException {
        System.out.println("Insira os seguintes dados para a criar um novo Battlepass: ");
        System.out.print("Id:");
        int id = s.nextInt();
        System.out.println("Freemium:");
        int freemium = s.nextInt();
        int points = 0;
        
        BattlePass battlepass = new BattlePass(id,points,freemium);
        BattlePassModel.create(battlepass, con);
        System.out.println("Reward created with success!!");
    }
    void listaBattlePass(Connection con) throws SQLException {
        HashSet all = BattlePassModel.listAll(con);
        Iterator<BattlePass> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
