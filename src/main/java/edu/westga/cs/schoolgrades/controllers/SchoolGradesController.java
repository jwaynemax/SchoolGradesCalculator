package edu.westga.cs.schoolgrades.controllers;


import edu.westga.cs.schoolgrades.model.Grade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.util.Optional;

public class SchoolGradesController {

    @FXML
    private ListView<Double> quizListView;

    private ObservableList<Double> quizList = FXCollections.observableArrayList(0.00);

    	public void initialize() {
    		quizListView.setItems(quizList);
    		
    		quizListView.setEditable(true);
    		
    		quizListView.setCellFactory(param -> new TextFieldListCell<>(new DoubleStringConverter()));
    		
    		class DoubleStringConverter extends StringConverter<Double> {
    		    @Override
    		    public String toString(Double value) {
    		        return value.toString();
    		    }

    		    @Override
    		    public Double fromString(String value) {
    		        return Double.parseDouble(value);
    		    }
    		}
        }

    

    	@FXML
        public void addQuizMenuItemClicked() {
    		quizList.add(0.00);
        }
}
