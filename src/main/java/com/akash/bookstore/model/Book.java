package com.akash.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Book {
    

    @Id
    @Column(name = "bookcode", nullable = false, length = 50)
    private String bookCode;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 100, message = "Author cannot exceed 100 characters")
    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @NotBlank(message = "Publisher is required")
    @Size(max = 100, message = "Publisher cannot exceed 100 characters")
    @Column(name = "publisher", nullable = false, length = 100)
    private String publisher;

    @NotNull(message = "Genre is required")
    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    @Column(name = "publication_year")
    private Integer publicationYear;
    
    @NotNull(message = "Priice is required")
    @Positive(message="Price Should be Positive")
    @Column(name = "price")
    private Integer price;
    
    @ManyToOne
    @JoinColumn(name = "added_by")
    private Executive addedBy;

    @Column(name = "addition_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime additionDate;

    @ManyToOne
    @JoinColumn(name = "last_modified_by")
    private Executive lastModifiedBy;

    @Column(name = "last_modification_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lastModificationDate;

	public Book() {
		super();
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Executive getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Executive addedBy) {
		this.addedBy = addedBy;
	}

	public LocalDateTime getAdditionDate() {
		return additionDate;
	}

	public void setAdditionDate(LocalDateTime additionDate) {
		this.additionDate = additionDate;
	}

	public Executive getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Executive lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}


    // Getters and setters
    
   
    
}