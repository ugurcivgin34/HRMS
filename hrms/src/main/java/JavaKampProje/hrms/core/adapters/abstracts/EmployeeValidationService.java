package JavaKampProje.hrms.core.adapters.abstracts;

import JavaKampProje.hrms.entities.concretes.Employer;

public interface EmployeeValidationService {
	boolean isValidatedByEmployee(Employer employer);
}
