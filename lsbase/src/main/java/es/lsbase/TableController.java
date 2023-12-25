import java.io.IOException;
import java.util.List;

import System.Cliente;
import System.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class TableController {

    private App parent;

    @FXML
    private TableView<Cliente> tablaPrincipal;
    @FXML
    private TableColumn<Cliente, String> nombreColumna;

    @FXML
    private TableColumn<Cliente, String> apellido1Columna;

    @FXML
    private TableColumn<Cliente, String> apellido2Columna;

    @FXML
    private TableColumn<Cliente, String> telefono1Columna;

    @FXML
    private TableColumn<Cliente, String> telefono2Columna;

    @FXML
    private TableColumn<Cliente, String> dniColumna;

    @FXML
    private TableColumn<Cliente, String> correoColumna;

    @FXML
    private TableColumn<Cliente, String> direccionSuministroColumna;

    @FXML
    private TableColumn<Cliente, String> patioColumna;

    @FXML
    private TableColumn<Cliente, String> puertaColumna;

    @FXML
    private TableColumn<Cliente, String> direccionCorrespondenciaColumna;

    @FXML
    private TableColumn<Cliente, Integer> codigoPostalColumna;

    @FXML
    private TableColumn<Cliente, String> poblacionColumna;

    @FXML
    private TableColumn<Cliente, String> provinciaColumna;

    @FXML
    private TableColumn<Cliente, String> cupsColumna;

    @FXML
    private TableColumn<Cliente, String> numeroCuentaColumna;

    @FXML
    private TableColumn<Cliente, String> anexoColumna;

    @FXML
    private TableColumn<Cliente, String> tarifaColumna;

    @FXML
    private TableColumn<Cliente, String> consumoColumna;

    @FXML
    private TableColumn<Cliente, String> companiaColumna;

    @FXML
    private TableColumn<Cliente, String> comisionColumna;

    @FXML
    private TableColumn<Cliente, String> activacionColumna;

    @FXML
    private TableColumn<Cliente, String> personaAutColumna;

    @FXML
    private TableColumn<Cliente, String> dniAutColumna;

    @FXML
    private TableColumn<Cliente, String> telefonoAutColumna;

    @FXML
    private TableColumn<Cliente, String> anotacionColumna;

    @FXML
    private Button busquedaBoton;
    @FXML
    private TextField busquedaTexto;

    @FXML
    private TabPane panelDeFondo;
    @FXML Tab tabTabla; 
    @FXML Tab tabAdd; 
    @FXML Tab tabNotificaciones; 

    @FXML
    private void initialize() throws IOException {
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        apellido1Columna.setCellValueFactory(new PropertyValueFactory<>("Apellido1"));
        apellido2Columna.setCellValueFactory(new PropertyValueFactory<>("Apellido2"));
        telefono1Columna.setCellValueFactory(new PropertyValueFactory<>("Telefono1"));
        telefono2Columna.setCellValueFactory(new PropertyValueFactory<>("Telefono2"));
        dniColumna.setCellValueFactory(new PropertyValueFactory<>("DNI"));
        correoColumna.setCellValueFactory(new PropertyValueFactory<>("CorreoElectronico"));
        direccionSuministroColumna.setCellValueFactory(new PropertyValueFactory<>("DireccionSuministro"));
        patioColumna.setCellValueFactory(new PropertyValueFactory<>("Patio"));
        puertaColumna.setCellValueFactory(new PropertyValueFactory<>("Puerta"));
        direccionCorrespondenciaColumna.setCellValueFactory(new PropertyValueFactory<>("DireccionCorrespondencia"));
        codigoPostalColumna.setCellValueFactory(new PropertyValueFactory<>("CodigoPostal"));
        poblacionColumna.setCellValueFactory(new PropertyValueFactory<>("Poblacion"));
        provinciaColumna.setCellValueFactory(new PropertyValueFactory<>("Provincia"));
        cupsColumna.setCellValueFactory(new PropertyValueFactory<>("CUPS"));
        numeroCuentaColumna.setCellValueFactory(new PropertyValueFactory<>("NumeroCuenta"));
        anexoColumna.setCellValueFactory(new PropertyValueFactory<>("Anexo"));
        tarifaColumna.setCellValueFactory(new PropertyValueFactory<>("Tarifa"));
        consumoColumna.setCellValueFactory(new PropertyValueFactory<>("Consumo"));
        companiaColumna.setCellValueFactory(new PropertyValueFactory<>("Compania"));
        comisionColumna.setCellValueFactory(new PropertyValueFactory<>("Comision"));
        activacionColumna.setCellValueFactory(new PropertyValueFactory<>("Activacion"));
        personaAutColumna.setCellValueFactory(new PropertyValueFactory<>("PersonaAut"));
        dniAutColumna.setCellValueFactory(new PropertyValueFactory<>("DNIAut"));
        telefonoAutColumna.setCellValueFactory(new PropertyValueFactory<>("TelefonoAut"));
        anotacionColumna.setCellValueFactory(new PropertyValueFactory<>("Anotacion"));

        busquedaBoton.setOnAction(event -> cargarBusqueda(busquedaTexto.getText()));
        busquedaTexto.setOnKeyTyped(event -> cargarBusqueda(busquedaTexto.getText()));


        String directorioTrabajo = System.getProperty("user.dir");
        File f = new File(directorioTrabajo + "/lsbase/src/main/resources/homeIcon.png");
        ImageView icon = new ImageView(new Image(new FileInputStream(f)));
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        tabTabla.setGraphic(icon);

        f = new File(directorioTrabajo + "/lsbase/src/main/resources/userIcon.png");
        icon = new ImageView(new Image(new FileInputStream(f)));
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        tabAdd.setGraphic(icon);

        f = new File(directorioTrabajo + "/lsbase/src/main/resources/notIcon.png");
        icon = new ImageView(new Image(new FileInputStream(f)));
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        tabNotificaciones.setGraphic(icon);
        cargarBusqueda("");
    }

    private void cargarBusqueda(String filtro){
        cleanTable();
        List<Cliente> personas = Database.getCoincidences(filtro);
        ObservableList<Cliente> listaObservable = FXCollections.observableArrayList(personas);
        tablaPrincipal.setItems(listaObservable);

        tablaPrincipal.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    //parent.EditController.editEntry(tablaPrincipal.getSelectionModel().getSelectedItem(), panelDeFondo, tabAdd);            
                }
            }
        });
    }

    private void cleanTable(){
        ArrayList<Cliente> c = new ArrayList<Cliente>();
        tablaPrincipal.setItems(FXCollections.observableArrayList(c));
    }

    public TableController(App p){parent = p;}
}