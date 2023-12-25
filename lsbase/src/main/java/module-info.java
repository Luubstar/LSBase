module es.lsbase {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.lsbase to javafx.fxml;
    exports es.lsbase;
}
