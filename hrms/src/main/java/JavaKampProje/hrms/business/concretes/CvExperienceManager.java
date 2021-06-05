package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CvExperienceService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.CvExperienceDao;
import JavaKampProje.hrms.entities.concretes.CvExperience;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CvExperienceManager implements CvExperienceService {
	private CvExperienceDao cvExperienceDao;

	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {

		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public Result add(CvExperience cvExperience) {
		cvExperienceDao.save(cvExperience);
		return new SuccessResult("cvexperience eklendi");
	}

	@Override
	public Result addAll(List<CvExperience> cvExperiences) {
		cvExperienceDao.saveAll(cvExperiences);
		return new SuccessResult("cvexperience eklendi");
	}

	
	@Override
	public SuccessDataResult<List<CvExperience>> getByCandidateIdOrderByBeginingDate(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getByCandidateIdOrderByBeginingDate(id),"Tecrübe listelendi.");
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndinDateDesc(int candidateId) {
		return new SuccessDataResult<>(this.cvExperienceDao.getAllByCandidateIdOrderByEndinDateDesc(candidateId),"Sıralandı");
	}

}
