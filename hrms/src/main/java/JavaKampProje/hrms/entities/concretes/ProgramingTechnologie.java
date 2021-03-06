package JavaKampProje.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programing_technologies")
public class ProgramingTechnologie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "programing_id")
	private int programingId;
	
//	@Column(name = "candidate_id")
//	private int candidateId;
	
	@Column(name = "programing_technology_name")
	private String programingTechnologyName;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
