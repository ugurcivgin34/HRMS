package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;

import JavaKampProje.hrms.entities.concretes.ProgramingTechnologie;

public interface ProgramingTechnologieService {
	Result add(ProgramingTechnologie programingTechnologie);
	Result addAll(List<ProgramingTechnologie> programingTechnologies) ;
    DataResult<List<ProgramingTechnologie>> getAll();
}
