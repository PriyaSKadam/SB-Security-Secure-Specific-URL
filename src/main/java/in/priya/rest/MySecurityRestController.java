package in.priya.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySecurityRestController {
	
	
	@GetMapping("/welcome")
	public String getdata()
	{
		return "Welcome to Priya IT";
	}
	
	@GetMapping("/greet")
	public String getGreetMsg()
	{
		return "Good Morning";
	}

}
