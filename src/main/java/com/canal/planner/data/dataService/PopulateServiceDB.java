package com.canal.planner.data.dataService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.canal.planner.data.entity.Creneau;
import com.canal.planner.data.entity.Equipment;
import com.canal.planner.data.entity.MeetingType;
import com.canal.planner.data.entity.Reunion;
import com.canal.planner.data.entity.Salle;

@Component
public class PopulateServiceDB {

	private List<Reunion> meetings;
	private List<Salle> rooms;
	private List<Equipment> extraScreens;
	private List<Equipment> extraSpeakers;
	private List<Equipment> extraWebcams;
	private List<Equipment> extraBoards;

	//alimenter les tableaux avec les données fournies 
	@PostConstruct
	private void init() {
		this.meetings = populateReunion();
		this.rooms = populateSalle();
		this.extraScreens = poulateExtraScreen();
		this.extraSpeakers = poulateExtraSpeaker();
		this.extraWebcams = poulateExtraWebcam();
		this.extraBoards = poulateExtraBoard();
	}

	public List<Reunion> populateReunion() {

		List<Reunion> reunions = new ArrayList<Reunion>();

		Creneau planingA = new Creneau("planingA", 8, 9);
		Creneau planingB = new Creneau("planingB", 9, 10);
		Creneau planingC = new Creneau("planingC", 10, 11);
		Creneau planingD = new Creneau("planingD", 11, 12);

		Reunion reunion1 = new Reunion("reunion1", MeetingType.VC, 8, planingB);
		Reunion reunion2 = new Reunion("reunion2", MeetingType.VC, 6, planingB);
		Reunion reunion3 = new Reunion("reunion3", MeetingType.RC, 4, planingD);
		Reunion reunion4 = new Reunion("reunion4", MeetingType.RS, 2, planingD);
		Reunion reunion5 = new Reunion("reunion5", MeetingType.SPEC, 9, planingD);
		Reunion reunion6 = new Reunion("reunion6", MeetingType.RC, 7, planingB);
		Reunion reunion7 = new Reunion("reunion7", MeetingType.VC, 9, planingA);
		Reunion reunion8 = new Reunion("reunion8", MeetingType.SPEC, 10, planingA);
		Reunion reunion9 = new Reunion("reunion9", MeetingType.SPEC, 5, planingB);

		Reunion reunion10 = new Reunion("reunion10", MeetingType.RS, 4, planingB);
		Reunion reunion11 = new Reunion("reunion11", MeetingType.RC, 8, planingB);
		Reunion reunion12 = new Reunion("reunion12", MeetingType.VC, 12, planingD);
		Reunion reunion13 = new Reunion("reunion13", MeetingType.SPEC, 5, planingD);
		Reunion reunion14 = new Reunion("reunion14", MeetingType.VC, 3, planingA);
		Reunion reunion15 = new Reunion("reunion15", MeetingType.SPEC, 2, planingA);
		Reunion reunion16 = new Reunion("reunion16", MeetingType.VC, 12, planingA);
		Reunion reunion17 = new Reunion("reunion17", MeetingType.VC, 6, planingC);
		Reunion reunion18 = new Reunion("reunion18", MeetingType.RS, 2, planingD);
		Reunion reunion19 = new Reunion("reunion19", MeetingType.RS, 4, planingB);
		Reunion reunion20 = new Reunion("reunion20", MeetingType.RC, 7, planingB);

		reunions.add(reunion1);
		reunions.add(reunion2);
		reunions.add(reunion3);
		reunions.add(reunion4);
		reunions.add(reunion5);
		reunions.add(reunion6);
		reunions.add(reunion7);
		reunions.add(reunion8);
		reunions.add(reunion9);
		reunions.add(reunion10);
		reunions.add(reunion11);
		reunions.add(reunion12);
		reunions.add(reunion13);
		reunions.add(reunion14);
		reunions.add(reunion15);
		reunions.add(reunion16);
		reunions.add(reunion17);
		reunions.add(reunion18);
		reunions.add(reunion19);
		reunions.add(reunion20);

		return reunions;

	}

	public List<Salle> populateSalle() {

		List<Salle> salles = new ArrayList<Salle>();

		Salle salle1 = new Salle("E1001", 23, false, false, false, false);
		Salle salle2 = new Salle("E1002", 10, true, false, false, false);
		Salle salle3 = new Salle("E1003", 8, false, true, false, false);
		Salle salle4 = new Salle("E1004", 4, false, false, true, false);
		Salle salle5 = new Salle("E2001", 4, false, false, false, false);
		Salle salle6 = new Salle("E2002", 15, true, false, false, true);
		Salle salle7 = new Salle("E2003", 7, false, false, false, false);
		Salle salle8 = new Salle("E2004", 9, false, false, true, false);
		Salle salle9 = new Salle("E3001", 13, true, true, false, true);
		Salle salle10 = new Salle("E3002", 8, false, false, false, false);
		Salle salle11 = new Salle("E3003", 9, true, true, false, false);
		Salle salle12 = new Salle("E3004", 4, false, false, false, false);

		salles.add(salle1);
		salles.add(salle2);
		salles.add(salle3);
		salles.add(salle4);
		salles.add(salle5);
		salles.add(salle6);
		salles.add(salle7);
		salles.add(salle8);
		salles.add(salle9);
		salles.add(salle10);
		salles.add(salle11);
		salles.add(salle12);

		return salles;

	}

	public List<Equipment> poulateExtraSpeaker() {

		List<Equipment> extraSpeakers = new ArrayList<Equipment>();

		Equipment extraSpeaker1 = new Equipment("Speaker", true);
		Equipment extraSpeaker2 = new Equipment("Speaker", true);
		Equipment extraSpeaker3 = new Equipment("Speaker", true);
		Equipment extraSpeaker4 = new Equipment("Speaker", true);

		extraSpeakers.add(extraSpeaker1);
		extraSpeakers.add(extraSpeaker2);
		extraSpeakers.add(extraSpeaker3);
		extraSpeakers.add(extraSpeaker4);

		return extraSpeakers;

	}

	public List<Equipment> poulateExtraScreen() {

		List<Equipment> extraScreens = new ArrayList<Equipment>();

		Equipment extraScreen1 = new Equipment("Screen", true);
		Equipment extraScreen2 = new Equipment("Screen", true);
		Equipment extraScreen3 = new Equipment("Screen", true);
		Equipment extraScreen4 = new Equipment("Screen", true);
		Equipment extraScreen5 = new Equipment("Screen", true);

		extraScreens.add(extraScreen1);
		extraScreens.add(extraScreen2);
		extraScreens.add(extraScreen3);
		extraScreens.add(extraScreen4);
		extraScreens.add(extraScreen5);

		return extraScreens;

	}

	public List<Equipment> poulateExtraWebcam() {

		List<Equipment> extraWebcams = new ArrayList<Equipment>();

		Equipment extraWebcam1 = new Equipment("Webcam", true);
		Equipment extraWebcam2 = new Equipment("Webcam", true);
		Equipment extraWebcam3 = new Equipment("Webcam", true);
		Equipment extraWebcam4 = new Equipment("Webcam", true);

		extraWebcams.add(extraWebcam1);
		extraWebcams.add(extraWebcam2);
		extraWebcams.add(extraWebcam3);
		extraWebcams.add(extraWebcam4);

		return extraWebcams;

	}

	public List<Equipment> poulateExtraBoard() {

		List<Equipment> extraBoards = new ArrayList<Equipment>();

		Equipment extraBoard1 = new Equipment("Board", true);
		Equipment extraBoard2 = new Equipment("Board", true);

		extraBoards.add(extraBoard1);
		extraBoards.add(extraBoard2);

		return extraBoards;
	}

	public List<Reunion> getMeetings() {
		return meetings;
	}

	public void setMeetings(List<Reunion> meetings) {
		this.meetings = meetings;
	}

	public List<Salle> getRooms() {
		return rooms;
	}

	public void setRooms(List<Salle> rooms) {
		this.rooms = rooms;
	}

	public List<Equipment> getExtraScreens() {
		return extraScreens;
	}

	public void setExtraScreens(List<Equipment> extraScreens) {
		this.extraScreens = extraScreens;
	}

	public List<Equipment> getExtraSpeakers() {
		return extraSpeakers;
	}

	public void setExtraSpeakers(List<Equipment> extraSpeakers) {
		this.extraSpeakers = extraSpeakers;
	}

	public List<Equipment> getExtraWebcams() {
		return extraWebcams;
	}

	public void setExtraWebcams(List<Equipment> extraWebcams) {
		this.extraWebcams = extraWebcams;
	}

	public List<Equipment> getExtraBoards() {
		return extraBoards;
	}

	public void setExtraBoards(List<Equipment> extraBoards) {
		this.extraBoards = extraBoards;
	}

}
