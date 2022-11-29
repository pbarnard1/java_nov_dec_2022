package com.adrianbarnard.week5startercode.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="halls")
public class Hall {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Hall name cannot be empty.")
	@Size(min=3, max=255, message="Hall name must be 3-255 characters.")
	private String name; // The name of the hall (e.g. "Kane Hall")
	
	@NotNull(message="Cannot leave floor count empty.")
	@Min(value=1, message="Must have at least 1 floor.")
	private Integer floors; // Number of floor
	
	@NotNull(message="Must select whether this hall has housing.")
	private Boolean isResidential; // Whether this hall has residents inside
	
	@NotNull(message="Must select whether this hall has lecture rooms.")
	private Boolean hasLectureRooms; // Whether the hall has lecture rooms

	// How do we connect to a University?
	
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
    
    // Add getters and setters here!
}
