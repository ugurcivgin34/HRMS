package JavaKampProje.hrms.core.adapters.concretes;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.core.adapters.abstracts.EmployeeValidationService;
import JavaKampProje.hrms.entities.concretes.Employer;

@Service
public class EmployeeValidationManager implements EmployeeValidationService {

	@Override
	public boolean isValidatedByEmployee(Employer employer) {
		System.out.println(employer.getCompanyName() + " adlı şirket sistem çalışanları tarafından onaylanmıştır.");
		return true;
	}
	
}