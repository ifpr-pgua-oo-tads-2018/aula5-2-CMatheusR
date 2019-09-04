package jogo.controle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jogo.NavegadorJanelas;
import jogo.model.Jogador;
import jogo.model.Jogo;
import jogo.model.SqliteJogadorDAO;
import jogo.model.jogadorDAO;

import java.sql.SQLException;
import java.util.Random;

public class JanelaJogo extends Controlador  {

    Random rand = new Random();

    private jogadorDAO jogDAO = new SqliteJogadorDAO();

    @FXML
    private TextField tfEmailJ1;

    @FXML
    private TextField tfEmailJ2;

    @FXML
    private PasswordField tfSenhaJ1;

    @FXML
    private PasswordField tfSenhaJ2;

    @FXML
    private TextField tfPalpiteJ1;

    @FXML
    private TextField tfPalpiteJ2;

    @FXML
    private Label lbNaoAcertouJog1;

    @FXML
    private Label lbNaoAcertouJog2;

    @FXML
    private Label lbAcertouJog1;

    @FXML
    private Label lbAcertouJog2;

    @FXML
    private Label lbNumSurteado;

    @FXML
    private Button btSortear;

    @FXML
    private void Resetar(){
        lbNumSurteado.setText("0");
        lbNaoAcertouJog1.setVisible(false);
        lbNaoAcertouJog2.setVisible(false);
        lbAcertouJog1.setVisible(false);
        lbAcertouJog2.setVisible(false);
        btSortear.setDisable(false);
        tfEmailJ1.clear();
        tfEmailJ2.clear();
        tfSenhaJ1.clear();
        tfSenhaJ2.clear();
        tfPalpiteJ1.clear();
        tfPalpiteJ2.clear();
    }


    @FXML
    private void Sortear() throws SQLException {
        int num_sorteado = rand.nextInt(10)+2;
        String emailJ1 = tfEmailJ1.getText();
        String emailJ2 = tfEmailJ2.getText();
        String senhaJ1 = tfSenhaJ1.getText();
        String senhaJ2 = tfSenhaJ2.getText();
        int palpiteJ1;
        int palpiteJ2;

        Jogador j1 = new Jogador();
        Jogador j2 = new Jogador();
        j1 = jogDAO.buscaJogador(emailJ1, senhaJ1);
        j2 = jogDAO.buscaJogador(emailJ2, senhaJ2);

        if(tfEmailJ1.getText().equals("")){
            mensagem("Jogador 1:\nNecessário Informar o Email");
        }
        else if(tfEmailJ2.getText().equals("")){
            mensagem("Jogador 2:\nNecessário Informar o Email");
        }
        else if(tfSenhaJ1.getText().equals("")){
            mensagem("Jogador 1:\nNecessário Informar a Senha");
        }
        else if(tfSenhaJ2.getText().equals("")){
            mensagem("Jogador 2:\nNecessário Informar a Senha");
        }
        else if(tfPalpiteJ1.getText().equals("")){
            mensagem("Jogador 1:\nNecessário Informar um Palpite");
        }
        else if(tfPalpiteJ2.getText().equals("")){
            mensagem("Jogador 2:\nNecessário Informar um Palpite");
        }
        else if(j1 == null){
            mensagem("Jogador 1:\nSenha ou Email Inválido");
        }
        else if(j2 == null){
            mensagem("Jogador 2:\nSenha ou Email Inválido");
        }else{
            palpiteJ1 = Integer.parseInt(tfPalpiteJ1.getText());
            palpiteJ2 = Integer.parseInt(tfPalpiteJ2.getText());
            lbNumSurteado.setText(Integer.toString(num_sorteado));
            if(palpiteJ1 == num_sorteado){
                lbAcertouJog1.setVisible(true);
            }
            else{lbNaoAcertouJog1.setVisible(true);}
            if(palpiteJ2 == num_sorteado) {
                lbAcertouJog2.setVisible(true);
            }
            else{lbNaoAcertouJog2.setVisible(true);}
            Jogo jogo = new Jogo(j1.getCodigo(), j2.getCodigo(), num_sorteado, palpiteJ1, palpiteJ2);
            controleJogo.getInstance().cadastraJogo(jogo);
            btSortear.setDisable(true);
        }
    }

    @FXML
    private void Sair(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }
}
