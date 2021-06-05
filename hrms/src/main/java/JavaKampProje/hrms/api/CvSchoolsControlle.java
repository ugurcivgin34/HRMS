package JavaKampProje.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.CvSchoolService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("/api/cvSchool")
public class CvSchoolsControlle {
	
	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolsControlle(CvSchoolService cvSchoolService) {
		
		this.cvSchoolService = cvSchoolService;
	}
	
	public Result add(CvSchool cvSchool) {
		
		this.cvSchoolService.add(cvSchool);
		return new  SuccessResult("Okul eklendi");
	}
	
	@GetMapping("/getGraduationDateDesc")
	public DataResult<List<CvSchool>>getByCandidateIdOrderBySchoolGradiationDateDesc(@RequestParam int candidateId) {
		return this.cvSchoolService.getAllByCandidateIdOrderBySchoolGradiationDate(candidateId);
	}
}
