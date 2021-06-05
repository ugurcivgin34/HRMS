package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CvSchoolService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.CvSchoolDao;
import JavaKampProje.hrms.entities.concretes.CvSchool;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CvSchoolManager implements CvSchoolService{
	private CvSchoolDao cvSchoolDao;
	
	@Autowired
	public CvSchoolManager(CvSchoolDao cvSchoolDao) {
		
		this.cvSchoolDao = cvSchoolDao;
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvSchool cvSchool) {
		this.cvSchoolDao.save(cvSchool);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public Result addAll(List<CvSchool> cvSchools) {
		this.cvSchoolDao.saveAll(cvSchools);
		return new SuccessResult("Cv eklendi.");
	}

	@Override
	public DataResult<List<CvSchool>> getByCandidateIdOrderBySchoolBeginingDate(int id) {
		return new SuccessDataResult<List<CvSchool>>(this.cvSchoolDao.getByCandidateIdOrderBySchoolBeginingDate(id), "Okullar listelendi.");
	}

	@Override
	public DataResult<List<CvSchool>> getAllByCandidateIdOrderBySchoolGradiationDate(int candidateId) {
		return new SuccessDataResult<>(this.cvSchoolDao.getAllByCandidateIdOrderBySchoolGradiationDate(candidateId),"Sıralandı");
	}

	
}
