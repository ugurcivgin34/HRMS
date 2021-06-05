package JavaKampProje.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cv_experience")
public class CvExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_experience_id")
	private int cvExperienceId;

//	@Column(name="candidate_id")
//	private int candidateId;
	
//	@Column(name="employer_id")
//	private int employerId;
	
	@Column(name="other_company")
	private String otherCompany;
	
	@Column(name="begining_date")
	private LocalDate beginingDate;
	
	@Column(name="ending_date")
	private LocalDate endinDate;
	
	@Column(name="cv_experience_name")
	private String cvExperienceName;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	@OneToOne()
	@JsonIgnore()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
}
