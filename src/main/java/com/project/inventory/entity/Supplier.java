package com.project.inventory.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "suppliers")
public class Supplier {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;
private String contactInfo;


// getters & setters
public Supplier() {}


public Long getId() { return id; }
public void setId(Long id) { this.id = id; }


public String getName() { return name; }
public void setName(String name) { this.name = name; }


public String getContactInfo() { return contactInfo; }
public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
