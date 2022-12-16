package com.adrianbarnard.manytomanydemo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @NotEmpty(message="City name cannot be empty.")
    @Size(min=2, max=255, message="City name must be 2-255 characters.")
    private String name;
    
    // OLD
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//    		name="cities_chains",
//    		joinColumns = @JoinColumn(name="city_id"),
//    		inverseJoinColumns = @JoinColumn(name="chain_id")
//    )
//    private List<Chain> chains;
    
    // NEW: Link to new middle table/model of Stores
    @OneToMany(mappedBy="city", fetch=FetchType.LAZY)
    private List<Store> stores;
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public City() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

//	public List<Chain> getChains() {
//		return chains;
//	}
//
//	public void setChains(List<Chain> chains) {
//		this.chains = chains;
//	}

}