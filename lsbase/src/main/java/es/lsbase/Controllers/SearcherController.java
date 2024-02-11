package Controllers;
import java.io.IOException;
import java.util.List;

import System.App;
import System.Cliente;
import System.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SearcherController extends Controller{


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
    private Label lblCantidad;
    @FXML
    private Label lblCantidadFiltro;

    App main;

    public SearcherController(App a){
    main = a;
    a.setSearcher(this);
    }

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

        int r = cargarBusqueda("");
        lblCantidad.setText(Integer.toString(r));
        changeCheckedString(r==0, lblCantidad);

    }

    private int cargarBusqueda(String filtro){
        cleanTable();
        List<Cliente> personas = Database.getCoincidences(filtro);
        ObservableList<Cliente> listaObservable = FXCollections.observableArrayList(personas);
        tablaPrincipal.setItems(listaObservable);

        tablaPrincipal.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    try{
                        SelectClient(tablaPrincipal.getSelectionModel().getSelectedItem());}
                    catch(Exception e){}       
                }
            }
        });

        lblCantidadFiltro.setText(Integer.toString(personas.size()));
        changeCheckedString(personas.size()==0, lblCantidadFiltro);

        return personas.size();
    }

    private void SelectClient(Cliente c) throws IOException{
        InputController controller = main.input;
        Starter s = main.iniciador;
        controller.editEntry(c,s);
    }

    private void cleanTable(){
        ArrayList<Cliente> c = new ArrayList<Cliente>();
        tablaPrincipal.setItems(FXCollections.observableArrayList(c));
    }

    private void changeCheckedString(boolean t, Label l){
        if (t){
            l.setTextFill(Color.color(0.75,0,0));
        }
        else{l.setTextFill(Color.color(0,0.5,0));}
    }
}