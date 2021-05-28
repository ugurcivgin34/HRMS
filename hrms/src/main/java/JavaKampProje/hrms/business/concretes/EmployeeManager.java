package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.EmployeeService;
import JavaKampProje.hrms.business.abstracts.EmployerService;
import JavaKampProje.hrms.core.adapters.abstracts.EmailValidationService;
import JavaKampProje.hrms.core.adapters.abstracts.EmployeeValidationService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.ErrorResult;
import JavaKampProje.hrms.core.utilities.Result;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.core.utilities.SuccessResult;
import JavaKampProje.hrms.dataAccess.EmployeeDao;
import JavaKampProje.hrms.dataAccess.EmployerDao;
import JavaKampProje.hrms.entities.concretes.Employee;
import JavaKampProje.hrms.entities.concretes.Employer;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(),"Çalışanlar listelendi");
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan eklendi");
	}
	
	
	

}
