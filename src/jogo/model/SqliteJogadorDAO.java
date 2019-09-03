package jogo.model;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SqliteJogadorDAO  implements jogadorDAO{

    private QueryRunner dbAccess = new QueryRunner();

    @Override
    public boolean atualizar(Jogador j) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        dbAccess.update(con, "UPDATE jogador SET jogadas=?, pontos=? where codigo=?",
                j.getJogadas(), j.getPontos(), j.getCodigo());

        con.close();

        return true;
    }

    @Override
    public Jogador buscaJogador(String email, String senha) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        Jogador j = dbAccess.query(con, "select * from jogador where email=? and senha=?",
                new BeanHandler<Jogador>(Jogador.class), email, senha);
        con.close();

        return j;

    }

    @Override
    public List<Jogador> ranking() throws SQLException {
        Connection con = FabricaConexao.getConnection();

        List<Jogador> lista = dbAccess.query(con, "select * from jogador order by pontos desc, jogadas",
                new BeanListHandler<Jogador>(Jogador.class));

        con.close();

        return lista;
    }

    @Override
    public long insere(Jogador j) throws SQLException {
        Connection con = FabricaConexao.getConnection();

        int codigo = dbAccess.insert(con,
                "INSERT INTO jogador(nome, email, senha, jogadas, pontos) VALUES(?,?,?,?,?)",
                new ScalarHandler<Integer>(), j.getNome(), j.getEmail(), j.getSenha(), j.getJogadas(), j.getPontos());

        j.setCodigo(codigo);

        con.close();

        return codigo;
    }

    @Override
    public List<Jogador> buscaTodos() throws SQLException {
        Connection con = FabricaConexao.getConnection();

        List<Jogador> lista = dbAccess.query(con, "SELECT * FROM jogador",
                new BeanListHandler<Jogador>(Jogador.class));

        con.close();

        return lista;
    }
}
