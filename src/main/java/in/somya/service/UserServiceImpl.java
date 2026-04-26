package in.somya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.somya.binding.User;
import in.somya.repo.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean saveUser(User user) {
		User savedUser = userRepo.save(user);
		return savedUser!=null;
	}

	@Override
	public User loginUser(String email, String pwd) {		
		User user = userRepo.findByEmail(email);
		if(user != null && user.getPwd().equals(pwd)) {
			return user;
		}
		return null;
	}

}
