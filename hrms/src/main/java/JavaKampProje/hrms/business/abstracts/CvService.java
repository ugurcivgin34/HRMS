package JavaKampProje.hrms.business.abstracts;

import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.dtos.CvDto;

public interface CvService {
	Result add(CvDto cvDto,int id);
}
