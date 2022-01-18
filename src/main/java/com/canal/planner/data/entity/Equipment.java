package com.canal.planner.data.entity;

import java.util.ArrayList;
import java.util.List;

public class Equipment {

	private String name;
	private Boolean availability;

	private List<Reunion> reunionList = new ArrayList<Reunion>();

	public Equipment() {
		// TODO Auto-generated constructor stub
	}

	public Equipment(String name, Boolean availability) {
		this.name = name;
		this.availability = availability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public List<Reunion> getReunionList() {
		return reunionList;
	}

	public void setReunionList(List<Reunion> reunionList) {
		this.reunionList = reunionList;
	}

	@Override
	public String toString() {
		return "Equipment [name=" + name + ", availability=" + availability + ", reunionList=" + reunionList + "]";
	}

}
