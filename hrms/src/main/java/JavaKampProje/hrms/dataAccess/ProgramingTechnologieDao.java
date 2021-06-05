package JavaKampProje.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import JavaKampProje.hrms.entities.concretes.ProgramingTechnologie;

public interface ProgramingTechnologieDao extends JpaRepository<ProgramingTechnologie, Integer>{

}
