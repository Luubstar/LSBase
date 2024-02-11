package Controllers;
import java.io.IOException;

import System.App;
import System.Cliente;
import System.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InputController extends Controller{

    @FXML
    private  TextField lineNombre;
    @FXML
    private  TextField linePApellido;
    @FXML
    private  TextField lineSApellido;
    @FXML
    private  TextField linePTelefono;
    @FXML
    private  TextField lineSTelefono;
    @FXML
    private  TextField lineDNI;
    @FXML
    private  TextField lineEmail;
    @FXML
    private  TextField lineDireccion;
    @FXML
    private  TextField linePatio;
    @FXML
    private  TextField linePuerta;
    @FXML
    private  TextField lineCorrespondencia;
    @FXML
    private  TextField lineCodPost;
    @FXML
    private  TextField linePoblacion;
    @FXML
    private  TextField lineProvincia;
    @FXML
    private  TextField lineCUPS;
    @FXML
    private  TextField lineNumCuenta;
    @FXML
    private  TextField lineAnexo;
    @FXML
    private  TextField lineTarifa;
    @FXML
    private  TextField lineConsumo;
    @FXML
    private  TextField lineCompania;
    @FXML
    private  TextField lineComision;
    @FXML
    private  TextField lineActivacion;
    @FXML
    private  TextField linePersonaAut;
    @FXML
    private  TextField lineTelefonoAut;
    @FXML
    private  TextField lineDNIAut;
    @FXML
    private  TextArea lineAnotacion;


    @FXML
    private  Button btnLimpiar;
    @FXML
    private  Button btnEliminar;
    @FXML
    private  Button btnGuardar;
    @FXML
    private  Button btnCancelar;

    App main;

    public InputController(App a){
    main = a;
    a.setInput(this);
    }

    @FXML
    private void initialize() throws IOException {System.out.print(lineNombre.getText());}

    @FXML
    public void editEntry(Cliente c, Starter mainController) throws IOException{
        loadInLines(c);
        mainController.changePanel(1);
        btnLimpiar.setDisable(false);
        btnCancelar.setDisable(false);
        btnEliminar.setDisable(false);
        btnGuardar.setDisable(false);

        btnCancelar.setOnAction(event -> cancelEntry());
        btnLimpiar.setOnAction(event -> clean());
        btnGuardar.setOnAction(event -> save(c));
        btnEliminar.setOnAction(event -> remove(c));
    }

    @FXML
    public void save(Cliente c){
        Cliente nc = loadInCliente(c);
        Database.save(nc);
        btnCancelar.setDisable(true);
        btnEliminar.setDisable(true);
        main.iniciador.changePanel(0);
        clean();
    }

    @FXML
    public void remove(Cliente c){
        Database.remove(c);
        btnCancelar.setDisable(true);
        btnEliminar.setDisable(true);
        main.iniciador.changePanel(0);
        clean();
    }

    @FXML
    public void cancelEntry(){
        clean();
        btnCancelar.setDisable(true);
        btnEliminar.setDisable(true);
        main.iniciador.changePanel(0);
    }

    public void clean(){loadInLines(new Cliente());}

    @FXML
    public void loadInLines(Cliente c){
        lineNombre.setText(c.getNombre());
        linePApellido.setText(c.getApellido1());
        lineSApellido.setText(c.getApellido2());
        linePTelefono.setText(c.getTelefono1());
        lineSTelefono.setText(c.getTelefono2());
        lineDNI.setText(c.getDNI());
        lineEmail.setText(c.getCorreoElectronico());
        lineDireccion.setText(c.getDireccionCorrespondencia());
        linePatio.setText(c.getPatio());
        linePuerta.setText(c.getPuerta());
        lineCorrespondencia.setText(c.getDireccionCorrespondencia());
        lineCodPost.setText(Integer.toString(c.getCodigoPostal()));
        linePoblacion.setText(c.getPoblacion());
        lineProvincia.setText(c.getProvincia());
        lineCUPS.setText(c.getCUPS());
        lineNumCuenta.setText(c.getNumeroCuenta());
        lineAnexo.setText(c.getAnexo());
        lineTarifa.setText(c.getTarifa());
        lineConsumo.setText(c.getConsumo());
        lineCompania.setText(c.getCompania());
        lineComision.setText(c.getComision());
        lineActivacion.setText(c.getActivacion());
        linePersonaAut.setText(c.getPersonaAut());
        lineTelefonoAut.setText(c.getTelefonoAut());
        lineDNIAut.setText(c.getDNIAut());
        lineAnotacion.setText(c.getAnotacion());
    }

    @FXML
    public Cliente loadInCliente(Cliente c){
        c.setNombre(lineNombre.getText());
        c.setApellido1(linePApellido.getText());
        c.setApellido2(lineSApellido.getText());
        c.setTelefono1(linePTelefono.getText());
        c.setTelefono2(lineSTelefono.getText());
        c.setDNI(lineDNI.getText());
        c.setCorreoElectronico(lineEmail.getText());
        c.setDireccionSuministro(lineDireccion.getText());
        c.setPatio(linePatio.getText());
        c.setPuerta(linePuerta.getText());
        c.setDireccionCorrespondencia(lineCorrespondencia.getText());
        c.setCodigoPostal(Integer.valueOf(lineCodPost.getText()));
        c.setPoblacion(linePoblacion.getText());
        c.setProvincia(lineProvincia.getText());
        c.setCUPS(lineCUPS.getText());
        c.setNumeroCuenta(lineNumCuenta.getText());
        c.setAnexo(lineAnexo.getText());
        c.setTarifa(lineTarifa.getText());
        c.setConsumo(lineConsumo.getText());
        c.setCompania(lineCompania.getText());
        c.setComision(lineComision.getText());
        c.setActivacion(lineActivacion.getText());
        c.setPersonaAut(linePersonaAut.getText());
        c.setTelefonoAut(lineTelefonoAut.getText());
        c.setDNIAut(lineDNIAut.getText());
        c.setAnotacion(lineAnotacion.getText());
        return c;
    }
}
