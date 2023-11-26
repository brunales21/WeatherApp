module com.app.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires okhttp3;

    opens com.app.weatherapp to javafx.fxml;
    exports com.app.weatherapp;
}
