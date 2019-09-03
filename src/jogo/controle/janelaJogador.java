package jogo.controle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import jogo.NavegadorJanelas;
import jogo.model.Jogador;

import java.sql.SQLException;

public class janelaJogador extends Controlador {

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSenha;

    @FXML
    private void Cadastrar() throws SQLException {

        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String senha = tfSenha.getText();

        if(nome.equals("")){
            mensagem("Faltando o Nome!!");
        }
        if(email.equals("")){
            mensagem("Faltando o Email!!");
        }
        if(senha.equals("")){
            mensagem("Faltando a Senha!!");
        }

        Jogador j = new Jogador(0, nome, email, senha, 0);
        controleJogador.getInstance().cadastraJogador(j);

        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);

    }

    @FXML
    private void Voltar(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }

}
