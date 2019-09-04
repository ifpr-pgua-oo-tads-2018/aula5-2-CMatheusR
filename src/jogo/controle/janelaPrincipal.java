package jogo.controle;

import javafx.fxml.FXML;
import jogo.NavegadorJanelas;

public class janelaPrincipal {

    @FXML
    public void Cadastrar () {
        NavegadorJanelas.loadJanela(NavegadorJanelas.CADASTRARJOGADOR);
    }

    @FXML
    public void Ranking () {
        NavegadorJanelas.loadJanela(NavegadorJanelas.RANKING);
    }

    @FXML
    public void iniciarJogo () {
        NavegadorJanelas.loadJanela(NavegadorJanelas.JOGO);
    }

}
