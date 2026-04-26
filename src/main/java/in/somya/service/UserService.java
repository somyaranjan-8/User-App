package in.somya.service;

import in.somya.binding.User;

public interface UserService {
		
	public boolean saveUser(User user);
	public User loginUser(String email , String pwd);
}
