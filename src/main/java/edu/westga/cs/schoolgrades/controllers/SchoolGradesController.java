package edu.westga.cs.schoolgrades.controllers;


import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
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
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.converter.DoubleStringConverter;


import java.util.Optional;

public class SchoolGradesController {

    @FXML
    private ListView<Double> quizListView;
    
    @FXML
    private ListView<Double> hwListView;

    @FXML
    private ObservableList<Double> quizList = FXCollections.observableArrayList(0.00);
    
    @FXML
    private ObservableList<Double> hwList = FXCollections.observableArrayList(0.00);
    
    @FXML
	private TextField quizSubtotal;
    
    @FXML
	private TextField hwSubtotal;
    
	private DoubleProperty quizDoubleProp = new SimpleDoubleProperty();
	private DoubleProperty hwDoubleProp = new SimpleDoubleProperty();

	private SimpleGrade hwSimpleGrade;
    private AverageOfGradesStrategy avgHw = new AverageOfGradesStrategy();
    private CompositeGrade hwComp = new CompositeGrade(avgHw);
    
    private SimpleGrade quizSimpleGrade;
    private SumOfGradesStrategy sumQuiz = new SumOfGradesStrategy();
    private CompositeGrade quizComp = new CompositeGrade(sumQuiz);

    
    	public void initialize() {
    		hwListView.setItems(hwList);
    		hwListView.setEditable(true);
    		hwListView.setCellFactory(param -> new TextFieldListCell<>(new DoubleStringConverter()));
    		
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
    		
    		hwListView.setOnEditCommit(event -> {
                int index = event.getIndex();
                Double newValue = event.getNewValue();
                hwList.set(index, newValue);
                
                hwSimpleGrade = new SimpleGrade(newValue);
                hwComp.add(hwSimpleGrade);
            });
    		
    		quizListView.setOnEditCommit(event -> {
                int index = event.getIndex();
                Double newValue = event.getNewValue();
                quizList.set(index, newValue);
                
                quizSimpleGrade = new SimpleGrade(newValue);
                quizComp.add(quizSimpleGrade);
            });
        }

    
    	@FXML
        public void addHwMenuItemClicked() {
    		hwList.add(0.00);
    		
        }
    	
    	@FXML
        public void addQuizMenuItemClicked() {
    		quizList.add(0.00);
    		
        }
    	
    	@FXML
        public void recalculate() {
    		
    		this.hwSubtotal.textProperty().bind(this.hwDoubleProp.asString());
			this.hwDoubleProp.set(this.hwComp.getValue());
    		
    		this.quizSubtotal.textProperty().bind(this.quizDoubleProp.asString());
			this.quizDoubleProp.set(this.quizComp.getValue());
    		    		
    		    		    		
        }
}
