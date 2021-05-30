package JavaKampProje.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.JobPostingService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}
	
	@GetMapping("/getAllByIsActive")
	public DataResult<List<JobPosting>> getByisOpenTrue(){
		return this.jobPostingService.getByisOpenTrue();
	}
	
	@GetMapping("/getAllByisActiveTrueOrderByPostedDate")
	public DataResult<List<JobPosting>> getByisOpenTrueOrderByPostedDate(){
		return this.jobPostingService.getByisOpenTrueOrderByPostedDate();
	}
	
	@GetMapping("/getByAllisActiveTrueAndEmployer")
	public DataResult<List<JobPosting>> getByisOpenTrueAndEmployer_companyName(String companyName){
		return this.jobPostingService.getByisOpenTrueAndEmployer_companyName(companyName);
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id) {
		return this.jobPostingService.changeOpenToClose(id);
	}
	
	

}
