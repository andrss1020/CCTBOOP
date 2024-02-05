module com.school.projectschool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.school.projectschool to javafx.fxml;
    exports com.school.projectschool;
}