package Controllers;
import javafx.scene.control.Label;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.security.PublicKey;
import Model.Auth;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import Model.Admin;
import Model.Annee;
import Model.AnneeDAO;
import Model.Auth;
import Model.ConnectionDB;
import Model.EmploiDuTempsDAO;
import Model.Etudiant;
import Model.EtudiantDAO;
import Model.EtudiantTable;
import Model.Module;
import Model.Prof;
import Model.ProfTable;
import Model.Role;
import Model.Semestre;
import Model.Specialite;
import Model.SpecialiteDAO;
import Model.Utilisateur;
import javafx.scene.layout.AnchorPane;
import Model.EtudiantDAO;

public class AdminPController implements Initializable {
	
	  @FXML
	    private Button AdminsBT;
	  @FXML
	    private Button backBT;

	    @FXML
	    private TableView<EtudiantTable> EtudiantT;

	    @FXML
	    private TableColumn<EtudiantTable, String> GmailT;

	    @FXML
	    private TableColumn<EtudiantTable, BigDecimal> GradeT;

	    @FXML
	    private TableColumn<EtudiantTable, Integer> MatriculeT;

	    @FXML
	    private TableColumn<EtudiantTable, String> NameT;

	    @FXML
	    private TableColumn<EtudiantTable, String> PasswordT;

	    @FXML
	    private TableColumn<EtudiantTable, String> SpecialityT;
	    @FXML
	    private TableColumn<EtudiantTable, String> groupeT;

	    @FXML
	    private TableColumn<EtudiantTable, String> SectionT;
	    
	    
	    
	    @FXML
	    private TableView<ProfTable> EtudiantT1;

	    @FXML
	    private TableColumn<ProfTable, String> GmailT1;

	    @FXML
	    private TableColumn<ProfTable, String> GradeT1;

	    @FXML
	    private TableColumn<ProfTable, Integer> MatriculeT1;

	    @FXML
	    private TableColumn<ProfTable, String> NameT1;

	    @FXML
	    private TableColumn<ProfTable, String> PasswordT1;

	    @FXML
	    private TableColumn<ProfTable, String> SpecialityT1;
	    @FXML
	    private TableColumn<ProfTable, String> SurnameT1;

	    @FXML
	    private TableColumn<ProfTable, String> SectionT1;
	    @FXML
	    private TableView<Admin> EtudiantT11;

	    @FXML
	    private TableColumn<Admin, String> GmailT11;

	  
	    @FXML
	    private TableColumn<Admin, Integer> MatriculeT11;

	    @FXML
	    private TableColumn<Admin, String> NameT11;

	    @FXML
	    private TableColumn<Admin, String> PasswordT11;

	  
	    @FXML
	    private TableColumn<Admin, String> SurnameT11;

	   
	    @FXML
	    
	    
	    
	    
	    private Button StudentsBT;

	    @FXML
	    private TableColumn<EtudiantTable, String> SurnameT;

	    @FXML
	    private Button TeachersBT;

	    @FXML
	    private TableColumn<EtudiantTable, String> YearT;

	    @FXML
	    private Label lbiStatus;
	    @FXML
	    private TextField SearchTextfield;
	    @FXML
	    private TextField GmailTextfield;
	    @FXML
	    private TextField GmailTextfield21;
	    @FXML
	    private TextField GmailTextfield22;
	    @FXML
	    private TextField GmailTextfield221;
	    @FXML
	    private TextField GroupeTextfield;
	    @FXML
	    private TextField MatriculeTextfield;

	    @FXML
	    private TextField MoyenneTextfield;
	    @FXML
	    private TextField NameTextfield;
	    @FXML
	    private TextField PasswordTextfield;
	    @FXML
	    private TextField SectionTextfield;
	    @FXML
	    private TextField SpecialityTextfield;
	    @FXML
	    private TextField SurnameTextfield;
	    @FXML
	    private TextField Yeartextfield;
	    @FXML
	    
	    private TextField GmailTextfield1;
        @FXML
	    
	    private TextField GmailTextfield2;
	    @FXML
	    private TextField GroupeTextfield1;
	    @FXML
	    private TextField MatriculeTextfield1;

	    @FXML
	    private TextField MoyenneTextfield1;
	    @FXML
	    private TextField NameTextfield1;
	    @FXML
	    private TextField PasswordTextfield1;
	    @FXML
	    private TextField SectionTextfield1;
	    @FXML
	    private TextField SpecialityTextfield1;
	    @FXML
	    private TextField SurnameTextfield1;
	    @FXML
	    private TextField Yeartextfield1;
	    @FXML
	    private TextField MoyenneTextfield2;
	    @FXML
	    private TextField NameTextfield2;
	    @FXML
	    private TextField PasswordTextfield2;
	    @FXML
	    private TextField SectionTextfield2;
	    @FXML
	    private TextField SpecialityTextfield2;
	    @FXML
	    private TextField SurnameTextfield2;
	    @FXML
	    private TextField MatriculeTextfield2;
	    
	    @FXML
	    private TextField MoyenneTextfield21;
	    @FXML
	    private TextField NameTextfield21;
	    @FXML
	    private TextField PasswordTextfield21;
	    @FXML
	    private TextField SectionTextfield21;
	    @FXML
	    private TextField SpecialityTextfield21;
	    @FXML
	    private TextField SurnameTextfield21;
	    @FXML
	    private TextField MatriculeTextfield21;
	    
	    @FXML
	    private TextField NameTextfield22;
	    @FXML
	    private TextField PasswordTextfield22;
	   
	   
	    @FXML
	    private TextField SurnameTextfield22;
	    @FXML
	    private TextField MatriculeTextfield22;
	    @FXML
	    private TextField NameTextfield221;
	    @FXML
	    private TextField PasswordTextfield221;
	   
	   
	    @FXML
	    private TextField SurnameTextfield221;
	    @FXML
	    private TextField MatriculeTextfield221;
	    @FXML
	    private TextField SearchTextfield1;
	    @FXML
	    private Button deleteBT;
	    @FXML
	    private Button updateBT2;
	    @FXML
	    private AnchorPane etudianrAnchor;
	    @FXML
	    private AnchorPane ajouterEAnchor;
	    
	    @FXML
	    private AnchorPane etudiantsettingsAnchor;
	    @FXML
	    private AnchorPane TeachersAnchor;
	    
	    @FXML
	    private AnchorPane profsettingsAnchor;
	    @FXML
	    private AnchorPane profajouterAnchor;
	    @FXML
	    private AnchorPane AdminAnchor;
	    @FXML
	    private AnchorPane adminSettingsAnchor;
	    @FXML
	    private AnchorPane adminajouterAnchor;
	    @FXML
	    private Button updateBT;
	    @FXML
	    private Button ajouterProfBTN1;
	    @FXML
	    private Button ajouterProfBTN;
	    @FXML
	    private Button backBT11;
	    @FXML
	    private Button ajouterProfBTN11;
	    @FXML
	    private Button backBT12;
	    @FXML
	    private Button backBT121;
	    @FXML
	    private Button updateBT21;
	    @FXML
	    private Button deleteBT11;
	    @FXML
	    private Button ajouterABTN;
	    @FXML
	    private Button deconexionadmin;
	    
	ObservableList<EtudiantTable> etudiantssList=FXCollections.observableArrayList();
	ObservableList<ProfTable> teacherList=FXCollections.observableArrayList();
	ObservableList<Admin> adminList=FXCollections.observableArrayList();
	 int currentYear = Year.now().getValue();
     int previousYear = currentYear - 1;
     
     Annee curAnnee;
     
     int index=-1;
   @FXML
	private void getselected(MouseEvent event) {
    	 etudiantsettingsAnchor.toFront();
    	 index= EtudiantT.getSelectionModel().getSelectedIndex();
    	 if(index<=-1) {
    		 return;
    	 }
    	 MatriculeTextfield.setText(MatriculeT.getCellData(index).toString());
    	 NameTextfield.setText(NameT.getCellData(index));
    	 SurnameTextfield.setText(SurnameT.getCellData(index));
    	 SpecialityTextfield.setText(SpecialityT.getCellData(index));
    	 Yeartextfield.setText(YearT.getCellData(index));
    	 BigDecimal cellValue = GradeT.getCellData(index);
    	 String value = (cellValue != null) ? cellValue.toString() : "N/A";
    	 MoyenneTextfield.setText(value);
    	 GmailTextfield.setText(GmailT.getCellData(index));
    	 PasswordTextfield.setText(PasswordT.getCellData(index));
    	 SectionTextfield.setText(SectionT.getCellData(index));
    	 GroupeTextfield.setText(groupeT.getCellData(index));

    	 
    	 
     }
   @FXML
	private void getselectedProf(MouseEvent event) {
		profsettingsAnchor.toFront();
   	 index= EtudiantT1.getSelectionModel().getSelectedIndex();
   	 if(index<=-1) {
   		 return;
   	 }
   	 MatriculeTextfield2.setText(MatriculeT1.getCellData(index).toString());
   	 NameTextfield2.setText(NameT1.getCellData(index));
   	 SurnameTextfield2.setText(SurnameT1.getCellData(index));
   	 SpecialityTextfield2.setText(SpecialityT1.getCellData(index));
   	 
   	 MoyenneTextfield2.setText(GradeT1.getCellData(index));
   	 GmailTextfield2.setText(GmailT1.getCellData(index));
   	 PasswordTextfield2.setText(PasswordT1.getCellData(index));
   	 SectionTextfield2.setText(SectionT1.getCellData(index));
   	
   	 
   	 
    }
     
   @FXML
   private void getselectedAdmin(MouseEvent event) {
	   adminSettingsAnchor.toFront();
  	 index= EtudiantT11.getSelectionModel().getSelectedIndex();
  	 if(index<=-1) {
  		 return;
  	 }
  	 MatriculeTextfield22.setText(MatriculeT11.getCellData(index).toString());
  	 NameTextfield22.setText(NameT11.getCellData(index));
  	 SurnameTextfield22.setText(SurnameT11.getCellData(index));
  	 
  	 GmailTextfield22.setText(GmailT11.getCellData(index));
  	 PasswordTextfield22.setText(PasswordT11.getCellData(index));
  	
  	 
  	 
   }
   
   public void switchToScene222(ActionEvent event) throws IOException {
 	  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Exit Application");
	        alert.setHeaderText("Confirm Exit");
	        alert.setContentText("Are you sure you want to exit the application?");
	        
	        // Get the stage from the event source
	        Stage stage = (Stage) deconexionadmin.getScene().getWindow();
	        
	        // If user confirms, close the application
	        alert.showAndWait().ifPresent(response -> {
	            if (response == ButtonType.OK) {
	            	  Parent homepageParent = null;
					try {
						homepageParent = FXMLLoader.load(getClass().getResource("/view/LoginP.fxml"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	   			   Scene homeoageScene=new Scene(homepageParent);
	   			   Stage appStage=(Stage)((Node)event.getSource()).getScene().getWindow();
	   			   appStage.setScene(homeoageScene);
	   			   appStage.show();
	            
	            }});
		}
   public void deletA(ActionEvent e) throws SQLException {
	   
	   
	   try(Connection connection = ConnectionDB.getConnection()) {
            AdminController adminController=new AdminController(connection);  
		   UtilisateurController utilisateurController=new UtilisateurController(connection);
  			SpecialiteController specialiteController=new SpecialiteController(connection);
 			int id=Integer.parseInt(MatriculeTextfield22.getText());
 			adminController.supprimerAdmin(id);
 			utilisateurController.supprimerUtilisateur(id);

 			adminList.clear();

			try(Connection connection1 = ConnectionDB.getConnection()) {
				AdminController adminController1=new AdminController(connection1);
				UtilisateurController utilisateurController1= new UtilisateurController(connection1);
				List<Utilisateur> utilisateurs=utilisateurController1.getTousLesUtilisateurs();
				
				
				for(int j=0;j<utilisateurs.size();j++) {
					Utilisateur utilisateur=utilisateurs.get(j);
					int number=utilisateur.getIdUser();
				
					if(adminController1.getAdminByMat(number) != null) {
						Admin admin=adminController1.getAdminByMat(utilisateur.getIdUser());
						admin.setMotdepasse(utilisateur.getMotdepasse());
						adminList.add(admin);
				
						
					}
					
					
					
					
					
				}
				
			
				
					MatriculeT11.setCellValueFactory(new PropertyValueFactory("idAdmin"));
					NameT11.setCellValueFactory(new PropertyValueFactory("nom"));
					SurnameT11.setCellValueFactory(new PropertyValueFactory("prenom"));
					GmailT11.setCellValueFactory(new PropertyValueFactory("email"));
					PasswordT11.setCellValueFactory(new PropertyValueFactory("motdepasse"));

					EtudiantT11.setItems(adminList);
				FilteredList<Admin> filterDataEtudiantTables=new FilteredList(adminList,b -> true);
				SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
				            return true;
				        }
				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
				        
				        if(Integer.toString(EtudiantTable.getIdAdmin()).toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getNom().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getPrenom().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				       
				        }else if(EtudiantTable.getEmail().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getMotdepasse().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				      
				      
				        }
				      return false;
				    });
				});
				
				SortedList<Admin> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
				
				sortedDaTables.comparatorProperty().bind(EtudiantT11.comparatorProperty());
				EtudiantT11.setItems(sortedDaTables);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AdminAnchor.toFront();
	   }}

  			
	   
public void updateA(ActionEvent e) throws SQLException {
	try(Connection connection = ConnectionDB.getConnection()) {
			UtilisateurController utilisateurController=new UtilisateurController(connection);
AdminController adminController=new AdminController(connection);
			int id=Integer.parseInt(MatriculeTextfield22.getText());
			Utilisateur utilisateur= utilisateurController.getUtilisateurByMat(id);
			
			utilisateur.setEmail(GmailTextfield22.getText());
			utilisateur.setMotdepasse(PasswordTextfield22.getText());
			utilisateur.setNom(NameTextfield22.getText());
			utilisateur.setPrenom(SurnameTextfield22.getText());
		   String query = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, motdepasse = ?, role = ? WHERE idUser = ?";
	        
	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
	            stmt.setString(1, utilisateur.getNom());
	            stmt.setString(2, utilisateur.getPrenom());
	            stmt.setString(3, utilisateur.getEmail());
	            stmt.setString(4, utilisateur.getMotdepasse());
	            stmt.setString(5, utilisateur.getRole().name());
	            stmt.setInt(6, utilisateur.getIdUser());
	            
	            int rowsAffected = stmt.executeUpdate();
	        }
		    
		    
		    adminList.clear();

			try(Connection connection1 = ConnectionDB.getConnection()) {
				AdminController adminController1=new AdminController(connection1);
				UtilisateurController utilisateurController1= new UtilisateurController(connection1);
				List<Utilisateur> utilisateurs=utilisateurController1.getTousLesUtilisateurs();
				
				
				for(int j=0;j<utilisateurs.size();j++) {
					Utilisateur utilisateur1=utilisateurs.get(j);
					int number=utilisateur1.getIdUser();
				
					if(adminController1.getAdminByMat(number) != null) {
						Admin admin1=adminController1.getAdminByMat(utilisateur1.getIdUser());
						admin1.setMotdepasse(utilisateur1.getMotdepasse());
						adminList.add(admin1);
				
						
					}
					
					
					
					
					
				}
				
			
				
					MatriculeT11.setCellValueFactory(new PropertyValueFactory("idAdmin"));
					NameT11.setCellValueFactory(new PropertyValueFactory("nom"));
					SurnameT11.setCellValueFactory(new PropertyValueFactory("prenom"));
					GmailT11.setCellValueFactory(new PropertyValueFactory("email"));
					PasswordT11.setCellValueFactory(new PropertyValueFactory("motdepasse"));

					EtudiantT11.setItems(adminList);
				FilteredList<Admin> filterDataEtudiantTables=new FilteredList(adminList,b -> true);
				SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
				            return true;
				        }
				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
				        
				        if(Integer.toString(EtudiantTable.getIdAdmin()).toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getNom().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getPrenom().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				       
				        }else if(EtudiantTable.getEmail().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getMotdepasse().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				      
				      
				        }
				      return false;
				    });
				});
				
				SortedList<Admin> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
				
				sortedDaTables.comparatorProperty().bind(EtudiantT11.comparatorProperty());
				EtudiantT11.setItems(sortedDaTables);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AdminAnchor.toFront();
	   
	  
	   
	}
	
	
	
	
}
	   
	   
	  
   
   
   
   
   
   
   
   
   
   public void back(ActionEvent e) {
    	 
    	 etudianrAnchor.toFront();
    	  
    	 
     }
 public void backProf(ActionEvent e) {
    	 
    	 TeachersAnchor.toFront();
    	  
    	 
     }
 public void backAdmin(ActionEvent e) {
	 
	 AdminAnchor.toFront();
	  
	 
 }
     public void showA(ActionEvent e) {
    	 
    	 ajouterEAnchor.toFront();
    	 
    	 
    	 
    	 
    	 
     }
 public void showAP(ActionEvent e) {
    	 
	 profajouterAnchor.toFront();
    	 
    	 
    	 
    	 
    	 
     }
 
 public void showAA(ActionEvent e) {
	 
	 adminajouterAnchor.toFront();
    	 
    	 
    	 
    	 
    	 
     }
     public void ajouter(ActionEvent e) {
    	 
    	 try(Connection connection = ConnectionDB.getConnection()) {
  			UtilisateurController utilisateurController=new UtilisateurController(connection);
  			EtudiantController etudiantController=new EtudiantController(connection);
  			SpecialiteController specialiteController=new SpecialiteController(connection);
  			AnneeController anneeController=new AnneeController(connection);
  			BigDecimal value = new BigDecimal(MoyenneTextfield1.getText());
  
  			
  			
  			
  			
  			
  			
  			
  			try {
 				String yearRange = previousYear + "-" + currentYear;
  			    int id = Integer.parseInt(MatriculeTextfield1.getText());
  			   

  			    
  			   Utilisateur utilisateur=new Utilisateur(id,NameTextfield1.getText(),SurnameTextfield1.getText(),GmailTextfield1.getText(),PasswordTextfield1.getText(),Role.Etudiant);
  			   String sql = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?, ?)";
  		        
  		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
  		            statement.setInt(1, utilisateur.getIdUser());
  		            statement.setString(2, utilisateur.getNom());
  		            statement.setString(3, utilisateur.getPrenom());
  		            statement.setString(4, utilisateur.getEmail());
  		            statement.setString(5, utilisateur.getMotdepasse());
  		            statement.setString(6, utilisateur.getRole().toString());
  		            
  		            int rowsAffected = statement.executeUpdate();
  		        }
  			   List<Specialite> specialites= specialiteController.getToutesLesSpecialites();
  			   
  			   for(int i=0; i<specialites.size();i++) {
  				   Specialite specialite=specialites.get(i);
					   System.out.println(specialite.getNomSpecialite());

  				   if(SpecialityTextfield1.getText().equalsIgnoreCase(specialite.getNomSpecialite())) {
  					   int idS= specialite.getIdSpecialite();
  					 
 		 			   Etudiant etudiant=new Etudiant(id,NameTextfield1.getText(),SurnameTextfield1.getText(),GmailTextfield1.getText(),idS,SectionTextfield1.getText(),GroupeTextfield1.getText(),null);
                  String sqll = "INSERT INTO etudiants (idEtudiant, idUser, idSpecialite, section, groupe, idEmploiDuTemps) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";
             
             try (PreparedStatement pstmt = connection.prepareStatement(sqll)) {
                 pstmt.setInt(1, etudiant.getIdEtudiant());
                 pstmt.setInt(2, utilisateur.getIdUser());
                 pstmt.setInt(3, etudiant.getIdSpecialite());
                 pstmt.setString(4, etudiant.getSection());
                 pstmt.setString(5, etudiant.getGroupe());
                 
                
                     pstmt.setNull(6, Types.INTEGER);
                     int userRows = pstmt.executeUpdate();
                     if (userRows != 1) {
                         throw new SQLException("Failed to insert user");
                     }

             }  
               					 Random randomm = new Random();
  			        // Generates between 1000 (inclusive) and 10000 (exclusive)
  			     int random= 1000 + randomm.nextInt(9000);
  	  			  Annee annee=new Annee(random,yearRange,idS);
  	  			if (annee == null || annee.getIdAnnee() == 0 || 
  	  	            annee.getAnneeScolaire() == null || annee.getAnneeScolaire().isEmpty() ||
  	  	            annee.getIdSpecialite() == 0) {
  	  	            throw new IllegalArgumentException("Tous les champs obligatoires doivent être fournis");
  	  	        }

  	  	        String sq = "INSERT INTO annees (idAnnee, anneeScolaire, idSpecialite, moyenneGenerale) " +
  	  	                     "VALUES (?, ?, ?, ?)";

  	  	        try (PreparedStatement pstmt = connection.prepareStatement(sq)) {
  	  	            pstmt.setInt(1, annee.getIdAnnee());
  	  	            pstmt.setString(2, annee.getAnneeScolaire());
  	  	            pstmt.setInt(3, annee.getIdSpecialite());
  	  	            
  	  	            // Handle optional moyenneGenerale
  	  	            if (annee.getmoyenneGenerale() != null) {
  	  	                pstmt.setBigDecimal(4, annee.getmoyenneGenerale());
  	  	            } else {
  	  	                pstmt.setNull(4, Types.DECIMAL);
  	  	            }

  	  	            int rowsAffected = pstmt.executeUpdate();  	  			  
  					   
  				   }
  				   
  	  	    String sql1 = "INSERT INTO etudiants_annees (idEtudiant, idAnnee) VALUES (?, ?)";
  	        
  	        try (PreparedStatement pstmt = connection.prepareStatement(sql1)) {
  	            pstmt.setInt(1, etudiant.getIdEtudiant());
  	            pstmt.setInt(2, annee.getIdAnnee());
  	            
  	           pstmt.executeUpdate();
  	  	        
  	        }
  	  	        
  	  	        ModuleController moduleController=new ModuleController(connection);
  	  	     
  	    List<Module> modules=   moduleController.getModulesParSpecialite(specialite.getIdSpecialite());
  	  int position = SectionTextfield1.getText().charAt(0) - 'A' + 1;
          System.out.println(position);

  	        for(int ii=0;ii<modules.size();ii++) {
  	        	Module module=modules.get(ii);
  	        	if(position==module.getCoefControle()) {
  	        	
  	        	 String sql11 = "INSERT INTO etudiants_modules (idEtudiant, idModule) VALUES (?, ?)";
  	  	        
  	  	        try (PreparedStatement pstmt = connection.prepareStatement(sql11)) {
  	  	            pstmt.setInt(1, etudiant.getIdEtudiant());
  	  	            pstmt.setInt(2, module.getIdModule());
  	  	            System.out.println(module.getIdModule());
  	  	            System.out.println(module.getCoefControle());

  	  	           pstmt.executeUpdate();
  	  	  	        
  	  	        }
  	        	
  	        	}
  	        }
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	        
  	  	        
  	  	        
  	  	        
  				   
  				   }}
  			   
  			   
  			   
  			} catch (NumberFormatException ee) {
  			    System.out.println("Invalid number input");
  			}
  		
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			
  		} catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
    	 
    	 etudiantssList.clear();
  		try(Connection connection = ConnectionDB.getConnection()) {
 			EtudiantController etudiantController=new EtudiantController(connection);
 			SpecialiteController specialiteController= new SpecialiteController(connection);
 			List<Etudiant> etudiants= etudiantController.getAllEtudiants();
 			
 			for(int i=0;i<etudiants.size();i++) {
 				
 				
 				
 				
 				Etudiant etudiant=etudiants.get(i);
 				AnneeController anneeC=new AnneeController(connection);
 				List<Annee> annees=	anneeC.getAnneesByEtudiantId(etudiant.getIdEtudiant());
 				String yearRange = previousYear + "-" + currentYear;
 				Specialite speString=specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
 				
 				for (int ii = 0; ii < annees.size(); ii++) {
 					Annee annee=annees.get(ii);
 					if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
 						 curAnnee=annee;
 					}
 					
 					EtudiantTable etudiantTable=new EtudiantTable(etudiant.getIdEtudiant(),etudiant.getNom(),etudiant.getPrenom(),speString.getNomSpecialite(),yearRange,curAnnee.getmoyenneGenerale(),etudiant.getEmail(),etudiant.getMotdepasse(),etudiant.getSection(),etudiant.getGroupe());
 					
 					etudiantssList.add(etudiantTable);
 				
 				
 				
 			}
 			
 				MatriculeT.setCellValueFactory(new PropertyValueFactory("Matricule"));
 				NameT.setCellValueFactory(new PropertyValueFactory("nameString"));
 				SurnameT.setCellValueFactory(new PropertyValueFactory("surnameString"));
 				SpecialityT.setCellValueFactory(new PropertyValueFactory("specialityString"));
 				YearT.setCellValueFactory(new PropertyValueFactory("yearString"));
 				GradeT.setCellValueFactory(new PropertyValueFactory("graDecimal"));
 				GmailT.setCellValueFactory(new PropertyValueFactory("gmailString"));
 				PasswordT.setCellValueFactory(new PropertyValueFactory("passwordString"));
 				SectionT.setCellValueFactory(new PropertyValueFactory("Section"));
 				groupeT.setCellValueFactory(new PropertyValueFactory("Groupe"));

 				EtudiantT.setItems(etudiantssList);
 			FilteredList<EtudiantTable> filterDataEtudiantTables=new FilteredList(etudiantssList,b -> true);
 			SearchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
 			    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
 			        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
 			            return true;
 			        }
 			        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
 			        
 			        if(Integer.toString(EtudiantTable.getMatricule()).toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getYearString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getGraDecimal().toString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getSection().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getGroupe().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }
 			      return false;
 			    });
 			});
 			
 			SortedList<EtudiantTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
 			
 			sortedDaTables.comparatorProperty().bind(EtudiantT.comparatorProperty());
 			
 			
 			EtudiantT.setItems(sortedDaTables);
 			}} catch (SQLException x) {
 			// TODO Auto-generated catch block
 			x.printStackTrace();
 		}
 		
 		
 		
 		
 	
 	
 	
 	
 	
 	
 	
 	
 	
     	 
  		 etudianrAnchor.toFront();
     	 
     	 
     	
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }
     
     
     
     public void ajouterA(ActionEvent e) throws SQLException {
    	 
    	 
    	 try(Connection connection = ConnectionDB.getConnection()) {
    			UtilisateurController utilisateurController=new UtilisateurController(connection);
    		    ProfController profController=new ProfController(connection);
    		    int id=Integer.parseInt(MatriculeTextfield221.getText());
    		   
  				   
  				  Admin admin=new Admin(id,NameTextfield221.getText(),SurnameTextfield221.getText(),GmailTextfield221.getText());
  		           Utilisateur utilisateur=new Utilisateur(id,NameTextfield221.getText(),SurnameTextfield221.getText(),GmailTextfield221.getText(),PasswordTextfield221.getText(),Role.Prof);
  		           
  		           
  		         
  	  			   String sql = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?, ?)";
  	  		        
  	  		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
  	  		            statement.setInt(1, utilisateur.getIdUser());
  	  		            statement.setString(2, utilisateur.getNom());
  	  		            statement.setString(3, utilisateur.getPrenom());
  	  		            statement.setString(4, utilisateur.getEmail());
  	  		            statement.setString(5, utilisateur.getMotdepasse());
  	  		            statement.setString(6, utilisateur.getRole().toString());
  	  		            
  	  		            int rowsAffected = statement.executeUpdate();
  	  		        }
  		           
  		           
  		           
  		           
  		           
  		           
  		           
  		        
				String query = "INSERT INTO admins (idAdmin, idUser) VALUES (?, ?)";
		        
		        try (PreparedStatement stmt = connection.prepareStatement(query)) {
		            stmt.setInt(1, admin.getIdAdmin());
		            stmt.setInt(2,utilisateur.getIdUser());
		            
		            int rowsAffected = stmt.executeUpdate();
  		   }}
    		    
    	   adminList.clear();

    				try(Connection connection1 = ConnectionDB.getConnection()) {
    					AdminController adminController1=new AdminController(connection1);
    					UtilisateurController utilisateurController1= new UtilisateurController(connection1);
    					List<Utilisateur> utilisateurs=utilisateurController1.getTousLesUtilisateurs();
    					
    					
    					for(int j=0;j<utilisateurs.size();j++) {
    						Utilisateur utilisateur=utilisateurs.get(j);
    						int number=utilisateur.getIdUser();
    					
    						if(adminController1.getAdminByMat(number) != null) {
    							Admin admin1=adminController1.getAdminByMat(utilisateur.getIdUser());
    							admin1.setMotdepasse(utilisateur.getMotdepasse());
    							adminList.add(admin1);
    					
    							
    						}
    						
    						
    						
    						
    						
    					}
    					
    				
    					
    						MatriculeT11.setCellValueFactory(new PropertyValueFactory("idAdmin"));
    						NameT11.setCellValueFactory(new PropertyValueFactory("nom"));
    						SurnameT11.setCellValueFactory(new PropertyValueFactory("prenom"));
    						GmailT11.setCellValueFactory(new PropertyValueFactory("email"));
    						PasswordT11.setCellValueFactory(new PropertyValueFactory("motdepasse"));

    						EtudiantT11.setItems(adminList);
    					FilteredList<Admin> filterDataEtudiantTables=new FilteredList(adminList,b -> true);
    					SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
    					    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
    					        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
    					            return true;
    					        }
    					        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
    					        
    					        if(Integer.toString(EtudiantTable.getIdAdmin()).toLowerCase().indexOf(searchKeyword)>-1) {
    					        	return true;
    					        }else if(EtudiantTable.getNom().toLowerCase().indexOf(searchKeyword)>-1) {
    					        	return true;
    					        }else if(EtudiantTable.getPrenom().toLowerCase().indexOf(searchKeyword)>-1) {
    					        	return true;
    					       
    					        }else if(EtudiantTable.getEmail().toLowerCase().indexOf(searchKeyword)>-1) {
    					        	return true;
    					        }else if(EtudiantTable.getMotdepasse().toLowerCase().indexOf(searchKeyword)>-1) {
    					        	return true;
    					      
    					      
    					        }
    					      return false;
    					    });
    					});
    					
    					SortedList<Admin> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
    					
    					sortedDaTables.comparatorProperty().bind(EtudiantT11.comparatorProperty());
    					EtudiantT11.setItems(sortedDaTables);
    					} catch (SQLException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    				AdminAnchor.toFront();
    		   
    		  
    		   
    		}
    		
    		
    		
    		
    	 
    	 
    	 
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     public void ajouterP(ActionEvent e) {
    	 
    	 try(Connection connection = ConnectionDB.getConnection()) {
   			UtilisateurController utilisateurController=new UtilisateurController(connection);
   		    ProfController profController=new ProfController(connection);
   		    int id=Integer.parseInt(MatriculeTextfield21.getText());
   		    SpecialiteController specialiteController= new SpecialiteController(connection);
   		  List<Specialite> specialites= specialiteController.getToutesLesSpecialites();
 		   AuthController authController=new AuthController(connection);
 		   for(int i=0; i<specialites.size();i++) {
 			   Specialite specialite=specialites.get(i);
 			   if(SpecialityTextfield21.getText().equalsIgnoreCase(specialite.getNomSpecialite())) {
 				   
 				   int idS= specialite.getIdSpecialite();
 		            Prof prof=new Prof(id,NameTextfield21.getText(),SurnameTextfield21.getText(),GmailTextfield21.getText(),idS,MoyenneTextfield21.getText(),SectionTextfield21.getText());
 		           Utilisateur utilisateur=new Utilisateur(id,NameTextfield21.getText(),SurnameTextfield21.getText(),GmailTextfield21.getText(),PasswordTextfield21.getText(),Role.Prof);
 		          
 	  			   String sql = "INSERT INTO utilisateurs (idUser, nom, prenom, email, motdepasse, role) VALUES (?, ?, ?, ?, ?, ?)";
 	  		        
 	  		        try (PreparedStatement statement = connection.prepareStatement(sql)) {
 	  		            statement.setInt(1, utilisateur.getIdUser());
 	  		            statement.setString(2, utilisateur.getNom());
 	  		            statement.setString(3, utilisateur.getPrenom());
 	  		            statement.setString(4, utilisateur.getEmail());
 	  		            statement.setString(5, utilisateur.getMotdepasse());
 	  		            statement.setString(6, utilisateur.getRole().toString());
 	  		            
 	  		            int rowsAffected = statement.executeUpdate();
 	  		        }
 		          String query = "INSERT INTO profs (idProf, idUser, idSpecialite, grade, departement) VALUES (?, ?, ?, ?, ?)";
 		         
 		         try (PreparedStatement stmt = connection.prepareStatement(query)) {
 		             stmt.setInt(1, prof.getIdProf());
 		             stmt.setInt(2, prof.getIdUser());
 		             stmt.setInt(3, prof.getIdSpecialite());
 		             stmt.setString(4, prof.getGrade());
 		             stmt.setString(5, prof.getDepartement());
 		             
 		             int rowsAffected = stmt.executeUpdate(); 			   }
   		    
 		   }
   		    
   		
   			
 		
 			teacherList.clear();

 		
 				
 				List<Utilisateur> utilisateurs=utilisateurController.getTousLesUtilisateurs();
 				List<ProfTable> Profs=  new ArrayList();
 				
 				
 				for(int j=0;j<utilisateurs.size();j++) {
 					Utilisateur utilisateur=utilisateurs.get(j);
 					int number=utilisateur.getIdUser();
 				
 					if(profController.getProfByMat(number) != null) {
 						Prof prof=profController.getProfByMat(utilisateur.getIdUser());
 						Specialite specialite1= specialiteController.getSpecialiteParId(prof.getIdSpecialite());
 						ProfTable profTable=new ProfTable(prof.getIdProf(),prof.getNom(),prof.getPrenom(),specialite1.getNomSpecialite(),prof.getGrade(),prof.getEmail(),utilisateur.getMotdepasse(),prof.getDepartement());
 						teacherList.add(profTable);
 				
 						
 					
 					
 					
 					
 					
 					
 				}
 				
 			
 				
 					MatriculeT1.setCellValueFactory(new PropertyValueFactory("idprof"));
 					NameT1.setCellValueFactory(new PropertyValueFactory("nameString"));
 					SurnameT1.setCellValueFactory(new PropertyValueFactory("surnameString"));
 					SpecialityT1.setCellValueFactory(new PropertyValueFactory("specialityString"));
 					GradeT1.setCellValueFactory(new PropertyValueFactory("grade"));
 					GmailT1.setCellValueFactory(new PropertyValueFactory("gmailString"));
 					PasswordT1.setCellValueFactory(new PropertyValueFactory("passwordString"));
 					SectionT1.setCellValueFactory(new PropertyValueFactory("departement"));

 					EtudiantT1.setItems(teacherList);
 				FilteredList<ProfTable> filterDataEtudiantTables=new FilteredList(teacherList,b -> true);
 				SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
 				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
 				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
 				            return true;
 				        }
 				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
 				        
 				        if(Integer.toString(EtudiantTable.getIdprof()).toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getGrade().toString().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				        }else if(EtudiantTable.getDepartement().toLowerCase().indexOf(searchKeyword)>-1) {
 				        	return true;
 				      
 				        }
 				      return false;
 				    });
 				});
 				
 				SortedList<ProfTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
 				
 				sortedDaTables.comparatorProperty().bind(EtudiantT1.comparatorProperty());
 				EtudiantT1.setItems(sortedDaTables);
 				
 			}
 			
 			
 			
 			
 				   TeachersAnchor.toFront();
   			
   			
   			
   			
   			
   			
   			
 		   }} catch (SQLException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
   		
    	 
    	 
    	 
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     public void deletE(ActionEvent e) throws SQLException {
    	 
  		try(Connection connection = ConnectionDB.getConnection()) {
  			EtudiantController etudiantController=new EtudiantController(connection);
  			UtilisateurController utilisateurController= new UtilisateurController(connection);
  			int id=Integer.parseInt(MatriculeTextfield.getText());
  			etudiantController.supprimerEtudiant(id);
  			utilisateurController.supprimerUtilisateur(id);
  			etudiantssList.clear();
  	 		try(Connection connection1 = ConnectionDB.getConnection()) {
  				EtudiantController etudiantController1=new EtudiantController(connection1);
  				SpecialiteController specialiteController= new SpecialiteController(connection1);
  				List<Etudiant> etudiants= etudiantController1.getAllEtudiants();
  				
  				for(int i=0;i<etudiants.size();i++) {
  					
  					
  					
  					
  					Etudiant etudiant=etudiants.get(i);
  					AnneeController anneeC=new AnneeController(connection1);
  					List<Annee> annees=	anneeC.getAnneesByEtudiantId(etudiant.getIdEtudiant());
  					String yearRange = previousYear + "-" + currentYear;
  					Specialite speString=specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
  					
  					for (int ii = 0; ii < annees.size(); ii++) {
  						Annee annee=annees.get(ii);
  						if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
  							 curAnnee=annee;
  						}
  						
  						EtudiantTable etudiantTable=new EtudiantTable(etudiant.getIdEtudiant(),etudiant.getNom(),etudiant.getPrenom(),speString.getNomSpecialite(),yearRange,curAnnee.getmoyenneGenerale(),etudiant.getEmail(),etudiant.getMotdepasse(),etudiant.getSection(),etudiant.getGroupe());
  						
  						etudiantssList.add(etudiantTable);
  					
  					
  					
  				}
  				
  					MatriculeT.setCellValueFactory(new PropertyValueFactory("Matricule"));
  					NameT.setCellValueFactory(new PropertyValueFactory("nameString"));
  					SurnameT.setCellValueFactory(new PropertyValueFactory("surnameString"));
  					SpecialityT.setCellValueFactory(new PropertyValueFactory("specialityString"));
  					YearT.setCellValueFactory(new PropertyValueFactory("yearString"));
  					GradeT.setCellValueFactory(new PropertyValueFactory("graDecimal"));
  					GmailT.setCellValueFactory(new PropertyValueFactory("gmailString"));
  					PasswordT.setCellValueFactory(new PropertyValueFactory("passwordString"));
  					SectionT.setCellValueFactory(new PropertyValueFactory("Section"));
  					groupeT.setCellValueFactory(new PropertyValueFactory("Groupe"));

  					EtudiantT.setItems(etudiantssList);
  				FilteredList<EtudiantTable> filterDataEtudiantTables=new FilteredList(etudiantssList,b -> true);
  				SearchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
  				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
  				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
  				            return true;
  				        }
  				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
  				        
  				        if(Integer.toString(EtudiantTable.getMatricule()).toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getYearString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getGraDecimal().toString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getSection().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }else if(EtudiantTable.getGroupe().toLowerCase().indexOf(searchKeyword)>-1) {
  				        	return true;
  				        }
  				      return false;
  				    });
  				});
  				
  				SortedList<EtudiantTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
  				
  				sortedDaTables.comparatorProperty().bind(EtudiantT.comparatorProperty());
  				
  				
  				EtudiantT.setItems(sortedDaTables);
  				}} catch (SQLException x) {
  				// TODO Auto-generated catch block
  				x.printStackTrace();
  			}
  			
  			
  			
  			
  		
  		
  		
  		
  		
  		
  		
  		
  		
  	    	 
  	 		 etudianrAnchor.toFront();
  	    	 
  	    	 
  	    	 
  			
  			
  			
  		}

  			
    	 
    	 
    	 
    	 
     }
     public void deletP(ActionEvent e) throws SQLException {
   		try(Connection connection = ConnectionDB.getConnection()) {
   			ProfController profController=new ProfController(connection);
   			UtilisateurController utilisateurController=new UtilisateurController(connection);
   			SpecialiteController specialiteController=new SpecialiteController(connection);
  			int id=Integer.parseInt(MatriculeTextfield2.getText());
  			profController.supprimerProf(id);
  			utilisateurController.supprimerUtilisateur(id);

  			teacherList.clear();

  			
			
			List<Utilisateur> utilisateurs=utilisateurController.getTousLesUtilisateurs();
			List<ProfTable> Profs=  new ArrayList();
			
			
			for(int j=0;j<utilisateurs.size();j++) {
				Utilisateur utilisateur=utilisateurs.get(j);
				int number=utilisateur.getIdUser();
			
				if(profController.getProfByMat(number) != null) {
					Prof prof=profController.getProfByMat(utilisateur.getIdUser());
					Specialite specialite= specialiteController.getSpecialiteParId(prof.getIdSpecialite());
					ProfTable profTable=new ProfTable(prof.getIdProf(),prof.getNom(),prof.getPrenom(),specialite.getNomSpecialite(),prof.getGrade(),prof.getEmail(),utilisateur.getMotdepasse(),prof.getDepartement());
					teacherList.add(profTable);
			
					
				
				
				
				
				
				
			}
			
		
			
				MatriculeT1.setCellValueFactory(new PropertyValueFactory("idprof"));
				NameT1.setCellValueFactory(new PropertyValueFactory("nameString"));
				SurnameT1.setCellValueFactory(new PropertyValueFactory("surnameString"));
				SpecialityT1.setCellValueFactory(new PropertyValueFactory("specialityString"));
				GradeT1.setCellValueFactory(new PropertyValueFactory("grade"));
				GmailT1.setCellValueFactory(new PropertyValueFactory("gmailString"));
				PasswordT1.setCellValueFactory(new PropertyValueFactory("passwordString"));
				SectionT1.setCellValueFactory(new PropertyValueFactory("departement"));

				EtudiantT1.setItems(teacherList);
			FilteredList<ProfTable> filterDataEtudiantTables=new FilteredList(teacherList,b -> true);
			SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
			    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
			        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
			            return true;
			        }
			        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
			        
			        if(Integer.toString(EtudiantTable.getIdprof()).toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGrade().toString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getDepartement().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			      
			        }
			      return false;
			    });
			});
			
			SortedList<ProfTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
			
			sortedDaTables.comparatorProperty().bind(EtudiantT1.comparatorProperty());
			EtudiantT1.setItems(sortedDaTables);
			
		}
		
		
		
		
			   TeachersAnchor.toFront();
			
			
			
			
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
   			
   			
   		}

   			
    	 
    	 
    	 
    	 
    	 
    	 
     
     
     public void updateE(ActionEvent e) {
 
 		try(Connection connection = ConnectionDB.getConnection()) {
 			UtilisateurController utilisateurController=new UtilisateurController(connection);
 			EtudiantController etudiantController=new EtudiantController(connection);
 			SpecialiteController specialiteController=new SpecialiteController(connection);
 			AnneeController anneeController=new AnneeController(connection);
 			BigDecimal value = new BigDecimal(MoyenneTextfield.getText());
 
 			
 			try {
				String yearRange = previousYear + "-" + currentYear;
 			    int id = Integer.parseInt(MatriculeTextfield.getText());
 			    ArrayList<Annee>anneess=new ArrayList<>(anneeController.getAnneesByEtudiantId(id));
 			   for (int ii = 0; ii < anneess.size(); ii++) {
					Annee annee=anneess.get(ii);
					if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
						 curAnnee=annee;
					}
 			   }
 			   curAnnee.setMoyGeneral(value);
 			   anneeController.modifierAnnee(curAnnee);
 			    ArrayList<Annee>annees=new ArrayList<>(anneeController.getAnneesByEtudiantId(id));

 			   Utilisateur utilisateur=new Utilisateur(id,NameTextfield.getText(),SurnameTextfield.getText(),GmailTextfield.getText(),PasswordTextfield.getText(),Role.Etudiant);
 			   utilisateurController.modifierUtilisateur(utilisateur);
 			   List<Specialite> specialites= specialiteController.getToutesLesSpecialites();
 			   
 			   for(int i=0; i<specialites.size();i++) {
 				   Specialite specialite=specialites.get(i);
 				   if(SpecialityTextfield.getText().equalsIgnoreCase(specialite.getNomSpecialite())) {
 					   
 					   int idS= specialite.getIdSpecialite();
 		 			   Etudiant etudiant=new Etudiant(id,NameTextfield.getText(),SurnameTextfield.getText(),GmailTextfield.getText(),PasswordTextfield.getText(),idS,SectionTextfield.getText(),GroupeTextfield.getText(),null,annees);
                       etudiantController.modifierEtudiant(etudiant);
 					   
 				   }
 				   
 				   
 			   }
 			   
 			   
 			   
 			} catch (NumberFormatException ee) {
 			    System.out.println("Invalid number input");
 			}
 		
 			
 		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		etudiantssList.clear();
 		try(Connection connection = ConnectionDB.getConnection()) {
			EtudiantController etudiantController=new EtudiantController(connection);
			SpecialiteController specialiteController= new SpecialiteController(connection);
			List<Etudiant> etudiants= etudiantController.getAllEtudiants();
			
			for(int i=0;i<etudiants.size();i++) {
				
				
				
				
				Etudiant etudiant=etudiants.get(i);
				AnneeController anneeC=new AnneeController(connection);
				List<Annee> annees=	anneeC.getAnneesByEtudiantId(etudiant.getIdEtudiant());
				String yearRange = previousYear + "-" + currentYear;
				Specialite speString=specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
				
				for (int ii = 0; ii < annees.size(); ii++) {
					Annee annee=annees.get(ii);
					if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
						 curAnnee=annee;
					}
					
					EtudiantTable etudiantTable=new EtudiantTable(etudiant.getIdEtudiant(),etudiant.getNom(),etudiant.getPrenom(),speString.getNomSpecialite(),yearRange,curAnnee.getmoyenneGenerale(),etudiant.getEmail(),etudiant.getMotdepasse(),etudiant.getSection(),etudiant.getGroupe());
					
					etudiantssList.add(etudiantTable);
				
				
				
			}
			
				MatriculeT.setCellValueFactory(new PropertyValueFactory("Matricule"));
				NameT.setCellValueFactory(new PropertyValueFactory("nameString"));
				SurnameT.setCellValueFactory(new PropertyValueFactory("surnameString"));
				SpecialityT.setCellValueFactory(new PropertyValueFactory("specialityString"));
				YearT.setCellValueFactory(new PropertyValueFactory("yearString"));
				GradeT.setCellValueFactory(new PropertyValueFactory("graDecimal"));
				GmailT.setCellValueFactory(new PropertyValueFactory("gmailString"));
				PasswordT.setCellValueFactory(new PropertyValueFactory("passwordString"));
				SectionT.setCellValueFactory(new PropertyValueFactory("Section"));
				groupeT.setCellValueFactory(new PropertyValueFactory("Groupe"));

				EtudiantT.setItems(etudiantssList);
			FilteredList<EtudiantTable> filterDataEtudiantTables=new FilteredList(etudiantssList,b -> true);
			SearchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
			    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
			        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
			            return true;
			        }
			        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
			        
			        if(Integer.toString(EtudiantTable.getMatricule()).toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getYearString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGraDecimal().toString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSection().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGroupe().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }
			      return false;
			    });
			});
			
			SortedList<EtudiantTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
			
			sortedDaTables.comparatorProperty().bind(EtudiantT.comparatorProperty());
			
			
			EtudiantT.setItems(sortedDaTables);
			}} catch (SQLException x) {
			// TODO Auto-generated catch block
			x.printStackTrace();
		}
		
		
		
		
	
	
	
	
	
	
	
	
	
    	 
 		 etudianrAnchor.toFront();
    	 
    	 
    	 
     }
     
     public void updateP(ActionEvent e) {
    	 
  		try(Connection connection = ConnectionDB.getConnection()) {
  			UtilisateurController utilisateurController=new UtilisateurController(connection);
  		    ProfController profController=new ProfController(connection);
  		    int id=Integer.parseInt(MatriculeTextfield2.getText());
  		    SpecialiteController specialiteController= new SpecialiteController(connection);
  		  List<Specialite> specialites= specialiteController.getToutesLesSpecialites();
		   
		   for(int i=0; i<specialites.size();i++) {
			   Specialite specialite=specialites.get(i);
			   if(SpecialityTextfield2.getText().equalsIgnoreCase(specialite.getNomSpecialite())) {
				   
				   int idS= specialite.getIdSpecialite();
		            Prof prof=new Prof(id,NameTextfield2.getText(),SurnameTextfield2.getText(),GmailTextfield2.getText(),PasswordTextfield2.getText(),idS,MoyenneTextfield2.getText(),SectionTextfield2.getText());
		            Utilisateur utilisateur= utilisateurController.getUtilisateurByMat(id);
					
					utilisateur.setEmail(GmailTextfield2.getText());
					utilisateur.setMotdepasse(PasswordTextfield2.getText());
					utilisateur.setNom(NameTextfield2.getText());
					utilisateur.setPrenom(SurnameTextfield2.getText());
				   String query = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, motdepasse = ?, role = ? WHERE idUser = ?";
			        
			        try (PreparedStatement stmt = connection.prepareStatement(query)) {
			            stmt.setString(1, utilisateur.getNom());
			            stmt.setString(2, utilisateur.getPrenom());
			            stmt.setString(3, utilisateur.getEmail());
			            stmt.setString(4, utilisateur.getMotdepasse());
			            stmt.setString(5, utilisateur.getRole().name());
			            stmt.setInt(6, utilisateur.getIdUser());
			            
			            int rowsAffected = stmt.executeUpdate();
			        }
  		    profController.modifierProf(prof);
			   }
  		    
		   }
  		    
  		
  			
		
			teacherList.clear();

		
				
				List<Utilisateur> utilisateurs=utilisateurController.getTousLesUtilisateurs();
				List<ProfTable> Profs=  new ArrayList();
				
				
				for(int j=0;j<utilisateurs.size();j++) {
					Utilisateur utilisateur=utilisateurs.get(j);
					int number=utilisateur.getIdUser();
				
					if(profController.getProfByMat(number) != null) {
						Prof prof=profController.getProfByMat(utilisateur.getIdUser());
						Specialite specialite= specialiteController.getSpecialiteParId(prof.getIdSpecialite());
						ProfTable profTable=new ProfTable(prof.getIdProf(),prof.getNom(),prof.getPrenom(),specialite.getNomSpecialite(),prof.getGrade(),prof.getEmail(),utilisateur.getMotdepasse(),prof.getDepartement());
						teacherList.add(profTable);
				
						
					
					
					
					
					
					
				}
				
			
				
					MatriculeT1.setCellValueFactory(new PropertyValueFactory("idprof"));
					NameT1.setCellValueFactory(new PropertyValueFactory("nameString"));
					SurnameT1.setCellValueFactory(new PropertyValueFactory("surnameString"));
					SpecialityT1.setCellValueFactory(new PropertyValueFactory("specialityString"));
					GradeT1.setCellValueFactory(new PropertyValueFactory("grade"));
					GmailT1.setCellValueFactory(new PropertyValueFactory("gmailString"));
					PasswordT1.setCellValueFactory(new PropertyValueFactory("passwordString"));
					SectionT1.setCellValueFactory(new PropertyValueFactory("departement"));

					EtudiantT1.setItems(teacherList);
				FilteredList<ProfTable> filterDataEtudiantTables=new FilteredList(teacherList,b -> true);
				SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
				            return true;
				        }
				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
				        
				        if(Integer.toString(EtudiantTable.getIdprof()).toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getGrade().toString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getDepartement().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				      
				        }
				      return false;
				    });
				});
				
				SortedList<ProfTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
				
				sortedDaTables.comparatorProperty().bind(EtudiantT1.comparatorProperty());
				EtudiantT1.setItems(sortedDaTables);
				
			}
			
			
			
			
				   TeachersAnchor.toFront();
  			
  			
  			
  			
  			
  			
  			
  		} catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			e1.printStackTrace();
 		}
  		
     	 
      }
     
     
	
	public void handleP(ActionEvent e) {
		
		if(e.getSource()==StudentsBT) {
			etudianrAnchor.toFront();
			
			
			
		}
		if(e.getSource()==TeachersBT) {
			TeachersAnchor.toFront();
			teacherList.clear();

			try(Connection connection = ConnectionDB.getConnection()) {
				ProfController profController=new ProfController(connection);
				SpecialiteController specialiteController= new SpecialiteController(connection);
				UtilisateurController utilisateurController= new UtilisateurController(connection);
				List<Utilisateur> utilisateurs=utilisateurController.getTousLesUtilisateurs();
				List<ProfTable> Profs=  new ArrayList();
				
				
				for(int j=0;j<utilisateurs.size();j++) {
					Utilisateur utilisateur=utilisateurs.get(j);
					int number=utilisateur.getIdUser();
				
					if(profController.getProfByMat(number) != null) {
						Prof prof=profController.getProfByMat(utilisateur.getIdUser());
						Specialite specialite= specialiteController.getSpecialiteParId(prof.getIdSpecialite());
						ProfTable profTable=new ProfTable(prof.getIdProf(),prof.getNom(),prof.getPrenom(),specialite.getNomSpecialite(),prof.getGrade(),prof.getEmail(),utilisateur.getMotdepasse(),prof.getDepartement());
						teacherList.add(profTable);
				
						
					}
					
					
					
					
					
				}
				
			
				
					MatriculeT1.setCellValueFactory(new PropertyValueFactory("idprof"));
					NameT1.setCellValueFactory(new PropertyValueFactory("nameString"));
					SurnameT1.setCellValueFactory(new PropertyValueFactory("surnameString"));
					SpecialityT1.setCellValueFactory(new PropertyValueFactory("specialityString"));
					GradeT1.setCellValueFactory(new PropertyValueFactory("grade"));
					GmailT1.setCellValueFactory(new PropertyValueFactory("gmailString"));
					PasswordT1.setCellValueFactory(new PropertyValueFactory("passwordString"));
					SectionT1.setCellValueFactory(new PropertyValueFactory("departement"));

					EtudiantT1.setItems(teacherList);
				FilteredList<ProfTable> filterDataEtudiantTables=new FilteredList(teacherList,b -> true);
				SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
				            return true;
				        }
				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
				        
				        if(Integer.toString(EtudiantTable.getIdprof()).toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getGrade().toString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getDepartement().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				      
				        }
				      return false;
				    });
				});
				
				SortedList<ProfTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
				
				sortedDaTables.comparatorProperty().bind(EtudiantT1.comparatorProperty());
				EtudiantT1.setItems(sortedDaTables);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			

			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		if(e.getSource()==AdminsBT) {
			AdminAnchor.toFront();
			adminList.clear();

			try(Connection connection = ConnectionDB.getConnection()) {
				AdminController adminController=new AdminController(connection);
				SpecialiteController specialiteController= new SpecialiteController(connection);
				UtilisateurController utilisateurController= new UtilisateurController(connection);
				List<Utilisateur> utilisateurs=utilisateurController.getTousLesUtilisateurs();
				
				
				for(int j=0;j<utilisateurs.size();j++) {
					Utilisateur utilisateur=utilisateurs.get(j);
					int number=utilisateur.getIdUser();
				
					if(adminController.getAdminByMat(number) != null) {
						Admin admin=adminController.getAdminByMat(utilisateur.getIdUser());
						admin.setMotdepasse(utilisateur.getMotdepasse());
						adminList.add(admin);
				
						
					}
					
					
					
					
					
				}
				
			
				
					MatriculeT11.setCellValueFactory(new PropertyValueFactory("idAdmin"));
					NameT11.setCellValueFactory(new PropertyValueFactory("nom"));
					SurnameT11.setCellValueFactory(new PropertyValueFactory("prenom"));
					GmailT11.setCellValueFactory(new PropertyValueFactory("email"));
					PasswordT11.setCellValueFactory(new PropertyValueFactory("motdepasse"));

					EtudiantT11.setItems(adminList);
				FilteredList<Admin> filterDataEtudiantTables=new FilteredList(adminList,b -> true);
				SearchTextfield1.textProperty().addListener((observable, oldValue, newValue) -> {
				    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
				        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
				            return true;
				        }
				        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
				        
				        if(Integer.toString(EtudiantTable.getIdAdmin()).toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getNom().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getPrenom().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				       
				        }else if(EtudiantTable.getEmail().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				        }else if(EtudiantTable.getMotdepasse().toLowerCase().indexOf(searchKeyword)>-1) {
				        	return true;
				      
				      
				        }
				      return false;
				    });
				});
				
				SortedList<Admin> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
				
				sortedDaTables.comparatorProperty().bind(EtudiantT11.comparatorProperty());
				EtudiantT11.setItems(sortedDaTables);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	etudianrAnchor.toFront();
		try(Connection connection = ConnectionDB.getConnection()) {
			EtudiantController etudiantController=new EtudiantController(connection);
			SpecialiteController specialiteController= new SpecialiteController(connection);
			List<Etudiant> etudiants= etudiantController.getAllEtudiants();
			
			for(int i=0;i<etudiants.size();i++) {
				
				
				
				
				Etudiant etudiant=etudiants.get(i);
				AnneeController anneeC=new AnneeController(connection);
				List<Annee> annees=	anneeC.getAnneesByEtudiantId(etudiant.getIdEtudiant());
				String yearRange = previousYear + "-" + currentYear;
				Specialite speString=specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
				
				for (int ii = 0; ii < annees.size(); ii++) {
					Annee annee=annees.get(ii);
					if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
						 curAnnee=annee;
					}
					
					EtudiantTable etudiantTable=new EtudiantTable(etudiant.getIdEtudiant(),etudiant.getNom(),etudiant.getPrenom(),speString.getNomSpecialite(),yearRange,curAnnee.getmoyenneGenerale(),etudiant.getEmail(),etudiant.getMotdepasse(),etudiant.getSection(),etudiant.getGroupe());
					
					etudiantssList.add(etudiantTable);
				
				
				
			}
			
				MatriculeT.setCellValueFactory(new PropertyValueFactory("Matricule"));
				NameT.setCellValueFactory(new PropertyValueFactory("nameString"));
				SurnameT.setCellValueFactory(new PropertyValueFactory("surnameString"));
				SpecialityT.setCellValueFactory(new PropertyValueFactory("specialityString"));
				YearT.setCellValueFactory(new PropertyValueFactory("yearString"));
				GradeT.setCellValueFactory(new PropertyValueFactory("graDecimal"));
				GmailT.setCellValueFactory(new PropertyValueFactory("gmailString"));
				PasswordT.setCellValueFactory(new PropertyValueFactory("passwordString"));
				SectionT.setCellValueFactory(new PropertyValueFactory("Section"));
				groupeT.setCellValueFactory(new PropertyValueFactory("Groupe"));

				EtudiantT.setItems(etudiantssList);
			FilteredList<EtudiantTable> filterDataEtudiantTables=new FilteredList(etudiantssList,b -> true);
			SearchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
			    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
			        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
			            return true;
			        }
			        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
			        
			        if(Integer.toString(EtudiantTable.getMatricule()).toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getYearString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGraDecimal().toString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGmailString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getPasswordString().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getSection().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }else if(EtudiantTable.getGroupe().toLowerCase().indexOf(searchKeyword)>-1) {
			        	return true;
			        }
			      return false;
			    });
			});
			
			SortedList<EtudiantTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
			
			sortedDaTables.comparatorProperty().bind(EtudiantT.comparatorProperty());
			EtudiantT.setItems(sortedDaTables);
			}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
	















}
