package ternary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplines")
public class Discipline {

	@Id
	@Column(name = "DiscId")
    private int discId;
	
	@Column(name = "Name")
    private String name;
	
	@Column(name = "Credits")
    private int credits;
    
    public Discipline() {}

    public Discipline(int discId, String name, int credits) {
    	this.discId = discId;
    	this.name = name;
        this.credits = credits;
    }

    public int getDiscId() {
        return discId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}