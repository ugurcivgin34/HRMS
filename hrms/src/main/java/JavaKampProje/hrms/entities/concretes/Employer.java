package JavaKampProje.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@Entity
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobPostings"})
public class Employer extends User {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adres")
	private String webAdres;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_activated_employer")
	private Boolean isActivatedEmployer;
	
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobPostings;
	
	@OneToOne(mappedBy = "employer")
	private CvExperience cvExperience;
}
