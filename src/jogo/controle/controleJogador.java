package jogo.controle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jogo.model.Jogador;
import jogo.model.SqliteJogadorDAO;
import jogo.model.jogadorDAO;

import java.sql.SQLException;

public class controleJogador {

    private static controleJogador instance = new controleJogador();

    private ObservableList<Jogador> jogadors;

    private jogadorDAO jogDAO = new SqliteJogadorDAO();

    private controleJogador(){
        jogadors = FXCollections.observableArrayList();
    }

    public static controleJogador getInstance(){return instance;}

    public void cadastraJogador(Jogador j) throws SQLException{
        long codigo = jogDAO.insere(j);
        j.setCodigo((int) codigo);
        jogadors.add(j);
    }

    public ObservableList<Jogador> listaRanking() throws SQLException{
        jogadors.clear();
        jogadors.addAll(jogDAO.ranking());
        return jogadors;
    }
}
