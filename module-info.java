module StudentTruckerPOO2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.management;
	requires java.sql;
	   requires transitive jbcrypt;
	requires java.desktop;
	requires javafx.graphics;
	

	    // Add these lines to export your packages
	    opens Controllers to javafx.fxml;
	    exports Controllers;
	    opens Model to javafx.base;  // This is the critical line
	   
	opens View to javafx.graphics, javafx.fxml;
}
