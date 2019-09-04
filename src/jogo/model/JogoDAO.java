package jogo.model;

import java.sql.SQLException;
import java.util.List;

public interface JogoDAO extends DAO<Jogo> {
        boolean atualizar(Jogador j) throws SQLException;
}
