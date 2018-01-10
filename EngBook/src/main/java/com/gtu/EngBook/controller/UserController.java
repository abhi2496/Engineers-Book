package com.gtu.EngBook.controller;

import com.gtu.EngBook.model.StudentModel;
import com.gtu.EngBook.model.UserModel;
import com.gtu.EngBook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(value="/user")
public class UserController
{

	@Autowired
	UserService userService;

	@RequestMapping(value="/register/student")
	public Map<String, Object> studentregister(@RequestBody Map<String, Object> req)
	{
		StudentModel studentModel=new StudentModel();
		UserModel userModel=new UserModel();
		studentModel.setEnroll_no(Long.parseLong( req.get("enroll").toString()));

		userModel.setFname(req.get("fname").toString());
		userModel.setLname(req.get("lname").toString());
		userModel.setGender(Integer.parseInt(req.get("gender").toString()));
//		userModel.getDob((Date)(req.get("dob")));

		String addr = req.get("addr").toString();
		long contact = (long) req.get("fname");
		String email = req.get("email").toString();
		String dept = req.get("dept").toString();
		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		int yop= (int) req.get("yop");
		String pass = req.get("pass").toString();

		boolean result=userService.studentRegister(studentModel);




		return req;
	}
	
	@RequestMapping(value="/register/faculty")
	public Map<String, Object> facultyregister(@RequestBody Map<String, Object> req)
	{
		String enroll = req.get("enroll").toString();
		String fname = req.get("fname").toString();
		String lname = req.get("lname").toString();
		boolean gender=(Boolean)req.get("gender");
		long dob=(long) req.get("dob");
		String addr = req.get("addr").toString();
		long contact = (long) req.get("fname");
		String email = req.get("email").toString();
		String dept = req.get("dept").toString();
		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		String pass = req.get("pass").toString();

		return req;
	}
	
	@RequestMapping(value="/register/hod")
	public Map<String, Object> hodregister(@RequestBody Map<String, Object> req)
	{
		String enroll = req.get("enroll").toString();
		String fname = req.get("fname").toString();
		String lname = req.get("lname").toString();
		boolean gender=(Boolean)req.get("gender");
		long dob=(long) req.get("dob");
		String addr = req.get("addr").toString();
		long contact = (long) req.get("fname");
		String email = req.get("email").toString();
		String dept = req.get("dept").toString();
		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		String pass = req.get("pass").toString();

		return req;
	}
	
	@RequestMapping(value="/register/principal")
	public Map<String, Object> principalregister(@RequestBody Map<String, Object> req)
	{
		String fname = req.get("fname").toString();
		String lname = req.get("lname").toString();
		boolean gender=(Boolean)req.get("gender");
		String website = req.get("website").toString();
		String tponame = req.get("tponame").toString();
		long tponumber = (long)req.get("tponumber");
		long dob=(long) req.get("dob");
		String addr = req.get("addr").toString();
		long contact = (long) req.get("fname");
		String email = req.get("email").toString();
		String col = req.get("col").toString();
		String univ = req.get("univ").toString();
		String pass = req.get("pass").toString();

		return req;
	}
	
	@RequestMapping(value="/register/chancellor")
	public Map<String, Object> chancellorregister(@RequestBody Map<String, Object> req)
	{
		String fname = req.get("fname").toString();
		String lname = req.get("lname").toString();
		String univname = req.get("univname").toString();
		String univwebsite = req.get("univwebsite").toString();
		boolean gender=(Boolean)req.get("gender");
		long dob=(long) req.get("dob");
		String addr = req.get("addr").toString();
		long contact = (long) req.get("fname");
		String email = req.get("email").toString();
		String pass = req.get("pass").toString();

		return req;
	}

	@RequestMapping(value="/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> req)
	{
		UserModel um=new UserModel();
		um.setPassword(req.get("password").toString());
		um.setEmail(req.get("email").toString());

		userService.login(um);

		return req;
	}

}
