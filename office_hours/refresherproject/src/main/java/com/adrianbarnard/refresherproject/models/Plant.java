package com.adrianbarnard.refresherproject.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="plants")
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name can't be empty.")
	@Size(min=1, max=255, message="Name cannot be more than 255 characters.")
	private String name; // Examples: rose, dahlia, oak
	
	@NotBlank(message="Color can't be empty.")
	@Size(min=1, max=255, message="Color cannot be more than 255 characters.")
	private String color;
	
	@NotNull(message="Must select whether the plant is a perennial.")
	private Boolean isPerennial;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date(); // NEW: Added by me
    }
	
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // Empty constructor
    public Plant() {
    }

    // Non-empty constructor - no ID or createdAt or updatedAt fields necessary
	public Plant(
			@NotBlank(message = "Name can't be empty.") @Size(min = 1, max = 255, message = "Name cannot be more than 255 characters.") String name,
			@NotBlank(message = "Color can't be empty.") @Size(min = 1, max = 255, message = "Color cannot be more than 255 characters.") String color,
			@NotNull(message = "Must select whether the plant is a perennial.") Boolean isPerennial) {
		this.name = name;
		this.color = color;
		this.isPerennial = isPerennial;
	}

	// Getters and setters 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getIsPerennial() {
		return isPerennial;
	}

	public void setIsPerennial(Boolean isPerennial) {
		this.isPerennial = isPerennial;
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
    
    
}
