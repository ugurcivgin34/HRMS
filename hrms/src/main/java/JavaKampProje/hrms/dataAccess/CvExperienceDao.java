package JavaKampProje.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer>{
	List<CvExperience> getByCandidateIdOrderByBeginingDate(int id);
	List<CvExperience> getAllByCandidateIdOrderByEndinDateDesc(int candidateId);
}
