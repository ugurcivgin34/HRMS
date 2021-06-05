package JavaKampProje.hrms.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.CvExperienceService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.entities.concretes.CvExperience;


@RestController
@RequestMapping("/api/cvExperience")
public class CvsExperienceController {
	private CvExperienceService cvExperienceService;

	@Autowired
	public CvsExperienceController(CvExperienceService cvExperienceService) {
		
		this.cvExperienceService = cvExperienceService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvExperience cvExperience) {
		this.cvExperienceService.add(cvExperience);
		return new SuccessResult("Başarılı");
	}
	
	@GetMapping("/getEndingDateDesc")
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndinDateDesc(@RequestParam int candidateId) {
		return this.cvExperienceService.getAllByCandidateIdOrderByEndinDateDesc(candidateId);
	}
	
}
