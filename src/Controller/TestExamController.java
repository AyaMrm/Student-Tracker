// terminé ! 
package Controller;

import Model.TestExam;
import Controller.TestExamService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class TestExamController {
	
    private final TestExamService testExamService;

    public TestExamController(Connection cnx) {
        this.testExamService = new TestExamService(cnx);
    }

    public boolean ajouterTestExam(TestExam testExam) {
        return testExamService.ajouterTestExam(testExam);
    }

    public boolean supprimerTestExam(int id) {
        return testExamService.supprimerTestExam(id);
    }

    public boolean modifierTestExamDateHeure(int id, Date date, Time heure) {
        return testExamService.modifierTestExamDateHeure(id, date, heure);
    }

    public TestExam getTestExamParId(int id) {
        return testExamService.getTestExamParId(id);
    }

    public List<TestExam> getAllTestExams() {
        return testExamService.getAllTestExams();
    }

    public List<TestExam> getTestExamsParDate(Date date) {
        return testExamService.getAllTestExamsParDate(date);
    }

    public TestExam getTestExamParDateModuleProf(Date date, int idModule, int idProf) {
        return testExamService.getTestExamParDateModuleProf(date, idModule, idProf);
    }
}
