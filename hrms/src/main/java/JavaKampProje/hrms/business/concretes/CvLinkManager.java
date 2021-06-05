package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.CvLinkService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.CvLinkDao;
import JavaKampProje.hrms.entities.concretes.CvLink;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CvLinkManager implements CvLinkService {
	private CvLinkDao cvLinkDao;

	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {

		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link eklendi");
	}

	@Override
	public Result addAll(List<CvLink> cvLinks) {
		this.cvLinkDao.saveAll(cvLinks);
		return new SuccessResult("Link eklendi");
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuccessDataResult<List<CvLink>> getByCandidateId(int id) {

		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getByCandidateId(id), null);
	}

	

}
