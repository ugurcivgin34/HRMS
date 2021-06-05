package JavaKampProje.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import JavaKampProje.hrms.business.abstracts.CvService;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
public class CvsController {

	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvDto cvDto, int id) {
		return this.cvService.add(cvDto, id);
	}
}
