package jogo.model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SqliteJogoDAO implements JogoDAO{

    private QueryRunner dbAccess = new QueryRunner();

    @Override
    public boolean atualizar(Jogador j) throws SQLException {
        return false;
    }

    @Override
    public long insere(Jogo jogo) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        int codigo = dbAccess.insert(con,
                "INSERT INTO jogo(id1, id2, soma, aposta1, aposta2) VALUES(?,?,?,?,?)",
                new ScalarHandler<Integer>(), jogo.getId1(), jogo.getId2(), jogo.getSoma(), jogo.getAposta1(), jogo.getAposta2());

        jogo.setCodigo(codigo);

        con.close();

        return codigo;
    }

    @Override
    public List<Jogo> buscaTodos() throws SQLException {
        return null;
    }
}
