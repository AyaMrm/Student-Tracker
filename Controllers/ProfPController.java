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
import java.time.LocalTime;
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
import Model.EtudiantNoteTable;
import Model.EtudiantTable;
import Model.Module;
import Model.Note;
import Model.NumeroSemestre;
import Model.Prof;
import Model.ProfTable;
import Model.Role;
import Model.Seance;
import Model.Semestre;
import Model.Specialite;
import Model.SpecialiteDAO;
import Model.Utilisateur;
import javafx.scene.layout.AnchorPane;
import Model.EtudiantDAO;

public class ProfPController implements Initializable {
	  @FXML
	    private Button CoursesBT;
	  @FXML
	    private Button 	deconexionprof;
	  
	  
	    @FXML
	    private Button Module1;
	    @FXML
	    private Button Module2;
	    @FXML
	    private Button NoteBT;
	  @FXML
	    private Button TimeBT;
	    @FXML
	    private Button GradesBT;

	    @FXML
	    private Button TimetabBT;
	    @FXML
	    private Button backBT12;
	    @FXML
	    private Button updateBT21;
	    
	    @FXML
	    private Button TranscriptBT;

	    @FXML
	    private Label class11;

	    @FXML
	    private Label class12;

	    @FXML
	    private Label class13;

	    @FXML
	    private Label class14;

	    @FXML
	    private Label class15;

	    @FXML
	    private Label class16;

	    @FXML
	    private Label class21;

	    @FXML
	    private Label class22;

	    @FXML
	    private Label class23;

	    @FXML
	    private Label class24;

	    @FXML
	    private Label class25;

	    @FXML
	    private Label class26;

	    @FXML
	    private Label class31;

	    @FXML
	    private Label class32;

	    @FXML
	    private Label class33;

	    @FXML
	    private Label class34;

	    @FXML
	    private Label class35;

	    @FXML
	    private Label class36;

	    @FXML
	    private Label class41;

	    @FXML
	    private Label class42;

	    @FXML
	    private Label class43;

	    @FXML
	    private Label class44;

	    @FXML
	    private Label class45;

	    @FXML
	    private Label class46;

	    @FXML
	    private Label class51;

	    @FXML
	    private Label class52;

	    @FXML
	    private Label class53;

	    @FXML
	    private Label class54;

	    @FXML
	    private Label class55;

	    @FXML
	    private Label class56;

	    @FXML
	    private Label class61;

	    @FXML
	    private Label class62;

	    @FXML
	    private Label class63;

	    @FXML
	    private Label class64;

	    @FXML
	    private Label class65;

	    @FXML
	    private Label class66;

	    @FXML
	    private Label class71;

	    @FXML
	    private Label class72;

	    @FXML
	    private Label class73;

	    @FXML
	    private Label class74;

	    @FXML
	    private Label class75;

	    @FXML
	    private Label class76;

	    @FXML
	    private Label corses11;

	    @FXML
	    private Label corses12;

	    @FXML
	    private Label corses13;

	    @FXML
	    private Label corses14;

	    @FXML
	    private Label corses15;

	    @FXML
	    private Label corses16;

	    @FXML
	    private Label corses21;

	    @FXML
	    private Label corses22;

	    @FXML
	    private Label corses23;

	    @FXML
	    private Label corses24;

	    @FXML
	    private Label corses25;

	    @FXML
	    private Label corses26;

	    @FXML
	    private Label corses31;

	    @FXML
	    private Label corses32;

	    @FXML
	    private Label corses33;

	    @FXML
	    private Label corses34;

	    @FXML
	    private Label corses35;

	    @FXML
	    private Label corses36;

	    @FXML
	    private Label corses41;

	    @FXML
	    private Label corses42;

	    @FXML
	    private Label corses43;

	    @FXML
	    private Label corses44;

	    @FXML
	    private Label corses45;

	    @FXML
	    private Label corses46;

	    @FXML
	    private Label corses51;

	    @FXML
	    private Label corses52;

	    @FXML
	    private Label corses53;

	    @FXML
	    private Label corses54;

	    @FXML
	    private Label corses55;

	    @FXML
	    private Label corses56;

	    @FXML
	    private Label corses61;

	    @FXML
	    private Label corses62;

	    @FXML
	    private Label corses63;

	    @FXML
	    private Label corses64;

	    @FXML
	    private Label corses65;

	    @FXML
	    private Label corses66;

	    @FXML
	    private Label corses71;

	    @FXML
	    private Label corses72;

	    @FXML
	    private Label corses73;

	    @FXML
	    private Label corses74;

	    @FXML
	    private Label corses75;

	    @FXML
	    private Label corses76;

	    @FXML
	    private AnchorPane emploiT;
	    @FXML
	    private AnchorPane etudiantNote;
	    @FXML
	    private AnchorPane NoteU;
	    @FXML
	    private Label lbiStatus;
	    @FXML
	    TextField SearchTextfield;
	    
	    @FXML
	    private TableView<EtudiantNoteTable> EtudiantT;

	    @FXML
	    private TableColumn<EtudiantNoteTable, String> SurnameT;

	    @FXML
	    private TableColumn<EtudiantNoteTable, BigDecimal> moyenne;

	    @FXML
	    private TableColumn<EtudiantNoteTable, Integer> MatriculeT;

	    @FXML
	    private TableColumn<EtudiantNoteTable, String> NameT;

	    @FXML
	    private TableColumn<EtudiantNoteTable, BigDecimal> exam;
	    @FXML
	    private TableColumn<EtudiantNoteTable, BigDecimal> cc;
	    @FXML
	    private TableColumn<EtudiantNoteTable, String> SpecialityT;
	    @FXML
	    private TableColumn<EtudiantNoteTable, String> groupeT;

	    @FXML
	    private TableColumn<EtudiantNoteTable, String> SectionT;
	    
		ObservableList<EtudiantNoteTable> etudiantssList=FXCollections.observableArrayList();
		
		
		
		
		
		
		
		 public void backProf(ActionEvent e) {
			 
			 etudiantNote.toFront();
			  
			 
		 }
		
		
		
		
		
		
		

	    public void affecheretud1(ActionEvent e) throws SQLException {
	    	 etudiantssList.clear();

	    	 etudiantNote.toFront();
				try(Connection connection = ConnectionDB.getConnection()) {
					int idP=Integer.parseInt(userString);

		            ProfModuleController profModuleController=new ProfModuleController(connection);
		            List<Integer> moduleProfIntegers=  profModuleController.getModulesParProf(idP);
		            EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
		            List<Integer> etuIntegers1=new ArrayList();
		            List<Integer> etuIntegers2=new ArrayList();

		            List<Integer> etuIntegers3=new ArrayList();
		            int modid=moduleProfIntegers.get(0);
		            etuIntegers1=etudiantModuleController.getEtudiantsParModule(modid);
		            
		            
		            for(int j=0;j<etuIntegers1.size();j++) {
	            		int idE= etuIntegers1.get(j);
	            		EtudiantController etudiantController=new EtudiantController(connection);
	            		UtilisateurController utilisateurController= new UtilisateurController(connection);
	            		Etudiant etudiant=etudiantController.getEtudiantById(idE);
	            		Utilisateur utilisateur=utilisateurController.getUtilisateurByMat(idE);

	                    List<Note> notes = new ArrayList<>();
	                    String sql = "SELECT * FROM notes WHERE idEtudiant = ? AND idModule = ?";

	                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                        statement.setInt(1, idE);
	                        statement.setInt(2, moduleProfIntegers.get(0));

	                        try (ResultSet resultSet = statement.executeQuery()) {
	                            while (resultSet.next()) {
	                                Note note = new Note();
	                                note.setIdNote(resultSet.getInt("idNote"));
	                                note.setCoefficient(resultSet.getInt("coefficient"));
	                                note.setCc(resultSet.getBigDecimal("cc"));
	                                note.setExam(resultSet.getBigDecimal("exam"));
	                                note.setMoyenne(resultSet.getBigDecimal("moyenne"));
	                                note.setIdEtudiant(resultSet.getInt("idEtudiant"));
	                                note.setIdProf(resultSet.getInt("idProf"));
	                                note.setIdModule(resultSet.getInt("idModule"));
	                                note.setIdSemestre(resultSet.getInt("idSemestre"));

	                                notes.add(note);
	                            }
	                        }
	                    }
	            		if(notes.size()>0) {
	            			Note note=notes.get(0);
	            			SpecialiteController specialiteController=new SpecialiteController(connection);
	            			Specialite specialite= specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
	            			EtudiantNoteTable etudiantNoteTable=new EtudiantNoteTable(etudiant.getIdEtudiant(),utilisateur.getNom(),utilisateur.getPrenom(),specialite.getNomSpecialite(),etudiant.getSection(),etudiant.getGroupe(),note.getCc(),note.getExam(),note.getMoyenne());
	            			etudiantssList.add(etudiantNoteTable);
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            		}else {
	            			NoteController noteController=new NoteController(connection);
	            			int idmod=moduleProfIntegers.get(0);
	            			BigDecimal noBigDecimal=BigDecimal.ZERO;;
	            			ModuleController moduleController=new ModuleController(connection);
	            			Module module=moduleController.getModuleParId(idmod);
	            			Random randomm = new Random();
	      			        // Generates between 1000 (inclusive) and 10000 (exclusive)
	      			     int random= 1000 + randomm.nextInt(9000);
	      			     AnneeController anneeController=new AnneeController(connection);
	      			  List<Annee> annee=   anneeController.getAnneesByEtudiantId(etudiant.getIdEtudiant());
	      			     Annee annee2=annee.get(0);
	      			     SemestreController semestreController=new SemestreController(connection);
	      			     Semestre semestre=new Semestre(random,NumeroSemestre.SEMESTRE_2,noBigDecimal,annee2.getIdAnnee());
	      			     semestreController.ajouterSemestre(semestre);
	      			     int coef=module.getCoefExamen().intValue();
	      			     
                           Note note=new Note(random,coef,noBigDecimal,noBigDecimal,noBigDecimal,etudiant.getIdEtudiant(),idP,module.getIdModule(),semestre.getIdSemestre());     
                           SpecialiteController specialiteController=new SpecialiteController(connection);
	            			Specialite specialite= specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
	            			EtudiantNoteTable etudiantNoteTable=new EtudiantNoteTable(etudiant.getIdEtudiant(),utilisateur.getNom(),utilisateur.getPrenom(),specialite.getNomSpecialite(),etudiant.getSection(),etudiant.getGroupe(),note.getCc(),note.getExam(),note.getMoyenne());
	            			etudiantssList.add(etudiantNoteTable);

	            			
	            			
	            		}
	            		
	            		
	            		
	            		
	            		
	            	}
	            	
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
				}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    
	    public void affecheretud2(ActionEvent e) throws SQLException {
	    	 etudiantssList.clear();

	    	 etudiantNote.toFront();
				try(Connection connection = ConnectionDB.getConnection()) {
					int idP=Integer.parseInt(userString);

		            ProfModuleController profModuleController=new ProfModuleController(connection);
		            List<Integer> moduleProfIntegers=  profModuleController.getModulesParProf(idP);
		            EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
		            List<Integer> etuIntegers1=new ArrayList();
		            List<Integer> etuIntegers2=new ArrayList();

		            List<Integer> etuIntegers3=new ArrayList();
		            int modid=moduleProfIntegers.get(1);
		            etuIntegers1=etudiantModuleController.getEtudiantsParModule(modid);
		            
		            
		            for(int j=0;j<etuIntegers1.size();j++) {
	            		int idE= etuIntegers1.get(j);
	            		EtudiantController etudiantController=new EtudiantController(connection);
	            		UtilisateurController utilisateurController= new UtilisateurController(connection);
	            		Etudiant etudiant=etudiantController.getEtudiantById(idE);
	            		Utilisateur utilisateur=utilisateurController.getUtilisateurByMat(idE);

	                    List<Note> notes = new ArrayList<>();
	                    String sql = "SELECT * FROM notes WHERE idEtudiant = ? AND idModule = ?";

	                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                        statement.setInt(1, idE);
	                        statement.setInt(2, moduleProfIntegers.get(1));

	                        try (ResultSet resultSet = statement.executeQuery()) {
	                            while (resultSet.next()) {
	                                Note note = new Note();
	                                note.setIdNote(resultSet.getInt("idNote"));
	                                note.setCoefficient(resultSet.getInt("coefficient"));
	                                note.setCc(resultSet.getBigDecimal("cc"));
	                                note.setExam(resultSet.getBigDecimal("exam"));
	                                note.setMoyenne(resultSet.getBigDecimal("moyenne"));
	                                note.setIdEtudiant(resultSet.getInt("idEtudiant"));
	                                note.setIdProf(resultSet.getInt("idProf"));
	                                note.setIdModule(resultSet.getInt("idModule"));
	                                note.setIdSemestre(resultSet.getInt("idSemestre"));

	                                notes.add(note);
	                            }
	                        }
	                    }
	            		if(notes.size()>0) {
	            			Note note=notes.get(0);
	            			SpecialiteController specialiteController=new SpecialiteController(connection);
	            			Specialite specialite= specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
	            			EtudiantNoteTable etudiantNoteTable=new EtudiantNoteTable(etudiant.getIdEtudiant(),utilisateur.getNom(),utilisateur.getPrenom(),specialite.getNomSpecialite(),etudiant.getSection(),etudiant.getGroupe(),note.getCc(),note.getExam(),note.getMoyenne());
	            			etudiantssList.add(etudiantNoteTable);
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            		}else {
	            			NoteController noteController=new NoteController(connection);
	            			int idmod=moduleProfIntegers.get(1);
	            			BigDecimal noBigDecimal=BigDecimal.ZERO;;
	            			ModuleController moduleController=new ModuleController(connection);
	            			Module module=moduleController.getModuleParId(idmod);
	            			Random randomm = new Random();
	      			        // Generates between 1000 (inclusive) and 10000 (exclusive)
	      			     int random= 1000 + randomm.nextInt(9000);
	      			     AnneeController anneeController=new AnneeController(connection);
	      			  List<Annee> annee=   anneeController.getAnneesByEtudiantId(etudiant.getIdEtudiant());
	      			     Annee annee2=annee.get(0);
	      			     SemestreController semestreController=new SemestreController(connection);
	      			     Semestre semestre=new Semestre(random,NumeroSemestre.SEMESTRE_2,noBigDecimal,annee2.getIdAnnee());
	      			     semestreController.ajouterSemestre(semestre);
	      			     int coef=module.getCoefExamen().intValue();
	      			     
                          Note note=new Note(random,coef,noBigDecimal,noBigDecimal,noBigDecimal,etudiant.getIdEtudiant(),idP,module.getIdModule(),semestre.getIdSemestre());     
                          SpecialiteController specialiteController=new SpecialiteController(connection);
	            			Specialite specialite= specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
	            			EtudiantNoteTable etudiantNoteTable=new EtudiantNoteTable(etudiant.getIdEtudiant(),utilisateur.getNom(),utilisateur.getPrenom(),specialite.getNomSpecialite(),etudiant.getSection(),etudiant.getGroupe(),note.getCc(),note.getExam(),note.getMoyenne());
	            			etudiantssList.add(etudiantNoteTable);

	            			
	            			
	            		}
	            		
	            		
	            		
	            		
	            		
	            	}
	            	
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
				}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    
	    
		public void switchToScene2222(ActionEvent event) throws IOException {
		 	  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			        alert.setTitle("Exit Application");
			        alert.setHeaderText("Confirm Exit");
			        alert.setContentText("Are you sure you want to exit the application?");
			        
			        // Get the stage from the event source
			        Stage stage = (Stage) deconexionprof.getScene().getWindow();
			        
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
	    
	    
	    public void handlep(ActionEvent e) throws SQLException {
	    	
	    	if(e.getSource()==TimeBT) {
	    		
	    		emploiT.toFront();
	    	}
            if(e.getSource()==NoteBT) {
            	 etudiantssList.clear();
	            etudiantNote.toFront();
				try(Connection connection = ConnectionDB.getConnection()) {
					int idP=Integer.parseInt(userString);

	            ProfModuleController profModuleController=new ProfModuleController(connection);
	            List<Integer> moduleProfIntegers=  profModuleController.getModulesParProf(idP);
	            EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
	            List<Integer> etuIntegers1=new ArrayList();
	            List<Integer> etuIntegers2=new ArrayList();

	            List<Integer> etuIntegers3=new ArrayList();

	            for(int i=0;i<moduleProfIntegers.size();i++) {
	            	int modid=moduleProfIntegers.get(i);
	            	ModuleController moduleController=new ModuleController(connection);
	            	Module module=moduleController.getModuleParId(modid);
	            	if(i==0) {
	            		
	            	 etuIntegers1=etudiantModuleController.getEtudiantsParModule(modid);
	            	Module1.setText(module.getNom());
	            		
	            	}
	            	if(i==1) {
	            		
		            	 etuIntegers2=etudiantModuleController.getEtudiantsParModule(modid);
		            	 Module2.setText(module.getNom());
		            	 Module1.toFront();
		            		Module2.toFront();
		            		
		            	}if(i==2) {
		            		
			            	 etuIntegers3=etudiantModuleController.getEtudiantsParModule(modid);
			            		
			            		
			            		
			            	}
	            	
	            	
		            	
	            	
	            	
	            	
	            }
	            for(int i=0;i<moduleProfIntegers.size();i++) {
	            	
	            	for(int j=0;j<etuIntegers1.size();j++) {
	            		int idE= etuIntegers1.get(j);
	            		EtudiantController etudiantController=new EtudiantController(connection);
	            		UtilisateurController utilisateurController= new UtilisateurController(connection);
	            		Etudiant etudiant=etudiantController.getEtudiantById(idE);
	            		Utilisateur utilisateur=utilisateurController.getUtilisateurByMat(idE);

	                    List<Note> notes = new ArrayList<>();
	                    String sql = "SELECT * FROM notes WHERE idEtudiant = ? AND idModule = ?";

	                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	                        statement.setInt(1, idE);
	                        statement.setInt(2, moduleProfIntegers.get(i));

	                        try (ResultSet resultSet = statement.executeQuery()) {
	                            while (resultSet.next()) {
	                                Note note = new Note();
	                                note.setIdNote(resultSet.getInt("idNote"));
	                                note.setCoefficient(resultSet.getInt("coefficient"));
	                                note.setCc(resultSet.getBigDecimal("cc"));
	                                note.setExam(resultSet.getBigDecimal("exam"));
	                                note.setMoyenne(resultSet.getBigDecimal("moyenne"));
	                                note.setIdEtudiant(resultSet.getInt("idEtudiant"));
	                                note.setIdProf(resultSet.getInt("idProf"));
	                                note.setIdModule(resultSet.getInt("idModule"));
	                                note.setIdSemestre(resultSet.getInt("idSemestre"));

	                                notes.add(note);
	                            }
	                        }
	                    }
	            		if(notes.size()>0) {
	            			Note note=notes.get(0);
	            			SpecialiteController specialiteController=new SpecialiteController(connection);
	            			Specialite specialite= specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
	            			EtudiantNoteTable etudiantNoteTable=new EtudiantNoteTable(etudiant.getIdEtudiant(),utilisateur.getNom(),utilisateur.getPrenom(),specialite.getNomSpecialite(),etudiant.getSection(),etudiant.getGroupe(),note.getCc(),note.getExam(),note.getMoyenne());
	            			etudiantssList.add(etudiantNoteTable);
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            			
	            		}else {
	            			NoteController noteController=new NoteController(connection);
	            			int idmod=moduleProfIntegers.get(i);
	            			BigDecimal noBigDecimal=BigDecimal.ZERO;;
	            			ModuleController moduleController=new ModuleController(connection);
	            			Module module=moduleController.getModuleParId(idmod);
	            			Random randomm = new Random();
	      			        // Generates between 1000 (inclusive) and 10000 (exclusive)
	      			     int random= 1000 + randomm.nextInt(9000);
	      			     AnneeController anneeController=new AnneeController(connection);
	      			  List<Annee> annee=   anneeController.getAnneesByEtudiantId(etudiant.getIdEtudiant());
	      			     Annee annee2=annee.get(0);
	      			     SemestreController semestreController=new SemestreController(connection);
	      			     Semestre semestre=new Semestre(random,NumeroSemestre.SEMESTRE_2,noBigDecimal,annee2.getIdAnnee());
	      			     semestreController.ajouterSemestre(semestre);
	      			     int coef=module.getCoefExamen().intValue();
	      			     
                           Note note=new Note(random,coef,noBigDecimal,noBigDecimal,noBigDecimal,etudiant.getIdEtudiant(),idP,module.getIdModule(),semestre.getIdSemestre());     
                           SpecialiteController specialiteController=new SpecialiteController(connection);
	            			Specialite specialite= specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
	            			EtudiantNoteTable etudiantNoteTable=new EtudiantNoteTable(etudiant.getIdEtudiant(),utilisateur.getNom(),utilisateur.getPrenom(),specialite.getNomSpecialite(),etudiant.getSection(),etudiant.getGroupe(),note.getCc(),note.getExam(),note.getMoyenne());
	            			etudiantssList.add(etudiantNoteTable);

	            			
	            			
	            		}
	            		
	            		
	            		
	            		
	            		
	            	}
	            	
	            	
	            	
	            	
	            	
	            	
	            	
	            	
	            	
	            	
	            	
	            }
	            
	            
	            MatriculeT.setCellValueFactory(new PropertyValueFactory("idEtudiant"));
 				NameT.setCellValueFactory(new PropertyValueFactory("nameString"));
 				SurnameT.setCellValueFactory(new PropertyValueFactory("surnameString"));
 				SpecialityT.setCellValueFactory(new PropertyValueFactory("specialityString"));
 				cc.setCellValueFactory(new PropertyValueFactory("cc"));
 				exam.setCellValueFactory(new PropertyValueFactory("exam"));
 				moyenne.setCellValueFactory(new PropertyValueFactory("moyenne"));
 				SectionT.setCellValueFactory(new PropertyValueFactory("sectionString"));
 				groupeT.setCellValueFactory(new PropertyValueFactory("groupeString"));
	            
	            

 				EtudiantT.setItems(etudiantssList);
 			FilteredList<EtudiantNoteTable> filterDataEtudiantTables=new FilteredList(etudiantssList,b -> true);
 			SearchTextfield.textProperty().addListener((observable, oldValue, newValue) -> {
 			    filterDataEtudiantTables.setPredicate(EtudiantTable -> {
 			        if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
 			            return true;
 			        }
 			        String searchKeyword = newValue.toLowerCase(); // Corrected: toLowerCase()
 			        
 			        if(Integer.toString(EtudiantTable.getIdEtudiant()).toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getNameString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getSurnameString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }else if(EtudiantTable.getSpecialityString().toLowerCase().indexOf(searchKeyword)>-1) {
 			        	return true;
 			        }
 			      return false;
 			    });
 			});
 			
 			SortedList<EtudiantNoteTable> sortedDaTables=new SortedList<>(filterDataEtudiantTables);
 			
 			sortedDaTables.comparatorProperty().bind(EtudiantT.comparatorProperty());
 			
 			
 			EtudiantT.setItems(sortedDaTables);
	            
				}
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	          
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	    	}
            
	    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

	    public static int getTimeSlotInRange(LocalTime inputTime) {
	        if (inputTime.isBefore(LocalTime.of(8, 0))) {
	            return 0; // Before 8:00
	        } else if (inputTime.isBefore(LocalTime.of(9, 40))) {
	            return 1; // 8:00 - 9:39
	        } else if (inputTime.isBefore(LocalTime.of(11, 10))) {
	            return 2; // 9:40 - 11:09
	        } else if (inputTime.isBefore(LocalTime.of(12, 50))) {
	            return 3; // 11:10 - 12:49
	        } else if (inputTime.isBefore(LocalTime.of(14, 30))) {
	            return 4; // 12:50 - 14:29
	        } else if (inputTime.isBefore(LocalTime.of(16, 10))) {
	            return 5; // 14:30 - 16:09
	        } else {
	            return 6; // 16:10 or later
	        }
	    }
	    LoginPController controller=new LoginPController()
	    		;    
	    String userString= controller.getLoggedInUsername();
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			emploiT.toFront();
			try(Connection connection = ConnectionDB.getConnection()) {
				int idP=Integer.parseInt(userString);
				
				
				SeanceController seanceController=new SeanceController(connection);
				List<Seance> seances=seanceController.getToutesLesSeances();
				List<Seance> seancesP= new ArrayList();

			for(int i=0;i<seances.size();i++) {
				Seance seance=seances.get(i);
				if(idP==seance.getIdProf()) {
					seancesP.add(seance);
					
				}
				
			}
			
			
			for(int i=0;i<seancesP.size();i++) {
				
				

				Seance seance=seancesP.get(i);
				if (seance.getIdJour() < 8) {
				if (seance.getIdJour() == 1) { // Day 1 (Sunday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses11.setText(module.getNom() + " Course");
				        class11.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses12.setText(module.getNom() + " Course");
				        class12.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses13.setText(module.getNom() + " Course");
				        class13.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses14.setText(module.getNom() + " Course");
				        class14.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses15.setText(module.getNom() + " Course");
				        class15.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses16.setText(module.getNom() + " Course");
				        class16.setText(seance.getSalle());
				    }
				}
				else if (seance.getIdJour() == 2) { // Day 2 (Monday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses21.setText(module.getNom() + " Course");
				        class21.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses22.setText(module.getNom() + " Course");
				        class22.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses23.setText(module.getNom() + " Course");
				        class23.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses24.setText(module.getNom() + " Course");
				        class24.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses25.setText(module.getNom() + " Course");
				        class25.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses26.setText(module.getNom() + " Course");
				        class26.setText(seance.getSalle());
				    }
				}
				else if (seance.getIdJour() == 3) { // Day 3 (Tuesday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses31.setText(module.getNom() + " Course");
				        class31.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses32.setText(module.getNom() + " Course");
				        class32.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses33.setText(module.getNom() + " Course");
				        class33.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses34.setText(module.getNom() + " Course");
				        class34.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses35.setText(module.getNom() + " Course");
				        class35.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses36.setText(module.getNom() + " Course");
				        class36.setText(seance.getSalle());
				    }
				}
				else if (seance.getIdJour() == 4) { // Day 4 (Wednesday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses41.setText(module.getNom() + " Course");
				        class41.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses42.setText(module.getNom() + " Course");
				        class42.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses43.setText(module.getNom() + " Course");
				        class43.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses44.setText(module.getNom() + " Course");
				        class44.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses45.setText(module.getNom() + " Course");
				        class45.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses46.setText(module.getNom() + " Course");
				        class46.setText(seance.getSalle());
				    }
				}
				else if (seance.getIdJour() == 5) { // Day 5 (Thursday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses51.setText(module.getNom() + " Course");
				        class51.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses52.setText(module.getNom() + " Course");
				        class52.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses53.setText(module.getNom() + " Course");
				        class53.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses54.setText(module.getNom() + " Course");
				        class54.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses55.setText(module.getNom() + " Course");
				        class55.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses56.setText(module.getNom() + " Course");
				        class56.setText(seance.getSalle());
				    }
				}
				else if (seance.getIdJour() == 6) { // Day 6 (Friday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses61.setText(module.getNom() + " Course");
				        class61.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses62.setText(module.getNom() + " Course");
				        class62.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses63.setText(module.getNom() + " Course");
				        class63.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses64.setText(module.getNom() + " Course");
				        class64.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses65.setText(module.getNom() + " Course");
				        class65.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses66.setText(module.getNom() + " Course");
				        class66.setText(seance.getSalle());
				    }
				}
				else if (seance.getIdJour() == 7) { // Day 7 (Saturday)
				    int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				    if (seaceN == 1) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses71.setText(module.getNom() + " Course");
				        class71.setText(seance.getSalle());
				    } else if (seaceN == 2) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses72.setText(module.getNom() + " Course");
				        class72.setText(seance.getSalle());
				    } else if (seaceN == 3) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses73.setText(module.getNom() + " Course");
				        class73.setText(seance.getSalle());
				    } else if (seaceN == 4) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses74.setText(module.getNom() + " Course");
				        class74.setText(seance.getSalle());
				    } else if (seaceN == 5) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses75.setText(module.getNom() + " Course");
				        class75.setText(seance.getSalle());
				    } else if (seaceN == 6) {
				        ModuleController moduleController = new ModuleController(connection);
				        Module module = moduleController.getModuleParId(seance.getIdModule());
				        corses76.setText(module.getNom() + " Course");
				        class76.setText(seance.getSalle());
				    }
				}
				

				}else {
					
					int num=0;
					
				    num=seance.getIdJour();
		
				    int seaceday = num / 10;
				    int groupe = num % 10;
				    String group = String.valueOf(groupe);
				 
				  
				 if (seaceday == 1) { 
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses11.setText(module.getNom() + " TD");
				         class11.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses12.setText(module.getNom() + " TD");
				         class12.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses13.setText(module.getNom() + " TD");
				         class13.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses14.setText(module.getNom() + " TD");
				         class14.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses15.setText(module.getNom() + " TD");
				         class15.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses16.setText(module.getNom() + " TD");
				         class16.setText(seance.getSalle());
				     }
				 }
				 else if (seaceday == 2) { 
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses21.setText(module.getNom() + " TD");
				         class21.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses22.setText(module.getNom() + " TD");
				         class22.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses23.setText(module.getNom() + " TD");
				         class23.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses24.setText(module.getNom() + " TD");
				         class24.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses25.setText(module.getNom() + " TD");
				         class25.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses26.setText(module.getNom() + " TD");
				         class26.setText(seance.getSalle());
				     }
				 }
				 else if (seaceday == 3) { 
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses31.setText(module.getNom() + " TD");
				         class31.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses32.setText(module.getNom() + " TD");
				         class32.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses33.setText(module.getNom() + " TD");
				         class33.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses34.setText(module.getNom() + " TD");
				         class34.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses35.setText(module.getNom() + " TD");
				         class35.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses36.setText(module.getNom() + " TD");
				         class36.setText(seance.getSalle());
				     }
				 }
				 else if (seaceday == 4) { 
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses41.setText(module.getNom() + " TD");
				         class41.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses42.setText(module.getNom() + " TD");
				         class42.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses43.setText(module.getNom() + " TD");
				         class43.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses44.setText(module.getNom() + " TD");
				         class44.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses45.setText(module.getNom() + " TD");
				         class45.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses46.setText(module.getNom() + " TD");
				         class46.setText(seance.getSalle());
				     }
				 }
				 else if (seaceday == 5) {
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses51.setText(module.getNom() + " TD");
				         class51.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses52.setText(module.getNom() + " TD");
				         class52.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses53.setText(module.getNom() + " TD");
				         class53.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses54.setText(module.getNom() + " TD");
				         class54.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses55.setText(module.getNom() + " TD");
				         class55.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses56.setText(module.getNom() + " TD");
				         class56.setText(seance.getSalle());
				     }
				 }
				 else if (seaceday == 6) { 
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses61.setText(module.getNom() + " TD");
				         class61.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses62.setText(module.getNom() + " TD");
				         class62.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses63.setText(module.getNom() + " TD");
				         class63.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses64.setText(module.getNom() + " TD");
				         class64.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses65.setText(module.getNom() + " TD");
				         class65.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses66.setText(module.getNom() + " TD");
				         class66.setText(seance.getSalle());
				     }
				 }
				 else if (seaceday == 7) { 
				     int seaceN = getTimeSlotInRange(seance.getDebutSeance());
				     ModuleController moduleController = new ModuleController(connection);
				     Module module = moduleController.getModuleParId(seance.getIdModule());

				     if (seaceN == 1) {
				         corses71.setText(module.getNom() + " TD");
				         class71.setText(seance.getSalle());
				     } else if (seaceN == 2) {
				         corses72.setText(module.getNom() + " TD");
				         class72.setText(seance.getSalle());
				     } else if (seaceN == 3) {
				         corses73.setText(module.getNom() + " TD");
				         class73.setText(seance.getSalle());
				     } else if (seaceN == 4) {
				         corses74.setText(module.getNom() + " TD");
				         class74.setText(seance.getSalle());
				     } else if (seaceN == 5) {
				         corses75.setText(module.getNom() + " TD");
				         class75.setText(seance.getSalle());
				     } else if (seaceN == 6 ) {
				         corses76.setText(module.getNom() + " TD");
				         class76.setText(seance.getSalle());
				     }
				 }

					
					
					
					
					
				}
				
				
				
			
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
				
				
			
			} catch (InternalError  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
