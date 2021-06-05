package JavaKampProje.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.CvSchool;

public interface CvSchoolDao extends JpaRepository<CvSchool, Integer> {
	List<CvSchool> getByCandidateIdOrderBySchoolBeginingDate(int id);

	List<CvSchool>getAllByCandidateIdOrderBySchoolGradiationDate(int candidateId);
}
