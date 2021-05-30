package JavaKampProje.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	List<JobPosting> getByisOpenTrue();
	List<JobPosting> getByisOpenTrueAndEmployer_companyName(String companyName);
	List<JobPosting> getByisOpenTrueOrderByPostedDate();
}
