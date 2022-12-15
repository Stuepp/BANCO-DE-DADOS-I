package finalfase;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class RewardController {
    static Scanner s = new Scanner(System.in);
	
    public void createReward(Connection con) throws SQLException {
        System.out.println("Insira os seguintes dados para a criar uma nova Recompensa: ");
        System.out.println("ID: ");
        int id = s.nextInt();
        s.nextLine();
        System.out.print("Name:");
        String name = s.nextLine();
        System.out.print("Category:");
        String category = s.nextLine();
        System.out.println("Insert the type of your reward:");
        System.out.println("(0) -> Spray");
        System.out.println("(1) -> Emote");
        System.out.println("(2) -> Skin");
        int type = s.nextInt();
        System.out.println("BattlePass o qual pertence:");
        int bp = s.nextInt();
        
        Reward reward = new Reward(id, name, category, type, bp);
        RewardModel.create(reward, con);
        System.out.println("Reward created with success!!");
    }

    void listaRewards(Connection con) throws SQLException {
        HashSet all = RewardModel.listAll(con);
        Iterator<Reward> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    void listaBattleReward(Connection con) throws SQLException {
        HashSet all = RewardModel.listAllWithBattlePass(con);
        Iterator<Reward> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    void listaMaiorPontos(Connection con) throws SQLException {
        int rowcount = RewardModel.listaMaiorPontos(con);
        
        System.out.println("Número de colunas: "+rowcount);
    }
}
