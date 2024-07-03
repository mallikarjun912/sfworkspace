package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerRepo repo;
	
	@Autowired
	CustomerService service;
		
	@PostMapping
	public String addCustomer(@RequestBody Customer cust) {
		repo.save(cust);
		return "customer added successfully";
	}
	
	@PostMapping("/customerinfo")
	public String addCustomerDetails(@RequestBody CustomerDto dto) {
		String str = service.addCustomerInfo(dto);
		return str;
	}
	
	
}
