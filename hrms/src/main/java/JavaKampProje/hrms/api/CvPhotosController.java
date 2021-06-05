package JavaKampProje.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import JavaKampProje.hrms.business.abstracts.CandidateService;
import JavaKampProje.hrms.business.abstracts.CvPhotoService;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.entities.concretes.Candidate;
import JavaKampProje.hrms.entities.concretes.CvPhoto;

@RestController
@RequestMapping("/api/cvPhotoController")
public class CvPhotosController {
private CvPhotoService cvPhotoService;
private CandidateService candidateService;
	
	@Autowired
	public CvPhotosController(CvPhotoService cvPhotoService,CandidateService candidateService) {
		super();
		this.cvPhotoService = cvPhotoService;
		this.candidateService=candidateService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam(value="id")int id,@RequestParam(value="imageFile")MultipartFile imageFile) {
			Candidate candidate=this.candidateService.getById(id).getData();
			CvPhoto cvPhoto =new CvPhoto();
			cvPhoto.setCandidate(candidate);
			return this.cvPhotoService.add(cvPhoto, imageFile);
		
	}
}
