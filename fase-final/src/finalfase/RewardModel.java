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

public class RewardModel {
    static void create(Reward reward, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO Reward (id ,name, category, type, battlepass)"
                    +"VALUES (?,?,?,?,?)");
            st.setInt(1, reward.getId());
            st.setString(2, reward.getName());
            st.setString(3, reward.getCategory());
            st.setInt(4, reward.getType());
            st.setInt(5, reward.getBattlepass());
            st.execute();
            st.close();
    }
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT id, name, category, type, battlepass FROM Reward";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new Reward(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getInt(5)));
            }
        return list;
    }
    static HashSet listAllWithBattlePass(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT Reward.id, name, category, type, Reward.battlepass, points, freemium FROM Reward NATURAL JOIN Battlepass";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            Reward rd = new Reward(result.getInt(1), result.getString(2),
                    result.getString(3), result.getInt(4),
                    result.getInt(5));
            BattlePass bp = new BattlePass(result.getInt(5),
                    result.getInt(6), result.getInt(7));
            // pints id freemium
            // id points freemium
            rd.setBp(bp);
            list.add(rd);
        }
        return list;
    }
    static int listaMaiorPontos(Connection con) throws SQLException{
        Statement st;
        st = con.createStatement();
        String sql = "select count(*) from Reward r where exists (select * from Reward where type = 1 and r.id = id)";
        ResultSet result = st.executeQuery(sql);
        result.next();
        int numofcols = result.getInt("count");
        result.close();
        return numofcols;
    }
}
