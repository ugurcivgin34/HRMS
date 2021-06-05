package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CandidateService;
import JavaKampProje.hrms.business.abstracts.CvExperienceService;
import JavaKampProje.hrms.business.abstracts.CvLanguageService;
import JavaKampProje.hrms.business.abstracts.CvLinkService;
import JavaKampProje.hrms.business.abstracts.CvPhotoService;
import JavaKampProje.hrms.business.abstracts.CvSchoolService;
import JavaKampProje.hrms.business.abstracts.CvService;
import JavaKampProje.hrms.business.abstracts.ProgramingTechnologieService;

import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.entities.concretes.Candidate;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {

	private CandidateService candidateService;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	private ProgramingTechnologieService programingTechnologieService;

	public CvManager(CandidateService candidateService, CvExperienceService cvExperienceService,
			CvLanguageService cvLanguageService, CvLinkService cvLinkService, CvPhotoService cvPhotoService,
			CvSchoolService cvSchoolService, ProgramingTechnologieService programingTechnologieService) {

		this.candidateService = candidateService;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
		this.programingTechnologieService = programingTechnologieService;
	}

	@Override
	public Result add(CvDto cvDto, int candidateId) {
		Candidate candidate= candidateService.getById(candidateId).getData();
		cvDto.setCandidate(candidate);
		
		cvDto.getCvExperiences().forEach(cvExperience -> cvExperience.setCandidate(candidate));
        cvExperienceService.addAll(cvDto.getCvExperiences());

       

        cvDto.getCvLanguages().forEach(cvLanguage -> cvLanguage.setCandidate(candidate));
        cvLanguageService.addAll(cvDto.getCvLanguages());
        
        
        cvDto.getCvLinks().forEach(cvLink -> cvLink.setCandidate(candidate));
        cvLinkService.addAll(cvDto.getCvLinks());

        cvDto.getCvPhotos().forEach(cvPhoto -> cvPhoto.setCandidate(candidate));
        cvPhotoService.addAll(cvDto.getCvPhotos());
        
        cvDto.getCvSchools().forEach(cvSchool -> cvSchool.setCandidate(candidate));
        cvSchoolService.addAll(cvDto.getCvSchools());
	
        return new SuccessResult("Cv eklendi");
	}

}
