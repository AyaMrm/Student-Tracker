package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Annee;
import Model.ConnectionDB;
import Model.Etudiant;
import Model.Module;
import Model.Note;
import Model.Prof;
import Model.ProfModule;
import Model.Seance;
import Model.Semestre;
import Model.SemestreDAO;
import Model.Specialite;
import javafx.fxml.Initializable;



	import javafx.scene.control.Label;

	import java.io.IOException;
import java.lang.classfile.ClassFile.ShortJumpsOption;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
	import java.security.PublicKey;
	import javafx.scene.layout.GridPane;
	import javafx.application.Platform;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.fxml.Initializable;
	import javafx.geometry.Pos;
	import javafx.scene.Node;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.chart.BarChart;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.chart.CategoryAxis;
	import javafx.scene.chart.NumberAxis;
	import javafx.scene.chart.PieChart;
	import javafx.scene.chart.XYChart;
	import javafx.scene.chart.XYChart.Series;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Button;
	import javafx.scene.control.ButtonType;
	import javafx.scene.control.DatePicker;
	import javafx.stage.Stage;
	import javafx.scene.control.TextField;
	import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.effect.Light.Spot;
import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.FlowPane;
	import javafx.scene.text.Text;
	import javafx.scene.control.PasswordField;
	import java.sql.Connection;

	import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
	import java.time.ZonedDateTime;
	import java.time.format.TextStyle;
	import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
	import java.util.ResourceBundle;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.paint.Color;



	public class DashboardPController implements Initializable  {
		
		ZonedDateTime dateFocus;
		ZonedDateTime today;
		
	    @FXML
	    private Button CoursesBT;
	    @FXML
	    private Label annee1;
	    @FXML
	    private Label specialite1;

	    @FXML
	    private Label specialite2;

	    @FXML
	    private Label specialite3;

	    @FXML
	    private Label specialite4;

	    @FXML
	    private Label specialite5;

	    @FXML
	    private Label specialite6;

	    @FXML
	    private Rectangle rec01;

	    @FXML
	    private Rectangle rec02;

	    @FXML
	    private Rectangle rec03;

	    @FXML
	    private Rectangle rec04;

	    @FXML
	    private Rectangle rec05;

	    @FXML
	    private Rectangle rec06;

	    @FXML
	    private Label annee2;

	    @FXML
	    private Label annee3;

	    @FXML
	    private Label annee4;

	    @FXML
	    private Label annee5;

	    @FXML
	    private Label annee6;
	    @FXML
	    private Label moyenneG1;

	    @FXML
	    private Label moyenneG2;

	    @FXML
	    private Label moyenneG3;

	    @FXML
	    private Label moyenneG4;

	    @FXML
	    private Label moyenneG5;

	    @FXML
	    private Label moyenneG6;
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
	 
	
	    private Button DashboardBT;
	    @FXML
	    private Button DeconnexionBT;
	    @FXML
	    private Button GradesBT;
	    @FXML
	    private Button CCbtn;

	    @FXML
	    private Button exambtn;

	    @FXML
	    private Button moyenbtn;
	    @FXML
	    private Text year;
	    @FXML
	    private Text month;
	    @FXML
	    private FlowPane calendar;
	    @FXML
	    private Button TimetabBT;
	    @FXML
	    private Button settingsB1;

	    @FXML
	    private Button TranscriptBT;

	    @FXML
	    private Label currentyear;
	    @FXML
	    private AnchorPane emploiT;
	    
	    @FXML
	    private AnchorPane dashbordarchon;
	    @FXML
	    private AnchorPane transcriptA;
	    @FXML
	    private AnchorPane notifA;
	    @FXML
	    private AnchorPane settingsA;
	    @FXML
	    private Label firstname;

	    @FXML
	    private Label group;

	    @FXML
	    private Label lastname;

	    @FXML
	    private Label lbiStatus;

	    @FXML
	    private Label matricule;
	    @FXML
	    private BarChart<String, Integer> chart;
	    @FXML
	    private BarChart<String, Integer> chartM;
	    @FXML
	    private BarChart<String, Integer> chartE;
	    @FXML
	    private Label section;
	    @FXML
	    private Label Labell;
	 
	    @FXML
	    private Label testlb;
	    @FXML
	    private Label testlb1;
	    @FXML
	    private Label testlb2;
	    @FXML
	    private Label testlb3;
	    @FXML
	    private Label testlb4;
	    @FXML
	    private Label testlb5;
	    @FXML
	    private Label testlb6;
	   
	    @FXML private AnchorPane calendarContainer;
	  
	    @FXML private Label monthYearLabel;
	    @FXML private GridPane calendarGrid;
	    @FXML private Button prevMonthBtn;
	    @FXML private Button nextMonthBtn;
	    @FXML private Button ExitButton;
	    @FXML private Button settingsB;
	    @FXML
	    private Label cc1;

	    @FXML
	    private Label cc2;

	    @FXML
	    private Label cc3;

	    @FXML
	    private Label cc4;

	    @FXML
	    private Label cc5;

	    @FXML
	    private Label cc6;

	    @FXML
	    private Label cc7;

	    @FXML
	    private Label cc8;

	    
	    @FXML
	    private Rectangle rec1;

	    @FXML
	    private Rectangle rec2;

	    @FXML
	    private Rectangle rec3;

	    @FXML
	    private Rectangle rec4;

	    @FXML
	    private Rectangle rec5;

	    @FXML
	    private Rectangle rec6;

	    @FXML
	    private Rectangle rec7;
	    @FXML
	    private Rectangle rec0;
	    @FXML
	    private Rectangle rec8;
	    @FXML
	    private Rectangle notifrec;

	    

	    @FXML
	    private Label moyenne1;

	    @FXML
	    private Label moyenne2;

	    @FXML
	    private Label moyenne3;

	    @FXML
	    private Label moyenne4;

	    @FXML
	    private Label moyenne5;

	    @FXML
	    private Label moyenne6;

	    @FXML
	    private Label moyenne7;

	    @FXML
	    private Label moyenne8;

	    @FXML
	    private Label mod1;

	    @FXML
	    private Label mod2;

	    @FXML
	    private Label mod3;

	    @FXML
	    private Label mod4;

	    @FXML
	    private Label mod5;

	    @FXML
	    private Label mod6;

	    @FXML
	    private Label mod7;

	    @FXML
	    private Label mod8;
	    @FXML
	    private Label exam1;

	    @FXML
	    private Label exam2;

	    @FXML
	    private Label exam3;

	    @FXML
	    private Label exam4;

	    @FXML
	    private Label exam5;
        @FXML
        AnchorPane Grade; 
	    @FXML
	    private Label exam6;

	    @FXML
	    private Label exam7;

	    @FXML
	    private Label exam8;
	    @FXML
	    private Label coef1;

	    @FXML
	    private Label coef2;

	    @FXML
	    private Label coef0;

	    @FXML
	    private Label cc0;

	    @FXML
	    private Label mod0;

	    @FXML
	    private Label moyenne0;

	    @FXML
	    private Label examain0;
	    @FXML
	    private Label coef3;

	    @FXML
	    private Label coef4;

	    @FXML
	    private Label coef5;

	    @FXML
	    private Label coef6;

	    @FXML
	    private Label coef7;

	    @FXML
	    private Label coef8;
	    @FXML private Label profile;
	    private LocalDate projectStart;
	    private LocalDate projectEnd;
	    
	    @FXML
	    private PieChart progressPieChart; 

	    @FXML
	    public void initializee() {
	        // 2. Initialize all variables
	        projectStart = LocalDate.of(2025, 1, 20); // Set your actual start date
	        projectEnd = LocalDate.of(2025, 5, 31); // Set your actual end date

	        if (progressPieChart == null) {
	            throw new IllegalStateException("progressPieChart was not injected - check FXML");
	        }
	        
	    
	        initializePieChartData();
	    }
	    
	    private void initializePieChartData() {
	        // 5. Calculate values using initialized variables
	        long totalDays = ChronoUnit.DAYS.between(projectStart, projectEnd);
	        long daysPassed = ChronoUnit.DAYS.between(projectStart, LocalDate.now());
	        double percentage = (daysPassed * 100.0) / totalDays;
	        String formattedPercentage = String.format("%.1f", percentage) + "%";
	        Labell.setText(formattedPercentage);
	        // 6. Create new observable list (proper initialization)
	        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
	            new PieChart.Data("", percentage),
	            new PieChart.Data("", 100 - percentage)
	        );
	        
	        progressPieChart.setStyle("""
	                -fx-pie-color: #00D560;
	                -fx-background-color: transparent;
	              
	                -fx-border-width: 2px;
	                """);
	        progressPieChart.setPrefSize(250, 250); 
	        progressPieChart.setMinSize(200, 200);  
	        
	        progressPieChart.setMaxSize(400, 400);  
	       
	        progressPieChart.setData(pieData);
	        
	        
	     
	      
	        progressPieChart.setLabelsVisible(false);
	        progressPieChart.setLegendVisible(false);
	    }

	    
	
	    public void switchToScene22(ActionEvent event) throws IOException {
	    	  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        alert.setTitle("Exit Application");
		        alert.setHeaderText("Confirm Exit");
		        alert.setContentText("Are you sure you want to exit the application?");
		        
		        // Get the stage from the event source
		        Stage stage = (Stage) ExitButton.getScene().getWindow();
		        
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
	   
	    @SuppressWarnings("null")
		private List<Seance> Etudiantceance(List<Seance> seances,Connection connection,Etudiant etudiant) {
	    	                EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
	                     List<Integer> modules=etudiantModuleController.getModulesParEtudiant(etudiant.getIdEtudiant());
	    	             List<Seance> seanceetudiant= new ArrayList<>();
	    	             
	    	             for (int i = 0; i < modules.size(); i++) {
	    	            	
	    	            	 for (int ii = 0; ii < seances.size(); ii++) {
	    	            		 Seance seance=seances.get(ii);
	    	            		 
	    	            		 if(modules.get(i)==seance.getIdModule()) {
	    	            			 seanceetudiant.add(seance);
	    	            			 
	    	            			 
	    	            			 
	    	            		 }
	    	            		 
	    	            	 }

	    	             }
	    	
	    	return seanceetudiant;
	    	
	    	
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
	    
	    
	    
	    
	    
	 private String getMoProN (Connection connection,Module module) {
		   
		   
		   String nomMString=module.getNom();
		   int idprof=module.getIdProfResponsable();
		   ProfController profController=new ProfController(connection);
		   Prof prof=profController.getProfByMat(idprof);
		   String nomP=prof.getNom();
		   return""+nomMString+" ("+nomP+")";
		   
		   
		   
		   
	   }
	 
	 
	 private void updateNumberLabel(BigDecimal number, Label label) {
		    if (number == null) {
		        label.setText(""); // or "0" if you prefer
		    } else {
		        label.setText(String.format("%.2f", number));
		    }
		

	       
	        // Set the label text with formatted number (2 decimal places)
	        label.setText(number.setScale(2, RoundingMode.HALF_UP).toString());

	        // Set color based on value comparison
	        if (number.compareTo(BigDecimal.TEN) < 0) {
	            label.setTextFill(Color.RED);
	        } else {
	            label.setTextFill(Color.GREEN);
	        }
	    }
	 public int trieparcc(BigDecimal note, List<Note> notes, int idprof, Connection connection, int idModule) {
		    if (note == null) return 0;
		    
		    int clas = 0;
		    for (Note note2 : notes) {
		        if (note2 != null && note2.getIdModule() == idModule && note2.getIdProf() == idprof) {
		            BigDecimal cc = note2.getCc();
		            if (cc != null && note.compareTo(cc) > 0) {
		                clas++;
		            }
		        }
		    }
		    return clas;
		}

		public int trieparE(BigDecimal note, List<Note> notes, int idprof, Connection connection, int idModule) {
		    if (note == null) return 0;
		    
		    int clas = 0;
		    for (Note note2 : notes) {
		        if (note2 != null && note2.getIdModule() == idModule && note2.getIdProf() == idprof) {
		            BigDecimal exam = note2.getExam();
		            if (exam != null && note.compareTo(exam) > 0) {
		                clas++;
		            }
		        }
		    }
		    return clas;
		}

		public int trieparM(BigDecimal note, List<Note> notes, int idprof, Connection connection, int idModule) {
		    if (note == null) return 0;
		    
		    int clas = 0;
		    for (Note note2 : notes) {
		        if (note2 != null && note2.getIdModule() == idModule && note2.getIdProf() == idprof) {
		            BigDecimal moyenne = note2.getMoyenne();
		            if (moyenne != null && note.compareTo(moyenne) > 0) {
		                clas++;
		            }
		        }
		    }
		    return clas;
		}

		BigDecimal getmynoteCC(List<Note> notes, int idetudiant) {
		    for (Note note : notes) {
		        if (note != null && note.getIdEtudiant() == idetudiant) {
		            return note.getCc() != null ? note.getCc() : BigDecimal.ZERO;
		        }
		    }
		    return BigDecimal.ZERO;
		}

		BigDecimal getmynoteE(List<Note> notes, int idetudiant) {
		    for (Note note : notes) {
		        if (note != null && note.getIdEtudiant() == idetudiant) {
		            return note.getExam() != null ? note.getExam() : BigDecimal.ZERO;
		        }
		    }
		    return BigDecimal.ZERO;
		}

		BigDecimal getmynoteM(List<Note> notes, int idetudiant) {
		    for (Note note : notes) {
		        if (note != null && note.getIdEtudiant() == idetudiant) {
		            return note.getMoyenne() != null ? note.getMoyenne() : BigDecimal.ZERO;
		        }
		    }
		    return BigDecimal.ZERO;
		}
	    
	    private YearMonth currentYearMonth;
	    @FXML
	    
	    private void handleExitButton(ActionEvent event) {
	        // Show confirmation dialog
	        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Exit Application");
	        alert.setHeaderText("Confirm Exit");
	        alert.setContentText("Are you sure you want to exit the application?");
	        
	        // Get the stage from the event source
	        Stage stage = (Stage) ExitButton.getScene().getWindow();
	        
	        // If user confirms, close the application
	        alert.showAndWait().ifPresent(response -> {
	            if (response == ButtonType.OK) {
	                stage.close();  // Close the current window
	                Platform.exit(); // Shutdown JavaFX
	                System.exit(0);  // Ensure complete shutdown
	            }
	        });
	        
	        // Consume the event to prevent any default handling
	        event.consume();
	    }
	    public DashboardPController() {
	        currentYearMonth = YearMonth.now(); // Initialize here first
	    }
	    @FXML
	    public void initialize() {
	        currentYearMonth = YearMonth.now();
	        updateCalendar();
	        
	        prevMonthBtn.setOnAction(e -> {
	            currentYearMonth = currentYearMonth.minusMonths(1);
	            updateCalendar();
	        });
	        
	        nextMonthBtn.setOnAction(e -> {
	            currentYearMonth = currentYearMonth.plusMonths(1);
	            updateCalendar();
	        });
	    }
	    public void initializechart() {
	     
	        
	        exambtn.setOnAction(e -> {
	        	chartE.toFront();
	        });
	        
	        CCbtn.setOnAction(e -> {
	        	chart.toFront();
	        });
	        moyenbtn.setOnAction(e -> {
	        	chartM.toFront();
	        });
	    }
   public void initializeSettingst() {
	     
	        
	   settingsB.setOnAction(e -> {
	        	notifA.toBack();
	        });
	        
	   settingsB.setOnAction(e -> {
	        	settingsA.toFront();
	        });
	        
	    }
   public void initializenotif() {
	     
       
	   settingsB1.setOnAction(e -> {
	        	notifA.toFront();
	        	notifrec.toFront();
	        	settingsA.toBack();
	        	});
	        
	   settingsB1.setOnAction(e -> {
	        	settingsA.toBack();
	        });
	        
	    }
	    private void updateCalendar() {
	       
	      
	            if (currentYearMonth == null) {
	                currentYearMonth = YearMonth.now();
	            }
	            
	            if (monthYearLabel == null || calendarGrid == null) {
	                System.err.println("FXML components not properly injected!");
	                return;
	            }
	            
	            calendarGrid.getChildren().clear();
	            
	        String monthName = currentYearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
	        
	        monthYearLabel.setText(monthName + " " + currentYearMonth.getYear());
	        
	   
	        
	        LocalDate firstOfMonth = currentYearMonth.atDay(1);
	        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue() % 7;
	        int daysInMonth = currentYearMonth.lengthOfMonth();
	        
	        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	        for (int i = 0; i < 7; i++) {
	            Label dayLabel = new Label(dayNames[i]);
	            dayLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 11;-fx-alignment: center;");
	            calendarGrid.add(dayLabel, i, 0);
	        }
	        
	        for (int day = 1; day <= daysInMonth; day++) {
	            Label dayLabel = new Label(String.valueOf(day));
	            dayLabel.setStyle("-fx-font-size: 12; -fx-alignment: center; -fx-min-width: 30; " +
	                             "-fx-min-height: 30; -fx-border-color: transparent;");
	            
	            if (currentYearMonth.equals(YearMonth.now())) {
	                LocalDate today = LocalDate.now();
	                if (day == today.getDayOfMonth()) {
	                    dayLabel.setStyle("-fx-background-color: #355C7D; -fx-text-fill: white; -fx-background-radius: 10px;-fx-border-radius: 10px; " +
	                                     "-fx-font-weight: bold;");
	                }
	            }
	            
	            int row = (dayOfWeek + day - 1) / 7 + 1;
	            int column = (dayOfWeek + day - 1) % 7;
	            
	            calendarGrid.add(dayLabel, column, row);
	        }
	    }
	    
	    public void setusername(String text) {
	        matricule.setText(text);
	    }
	
	  LoginPController controller=new LoginPController()
	;    
	    String userString= controller.getLoggedInUsername();
	    
	    int currentYear = Year.now().getValue();
        int previousYear = currentYear - 1;
        
        String yearRange = previousYear + "-" + currentYear;
		int i=0;
	    int idAnne;
	    String annescolaire;
	    String specialitString;
	    String profnameString;
	    int idprof;
	    String idetudiant=userString;
	    String sectionString;
	    Annee curAnnee = null;
	    Semestre cuSemestre=new Semestre();
	    @FXML
	    public void showDashboard() {
	    	dashbordarchon.toFront();
	    }
	  
		@FXML
		public void handleclicks(ActionEvent e) throws SQLException {

			Etudiant etudiant = null;
			setusername(userString);
			int id=Integer.parseInt(matricule.getText());
			
			
			try(Connection connection = ConnectionDB.getConnection()) {
				AnneeController anneeC=new AnneeController(connection);
			List<Annee> annees=	anneeC.getAnneesByEtudiantId(id);
				
			
			for (int i = 0; i < annees.size(); i++) {
				Annee annee=annees.get(i);
				if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
					 curAnnee=annee;
					 SemestreController semaistrecurrController=new SemestreController(connection);
					    List<Semestre> semaiSemestres=semaistrecurrController.getAllSemestres();
					    List<Semestre>semestres=new ArrayList();
					    int conteur=0;
					for(int ii=0;ii<semaiSemestres.size();ii++) {
                        Semestre semestre=semaiSemestres.get(ii);
						if(semestre.getIdAnnee()==annee.getIdAnnee()) {
							semestres.add(semestre);
							conteur++;
							
							
						}
						
						
					}
					 if(conteur==1) {
						 
						 cuSemestre=semestres.get(0);
						 
						 
					 }
                     if(conteur==2) {
						 
						 cuSemestre=semestres.get(0);
						 
						 
					 }
					 
					 
					 
				}
				
				
			}
				
				
			}
			
			
	
			System.out.print(cuSemestre.getIdSemestre());
		
			if(curAnnee!=null) {
				
				
			
			if(e.getSource()==DashboardBT) {
			
				transcriptA.toBack();
				initializee();
				Series<String, Integer> series = new XYChart.Series<>();
				Series<String, Integer> seriesE = new XYChart.Series<>();
				Series<String, Integer> seriesM = new XYChart.Series<>();

				 chart.getData().clear();
				updateCalendar();
				lbiStatus.setText("Dash Board");
				
				dashbordarchon.toFront();
				matricule.setText(userString);
			    id=Integer.parseInt(matricule.getText());
				try(Connection connection = ConnectionDB.getConnection()) {
					EtudiantController etudiantController=new EtudiantController(connection);
					 etudiant=etudiantController.getEtudiantById(id);
					section.setText(etudiant.getSection());
					group.setText(etudiant.getGroupe());
					firstname.setText(etudiant.getNom());
					
					char firstChar = (etudiant.getNom()).charAt(0);
					
					
					settingsB.setText(""+firstChar+"");
					settingsB1.setText(""+firstChar+"");

					
					lastname.setText(etudiant.getPrenom());
					AnneeController anneeController=new AnneeController(connection);
					List<Annee> annees=anneeController.getAnneesByEtudiantId(id);
					Annee currAnnee = null;
					for (int i = 0; i < annees.size(); i++) {
						Annee annee=annees.get(i);
						if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
							 currAnnee=annee;
						}
						
						
					}
					SpecialiteController specialiteController=new SpecialiteController(connection);
				Specialite specialite=specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
				currentyear.setText(""+specialite.getNomSpecialite()+" \\"+currAnnee.getAnneeScolaire()+"");
					EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
			List<Integer> modulesIntegers=etudiantModuleController.getModulesParEtudiant(id);
			NoteController noteController=new NoteController(connection);
			List<Note> notes=noteController.getToutesLesNotes();
			for (int i = 0; i < modulesIntegers.size(); i++) {
			   if(i==0) {
				 
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
				  
				   Module module=moduleController.getModuleParId(item);
				   testlb.setText(getMoProN(connection,module));
				   testlb.toFront();
				   //trieparcc (BigDecimal note,List<Note> notes,int idprof,Connection connection, int idModule)
				 int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   }
			   if(i==1) {
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
			
				   Module module=moduleController.getModuleParId(item);
				   testlb1.setText(getMoProN(connection,module));
				   testlb1.toFront();
				   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   } if(i==2) {
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
				  
				   Module module=moduleController.getModuleParId(item);
				   testlb2.setText(getMoProN(connection,module));
				   testlb2.toFront();
				   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   } if(i==3) {
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
				  
				   Module module=moduleController.getModuleParId(item);
				   testlb3.setText(getMoProN(connection,module));
				   testlb3.toFront();
				   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   } if(i==4) {
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
				  
				   Module module=moduleController.getModuleParId(item);
				   testlb4.setText(getMoProN(connection,module));
				   testlb4.toFront();
				   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   } if(i==5) {
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
				  
				   Module module=moduleController.getModuleParId(item);
				   testlb5.setText(getMoProN(connection,module));
				   testlb5.toFront();
				   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   } if(i==6) {
				   ModuleController moduleController=new ModuleController(connection);
				   int item = modulesIntegers.get(i);
				  
				   Module module=moduleController.getModuleParId(item);
				   testlb6.setText(getMoProN(connection,module));
				   testlb6.toFront();
				   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					series.getData().add(new XYChart.Data<>(module.getNom(), clas));
					int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
					int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
					seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
			   }
				
				
				
				
				
				
				
				
				
				
				
			}
				
				}
				
				
				 chart.getData().clear();
				 chartE.getData().clear();
				 chartM.getData().clear();

				
				
				chart.getData().addAll(series);
				chartE.getData().addAll(seriesE);
				chartM.getData().addAll(seriesM);

				
				
				
				
			}
			else
				if(e.getSource()==TimetabBT) {
					transcriptA.toBack();
					emploiT.toFront();
					lbiStatus.setText(" Time Table");
					try(Connection connection = ConnectionDB.getConnection()) {
						
						EtudiantController etudiantController=new EtudiantController(connection);
						 etudiant=etudiantController.getEtudiantById(id);
						SeanceController seanceController=new SeanceController(connection);
						List<Seance> seances=seanceController.getToutesLesSeances();
						List<Seance> seacesetudiantList=Etudiantceance(seances,connection,etudiant);
						for (int i = 0; i < seacesetudiantList.size(); i++) {
							Seance seance=seacesetudiantList.get(i);
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
							 
							    if (etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
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
							     } else if (seaceN == 6 && etudiant.getGroupe().equalsIgnoreCase(group)) {
							         corses76.setText(module.getNom() + " TD");
							         class76.setText(seance.getSalle());
							     }
							 }

								
								
								
							}	
								
							}
							
							
							
						}

					}
					
				}
				else
					if(e.getSource()==CoursesBT) {
						transcriptA.toBack();
						lbiStatus.setText(" Courses");

					
					
					
				}
				else
					if(e.getSource()==GradesBT) {
						transcriptA.toBack();
						lbiStatus.setText(" Grades");
                        Grade.toFront();
						try(Connection connection = ConnectionDB.getConnection()) {
						
							
							EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
					List<Integer> modulesIntegers=etudiantModuleController.getModulesParEtudiant(id);
					NoteController noteController=new NoteController(connection);
					List<Note> notes=noteController.getToutesLesNotes();
					ModuleController moduleController=new ModuleController(connection);
					int i = 0;
					BigDecimal  moyennegeneralBigDecimal = BigDecimal.ZERO;
					int coefF=0;
					int coefN=0;
					while ( i <= modulesIntegers.size()) {
						
						if(i==0) {
						
							rec0.toFront();
							cc0.toFront();
							examain0.toFront();
							mod0.toFront();
							moyenne0.toFront();
							coef0.toFront();
						
							rec1.toFront();
							if(i!=modulesIntegers.size()) {
							
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod1.setText(module.getNom());
							mod1.toFront();
							int co = module.getCoefExamen().intValue();
							coef1.setText(Integer.toString(co));
							coef1.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
							
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
						
									updateNumberLabel(note.getCc(),cc1);
									updateNumberLabel(note.getExam(),exam1);
									updateNumberLabel(note.getMoyenne(),moyenne1);
									coef1.setText(Integer.toString(note.getCoefficient()));
									cc1.toFront();
									exam1.toFront();
									
									moyenne1.toFront();
									coef1.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
									
								}
								
								
							}
							
							
							
						}else {
							
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne1);
							coef1.setText(Integer.toString(coefF));
							
							
						}
						
							
						}
						
						if(i==1) {
							rec2.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod2.setText(module.getNom());
							mod2.toFront();
							int co = module.getCoefExamen().intValue();
							coef2.setText(Integer.toString(co));
							coef2.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc2);
									updateNumberLabel(note.getExam(),exam2);
									updateNumberLabel(note.getMoyenne(),moyenne2);
									coef2.setText(Integer.toString(note.getCoefficient()));
								
									cc2.toFront();
									exam2.toFront();
								
									moyenne2.toFront();
									coef2.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne2);
							coef2.setText(Integer.toString(coefF));
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) >= 0) {
								 cc2.setText("Admis");
								    cc2.getStyleClass().add("admis-label");
								} else {
								    cc2.setText("Rejeter");
								    cc2.getStyleClass().add("rejeter-label");
						        }
						cc2.toFront();
							moyenne2.toFront();
							coef2.toFront();
							
						}
							
							
						}
						if(i==2) {
							rec3.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod3.setText(module.getNom());
							int co = module.getCoefExamen().intValue();
							coef3.setText(Integer.toString(co));
							coefN=coefN+co;
							coef3.toFront();
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc3);
									updateNumberLabel(note.getExam(),exam3);
									updateNumberLabel(note.getMoyenne(),moyenne3);
									coef3.setText(Integer.toString(note.getCoefficient()));
									cc3.toFront();
									exam3.toFront();
									mod3.toFront();
									moyenne3.toFront();
									
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
									
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
								
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne3);
							coef3.setText(Integer.toString(coefF));
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) >= 0) {
								 cc3.setText("Admis");
								    cc3.getStyleClass().add("admis-label");
								} else {
								    cc3.setText("Rejeter");
								    cc3.getStyleClass().add("rejeter-label");
						        }
						cc3.toFront();
							moyenne3.toFront();
							coef3.toFront();
							SemestreController semestreController=new SemestreController(connection);
							Semestre semestre=new Semestre(cuSemestre.getIdSemestre(),cuSemestre.getNumero(),moyennegeneralBigDecimal,cuSemestre.getIdAnnee());
							semestreController.modifierSemestre(semestre);
							
							
							PreparedStatement stmt = connection.prepareStatement(
								    "UPDATE semestres SET moyenneSemestre = ? WHERE idSemestre = ?"
								);
								stmt.setBigDecimal(1, moyennegeneralBigDecimal); 
								stmt.setInt(2, cuSemestre.getIdSemestre());      
								int rowsUpdated = stmt.executeUpdate();
								System.out.println("Rows updated: " + rowsUpdated); 
						}
							
							
						}
						
						if(i==3) {
							rec4.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							
							mod4.setText(module.getNom());
							mod4.toFront();
							int co = module.getCoefExamen().intValue();
							coef4.setText(Integer.toString(co));
							coef4.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
							
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc4);
									updateNumberLabel(note.getExam(),exam4);
									updateNumberLabel(note.getMoyenne(),moyenne4);
									coef4.setText(Integer.toString(note.getCoefficient()));
									cc4.toFront();
									exam4.toFront();
								
									moyenne4.toFront();
									coef4.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
									
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
								
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							
							SemestreController semestreController=new SemestreController(connection);
							Semestre semestre=new Semestre(cuSemestre.getIdSemestre(),cuSemestre.getNumero(),moyennegeneralBigDecimal,cuSemestre.getIdAnnee());
							SemestreDAO semestreDAO= new SemestreDAO(connection);
							semestreDAO.updateSemestre(semestre);
							semestreController.modifierSemestre(semestre);
							
							
							updateNumberLabel(moyennegeneralBigDecimal,moyenne4);
							coef4.setText(Integer.toString(coefF));
							
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) >= 0) {
								 cc4.setText("Admis");
								    cc4.getStyleClass().add("admis-label");
								} else {
								    cc4.setText("Rejeter");
								    cc4.getStyleClass().add("rejeter-label");
						        }
						cc4.toFront();
							moyenne4.toFront();
							coef4.toFront();
							
							PreparedStatement stmt = connection.prepareStatement(
								    "UPDATE semestres SET moyenneSemestre = ? WHERE idSemestre = ?"
								);
								stmt.setBigDecimal(1, moyennegeneralBigDecimal); 
								stmt.setInt(2, cuSemestre.getIdSemestre());      
								int rowsUpdated = stmt.executeUpdate();
								System.out.println("Rows updated: " + rowsUpdated); 

							
						}
							
						
							
							
						}
						if(i==4) {
							rec5.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod5.setText(module.getNom());
							mod5.toFront();
							int co = module.getCoefExamen().intValue();
							coef5.setText(Integer.toString(co));
							coef5.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc5);
									updateNumberLabel(note.getExam(),exam5);
									updateNumberLabel(note.getMoyenne(),moyenne5);
									coef5.setText(Integer.toString(note.getCoefficient()));
									cc5.toFront();
									exam5.toFront();
									
									moyenne5.toFront();
									coef5.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
								
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne5);
							coef5.setText(Integer.toString(coefF));
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) >= 0) {
								 cc5.setText("Admis");
								    cc5.getStyleClass().add("admis-label");
								} else {
								    cc5.setText("Rejeter");
								    cc5.getStyleClass().add("rejeter-label");
						        }
						cc5.toFront();
							moyenne5.toFront();
							coef5.toFront();
							
							PreparedStatement stmt = connection.prepareStatement(
								    "UPDATE semestres SET moyenneSemestre = ? WHERE idSemestre = ?"
								);
								stmt.setBigDecimal(1, moyennegeneralBigDecimal); 
								stmt.setInt(2, cuSemestre.getIdSemestre());      
								int rowsUpdated = stmt.executeUpdate();
								System.out.println("Rows updated: " + rowsUpdated);  
						}
							
							
						}
						
						if(i==5) {
							rec6.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod6.setText(module.getNom());
							mod6.toFront();
							int co = module.getCoefExamen().intValue();
							coef6.setText(Integer.toString(co));
							coef6.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc6);
									updateNumberLabel(note.getExam(),exam6);
									updateNumberLabel(note.getMoyenne(),moyenne6);
									coef6.setText(Integer.toString(note.getCoefficient()));
									cc6.toFront();
									exam6.toFront();
									
									moyenne6.toFront();
									coef6.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
								
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne6);
							coef6.setText(Integer.toString(coefF));
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) <= 0) {
								 cc6.setText("Admis");
								    cc6.getStyleClass().add("admis-label");
								} else {
								    cc6.setText("Rejeter");
								    cc6.getStyleClass().add("rejeter-label");
						        }
						
							moyenne6.toFront();
							coef6.toFront();
							cc6.toFront();
							PreparedStatement stmt = connection.prepareStatement(
								    "UPDATE semestres SET moyenneSemestre = ? WHERE idSemestre = ?"
								);
								stmt.setBigDecimal(1, moyennegeneralBigDecimal);  
								stmt.setInt(2, cuSemestre.getIdSemestre());      
								int rowsUpdated = stmt.executeUpdate();
								System.out.println("Rows updated: " + rowsUpdated);  
						}
							
							
						}
						if(i==6) {
							rec7.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod7.setText(module.getNom());
							mod7.toFront();
							int co = module.getCoefExamen().intValue();
							coef7.setText(Integer.toString(co));
							coef7.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc7);
									updateNumberLabel(note.getExam(),exam7);
									updateNumberLabel(note.getMoyenne(),moyenne7);
									coef7.setText(Integer.toString(note.getCoefficient()));
									cc7.toFront();
									exam7.toFront();
								
									moyenne7.toFront();
									coef7.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
								
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne7);
							coef7.setText(Integer.toString(coefF));
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) <= 0) {
								 cc7.setText("Admis");
								    cc7.getStyleClass().add("admis-label");
								} else {
								    cc7.setText("Rejeter");
								    cc7.getStyleClass().add("rejeter-label");
						        }
						    cc7.toFront();
							moyenne7.toFront();
							coef7.toFront();
							PreparedStatement stmt = connection.prepareStatement(
								    "UPDATE semestres SET moyenneSemestre = ? WHERE idSemestre = ?"
								);
								stmt.setBigDecimal(1, moyennegeneralBigDecimal);  
								stmt.setInt(2, cuSemestre.getIdSemestre());      
								int rowsUpdated = stmt.executeUpdate();
								System.out.println("Rows updated: " + rowsUpdated);  
						}
							
							
						}
						
						if(i==7) {
							rec8.toFront();
							if(i!=modulesIntegers.size()) {
							Module module=moduleController.getModuleParId(modulesIntegers.get(i));
							mod8.setText(module.getNom());
							mod8.toFront();
							int co = module.getCoefExamen().intValue();
							coef8.setText(Integer.toString(co));
							coef8.toFront();
							coefN=coefN+co;
							for (int ii = 0; ii < notes.size(); ii++) {
								Note note=notes.get(ii);
								if(id==note.getIdEtudiant()&&module.getIdModule()==note.getIdModule()) {
									updateNumberLabel(note.getCc(),cc8);
									updateNumberLabel(note.getExam(),exam8);
									updateNumberLabel(note.getMoyenne(),moyenne8);
									coef8.setText(Integer.toString(note.getCoefficient()));
									cc8.toFront();
									exam8.toFront();
								
									moyenne8.toFront();
									coef8.toFront();
									moyennegeneralBigDecimal=moyennegeneralBigDecimal.add(note.getMoyenne().multiply(new BigDecimal(note.getCoefficient())));
									coefF=coefF+note.getCoefficient();
								}
								
								
							}
							
							
							
						}else {
							if(coefF==0) {
								coefF=coefN;
								
								
								
							}
							moyennegeneralBigDecimal=moyennegeneralBigDecimal.divide(new BigDecimal(coefF), 2, RoundingMode.HALF_UP);
							updateNumberLabel(moyennegeneralBigDecimal,moyenne8);
							coef8.setText(Integer.toString(coefF));
							 if (moyennegeneralBigDecimal.compareTo(BigDecimal.TEN) <= 0) {
								 cc8.setText("Admis");
								    cc8.getStyleClass().add("admis-label");
								} else {
								    cc8.setText("Rejeter");
								    cc8.getStyleClass().add("rejeter-label");
						        }
						    cc8.toFront();
							moyenne8.toFront();
							coef8.toFront();
							PreparedStatement stmt = connection.prepareStatement(
								    "UPDATE semestres SET moyenneSemestre = ? WHERE idSemestre = ?"
								);
								stmt.setBigDecimal(1, moyennegeneralBigDecimal);
								stmt.setInt(2, cuSemestre.getIdSemestre());   
								int rowsUpdated = stmt.executeUpdate();
								System.out.println("Rows updated: " + rowsUpdated);  
						}
							
							
						}
						
						
						
						
						
						
						
						i++;
						
					}
					
					
					
					
					
						}		
						
						
					}
					else
						if(e.getSource()==TranscriptBT) {
							transcriptA.toBack();
							lbiStatus.setText(" Transcripts");
							dashbordarchon.toFront();
							transcriptA.toFront();
							try(Connection connection = ConnectionDB.getConnection()) {
								AnneeController anneeController=new AnneeController(connection);
							
								List<Annee> annees=	anneeController.getAnneesByEtudiantId(id);
								for(int i=0;i<annees.size();i++) {
									Annee annee1=annees.get(i);
									String year1=annee1.getAnneeScolaire();
									System.out.print(annee1.getIdAnnee());
									
									int endyear1 = Integer.parseInt(year1.split("-")[1]);
							
								    int	minindex=i;
									for(int j=0;j<annees.size();j++) {
									Annee annee2=annees.get(j);
									String year2=annee2.getAnneeScolaire();
									int endYear2 = Integer.parseInt(year2.split("-")[1]);
									if(endYear2<endyear1) {
									endyear1=endYear2;
										minindex=j;
										
									}
									
									
									
									}
									
									
									Annee anneinter=annees.get(minindex);
									annees.set(minindex,annee1);
									annees.set(i,anneinter);
									
								}
								SpecialiteController soController=new SpecialiteController(connection);
								Specialite specialite;
								for(int i=0;i<annees.size();i++) {
									if (i == 0) {
										rec01.toFront();
									    Annee anneinter = annees.get(i);
									    specialite = soController.getSpecialiteParId(anneinter.getIdSpecialite());
									    annee1.setText(anneinter.getAnneeScolaire());
									    specialite1.setText(specialite.getNomSpecialite());
									    annee1.toFront();
									    specialite1.toFront();
									    moyenneG1.toFront();  
									    updateNumberLabel(anneinter.getmoyenneGenerale(), moyenneG1);
									} 
									else if (i == 1) {
										rec02.toFront();
									    Annee anneinter = annees.get(i);
									    specialite = soController.getSpecialiteParId(anneinter.getIdSpecialite());
									    annee2.setText(anneinter.getAnneeScolaire());
									    specialite2.setText(specialite.getNomSpecialite());
									    annee2.toFront();
									    specialite2.toFront();
									    moyenneG2.toFront();  
									    updateNumberLabel(anneinter.getmoyenneGenerale(), moyenneG2);
									} 
									else if (i == 2) {
										rec03.toFront();
									    Annee anneinter = annees.get(i);
									    specialite = soController.getSpecialiteParId(anneinter.getIdSpecialite());
									    annee3.setText(anneinter.getAnneeScolaire());
									    specialite3.setText(specialite.getNomSpecialite());
									    annee3.toFront();
									    specialite3.toFront();
									    moyenneG3.toFront(); 
									    updateNumberLabel(anneinter.getmoyenneGenerale(), moyenneG3);
									} 
									else if (i == 3) {
										rec04.toFront();
									    Annee anneinter = annees.get(i);
									    specialite = soController.getSpecialiteParId(anneinter.getIdSpecialite());
									    annee4.setText(anneinter.getAnneeScolaire());
									    specialite4.setText(specialite.getNomSpecialite());
									    annee4.toFront();
									    specialite4.toFront();
									    moyenneG4.toFront();  
									    updateNumberLabel(anneinter.getmoyenneGenerale(), moyenneG4);
									} 
									else if (i == 4) {
										rec05.toFront();
									    Annee anneinter = annees.get(i);
									    specialite = soController.getSpecialiteParId(anneinter.getIdSpecialite());
									    annee5.setText(anneinter.getAnneeScolaire());
									    specialite5.setText(specialite.getNomSpecialite());
									    annee5.toFront();
									    specialite5.toFront();
									    moyenneG5.toFront();  
									    updateNumberLabel(anneinter.getmoyenneGenerale(), moyenneG5);
									} 
									else if (i == 5) {
										rec06.toFront();
									    Annee anneinter = annees.get(i);
									    specialite = soController.getSpecialiteParId(anneinter.getIdSpecialite());
									    annee6.setText(anneinter.getAnneeScolaire());
									    specialite6.setText(specialite.getNomSpecialite());
									    annee6.toFront();
									    specialite6.toFront();
									    moyenneG6.toFront(); 
									    updateNumberLabel(anneinter.getmoyenneGenerale(), moyenneG6);
									}
									
								
								}
								
								
								
								
								
							}
					
							
							
							
							
							
							
						}
			
			
			}
		
			
		}
		
		
	    
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		transcriptA.toBack();
		initializee();
		Series<String, Integer> series = new XYChart.Series<>();
		Series<String, Integer> seriesE = new XYChart.Series<>();
		Series<String, Integer> seriesM = new XYChart.Series<>();

		 chart.getData().clear();
		updateCalendar();
		lbiStatus.setText(" Dash Board");
		
		dashbordarchon.toFront();
		matricule.setText(userString);
	   int id=Integer.parseInt(matricule.getText());
		try(Connection connection = ConnectionDB.getConnection()) {
			EtudiantController etudiantController=new EtudiantController(connection);
			Etudiant etudiant=etudiantController.getEtudiantById(id);
			section.setText(etudiant.getSection());
			group.setText(etudiant.getGroupe());
			firstname.setText(etudiant.getNom());
			
			char firstChar = (etudiant.getNom()).charAt(0);
			
			
			settingsB.setText(""+firstChar+"");
			settingsB1.setText(""+firstChar+"");

			
			lastname.setText(etudiant.getPrenom());
			AnneeController anneeController=new AnneeController(connection);
			List<Annee> annees=anneeController.getAnneesByEtudiantId(id);
			Annee currAnnee = null;
			for (int i = 0; i < annees.size(); i++) {
				Annee annee=annees.get(i);
				if(yearRange.equalsIgnoreCase(annee.getAnneeScolaire())) {
					 currAnnee=annee;
				}
				
				
			}
			SpecialiteController specialiteController=new SpecialiteController(connection);
		Specialite specialite=specialiteController.getSpecialiteParId(etudiant.getIdSpecialite());
		currentyear.setText(""+specialite.getNomSpecialite()+" \\"+currAnnee.getAnneeScolaire()+"");
			EtudiantModuleController etudiantModuleController=new EtudiantModuleController(connection);
	List<Integer> modulesIntegers=etudiantModuleController.getModulesParEtudiant(id);
	NoteController noteController=new NoteController(connection);
	List<Note> notes=noteController.getToutesLesNotes();
	for (int i = 0; i < modulesIntegers.size(); i++) {
	   if(i==0) {
		 
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
		  
		   Module module=moduleController.getModuleParId(item);
		   testlb.setText(getMoProN(connection,module));
		   testlb.toFront();
		   //trieparcc (BigDecimal note,List<Note> notes,int idprof,Connection connection, int idModule)
		 int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   }
	   if(i==1) {
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
	
		   Module module=moduleController.getModuleParId(item);
		   testlb1.setText(getMoProN(connection,module));
		   testlb1.toFront();
		   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   } if(i==2) {
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
		  
		   Module module=moduleController.getModuleParId(item);
		   testlb2.setText(getMoProN(connection,module));
		   testlb2.toFront();
		   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   } if(i==3) {
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
		  
		   Module module=moduleController.getModuleParId(item);
		   testlb3.setText(getMoProN(connection,module));
		   testlb3.toFront();
		   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   } if(i==4) {
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
		  
		   Module module=moduleController.getModuleParId(item);
		   testlb4.setText(getMoProN(connection,module));
		   testlb4.toFront();
		   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   } if(i==5) {
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
		  
		   Module module=moduleController.getModuleParId(item);
		   testlb5.setText(getMoProN(connection,module));
		   testlb5.toFront();
		   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   } if(i==6) {
		   ModuleController moduleController=new ModuleController(connection);
		   int item = modulesIntegers.get(i);
		  
		   Module module=moduleController.getModuleParId(item);
		   testlb6.setText(getMoProN(connection,module));
		   testlb6.toFront();
		   int clas=trieparcc(getmynoteCC(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			series.getData().add(new XYChart.Data<>(module.getNom(), clas));
			int clasE=trieparE(getmynoteE(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesE.getData().add(new XYChart.Data<>(module.getNom(), clasE));
			int clasM=trieparM(getmynoteM(notes,id),notes,module.getIdProfResponsable(),connection,module.getIdModule());
			seriesM.getData().add(new XYChart.Data<>(module.getNom(), clasM));
	   }
		
		
		
	}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 chart.getData().clear();
		 chartE.getData().clear();
		 chartM.getData().clear();

		
		
		chart.getData().addAll(series);
		chartE.getData().addAll(seriesE);
		chartM.getData().addAll(seriesM);

		
	}

}
