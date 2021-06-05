package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.entities.concretes.CvPhoto;
import JavaKampProje.hrms.entities.dtos.CvDto;

public interface CvPhotoService {
	DataResult<List<CvDto>> getAll();
	Result add(CvPhoto cvPhoto,MultipartFile imageFile);
	Result addAll(List<CvPhoto> cvPhotos);
	DataResult<List<CvPhoto>> getByCandidateId(int id);
}
