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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_links")
public class CvLink {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_link_id")
	private int cvLinkId;
	
//	@Column(name = "candidate_id")
//	private int candidateId;
	
	@Column(name = "link_name")
	private String linkName;
	
	@ManyToOne()
	@JsonIgnore()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
