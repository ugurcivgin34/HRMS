package JavaKampProje.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import JavaKampProje.hrms.entities.concretes.Candidate;
import JavaKampProje.hrms.entities.concretes.CvExperience;
import JavaKampProje.hrms.entities.concretes.CvLanguage;
import JavaKampProje.hrms.entities.concretes.CvLink;
import JavaKampProje.hrms.entities.concretes.CvPhoto;
import JavaKampProje.hrms.entities.concretes.CvSchool;
import JavaKampProje.hrms.entities.concretes.ProgramingTechnologie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	@JsonIgnore()
	private Candidate candidate;
	private List<CvExperience> cvExperiences;
	private List<CvLanguage> cvLanguages;
	private List<CvLink> cvLinks;
	private List<CvPhoto> cvPhotos;
	private List<CvSchool> cvSchools;
	private List<ProgramingTechnologie> programingTechnologies;
}
