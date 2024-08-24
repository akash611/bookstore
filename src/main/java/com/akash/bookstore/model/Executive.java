package com.akash.bookstore.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("executive")
public class Executive extends User {

}
