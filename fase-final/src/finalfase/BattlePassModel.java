/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalfase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
/**
 *
 * @author Stuepp
 */
public class BattlePassModel {
    	static void addPoints(int points, Connection con) throws SQLException {
		PreparedStatement st;
		st =  con.prepareStatement("UPDATE TABLE Battlepass SET COLUMN points = "+points);
		st.execute();
		st.close();
	}
    static void create(BattlePass bp, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO Battlepass (points, id, freemium)"+"VALUES (?,?,?)");
            st.setInt(1, bp.getPoints());
            st.setInt(2, bp.getId());
            st.setInt(3, bp.getFreemium());
            st.execute();
            st.close();
    }
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT id, points, freemium FROM Battlepass";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new BattlePass(result.getInt(1), result.getInt(2), result.getInt(3)));
            }
        return list;
    }
}
