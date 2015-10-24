package com.lukeyj.example;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class Example {

	private static Logger LOGGER = Logger.getLogger(Example.class.getName());
	
	  @RequestMapping(method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
		  
	      LOGGER.info("We are in the method");
	      
	      
	      model.addAttribute("message", "Hello Spring MVC Framework!");

	      return "/view/hello";
	   }
}
