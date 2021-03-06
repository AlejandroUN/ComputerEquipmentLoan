/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controllers;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriela
 */
public class RegisterController implements Initializable {

    private BorderPane panelPrincipal;
    UsuarioDAO uDao = new UsuarioDAO();
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        RegisterController.usuario = usuario;
    }
    
    
    
    @FXML
    private Pane panelLogin;

    @FXML
    private Label escudoLB;

    @FXML
    private Text logoAppLogin;

    @FXML
    private PasswordField passwordPTFLD;

    @FXML
    private PasswordField passwordRePTFLD;

    @FXML
    private TextField nombresTFD;

    @FXML
    private TextField apellidosTFD;

    @FXML
    private TextField usuarioTFD;

    @FXML
    private Button baskToLoginBtn;

    @FXML
    private Button registrarseBtn;

    @FXML
    private Label alertContrase??aLB;
    
    @FXML
    private Label alertUsuarioLB;

    @FXML
    private Label alertGeneralLB;

    @FXML
    private ComboBox<String> facultadCB;

    @FXML
    private ComboBox<String> carreraCB;

    @FXML
    void baskToLoginBtnAction(ActionEvent event) throws IOException {
        Parent newParent;
        newParent = FXMLLoader.load(getClass().getResource("/GUI/views/login.fxml"));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    
    @FXML
    void facultadSelectedBtn(ActionEvent event) {
         String selectedItem = facultadCB.getValue();
        carreraCB.getItems().clear();
        switch (selectedItem){
            case "":
                carreraCB.setDisable(true);
            break;
            case "Facultad de Artes":
                carreraCB.getItems().addAll("Arquitectura",
                                            "Cine y televisi??n",
                                            "Dise??o Gr??fico",
                                            "Dise??o Industrial",
                                            "M??sica",
                                            "M??sica Instrumental");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Ciencias":
                carreraCB.getItems().addAll("Biolog??a",
                                            "Farmacia",
                                            "F??sica",
                                            "Estad??stica",
                                            "Geolog??a",
                                            "Matem??ticas",
                                            "Qu??mica",
                                            "Ciencias de la Computaci??n");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Ciencias Agrarias":
                carreraCB.getItems().addAll("Ingenier??a Agron??mica");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Ciencias Econ??micas":
                carreraCB.getItems().addAll("Adminixtraci??n","Contadur??a","Econom??a");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Ciencias Humanas":
                carreraCB.getItems().addAll("Antropolog??a",
                                            "Estudios literarios",
                                            "Espa??ol y filolog??a cl??sica",
                                            "Filolog??a e idiomas",
                                            "Filosof??a",
                                            "Geograf??a",
                                            "Historia",
                                            "Ling????stica",
                                            "Psicolog??a",
                                            "Sociolog??a",
                                            "Trabajo Social");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Derecho, Ciencias Pol??ticas y Sociales":
                carreraCB.getItems().addAll("Ciencia Pol??tica","Derecho");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Enfermer??a":
                carreraCB.getItems().addAll("Enfermer??a");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Ingenier??a":
                carreraCB.getItems().addAll("Ingenier??a Agr??cola",
                                            "Ingenier??a Civil",
                                            "Ingenier??a de Sistemas y Computaci??n",
                                            "Ingenier??a El??ctrica",
                                            "Ingenier??a Electr??nica",
                                            "Ingenier??a Industrial",
                                            "Ingenier??a Mec??nica",
                                            "Ingenier??a Mecatr??nica",
                                            "Ingenier??a Qu??mica");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Medicina":
                carreraCB.getItems().addAll("Fisioterapia",
                                            "Fonoaudiolog??a",
                                            "Medicina",
                                            "Nutrici??n y Diet??tica",
                                            "Terapia Ocupacional");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Medicina Veterinaria y de Zootecnia":
                carreraCB.getItems().addAll("Medicina Veterinaria","Zootecnia");
                carreraCB.setDisable(false);
            break;
            case "Facultad de Odontolog??a":
                carreraCB.getItems().addAll("Odontolog??a");
                carreraCB.setDisable(false);
            break;
            default:
                carreraCB.setDisable(true);
            break;
            
        }
    }    
    
    @FXML
    void registrarseBtnAction(ActionEvent event) throws IOException{
        alertGeneralLB.setVisible(false);
        if (nombresTFD.getText().equals("") || apellidosTFD.getText().equals("") 
                || usuarioTFD.getText().equals("") || passwordPTFLD.getText().equals("") 
                || passwordRePTFLD.getText().equals("") || facultadCB.getValue() == null 
                || carreraCB.getValue() == null || alertContrase??aLB.isVisible() 
                || alertUsuarioLB.isVisible()){
            alertGeneralLB.setText("Datos Incompletos, asegurese de ingresar todos los datos correctamente");
            alertGeneralLB.setVisible(true);
        } else{
            usuario = new Usuario(usuarioTFD.getText(), passwordPTFLD.getText(), nombresTFD.getText(),
            apellidosTFD.getText(), carreraCB.getValue(), facultadCB.getValue(), 0);                    
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GUI/views/confirmRegistration.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 437, 209);
            Stage stagePop = new Stage();
            stagePop.getIcons().add(new Image(getClass().getResourceAsStream("/GUI/static/icons/herramienta.png")));
            stagePop.setTitle("Confirmar crear usuario");
            stagePop.setScene(scene);
            stagePop.showAndWait();

            if (ConfirmRegistrationController.isCreado()) {
                changeScene(event, "/GUI/views/login.fxml");
            }           
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alertContrase??aLB.setVisible(false);
        alertUsuarioLB.setVisible(false);
        alertGeneralLB.setVisible(false);
        escudoLB.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/resources/Escudo_Color.png")))); 
        facultadCB.getItems().addAll("Facultad de Artes",
                            "Facultad de Ciencias",
                            "Facultad de Ciencias Agrarias",
                            "Facultad de Ciencias Econ??micas",
                            "Facultad de Ciencias Humanas",
                            "Facultad de Derecho, Ciencias Pol??ticas y Sociales",
                            "Facultad de Enfermer??a",
                            "Facultad de Ingenier??a",
                            "Facultad de Medicina",
                            "Facultad de Medicina Veterinaria y de Zootecnia",
                            "Facultad de Odontolog??a");
        
        passwordRePTFLD.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    alertContrase??aLB.setVisible(false);
                } else {
                    alertContrase??aLB.setVisible(false);
                    if (passwordPTFLD.getText().length()<5){
                        alertContrase??aLB.setText("La contrase??a es muy corta");
                        alertContrase??aLB.setVisible(true);                        
                    } 
                    if (!passwordPTFLD.getText().equals(passwordRePTFLD.getText()) && !passwordPTFLD.getText().equals("")) {
                        alertContrase??aLB.setText("Las contrase??as no coinciden");
                        alertContrase??aLB.setVisible(true);
                    }
                }
            }
        });
        
         passwordPTFLD.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    alertContrase??aLB.setVisible(false);
                } else {
                    alertContrase??aLB.setVisible(false);                    
                    if (passwordPTFLD.getText().length()<5){
                        alertContrase??aLB.setText("La contrase??a es muy corta");
                        alertContrase??aLB.setVisible(true);                        
                    } 
                    if (!passwordPTFLD.getText().equals(passwordRePTFLD.getText()) && !passwordPTFLD.getText().equals("")) {
                        alertContrase??aLB.setText("Las contrase??as no coinciden");
                        alertContrase??aLB.setVisible(true);
                    }                   
                }
            }
        });
        usuarioTFD.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if (newPropertyValue) {
                    alertUsuarioLB.setVisible(false);
                } else {
                    alertUsuarioLB.setVisible(false);                    
                    new Thread( new Runnable() {
                        @Override
                        public void run() {
                            if (uDao.Buscar(usuarioTFD.getText())){
                                alertUsuarioLB.setVisible(true);                        
                        } 
                        }
                    }).start();
                                                         
                }
            }
        });
        usuarioTFD.addEventFilter(KeyEvent.KEY_TYPED , word_Validation());
        nombresTFD.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation());
        apellidosTFD.addEventFilter(KeyEvent.KEY_TYPED , letter_Validation());
    }  
    
    void changeScene(ActionEvent event, String fxml) throws IOException {
        Parent newParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(newParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    
    public EventHandler<KeyEvent> letter_Validation() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (!Character.isAlphabetic(e.getCharacter().charAt(0)) && !Character.isSpaceChar(e.getCharacter().charAt(0))) {
                    e.consume();
                }
            }
        };
    }
    
    public EventHandler<KeyEvent> word_Validation() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (!Character.isAlphabetic(e.getCharacter().charAt(0))) {
                    e.consume();
                }
            };
    };
    }
}

