package com.akash.bookstore.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Order date is required")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "ordered_by", nullable = false)
    @NotNull(message = "Ordered by is required")
    private Buyer orderedBy;
    @Column(name = "city", nullable = false, length = 50)
    @NotEmpty(message = "City is required")
    private String city;
    @Column(name = "address", nullable = false, length = 100)
    @NotEmpty(message = "Address is required")
    private String address;
    @Column(name = "pin_code", nullable = false, length = 10)
    @NotEmpty(message = "Pin code is required")
    private String pinCode;
    @ManyToOne
    @JoinColumn(name = "last_managed_by", nullable = false)
    @NotNull(message = "Last managed by is required")
    private Executive lastManagedBy;
    @Column(name = "last_managed_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Last Manged date is required")
    private LocalDateTime lastMangedDate;
    @Column(name = "status", nullable = false)
    @NotEmpty(message = "Status is required")
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public Buyer getOrderedBy() {
		return orderedBy;
	}
	public void setOrderedBy(Buyer orderedBy) {
		this.orderedBy = orderedBy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Executive getLastManagedBy() {
		return lastManagedBy;
	}
	public void setLastManagedBy(Executive lastManagedBy) {
		this.lastManagedBy = lastManagedBy;
	}
	public LocalDateTime getLastMangedDate() {
		return lastMangedDate;
	}
	public void setLastMangedDate(LocalDateTime lastMangedDate) {
		this.lastMangedDate = lastMangedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order() {
		super();
	}

	
}
