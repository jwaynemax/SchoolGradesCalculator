package edu.westga.cs.schoolgrades.controllers;


import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class SchoolGradesController {
	
	 @FXML
    private ListView<Double> examListView;
	
    @FXML
    private ListView<Double> hwListView;
    
	@FXML
    private ListView<Double> quizListView;
    
	@FXML
    private ObservableList<Double> examList = FXCollections.observableArrayList(0.00);
	
    @FXML
    private ObservableList<Double> hwList = FXCollections.observableArrayList(0.00);

    @FXML
    private ObservableList<Double> quizList = FXCollections.observableArrayList(0.00);
    
    @FXML
   	private TextField examSubtotal;
    
    @FXML
   	private TextField hwSubtotal;
    
    @FXML
	private TextField quizSubtotal;
    
    private DoubleProperty examDoubleProp = new SimpleDoubleProperty();    
	private DoubleProperty hwDoubleProp = new SimpleDoubleProperty();
    private DoubleProperty quizDoubleProp = new SimpleDoubleProperty();
    
    private SimpleGrade examSimpleGrade;
    private AverageOfGradesStrategy avgExam = new AverageOfGradesStrategy();
    private CompositeGrade examComp = new CompositeGrade(avgExam);

	private SimpleGrade hwSimpleGrade;
    private AverageOfGradesStrategy avgHw = new AverageOfGradesStrategy();
	private DropLowestStrategy dropLowestHw = new DropLowestStrategy(avgHw);
    private CompositeGrade hwComp = new CompositeGrade(dropLowestHw);
    
    private SimpleGrade quizSimpleGrade;
    private SumOfGradesStrategy sumQuiz = new SumOfGradesStrategy();
    private CompositeGrade quizComp = new CompositeGrade(sumQuiz);

    
    	public void initialize() {
    		examListView.setItems(examList);
    		examListView.setEditable(true);
    		examListView.setCellFactory(param -> new TextFieldListCell<>(new DoubleStringConverter()));
    		
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
    		
    		examListView.setOnEditCommit(event -> {
                int index = event.getIndex();
                Double newValue = event.getNewValue();
                examList.set(index, newValue);
                
                examSimpleGrade = new SimpleGrade(newValue);
                examComp.add(examSimpleGrade);
            });
    		
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
        public void addExamMenuItemClicked() {
    		examList.add(0.00);
    		
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
    		
    		this.examSubtotal.textProperty().bind(this.examDoubleProp.asString());
			this.examDoubleProp.set(this.examComp.getValue());
    		
    		this.hwSubtotal.textProperty().bind(this.hwDoubleProp.asString());
			this.hwDoubleProp.set(this.hwComp.getValue());
    		
    		this.quizSubtotal.textProperty().bind(this.quizDoubleProp.asString());
			this.quizDoubleProp.set(this.quizComp.getValue());
    		    			    		
        }
}
