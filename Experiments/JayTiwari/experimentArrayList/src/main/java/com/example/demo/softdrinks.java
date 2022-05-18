package com.example.demo;

public class softdrinks {

	private String name;

	private String colour;

	public softdrinks() {

	}

	public softdrinks(String name, String colour) {
		this.name = name;
		this.colour = colour;
	}

	public String getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getcolour() {
		return this.colour;
	}

	public void setcolour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return name;
	}

}
