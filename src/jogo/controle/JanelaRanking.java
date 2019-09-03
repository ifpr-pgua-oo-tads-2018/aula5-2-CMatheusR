package jogo.controle;

import com.sun.javafx.scene.control.SelectedCellsMap;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import jogo.NavegadorJanelas;
import jogo.model.Jogador;

import java.sql.SQLException;

public class JanelaRanking {

    @FXML
    private TableView<Jogador> tbRanking;

    @FXML
    private TableColumn<Jogador, String> tcJogador;

    @FXML
    private TableColumn<Jogador, String> tcEmail;

    @FXML
    private TableColumn<Jogador, Double> tcPontos;

    @FXML
    private TableColumn<Jogador, Integer> tcJogadas;

    public void initialize() throws SQLException{
        tcJogador.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcPontos.setCellValueFactory(new PropertyValueFactory<>("pontos"));
        tcJogadas.setCellValueFactory(new PropertyValueFactory<>("jogadas"));

        tbRanking.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        try{
            tbRanking.setItems(controleJogador.getInstance().listaRanking());
        } catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Problema ao buscar jogadores \n" + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void acaoSair(){
        NavegadorJanelas.loadJanela(NavegadorJanelas.PRINCIPAL);
    }
}
