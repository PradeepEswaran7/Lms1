package com.example.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.dao.FacultyRepository;
import com.example.lms.dao.UserRepository;
import com.example.lms.model.Faculty;
import com.example.lms.model.User;

@Service
public class FacultyService {
	@Autowired
    private FacultyRepository facultyRepository;
	
	 public String loginFaculty(Faculty faculty) {
	        try {
	            Faculty existingFaculty = facultyRepository.findByEmail(faculty.getEmail());

	            if (existingFaculty != null && existingFaculty.getPassword().equals(faculty.getPassword())) {
	                // Login successful
	                return "Login successful!";
	            } else {
	                // User not found or incorrect password
	                return "Invalid credentials!";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Login unsuccessful!";
	        }
	    }
	
	 public List<Faculty> getAllFaculty() {
	    	return facultyRepository.findAll();
	    }
	 public int getFauIdByEmail(String email) {
	        Faculty faulty = facultyRepository.findByEmail(email);
	        return faulty != null ? faulty.getFaculty_id():-1; // Return -1 or some default value if user not found
	    }
}
