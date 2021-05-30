package JavaKampProje.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_postings")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="job_details")
	private String jobDetails;
	
	@Column(name="min_wage")
	private double minWage;
	
	@Column(name="max_wage")
	private double maxWage;
	
	@Column(name="number_of_open_position")
	private int numberOfOpenPositions;
	
	@Column(name="last_apply_date")
	private LocalDate lastApplydate;
	
	@Column(name="is_open")
	private boolean isOpen;
	
	@Column(name="posted_date")
	private LocalDate postedDate;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	
	
	
	
}
