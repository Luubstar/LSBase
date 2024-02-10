package Controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Starter extends Controller{

    @FXML
    public TabPane panelDeFondo;
    @FXML public Tab tabSearcher; 
    @FXML public Tab tabInput; 
    @FXML public Tab tabNotificaciones; 

    private static FXMLLoader getFXML(String fxml) throws IOException {
        File f = new File("lsbase/src/main/resources/" + fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(f.toURI().toURL());
        return fxmlLoader;
    }

    @FXML
    private void initialize() throws IOException {
        addToTab(tabInput, "input");
        addToTab(tabSearcher,"searcher");

        String directorioTrabajo = System.getProperty("user.dir");
        File f = new File(directorioTrabajo + "/lsbase/src/main/resources/homeIcon.png");
        ImageView icon = new ImageView(new Image(new FileInputStream(f)));
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        tabSearcher.setGraphic(icon);

        f = new File(directorioTrabajo + "/lsbase/src/main/resources/userIcon.png");
        icon = new ImageView(new Image(new FileInputStream(f)));
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        tabInput.setGraphic(icon);

        f = new File(directorioTrabajo + "/lsbase/src/main/resources/notIcon.png");
        icon = new ImageView(new Image(new FileInputStream(f)));
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        tabNotificaciones.setGraphic(icon);
    }

    @FXML
    private void addToTab(Tab t,String fxml) throws IOException
    {
        FXMLLoader loader = getFXML(fxml);
        t.setContent(loader.load());
    }

    @FXML
    public void changePanel(int i){panelDeFondo.getSelectionModel().select(i);}
}