package JavaKampProje.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.CvLink;

public interface CvLinkDao extends JpaRepository<CvLink, Integer>{
	List<CvLink> getByCandidateId(int id);
}
