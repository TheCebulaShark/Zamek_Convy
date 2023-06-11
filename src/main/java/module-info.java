module com.castle.zamek_conwy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.controlsfx.controls;

    opens com.castle.zamek_conwy to javafx.fxml;
    exports com.castle.zamek_conwy;
}