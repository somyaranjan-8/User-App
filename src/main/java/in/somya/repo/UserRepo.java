package in.somya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.somya.binding.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
}
