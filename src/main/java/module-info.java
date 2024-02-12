module com.school.projectschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.school.projectschool to javafx.fxml;
    exports com.school.projectschool;
}