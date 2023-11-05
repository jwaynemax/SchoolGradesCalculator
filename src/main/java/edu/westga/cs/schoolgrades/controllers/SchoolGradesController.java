package edu.westga.cs.schoolgrades.controllers;


import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
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
    
    @FXML
	private TextField finalGrade;
    
    private DoubleProperty examDoubleProp = new SimpleDoubleProperty();    
	private DoubleProperty hwDoubleProp = new SimpleDoubleProperty();
    private DoubleProperty quizDoubleProp = new SimpleDoubleProperty();
    private DoubleProperty finalGradeProp = new SimpleDoubleProperty();

    
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
    		
    		examSimpleGrade = new SimpleGrade(0.00);
            examComp.add(examSimpleGrade);
            
            hwSimpleGrade = new SimpleGrade(0.00);
            hwComp.add(hwSimpleGrade);
            
            quizSimpleGrade = new SimpleGrade(0.00);
            quizComp.add(quizSimpleGrade);
    		
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
                examComp.removeAt(index);
                examComp.add(examSimpleGrade, index);
            });
    		
    		hwListView.setOnEditCommit(event -> {
                int index = event.getIndex();
                Double newValue = event.getNewValue();
                hwList.set(index, newValue);
                
                hwSimpleGrade = new SimpleGrade(newValue);
                hwComp.removeAt(index);
                hwComp.add(hwSimpleGrade, index);
            });
    		
    		quizListView.setOnEditCommit(event -> {
                int index = event.getIndex();
                Double newValue = event.getNewValue();
                quizList.set(index, newValue);
                
                quizSimpleGrade = new SimpleGrade(newValue);
                quizComp.removeAt(index);
                quizComp.add(quizSimpleGrade, index);
            });
        }

    	@FXML
        public void addExamMenuItemClicked() {
    		examList.add(0.00);
    		examSimpleGrade = new SimpleGrade(0.00);
            examComp.add(examSimpleGrade);
        }
    
    	@FXML
        public void addHwMenuItemClicked() {
    		hwList.add(0.00);
    		hwSimpleGrade = new SimpleGrade(0.00);
            hwComp.add(hwSimpleGrade);
    		
        }
    	
    	@FXML
        public void addQuizMenuItemClicked() {
    		quizList.add(0.00);
    		quizSimpleGrade = new SimpleGrade(0.00);
            quizComp.add(quizSimpleGrade);
        }
    	
    	@FXML
        public void recalculate() {
    		
    		this.examSubtotal.textProperty().bind(this.examDoubleProp.asString());
			this.examDoubleProp.set(this.examComp.getValue());
    		
    		this.hwSubtotal.textProperty().bind(this.hwDoubleProp.asString());
			this.hwDoubleProp.set(this.hwComp.getValue());
    		
    		this.quizSubtotal.textProperty().bind(this.quizDoubleProp.asString());
			this.quizDoubleProp.set(this.quizComp.getValue());
			
			this.calculateFinal();
    		    			    		
        }

		private void calculateFinal() {
			WeightedGrade quizFinal = new WeightedGrade(this.quizComp, .2);
			WeightedGrade hwFinal = new WeightedGrade(this.hwComp, .3);
			WeightedGrade examFinal = new WeightedGrade(this.examComp, .5);

			this.finalGrade.textProperty().bind(this.finalGradeProp.asString());
			this.finalGradeProp.set(quizFinal.getValue() + hwFinal.getValue() + examFinal.getValue());
						
		}
}
