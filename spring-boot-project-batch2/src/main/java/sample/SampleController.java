package sample;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class SampleController {
	@GetMapping
	public String welcome() {
		return "Welcome to spring boot application";
	}
	@GetMapping("/{data}/{value}")
	public String getMethodWithParameter(@PathVariable String data, @PathVariable int value) {
		return "the value is  :  "+data+" and int = "+value;
	}
	@PostMapping
	public String postMethod() {
		return "this is post mapping";
	}
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer cust) {
		return cust;
	}
	@PutMapping
	public String putMethod() {
		return "this is put mapping";
	}
	@DeleteMapping
	public String deleteMethod() {
		return "this is delete mapping";
	}
	
}
