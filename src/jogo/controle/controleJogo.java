package jogo.controle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jogo.controle.controleJogador;
import jogo.model.*;

import java.sql.SQLException;

public class controleJogo {

    private static controleJogo instance = new controleJogo();

    private ObservableList<Jogo> jogo;

    private JogoDAO jogDAO = new SqliteJogoDAO();

    private controleJogo(){
        jogo = FXCollections.observableArrayList();
    }

    public static controleJogo getInstance(){return instance;}

    public void cadastraJogo(Jogo j) throws SQLException {
        long codigo = jogDAO.insere(j);
        j.setCodigo((int) codigo);
        jogo.add(j);
    }

}
