package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CvLanguageService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.CvLanguageDao;
import JavaKampProje.hrms.entities.concretes.CvLanguage;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CvLanguageManager implements CvLanguageService {
	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Language eklendi");
	}

	@Override
	public Result addAll(List<CvLanguage> cvLanguages) {
		this.cvLanguageDao.saveAll(cvLanguages);
		return new SuccessResult("Language eklendi");
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuccessDataResult<List<CvLanguage>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getByCandidateId(id), "Diller alındı");
	}

	

}
