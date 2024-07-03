package sample;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepo custRepo;
	@Autowired 
	AddessRepo addrRepo;
	
	@Transactional
	public String addCustomerInfo(CustomerDto dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setCommision(dto.getCommision());
		custRepo.save(customer);
		
		if(dto.getCity().isBlank())
				throw new RuntimeException("city should not be empty");
		Address address = new Address();
		address.setStreet(dto.getStreet());
		address.setCity(dto.getCity()); 
		address.setCustomerId(customer.getId()); 
		addrRepo.save(address) ;
		return "inserted";
	}
}
