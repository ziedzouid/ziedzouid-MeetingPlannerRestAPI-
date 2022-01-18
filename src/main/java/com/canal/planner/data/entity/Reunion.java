package com.canal.planner.data.entity;

public class Reunion {

	private String name;
	private MeetingType type;
	private Integer personNb;
	private Creneau planing;

	public Reunion() {
		// TODO Auto-generated constructor stub
	}

	public Reunion(String name, MeetingType type, Integer personNb, Creneau planing) {
		super();
		this.name = name;
		this.type = type;
		this.personNb = personNb;
		this.planing = planing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MeetingType getType() {
		return type;
	}

	public void setType(MeetingType type) {
		this.type = type;
	}

	public Integer getPersonNb() {
		return personNb;
	}

	public void setPersonNb(Integer personNb) {
		this.personNb = personNb;
	}

	public Creneau getPlaning() {
		return planing;
	}

	public void setPlaning(Creneau planing) {
		this.planing = planing;
	}

	@Override
	public String toString() {
		return "Reunion [name=" + name + ", type=" + type + ", personNb=" + personNb + ", planing=" + planing + "]";
	}

}
