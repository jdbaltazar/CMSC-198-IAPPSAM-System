package com.iappsam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Contact_ID")
	private int contactID;

	@Column(name = "Data")
	private String data;

	@Column(name = "Contact_Type")
	private ContactType contactType;

	// @ManyToOne
	// @JoinTable(name = "Person_Contact", joinColumns = @JoinColumn(name =
	// "Contact_ID"), inverseJoinColumns = @JoinColumn(name = "Person_ID"))
	// private Person person;

	public Contact() {
		super();
	}

	public Contact(String data, ContactType contactType) {
		super();
		this.data = data;
		this.contactType = contactType;
	}

	public int getContactID() {
		return contactID;
	}

	public String getData() {
		return data;
	}

	public ContactType getType() {
		return contactType;
	}

	// public Person getPerson() {
	// return person;
	// }
	//
	// public void setPerson(Person person) {
	// this.person = person;
	// }

	public void setId(int contactID) {
		this.contactID = contactID;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setType(ContactType type) {
		this.contactType = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactType != other.contactType)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
}
