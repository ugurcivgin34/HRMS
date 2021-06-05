package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.concretes.CvSchool;
import JavaKampProje.hrms.entities.dtos.CvDto;

public interface CvSchoolService {
	DataResult<List<CvDto>> getAll();
	Result add(CvSchool cvSchool);
	Result addAll(List<CvSchool> cvSchools);
	DataResult<List<CvSchool>> getByCandidateIdOrderBySchoolBeginingDate(int id);
	DataResult<List<CvSchool>> getAllByCandidateIdOrderBySchoolGradiationDate(int candidateId);
}
