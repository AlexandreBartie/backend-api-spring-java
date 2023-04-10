package br.com.bartie.data;

import java.io.Serializable;

public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public Long id;
	public String firstName;
	public String lastName;
	public String address;
	public String gender;

}