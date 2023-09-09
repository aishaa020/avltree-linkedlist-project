package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	TawjeheDS scientific = new TawjeheDS<>();
	TawjeheDS literary = new TawjeheDS<>();
	TawjeheDS both = new TawjeheDS<>();
	
		
	
	@Override
	public void start(Stage primaryStage) {
		
		GridPane gr = new GridPane(); 
		
		gr.setAlignment(Pos.BASELINE_CENTER);
	    gr.setHgap(5.5);
		gr.setVgap(5.5);
		
		Button b1 = new Button("Load File");
		b1.setStyle("-fx-font-size: 15");
		TextArea t1 = new TextArea();
		t1.setEditable(false); 
		
		FileChooser fileChooser = new FileChooser();///reading the file and spliting it to sci & lit
		b1.setOnAction(e ->{
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			
			try {
				Scanner in = new Scanner(selectedFile);
			
				int counter = 0;
				while(in.hasNextLine()) {
					
					String[] list = in.nextLine().split(",");
					if(list[1].equalsIgnoreCase("Scientific")) {
						scientific.insertRecord(new TawjeheRecords(Integer.parseInt(list[0]), list[1], Double.parseDouble(list[2])));
						
					}else {
						literary.insertRecord(new TawjeheRecords(Integer.parseInt(list[0]), list[1], Double.parseDouble(list[2])));
						
					}
					
					//counter++;
					both.insertRecord(new TawjeheRecords(Integer.parseInt(list[0]), list[1], Double.parseDouble(list[2])));
				}
				
			
			t1.appendText(both.d.toString() );
			
	     
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("No file choosen");
			}
			
			 catch (NullPointerException ex) {
					
				 System.out.println("No file choosen");
				}
			
			
			
		});
		
		
		
		
		
		
	    VBox v = new VBox();
	    v.setSpacing(10);
	   // TextArea t2 = new TextArea();
	    
	    Button b2 = new Button("Go to options");
	    b2.setStyle("-fx-font-size: 15");
	    
	    
	    v.getChildren().addAll(b1, t1,  b2);
		 
		//gr.add(b1, 0, 0);
		gr.add(v, 0, 3);
		
		Scene scene = new Scene(gr , 1000 , 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("project 3");
		primaryStage.show();
		
		//////////////////////////////////////////////////////////////////////////////
		/*page 2*/
		GridPane gr2 = new GridPane();
		gr2.setAlignment(Pos.BASELINE_CENTER);
	    gr2.setHgap(5.5);
		gr2.setVgap(5.5);
		
		
		HBox h = new HBox();
		
		Label lbl = new Label("Choose a field:");
		

		RadioButton rb1 = new RadioButton("Scientific");
		
		RadioButton rb2 = new RadioButton("litrary");

		
//		TextArea t1 = new TextArea();
//		t1.setEditable(false); 

		ToggleGroup tg = new ToggleGroup();
		rb1.setToggleGroup(tg);
		rb2.setToggleGroup(tg);


		h.getChildren().addAll(rb1, rb2);
		h.setSpacing(15);
		
		VBox v1 =new VBox();
		v1.setSpacing(10);
		v1.getChildren().addAll(lbl, h);
		
		//insert a record
		HBox hb1 = new HBox(10);
		Label insert = new Label("insert a record");
		
		
		TextField num1 = new TextField();
		
		
		TextField grade1 = new TextField();
		
		
		
		
		Button ins = new Button("Insert");
		
		 
		hb1.getChildren().addAll(insert, num1, grade1,  ins);
		
		ins.setOnAction(e ->{
			if(rb1.isSelected()) {
				
				scientific.insertRecord(new TawjeheRecords(Integer.parseInt(num1.getText()), "Scientific" , Double.parseDouble(grade1.getText())));
				
			}else if (rb2.isSelected()) {
				
				literary.insertRecord(new TawjeheRecords(Integer.parseInt(num1.getText()), "literary" , Double.parseDouble(grade1.getText())));
				
			}
			
			
		});
		
		//Update a record
		VBox vb = new VBox(10);
		HBox uph = new HBox();
		HBox hb2 = new HBox();
		HBox seath = new HBox();
		
		RadioButton up1 = new RadioButton(" Update branch");
		
		RadioButton up2 = new RadioButton("Update average");
		
		ToggleGroup tg1 = new ToggleGroup();
		up1.setToggleGroup(tg1);
		up2.setToggleGroup(tg1);
		
		vb.setSpacing(15);
		uph.setSpacing(15);
		hb2.setSpacing(15);
		seath.setSpacing(15);
		
		Label update = new Label("Update a record:");
		
		Label enter = new Label("Enter seat number:");
		
		
		TextField num2 = new TextField(); //for seat num
		
		
		TextField num3 = new TextField();//for new grade
		num3.setStyle("-fx-font-size: 12");
		
		Button up = new Button("Update");

		 
		uph.getChildren().addAll(up1, up2);
		
		seath.getChildren().addAll(enter, num2);
		
		hb2.getChildren().addAll(num3, up);
		
		vb.getChildren().addAll(update, uph,seath, hb2);
		
		up.setOnAction(e ->{
			try {
			if(rb1.isSelected()) {
			   if(up1.isSelected()) { 
				 scientific.updateBranch(Integer.parseInt(num2.getText()), num3.getText());
				 
				 
				 double value1 = Double.parseDouble(scientific.findRec(Integer.parseInt(num2.getText())).substring(scientific.findRec(Integer.parseInt(num2.getText())).lastIndexOf(" ")));
				 literary.insertRecord(new TawjeheRecords(Integer.parseInt(num2.getText()), num3.getText(),  value1));
				 
				 scientific.deleteRec(Integer.parseInt(num2.getText()));
				
			   } else if(up2.isSelected()) {
				   
				   scientific.updateAverage(Integer.parseInt(num2.getText()), Double.parseDouble(num3.getText()));
					 
				   scientific.deleteRec(Integer.parseInt(num2.getText()));
					
					scientific.insertRecord(new TawjeheRecords(Integer.parseInt(num2.getText()), "scientific" , Double.parseDouble(num3.getText())));
					 
					 
				   
				
				
				
			   }
		 }else if(rb2.isSelected()) {
				
				if(up1.isSelected()) {
					literary.updateBranch(Integer.parseInt(num2.getText()), num3.getText());
					
					
					double value2 = Double.parseDouble(literary.findRec(Integer.parseInt(num2.getText())).substring(literary.findRec(Integer.parseInt(num2.getText())).lastIndexOf(" ")));
					 scientific.insertRecord(new TawjeheRecords(Integer.parseInt(num2.getText()), num3.getText(),  value2));
					 
					 literary.deleteRec(Integer.parseInt(num2.getText()));
					
					
			  }else if(up2.isSelected()) {
					
				  literary.updateAverage(Integer.parseInt(num2.getText()), Double.parseDouble(num3.getText()));
					 
				  literary.deleteRec(Integer.parseInt(num2.getText()));
					
				  literary.insertRecord(new TawjeheRecords(Integer.parseInt(num2.getText()), "literary" , Double.parseDouble(num3.getText())));
					 
					
					
				
				
				
				
				  }
				
			}
			}catch (NumberFormatException ex) {
				
			 System.out.println("wrong input");
			}
		
			
		});
		
		//Delete a record
		HBox hb3 = new HBox(10);
		
		Label delete = new Label("Delete a record");
		
		
		TextField num4 = new TextField();
		
		
		Button del = new Button("Delete");
		
		
		hb3.getChildren().addAll(delete, num4, del);
		
		del.setOnAction(e -> {
			if(rb1.isSelected()) {
				
				scientific.deleteRec(Integer.parseInt(num4.getText()));
				
				
			}else if (rb2.isSelected()) {
				
				literary.deleteRec(Integer.parseInt(num4.getText()));
				
			}
			
			
			
		});
		
		//find a record
		HBox hb4 = new HBox(10);
		
		Label find = new Label("search for a record");
		
		
		TextField num5 = new TextField();
		
		Label prev = new Label("previous:");
		TextField prv = new TextField();
		
		TextField num6 = new TextField();
		
		
		
		Label next = new Label("next:");
		
		TextField nxt = new TextField();
		
		
		Button ser = new Button("Search");
		
		
		hb4.getChildren().addAll(find, num5,num6, prev,prv, next,nxt, ser);
		
		ser.setOnAction(e ->{
			
			if(rb1.isSelected()) {
				num6.setText(scientific.findRec(Integer.parseInt(num5.getText())));
				
				prv.setText(scientific.findprev(Integer.parseInt(num5.getText())));
				nxt.setText(scientific.findnext(Integer.parseInt(num5.getText())));
				
				System.out.println(scientific.dsorted.toString());
				
			}else if (rb2.isSelected()) {
				num6.setText(literary.findRec(Integer.parseInt(num5.getText())));
				prv.setText(literary.findprev(Integer.parseInt(num5.getText())));
				nxt.setText(literary.findnext(Integer.parseInt(num5.getText())));
				
			}
			
		});
		
		//get all 
		HBox hb5 = new HBox(10);
		Label get = new Label("Get all students that their grade is -->");
	   
		
		TextField num8 = new TextField();
		

		TextArea num9 = new TextArea();
		
		
		Button getall = new Button("Get");
		
		
		hb5.getChildren().addAll(get, num8, num9, getall);
		
		
		getall.setOnAction(e->{
			
			if(rb1.isSelected()) {
				num9.appendText(scientific.GetAll(Double.parseDouble(num8.getText()))  +"\n" );
				
			}else if (rb2.isSelected()) {
				num9.appendText(literary.GetAll(Double.parseDouble(num8.getText()))  + "\n");

				
			}
			
			
			
		});
		
		
		
		
		
		
		//back button
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene);
				primaryStage.setTitle("project 3");
				primaryStage.show();
				
				rb1.setSelected(false);
				rb2.setSelected(false);
			}
	    	
	    	
	    
    });
		
	
		//printing
		
		HBox ph = new HBox();
		ph.setSpacing(15);
		
		TextArea printArea = new TextArea();
		
		
		ComboBox<String> cb = new ComboBox<>();
	    cb.getItems().addAll("print doubly linked list", "print 1st AVL", "print 2nd AVL");
	    cb.setPromptText("Fields");
	    ph.getChildren().addAll(cb , printArea);
	    cb.setOnAction(e ->{
	    	try {
	    	if(rb1.isSelected()) {
	    	
	    		if(cb.getSelectionModel().getSelectedItem().equals("print doubly linked list")) {
				    printArea.appendText(scientific.d.toString() + "\n");
				
			
	    		}else if(cb.getSelectionModel().getSelectedItem().equals("print 1st AVL")) {
	    			printArea.appendText(scientific.seattree.levelOrder(scientific.seattree.root) + "\n");
				
			
	    		}
				
			
			
	    		else if(cb.getSelectionModel().getSelectedItem().equals("print 2nd AVL")) {
	    			printArea.appendText(scientific.gradetree.levelOrder(scientific.gradetree.root) + "\n");
				 
				 
			 
	    		}
	    	}	 
	    	else if(rb2.isSelected()) {
	    		if(cb.getSelectionModel().getSelectedItem().equals("print doubly linked list")) {
	    			printArea.appendText(literary.d.toString() + "\n");
				
			
	    		}else if(cb.getSelectionModel().getSelectedItem().equals("print 1st AVL")) {
	    			printArea.appendText(literary.seattree.levelOrder(literary.seattree.root) + "\n");
	    			
				
			
	    		}
				
			
			
	    		else if(cb.getSelectionModel().getSelectedItem().equals("print 2nd AVL")) {
	    			printArea.appendText(literary.gradetree.levelOrder(literary.gradetree.root) + "\n");
				 
			 
	    		}
				 
	    	 
				 
				 
				 
				 
				 
			 }
				 
	    	}catch(NullPointerException x) {
	    		printArea.appendText("list is empty");
	    		
	    		
	    	}
	  
	    	
	    });
	    
	    HBox cph = new HBox();
	    TextArea cba = new TextArea();
	    cba.setMinHeight(20);
	    
	   cph.setSpacing(15);
	    
	    ComboBox<String> cbh = new ComboBox<>();
	    cbh.getItems().addAll("1st avl height", "2nd AVL height");
	    cbh.setPromptText("Height");
	    
	    cph.getChildren().addAll(cbh, cba);
	    
	   cbh.setOnAction(e -> {
		   
		   if(rb1.isSelected()) {
		    	
	    		if(cbh.getSelectionModel().getSelectedItem().equals("1st avl height")) {
				    cba.appendText(scientific.seattree.printHeight() +"\n" );
				
			
	    		}else if(cbh.getSelectionModel().getSelectedItem().equals("2nd AVL height")) {
	    			cba.appendText(scientific.gradetree.printHeight() );
				
			
	    		}
		   }else if(rb2.isSelected()) {
	    		if(cbh.getSelectionModel().getSelectedItem().equals("1st avl height")) {
	    			cba.appendText(literary.seattree.printHeight() + "\n");
				
			
	    		}else if(cbh.getSelectionModel().getSelectedItem().equals("2nd AVL height")) {
	    			cba.appendText(literary.gradetree.printHeight() + "\n");
	    			
				
			
	    		}
	    	}
	   
	   
	   
	   });
	    
	    
		
		gr2.add(v1, 0, 0);
		gr2.add(hb1, 0, 2);
		
		gr2.add(vb, 0, 4);
		
		gr2.add(hb3, 0, 6);
		
		gr2.add(hb4, 0, 8);
		
		gr2.add(hb5, 0, 10);
		
		gr2.add(ph, 0, 12);
		
		gr2.add(back, 0, 15);
		
		gr2.add(cph, 0, 14);
		
		
		
		Scene scene2 = new Scene(gr2 , 1000 , 800);
		b2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				primaryStage.setScene(scene2);
				primaryStage.setTitle("project 3");
				primaryStage.show();
				
				rb1.setSelected(false);
				rb2.setSelected(false);
			}
	    	
	    	
	    
    });
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
	}
}
