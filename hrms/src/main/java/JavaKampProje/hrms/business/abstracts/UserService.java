package JavaKampProje.hrms.business.abstracts;

import java.util.List;

import JavaKampProje.hrms.core.utilities.DataResult;
import JavaKampProje.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
}
