package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.JobPostingService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.JobPostingDao;
import JavaKampProje.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {
	private JobPostingDao jobPostingDao;

	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if (!CheckIfNullField(jobPosting)) {
			return new ErrorResult("Eksik bilgi girdiniz.Lütfen tüm bilgileri giriniz");
		} else {
			this.jobPostingDao.save(jobPosting);
			return new SuccessResult("İş ilanı eklendi");
		}

	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(), "Listelendi");
	}

	@Override
	public Result delete(int id) {
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByisOpenTrue() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByisOpenTrue(),
				"Tüm aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByisOpenTrueAndEmployer_companyName(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(
				this.jobPostingDao.getByisOpenTrueAndEmployer_companyName(companyName),
				"Bir firmaya ait olan aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getByisOpenTrueOrderByPostedDate() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByisOpenTrueOrderByPostedDate(),
				"Tarihe göre sıralandı");
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getOne(id));
	}

	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new SuccessResult("Böyle bir iş ilanı yok");
		}
		if (getById(id).getData().isOpen() == false) {
			return new SuccessResult("Zaten bu iş ilanı kapalı");
		}

		// update(getById(id).getData().setOpen(false));
		JobPosting jobPosting = getById(id).getData();
		jobPosting.setOpen(false);
		update(jobPosting);
		return new SuccessResult("İş ilanı kapatıldı");

	}

	private boolean CheckIfNullField(JobPosting jobPosting) {
		if (jobPosting.getJobPosition() != null && jobPosting.getJobDetails() != null && jobPosting.getCity() != null
				&& jobPosting.getNumberOfOpenPositions() != 0) {
			return true;
		}
		return false;
	}

}
