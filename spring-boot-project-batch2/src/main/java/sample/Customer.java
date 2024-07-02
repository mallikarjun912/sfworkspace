package sample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	private int id;
	@Column(length = 50)
	private String name;
	@Column
	private double  commision;
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
	public double getCommision() {
		return commision;
	}
	public void setCommision(double commision) {
		this.commision = commision;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", commision=" + commision + "]";
	}
	
}
