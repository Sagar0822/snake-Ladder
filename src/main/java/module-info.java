module com.example.snakeladdergame22dec {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakeladdergame22dec to javafx.fxml;
    exports com.example.snakeladdergame22dec;
}