package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.ProgramingTechnologieService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.ProgramingTechnologieDao;
import JavaKampProje.hrms.entities.concretes.ProgramingTechnologie;

@Service
public class ProgramingTechnologieManager implements ProgramingTechnologieService {
	ProgramingTechnologieDao programingTechnologieDao;
	
	@Autowired
	public ProgramingTechnologieManager(ProgramingTechnologieDao programingTechnologieDao) {
		
		this.programingTechnologieDao = programingTechnologieDao;
	}

	@Override
	public Result add(ProgramingTechnologie programingTechnologie) {
		this.programingTechnologieDao.save(programingTechnologie);
		return new SuccessResult("Program Dili eklendi");
	}
	@Override
	public Result addAll(List<ProgramingTechnologie> programingTechnologies) {
		this.programingTechnologieDao.saveAll(programingTechnologies);
		return new SuccessResult("Program Dili eklendi");
	}
	
	@Override
	public DataResult<List<ProgramingTechnologie>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
