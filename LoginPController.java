package Controllers;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.ConnectionDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class LoginPController  implements Initializable {
	  private static String loggedInUsername; // Static to share between scenes
	  
	    
	    // Initialize in constructor
	 
	    public static String getLoggedInUsername() {
	        return loggedInUsername;
	    }
	    
	    public static void setLoggedInUsername(String username) {
	        loggedInUsername = username;
	    }

	    @FXML
	    private Button Forgetbutton;

	    @FXML
	    private Button Loginbutton;

	    @FXML
	    private Label loginmsgL;

	    @FXML
	    private PasswordField passwoedfiled;

	    @FXML
	    private TextField usernametextfield;
	    private EtudiantController etudiantController;

	    // Setter method for EtudiantController
	    public void setEtudiantController(EtudiantController etudiantController) {
	        this.etudiantController = etudiantController;
	    }

	   
	    public void loginAction(ActionEvent e) throws IOException, SQLException {
			
			if(usernametextfield.getText().isBlank()==false && passwoedfiled.getText().isBlank()==false) {
				setLoggedInUsername(usernametextfield.getText());
				validlogin(e);
				
			}else {
				loginmsgL.setText("Please enter your username and password.");
				
			}
			
		}
	    
		public void validlogin(ActionEvent e) throws IOException, SQLException {
			int number = Integer.parseInt(usernametextfield.getText());
			System.out.println(number);
			try(Connection connection = ConnectionDB.getConnection()) {
			EtudiantController etudiantController=new EtudiantController(connection);
			AuthController authController=new AuthController(connection);
			AdminController adminController= new AdminController(connection);
			ProfController pController=new ProfController(connection);
				if(etudiantController.etudiantExiste(number)) {
					loginmsgL.setText("you are a student");
					
					if(authController.connecter(number,passwoedfiled.getText()) != null) {
						System.out.println("ak d5alt");
						switchToScene2(e);
						
						
						
						
						
						
						
					}
					
	            
				
			}
			

				if(adminController.getAdminByMat(number)!= null) {
					loginmsgL.setText("you are an admin");
					
					if(authController.connecter(number,passwoedfiled.getText()) != null) {
						System.out.println("ak d5alt");
					
						
						
						switchToScene1(e);
						
						
						
					}
					
	            
				
			}	
				
				
				if(pController.getProfByMat(number)!= null) {
					loginmsgL.setText("you are an Teacher");
					
					if(authController.connecter(number,passwoedfiled.getText()) != null) {
						System.out.println("ak d5alt");
					
						
						
						switchToScene3(e);
						
						
						
					}
					
	            
				
			}		
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
		}
		
		
		
		@SuppressWarnings("exports")
		public void switchToScene2(ActionEvent event) throws IOException {
		   Parent homepageParent=FXMLLoader.load(getClass().getResource("/view/DashboardP.fxml"));
		   Scene homeoageScene=new Scene(homepageParent);
		   Stage appStage=(Stage)((Node)event.getSource()).getScene().getWindow();
		   appStage.setScene(homeoageScene);
		   appStage.show();
		}
	    
		public void switchToScene1(@SuppressWarnings("exports") ActionEvent event) throws IOException {
			   Parent homepageParent=FXMLLoader.load(getClass().getResource("/view/AdminP.fxml"));
			   Scene homeoageScene=new Scene(homepageParent);
			   Stage appStage=(Stage)((Node)event.getSource()).getScene().getWindow();
			   appStage.setScene(homeoageScene);
			   appStage.show();
			}
		    
		public void switchToScene3(@SuppressWarnings("exports") ActionEvent event) throws IOException {
			   Parent homepageParent=FXMLLoader.load(getClass().getResource("/view/ProfP.fxml"));
			   Scene homeoageScene=new Scene(homepageParent);
			   Stage appStage=(Stage)((Node)event.getSource()).getScene().getWindow();
			   appStage.setScene(homeoageScene);
			   appStage.show();
			}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
		}
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}