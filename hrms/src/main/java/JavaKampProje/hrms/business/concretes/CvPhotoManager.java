package JavaKampProje.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import JavaKampProje.hrms.business.abstracts.CvPhotoService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.core.utilities.imageUpload.ImageUploadService;
import JavaKampProje.hrms.dataAccess.CvPhotoDao;
import JavaKampProje.hrms.entities.concretes.CvPhoto;
import JavaKampProje.hrms.entities.dtos.CvDto;

@Service
public class CvPhotoManager implements CvPhotoService {
	private CvPhotoDao cvPhotoDao;
	private ImageUploadService photoUploadService;
	
	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao,ImageUploadService photoUploadService) {
		
		this.cvPhotoDao = cvPhotoDao;
		this.photoUploadService=photoUploadService;
	}

	

	@Override
	public Result addAll(List<CvPhoto> cvPhotos) {
		this.cvPhotoDao.saveAll(cvPhotos);
		return new SuccessResult("Foto eklendi");
	}

	@Override
	public DataResult<List<CvDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(CvPhoto cvPhoto, MultipartFile imageFile) {
		Map<String, String> uploadImage= this.photoUploadService.uploadImageFile(imageFile).getData();
		cvPhoto.setPhoto(uploadImage.get("photo"));
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Cv foto eklendi");
	}

	@Override
	public DataResult<List<CvPhoto>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CvPhoto>>(this.cvPhotoDao.getByCandidateId(id),"Foto listelendi");
	}

	

}
