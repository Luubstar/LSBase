package Controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import System.App;
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

    public App main = null; 

    public Starter(App a){
        main = a;
        a.setStarter(this);
    }

    private static FXMLLoader getFXML(String fxml) throws IOException {
        File f = new File("lsbase/src/main/resources/" + fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(f.toURI().toURL());
        return fxmlLoader;
    }

    @FXML
    private void initialize() throws IOException {
        addToTab(tabInput, "input", new InputController(main));
        addToTab(tabSearcher,"searcher", new SearcherController(main));

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
    private void addToTab(Tab t,String fxml, Controller a) throws IOException
    {
        FXMLLoader loader = getFXML(fxml);
        loader.setController(a);
        t.setContent(loader.load());
    }

    @FXML
    public void changePanel(int i){panelDeFondo.getSelectionModel().select(i);}
}