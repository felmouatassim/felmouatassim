package ma.farouk.business;

import java.util.List;

import javax.ejb.Remote;

import ma.farouk.entity.Customer;

@Remote
public interface ICustomer {
	
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);
	public void addCustomer(String firstName, String lastName, String country);
	public List<Customer> getAllCustomers();

}
