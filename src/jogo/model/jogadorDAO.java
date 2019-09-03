package jogo.model;

import java.sql.SQLException;
import java.util.List;

public interface jogadorDAO extends DAO<Jogador>{
    boolean atualizar(Jogador j) throws SQLException;
    Jogador buscaJogador(String email, String senha) throws SQLException;
    List<Jogador> ranking() throws  SQLException;
}
