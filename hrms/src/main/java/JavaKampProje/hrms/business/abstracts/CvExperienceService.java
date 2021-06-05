package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.entities.concretes.CvExperience;
import JavaKampProje.hrms.entities.dtos.CvDto;


public interface CvExperienceService {
	DataResult<List<CvDto>> getAll();
	Result add(CvExperience cvExperience);
	Result addAll(List<CvExperience> cvExperince);
	SuccessDataResult<List<CvExperience>> getByCandidateIdOrderByBeginingDate(int id);
	DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndinDateDesc(int candidateId);
}
