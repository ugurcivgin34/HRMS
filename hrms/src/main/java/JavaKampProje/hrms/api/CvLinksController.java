package JavaKampProje.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.CvLinkService;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.entities.concretes.CvLink;

@RestController
@RequestMapping("/api/cvLinkController")
public class CvLinksController {
	private CvLinkService cvLinkService;

	@Autowired
	public CvLinksController(CvLinkService cvLinkService) {
		
		this.cvLinkService = cvLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvLink cvLink) {
		this.cvLinkService.add(cvLink);
		return new SuccessResult("Link eklendi");
	}
}
