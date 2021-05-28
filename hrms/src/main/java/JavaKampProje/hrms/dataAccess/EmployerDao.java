package JavaKampProje.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer findByEmailEquals(String email);
	Employer findByWebAdresEquals(String webAdres);
}
