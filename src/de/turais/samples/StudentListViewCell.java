package de.turais.samples;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.controlsfx.control.GridCell;

import java.io.IOException;

/**
 * Created by Johannes on 23.05.16.
 *
 */

public class StudentListViewCell extends GridCell<Student> implements EventHandler<MouseEvent> {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private FontAwesomeIconView fxIconGender;

    @FXML
    private GridPane gridPane;

    private FXMLLoader mLLoader;
    private Student student;
    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);

        this.student = student;
        if(empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/fxml/ListCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            label1.setText(String.valueOf(student.getStudentId()));
            label2.setText(student.getName());

            if(student.getGender().equals(Student.GENDER.MALE)) {
                fxIconGender.setIcon(FontAwesomeIcon.MARS);
            } else if(student.getGender().equals(Student.GENDER.FEMALE)) {
                fxIconGender.setIcon(FontAwesomeIcon.VENUS);
            } else {
                fxIconGender.setIcon(FontAwesomeIcon.GENDERLESS);
            }
            gridPane.setOnMouseClicked(this);
            setText(null);
            setGraphic(gridPane);
        }

    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(student.getName());
    }
}
