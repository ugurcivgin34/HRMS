package JavaKampProje.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{
	List<CvLanguage> getByCandidateId(int id);
}
