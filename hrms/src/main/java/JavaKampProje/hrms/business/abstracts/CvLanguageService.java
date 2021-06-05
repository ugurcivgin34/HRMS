package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.entities.concretes.CvLanguage;
import JavaKampProje.hrms.entities.dtos.CvDto;

public interface CvLanguageService {
	DataResult<List<CvDto>> getAll();
	Result add(CvLanguage cvLanguage);
	Result addAll(List<CvLanguage> cvLanguages);
	SuccessDataResult<List<CvLanguage>> getByCandidateId(int id);
}
