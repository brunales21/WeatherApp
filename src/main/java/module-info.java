module com.app.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;
    requires java.net.http;
    requires java.desktop;

    opens com.app.weatherapp to javafx.fxml;
    exports com.app.weatherapp;
}
