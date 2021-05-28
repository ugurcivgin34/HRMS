package JavaKampProje.hrms.core.adapters.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import JavaKampProje.hrms.core.adapters.abstracts.FakeMernisService;

@Service
public class FakeMernisAdapter implements FakeMernisService {

	@Override
	public boolean checkUser(String identiyNumber, String firstName, String lastName) {
		if(identiyNumber.length()!= 11) {
			System.out.println("Tc kimlik numaranız 11 haneden büyük ve ya küçük.");
			return false;
		}
		if(firstName.length()<2 || lastName.length()<2) {
			System.out.println("Adınız ve ya soyadınız 2 karakterden küçük olamaz.");
			return false;
		}
		
		else {
				System.out.println("Mernis doğrulaması sağlandı.");
				return true;
		}
		
		
	}

}
