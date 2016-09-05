package model.pojo;
// Generated Sep 5, 2016 6:56:12 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,schema="public"
)
public class Customer  implements java.io.Serializable {


     private int customerId;
     private String name;
     private String telNumber;
     private Set<Order> orders = new HashSet<Order>(0);

    public Customer() {
    }

	
    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    public Customer(int customerId, String name, String telNumber, Set<Order> orders) {
       this.customerId = customerId;
       this.name = name;
       this.telNumber = telNumber;
       this.orders = orders;
    }
   
     @Id 

    
    @Column(name="customer_id", unique=true, nullable=false)
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    
    @Column(name="name", nullable=false, length=80)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="tel_number", length=80)
    public String getTelNumber() {
        return this.telNumber;
    }
    
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }




}

