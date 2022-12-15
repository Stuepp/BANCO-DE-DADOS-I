/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalfase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author Stuepp
 */
public class FinalFase {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        RewardController rc = new RewardController();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1:
                    	new BattlePassController().createBattlePass(con); // OK
                    	break;
                    case 2:
                    	new RewardController().createReward(con); // OK
                        break;
                    case 3: 
                    	new RewardController().listaRewards(con); // OK
                        break;
                    case 4:
                    	new BattlePassController().listaBattlePass(con); // OK
                    case 5:
                    	new RewardController().listaBattleReward(con);
                    	break;
                    case 6:
                        new RewardController().listaMaiorPontos(con);
                        break;
                    default:
                    	break;
                }
            }catch(SQLException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<6);  
        con.close();
	}
	
    private static int menu() {
        System.out.println("-----------------MENU---------------------------");
        System.out.println("Informe o número da opção que desejas executar: ");
        System.out.println("1 - Criar um battle pass");
        System.out.println("2 - Inserir uma nova Recompensa");
        System.out.println("3 - Exibir todas as Recompensas");
        System.out.println("4 - Exibit todos os BattlePass");
        System.out.println("5 - Exibir todos os Reward e seus respectivos BattlePass");
        System.out.println("6 - Exibir a quantidade de Rewards do tipo 2");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        return s.nextInt();
    }
}
