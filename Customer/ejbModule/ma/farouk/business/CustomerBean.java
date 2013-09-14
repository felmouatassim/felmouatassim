package ma.farouk.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ma.farouk.entity.Customer;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless(mappedName="CustomerBean")
public class CustomerBean implements ICustomer {
	@PersistenceContext(unitName="OracleDB")
	EntityManager em;
	
	public Customer getCustomer(int id){
		
		Customer cust = em.find(Customer.class, id);
		return cust;
		
	}
	public void deleteCustomer(int id){
		
		Customer cust = em.find(Customer.class, id);
		em.remove(cust);
		
	}
	public void addCustomer(String firstName, String lastName, String country){
		
		Customer cust = new Customer(firstName, lastName, country);
		em.persist(cust);
	}
	public List<Customer> getAllCustomers(){
		
		Query q = em.createQuery("select p from "+Customer.class.getName()+" p");
		List<Customer> list = q.getResultList();
		return list;
		
	}

    /**
     * Default constructor. 
     */
    public CustomerBean() {
        // TODO Auto-generated constructor stub
    }

}
