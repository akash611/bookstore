package com.akash.bookstore.model;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@DiscriminatorValue("buyer")
public class Buyer extends User {
	@NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address cannot exceed 100 characters")
    @Column(name = "address", nullable = true, length = 100)
    private String address;

    @NotBlank(message = "City is required")
    @Size(max = 50, message = "City cannot exceed 50 characters")
    @Column(name = "city", nullable = true, length = 50)
    private String city;

    @NotBlank(message = "PIN code is required")
    @Size(max = 6, message = "PIN code cannot exceed 6 characters")
    @Column(name = "pincode", nullable = true, length = 6)
    private String pinCode;

	public Buyer() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
	
