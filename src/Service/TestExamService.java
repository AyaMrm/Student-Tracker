// terminé !
package Service;

import Model.TestExamDAO;
import Model.TestExam;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.List;

public class TestExamService {
	
    private final TestExamDAO testExamDAO;

    public TestExamService(TestExamDAO testExamDAO) {
        this.testExamDAO = testExamDAO;
    }

    public boolean ajouterTestExam(TestExam testExam) {
        if (testExam == null || testExam.getDate() == null || testExam.getHeure() == null || 
            testExam.getType() == null || testExam.getIdProf() <= 0 || testExam.getIdModule() <= 0) {
            return false;
        }
        try {
            return testExamDAO.ajouterTestExam(testExam);
        } catch (Exception e) {
            return false;
        }
    }

    public TestExam getTestExamParId(int id) {
        if (id <= 0) return null;
        try {
            return testExamDAO.getTestExamParId(id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean supprimerTestExam(int idTest) {
        if (idTest <= 0) return false;
        try {
            return testExamDAO.supprimerTestExam(idTest);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modifierTestExamDateHeure(int idTest, Date newDate, Time newHeure) {
        if (idTest <= 0 || newDate == null || newHeure == null) return false;
        try {
            return testExamDAO.modifierTestExamDateHeure(idTest, newDate, newHeure);
        } catch (Exception e) {
            return false;
        }
    }

    public List<TestExam> getAllTestExams() {
        try {
            return testExamDAO.getAllTestExams();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<TestExam> getAllTestExamsParDate(Date date) {
        if (date == null) return Collections.emptyList();
        try {
            return testExamDAO.getAllTestExamsParDate(date);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public TestExam getTestExamParDateModuleProf(Date date, int idModule, int idProf) {
        if (date == null || idModule <= 0 || idProf <= 0) return null;
        try {
            return testExamDAO.getTestExamParDateModuleProf(date, idModule, idProf);
        } catch (Exception e) {
            return null;
        }
    }
}
