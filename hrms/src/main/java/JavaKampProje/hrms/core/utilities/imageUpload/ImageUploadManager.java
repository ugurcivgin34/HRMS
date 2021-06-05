package JavaKampProje.hrms.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorDataResult;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService{
	
	private Cloudinary cloudinary;
	
	public ImageUploadManager() {
		this.cloudinary=new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "db2sxwv2z",
				"api_key", "858515998929197",
				"api_secret", "v88NbrIVGAo-x_U0n0TBmSXaJjQ"
				
				));
	}
	
	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

}
