package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.EmployerService;
import JavaKampProje.hrms.core.adapters.abstracts.EmailValidationService;
import JavaKampProje.hrms.core.adapters.abstracts.EmployeeValidationService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.EmployerDao;
import JavaKampProje.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	private EmployerDao employerDao;
	private EmailValidationService emailValidationService;
	private EmployeeValidationService employeeValidationService;
	
	
	public EmployerManager(EmployerDao employerDao, EmailValidationService emailValidationService,
			EmployeeValidationService employeeValidationService) {
		super();
		this.employerDao = employerDao;
		this.emailValidationService = emailValidationService;
		this.employeeValidationService = employeeValidationService;
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Şirketler listelendi");
	}

	

	@Override
	public Result add(Employer employer) {
		if(employerDao.findByEmailEquals(employer.getEmail())!= null || employerDao.findByWebAdresEquals(employer.getWebAdres()) != null) {
			return new ErrorResult("Şirket eklenemedi");
		}
		if(employer.getPassword().isEmpty()) {
			return new ErrorResult("Şifre alanı boş bırakılamaz. "+"Kullanıcı eklenemedi");
		}
		if(eMailequalsWebSite(employer) != null) {
			return new ErrorResult("Bu eposta adresi domain ile eşleşmiyor. "+"Kullanıcı eklenemedi");
			
		}
		else {
		
		if(!emailValidationService.isEmailValid(employer.getEmail())) {
			return new ErrorResult("Geçersiz bir eposta adresi girdiniz. "+"Kullanıcı eklenemedi");
		}else {
			if(!employeeValidationService.isValidatedByEmployee(employer)) {
				return new ErrorResult("Hesabınız henüz doğrulanmamıştır. "+"Kullanıcı eklenemedi");
			}
			else {
			this.employerDao.save(employer);
			return new SuccessResult("Başarıyla eklendi");}
		}
		}
	}
	private Result eMailequalsWebSite(Employer employer) {
        String email = employer.getEmail();
        String webSite = employer.getWebAdres();
        String[] emailSplit = email.split("@");
        String[] webSiteSplit = webSite.split("www.");
        if(!emailSplit[1].equals(webSiteSplit[1])) {
            return new ErrorResult("E-posta ile web domaininiz ayni olmalidir");
        }
        return null;
    }

}
