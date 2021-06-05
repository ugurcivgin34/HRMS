package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.concretes.Candidate;
import JavaKampProje.hrms.entities.dtos.CvDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate);
	public DataResult<Candidate> getById(int id);
	public DataResult<CvDto> getCvById(int id);
}
