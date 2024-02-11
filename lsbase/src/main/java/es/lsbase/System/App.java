package System;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

import Controllers.InputController;
import Controllers.SearcherController;
import Controllers.Starter;

public class App extends Application {

    private static Scene scene;
    public SearcherController searcher;
    public InputController input;
    public Starter iniciador;

    public void setStarter(Starter s){iniciador = s;}
    public void setInput(InputController s){input = s;}
    public void setSearcher(SearcherController s){searcher = s;}

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = getFXML("main");
        loader.setController(new Starter(this));
        scene = new Scene(loader.load(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(getFXML(fxml).load());
    }

    private static FXMLLoader getFXML(String fxml) throws IOException {
        File f = new File("lsbase/src/main/resources/" + fxml + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(f.toURI().toURL());
        return fxmlLoader;
    }

    public static void main(String[] args) throws ClassNotFoundException{
        launch();
    }

}