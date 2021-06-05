package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.entities.concretes.CvLink;
import JavaKampProje.hrms.entities.dtos.CvDto;

public interface CvLinkService {
	DataResult<List<CvDto>> getAll();
	Result add(CvLink cvLink);
	Result addAll(List<CvLink> cvLinks);
	SuccessDataResult<List<CvLink>> getByCandidateId(int id);
}
