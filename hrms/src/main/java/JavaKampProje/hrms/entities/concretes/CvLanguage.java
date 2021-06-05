package JavaKampProje.hrms.entities.concretes;

import lombok.AllArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvLanguage"})
public class CvLanguage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_languages_id")
	private int cvLanguagesId;

//	@Column(name = "languages_id")
//	private int languagesId;
	
//	@Column(name="candidate_id")
//	private int candidateId;
	
	@Min(1)
	@Max(5)
	@Column(name="level")
	private int level;
	
	@Column(name="language")
	private String language;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
