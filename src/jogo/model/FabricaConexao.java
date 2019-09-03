package jogo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

        private static int MAX_CONNECITIONS=5;
        private static String CON_STRING = "jdbc:sqlite:JogoDados.sqlite";

        private static Connection[] pool;

        private static FabricaConexao instance = new FabricaConexao();

        private FabricaConexao() {pool = new Connection[MAX_CONNECITIONS];}

        public static Connection getConnection() throws SQLException{
                for (int i =0; i< MAX_CONNECITIONS;i++){
                        if((instance.pool[i] == null || instance.pool[i].isClosed())){
                                instance.pool[i] = DriverManager.getConnection(CON_STRING);
                                return instance.pool[i];
                        }
                }
                throw new SQLException("Máximo de Conexões");
        }


}
