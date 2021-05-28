package JavaKampProje.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.business.abstracts.UserService;
import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.core.utilities.SuccessDataResult;
import JavaKampProje.hrms.dataAccess.Userdao;
import JavaKampProje.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	private Userdao userdao;
	
	
	public UserManager(Userdao userdao) {
		super();
		this.userdao = userdao;
	}


	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userdao.findAll(),"Kişiler listelendi");
	}

}
