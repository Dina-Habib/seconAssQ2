/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempretureconv;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dinahabib
 */
public class TempretureConv extends Application {
    private Label label1,label2,label3;
    private TextField textField;
    private RadioButton fr,kr;
    private ToggleGroup tg;
    
    @Override
    public void start(Stage primaryStage) {
        label1=new Label("Enter Celsius tempreture: ");
        textField=new TextField();
        tg=new ToggleGroup();
        fr=new RadioButton("Fahrenheit");
        kr=new RadioButton("Kelvin");
        tg.getToggles().addAll(fr,kr);
        EventHandler1 eventHandler1 = new EventHandler1();
        fr.setOnAction(eventHandler1);
        kr.setOnAction(eventHandler1);
        HBox hbox1=new HBox(10);
        hbox1.getChildren().addAll(fr,kr);
        hbox1.setAlignment(Pos.CENTER);
        label2=new Label("New Tempreture in is:");
        label3=new Label();
        HBox hbox2=new HBox(10);
        hbox2.getChildren().addAll(label2,label3);
        hbox2.setAlignment(Pos.CENTER);
        VBox vbox=new VBox(25,label1,textField,hbox1,hbox2);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color:lightgray");
        Scene scene = new Scene(vbox,260,300);
        primaryStage.setTitle("Tempreture Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private class EventHandler1 implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
           double temp = Double.parseDouble(textField.getText());
           if(event.getSource()==fr){
              label3.setText(temp * 9/5 + 32+ "");
           }else if(event.getSource()==kr){
             label3.setText(temp+ 273.15+"");
           }
        }
        
    } 
        }
        
   
    

