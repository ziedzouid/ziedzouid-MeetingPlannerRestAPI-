package com.canal.planner.data.entity;

import java.util.ArrayList;
import java.util.List;

public class Salle {

	private String name;
	private Integer capacity;
	private Boolean screen;
	private Boolean speaker;
	private Boolean board;
	private Boolean webcam;

	private List<Reunion> reunionList = new ArrayList<Reunion>();

	public Salle() {
		// TODO Auto-generated constructor stub
	}

	public Salle(String name, Integer capacity, Boolean screen, Boolean speaker, Boolean board, Boolean webcam) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.screen = screen;
		this.speaker = speaker;
		this.board = board;
		this.webcam = webcam;
	}

	@Override
	public String toString() {
		return "Salle [name=" + name + ", capacity=" + capacity + ", screen=" + screen + ", speaker=" + speaker
				+ ", board=" + board + ", webcam=" + webcam + ", reunionList="
				+ reunionList + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getScreen() {
		return screen;
	}

	public void setScreen(Boolean screen) {
		this.screen = screen;
	}

	public Boolean getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Boolean speaker) {
		this.speaker = speaker;
	}

	public Boolean getBoard() {
		return board;
	}

	public void setBoard(Boolean board) {
		this.board = board;
	}

	public Boolean getWebcam() {
		return webcam;
	}

	public void setWebcam(Boolean webcam) {
		this.webcam = webcam;
	}

	public List<Reunion> getReunionList() {
		return reunionList;
	}

	public void setReunionList(List<Reunion> reunionList) {
		this.reunionList = reunionList;
	}

}
