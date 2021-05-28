package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CandidateService;
import JavaKampProje.hrms.core.adapters.abstracts.EmailValidationService;
import JavaKampProje.hrms.core.adapters.abstracts.FakeMernisService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.CandidateDao;
import JavaKampProje.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {
	private CandidateDao candidateDao;
	private FakeMernisService fakeMernisService;
	private EmailValidationService emailValid;
	
	
	public CandidateManager(CandidateDao candidateDao, FakeMernisService fakeMernisService,
			EmailValidationService emailValid) {
		super();
		this.candidateDao = candidateDao;
		this.fakeMernisService = fakeMernisService;
		this.emailValid = emailValid;
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

}
