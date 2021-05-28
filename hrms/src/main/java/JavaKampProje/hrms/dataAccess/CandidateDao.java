package JavaKampProje.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JavaKampProje.hrms.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	Candidate findByEmailEquals(String email);
	Candidate findByIdentityNumberEquals(String identityNumber);
}
