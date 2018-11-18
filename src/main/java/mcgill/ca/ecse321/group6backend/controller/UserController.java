package mcgill.ca.ecse321.group6backend.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mcgill.ca.ecse321.group6backend.model.User;
import mcgill.ca.ecse321.group6backend.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserRepository uRepository;
	
	@RequestMapping("/")
	public String greeting() {
		return "Hello world!";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> createUser(
            @RequestParam("username") String userName
    ) throws JSONException {
        User user = uRepository.createUser(userName);
        if (user != null) {
            JSONObject json = new JSONObject();
            json.put("msg","data"+" " + userName + " created!");
            return new ResponseEntity<>(json.toString(), HttpStatus.OK);
        } else {
            JSONObject json = new JSONObject();
            json.put("msg","data" + " " + userName + " could not be created.");
            return new ResponseEntity<>(json.toString(), HttpStatus.CONFLICT);
        }
	}
	
	@RequestMapping(value = "/check/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable("name") String name) {
		User user = uRepository.getUser(name);
		return user;
	}
}
