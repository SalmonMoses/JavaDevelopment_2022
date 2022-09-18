package me.salmonmoses;

import me.salmonmoses.core.Observable;

public class OrderModel {
	private String name = "";
	private String city = "";
	private String number = "";
	private String email = "";

	public Observable<Boolean> wantsMailing = new Observable<>(false);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
