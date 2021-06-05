package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CandidateService;
import JavaKampProje.hrms.business.abstracts.CvExperienceService;
import JavaKampProje.hrms.business.abstracts.CvLanguageService;
import JavaKampProje.hrms.business.abstracts.CvLinkService;
import JavaKampProje.hrms.business.abstracts.CvPhotoService;
import JavaKampProje.hrms.business.abstracts.CvSchoolService;
import JavaKampProje.hrms.core.adapters.abstracts.EmailValidationService;
import JavaKampProje.hrms.core.adapters.abstracts.FakeMernisService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.CandidateDao;
import JavaKampProje.hrms.entities.concretes.Candidate;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CandidateManager implements CandidateService {
	private CandidateDao candidateDao;
	private FakeMernisService fakeMernisService;
	private EmailValidationService emailValid;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvLinkService cvLinkService;
	private CvPhotoService cvPhotoService;
	private CvSchoolService cvSchoolService;
	
	
	
	public CandidateManager(CandidateDao candidateDao, FakeMernisService fakeMernisService,
			EmailValidationService emailValid, CvExperienceService cvExperienceService,
			CvLanguageService cvLanguageService, CvLinkService cvLinkService, CvPhotoService cvPhotoService,
			CvSchoolService cvSchoolService) {
		
		this.candidateDao = candidateDao;
		this.fakeMernisService = fakeMernisService;
		this.emailValid = emailValid;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvLinkService = cvLinkService;
		this.cvPhotoService = cvPhotoService;
		this.cvSchoolService = cvSchoolService;
	}

	

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if(candidateDao.findByEmailEquals(candidate.getEmail())!= null || candidateDao.findByIdentityNumberEquals(candidate.getIdentityNumber()) != null) {
			return new ErrorResult("Kullanıcı eklenemedi");
		}
		
		if(!this.fakeMernisService.checkUser(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName())) {
			return new ErrorResult("Mernis doğrulaması başarısız. "+"Kullanıcı eklenemedi");
		}
		if(candidate.getPassword().isEmpty()) {
			return new ErrorResult("Şifre alanı boş bırakılamaz. "+"Kullanıcı eklenemedi");
		}
		else {
			if(!emailValid.isEmailValid(candidate.getEmail())) {
				return new ErrorResult("Geçersiz email girdiniz "+"Kullanıcı eklenemedi");
			}
			if(!emailValid.isEmailValidonclick(candidate.getEmail())) {
				return new ErrorResult("Doğrulama linkine tıklayınız.."+"Kullanıcı eklenemedi");
			}
			else {
			
		this.candidateDao.save(candidate);
		return new SuccessResult("Kullanıcı eklendi");}}
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public DataResult<CvDto> getCvById(int id) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.getById(id).getData());
		cvDto.setCvExperiences(this.cvExperienceService.getByCandidateIdOrderByBeginingDate(id).getData());
		cvDto.setCvLanguages(this.cvLanguageService.getByCandidateId(id).getData());
		cvDto.setCvLinks(this.cvLinkService.getByCandidateId(id).getData());
		cvDto.setCvPhotos(this.cvPhotoService.getByCandidateId(id).getData());
		cvDto.setCvSchools(this.cvSchoolService.getByCandidateIdOrderBySchoolBeginingDate(id).getData());
		
		return new SuccessDataResult<>(cvDto);
	}

}
