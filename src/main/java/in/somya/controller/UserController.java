package in.somya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.somya.binding.User;
import in.somya.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		boolean status = userService.saveUser(user);
		if(status) {
			return new ResponseEntity<>("User Saved" , HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Registration Failed" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	    @PostMapping("/login")
	    public ResponseEntity<?> loginUser(@RequestBody User user){

	        User validUser = userService.loginUser(user.getEmail() , user.getPwd());

	        if(validUser != null){
	            return ResponseEntity.ok(validUser);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                                 .body("Invalid Email or Password");
	        }
	    }
	}

