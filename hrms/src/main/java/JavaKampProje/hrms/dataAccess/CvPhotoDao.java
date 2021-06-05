package JavaKampProje.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer>{
	List<CvPhoto> getByCandidateId(int id);
}
