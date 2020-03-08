/**
 * Basic class that demonstrates the relationship 
 * between this Java object and the connected database's entity
 * @author Benjamin Porter
 */

package porter.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kennel")
public class Kennel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "breed")
	private String breed;
	
	@Column(name = "isLicensed")
	private boolean isLicensed;
	
	// Super constructor
	public Kennel() {
		
	}

	// Constructor method
	public Kennel(String name, String breed, boolean isLicensed) {
		this.name = name;
		this.breed = breed;
		this.isLicensed = isLicensed;
	}

	// Getter, setter, and toString methods, used for debugging  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isLicensed() {
		return isLicensed;
	}

	public void setLicensed(boolean isLicensed) {
		this.isLicensed = isLicensed;
	}

	@Override
	public String toString() {
		return "Kennel [id=" + id + ", name=" + name + ", breed=" + breed + ", isLicensed=" + isLicensed + "]";
	}
}
