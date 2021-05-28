package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.JobPositionService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.JobPositionDao;
import JavaKampProje.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(), "İşler listelendi.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.findByPositionEquals(jobPosition.getPosition()) != null) {
			return new ErrorResult("Bu iş dalı daha önce eklenmiştir." + " Ekleme başarısız");
		}else {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Başarıyla eklendi");}
	}

}
