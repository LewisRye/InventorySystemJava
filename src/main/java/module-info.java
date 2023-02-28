module com.lewis.inventory {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.lewis.inventory to javafx.fxml;
    exports com.lewis.inventory;
}