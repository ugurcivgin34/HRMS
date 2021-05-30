package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result delete(int id);
	Result update(JobPosting jobPosting);
	Result changeOpenToClose(int id);
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getByisOpenTrue();
	DataResult<List<JobPosting>> getByisOpenTrueAndEmployer_companyName(String companyName);
	DataResult<List<JobPosting>> getByisOpenTrueOrderByPostedDate();
	DataResult<JobPosting> getById(int id);
	
}
