package JavaKampProje.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.CandidateService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.concretes.Candidate;
import JavaKampProje.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;

	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		
		return this.candidateService.getAll();
				
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/getCv")
	public DataResult<CvDto> getCvById(@RequestParam int id){
		return (this.candidateService.getCvById(id));
	}
	
}
