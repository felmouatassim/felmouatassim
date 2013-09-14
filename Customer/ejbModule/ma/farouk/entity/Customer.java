package ma.farouk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "appUsersSeq", sequenceName = "APP_USERS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appUsersSeq")
	private int id;
	@Column(name = "FIRST_NAME")
	private String prenom;
	@Column(name = "LAST_NAME")
	private String nom;
	@Column(name = "COUNTRY")
	private String pays;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Customer() {
		super();
	}

	public Customer(String firstName, String lastName, String country) {
		super();

		this.nom = lastName;
		this.prenom = firstName;
		this.pays = country;
	}
}
