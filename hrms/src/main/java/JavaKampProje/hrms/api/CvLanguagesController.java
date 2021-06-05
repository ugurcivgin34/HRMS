package JavaKampProje.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.CvLanguageService;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.entities.concretes.CvLanguage;

@RestController
@RequestMapping("/api/cvLanguageController")
public class CvLanguagesController {
private CvLanguageService cvLanguageService;
	
	@Autowired
	public CvLanguagesController(CvLanguageService cvLanguageService) {
		
		this.cvLanguageService = cvLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		
		this.cvLanguageService.add(cvLanguage);
		return new SuccessResult("Dil eklendi.");
	} 
}
