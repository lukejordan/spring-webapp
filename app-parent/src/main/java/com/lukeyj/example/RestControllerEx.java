package com.lukeyj.example;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lukeyj.example.data.Controller;
import com.lukeyj.example.data.Job;
import com.lukeyj.example.data.Person;

@RestController
public class RestControllerEx {

	private static Logger LOGGER = Logger.getLogger(Example.class.getName());
	
	  @RequestMapping(value = "/service/test", method = RequestMethod.GET)
	   public @ResponseBody Person testService(ModelMap model) {
		  
	      LOGGER.info("In test service");
	      
	      Person person = new Person ();
	      
	      person.setAge(21);
	      person.setFirstName("First1");
	      person.setLastName("Last3");

	      Job job = new Job();
	      job.setCompany("company2");
	      job.setRole("role1");
	      
	      person.setJob(job);
	      
	      //model.addAttribute("message", "Hello Spring MVC Framework!");

	      return person;
	   }
	  
	  @RequestMapping(value = "/service/testMultiple", method = RequestMethod.GET)
	   public @ResponseBody List testService2(ModelMap model) {
		  
	      LOGGER.info("In test multiple service");
	   
	      List<Person> people = new ArrayList<Person> ();
	      
	      Person person = new Person ();
	      
	      person.setAge(21);
	      person.setFirstName("First1");
	      person.setLastName("Last3");

	      Job job = new Job();
	      job.setCompany("company2");
	      job.setRole("role1");
	      
	      person.setJob(job);
	      


	      
	      Person person2 = new Person ();
	      
	      person2.setAge(25);
	      person2.setFirstName("Frank");
	      person2.setLastName("Smith");

	      Job job2 = new Job();
	      job2.setCompany("Mountain View");
	      job2.setRole("bigwig");
	      
	      person2.setJob(job2);
	      
	      people.add(person);
	      people.add(person2);
	      //model.addAttribute("message", "Hello Spring MVC Framework!");

	      return people;
	   }
	  //@RequestBody
	  @RequestMapping(value = "/service/testPost", method = RequestMethod.POST)
	   public ResponseEntity testSubmit(@ModelAttribute Controller controller) {
		  
	      LOGGER.info("test submiteed");
	      LOGGER.info("key: " + controller.getKey());
	      
//	      List<Person> people = new ArrayList<Person> ();
//	      
	      Person person = new Person ();
	      
	      person.setAge(21);
	      person.setFirstName("First1");
	      person.setLastName("Last3");

	      Job job = new Job();
	      job.setCompany("company2");
	      job.setRole("role1");
	      
	      person.setJob(job);
	      
//
//
//	      
//	      Person person2 = new Person ();
//	      
//	      person2.setAge(25);
//	      person2.setFirstName("Frank");
//	      person2.setLastName("Smith");
//
//	      Job job2 = new Job();
//	      job2.setCompany("Bleeh");
//	      job2.setRole("bigwig");
//	      
//	      person2.setJob(job2);
//	      
//	      people.add(person);
//	      people.add(person2);
//	      //model.addAttribute("message", "Hello Spring MVC Framework!");
	      
	      URI location = URI.create("http://localhost/moo");
	     
	      HttpHeaders responseHeaders = new HttpHeaders();
	      responseHeaders.setLocation(location);
	      responseHeaders.set("MyResponseHeader", "MyValue");
	      
	      ResponseEntity response = new ResponseEntity<Person>(person, responseHeaders, HttpStatus.NOT_FOUND);
	      
	      return response;
	   }
	  
}
