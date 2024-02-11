package Controllers;
import java.io.IOException;

import System.App;
import System.Cliente;
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
        mainController.changePanel(1);
        System.out.println(btnCancelar.isDisabled());
        btnLimpiar.setDisable(false);
        btnCancelar.setDisable(false);
        btnEliminar.setDisable(false);
        btnGuardar.setDisable(false);
        System.out.println(btnCancelar.isDisabled());
    }

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
}
