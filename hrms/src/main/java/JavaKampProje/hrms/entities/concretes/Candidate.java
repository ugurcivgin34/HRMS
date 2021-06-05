package JavaKampProje.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User {

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "candidate")
	private List<CvLanguage> cvLanguages;

	@OneToMany(mappedBy = "candidate")
	private List<CvSchool> cvSchools;

	@OneToMany(mappedBy = "candidate")
	private List<CvExperience> cvExperiences;

	@OneToMany(mappedBy = "candidate")
	private List<CvLink> cvLinks;

	@OneToMany(mappedBy = "candidate")

	private List<CvPhoto> cvPhotos;

	@OneToMany(mappedBy = "candidate")
	private List<ProgramingTechnologie> programingTechnologies;
}
