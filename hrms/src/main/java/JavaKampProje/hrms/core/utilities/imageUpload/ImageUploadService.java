package JavaKampProje.hrms.core.utilities.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import JavaKampProje.hrms.core.utilities.DataResult;

public interface ImageUploadService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
