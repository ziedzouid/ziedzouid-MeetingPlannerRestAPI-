package com.canal.planner.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canal.planner.data.dataService.PopulateServiceDB;
import com.canal.planner.data.entity.Equipment;
import com.canal.planner.data.entity.MeetingType;
import com.canal.planner.data.entity.Reunion;
import com.canal.planner.data.entity.Salle;

@Service
public class PlannerMeetingServiceImpl implements PlannerMeetingService {

	@Autowired
	PopulateServiceDB dataService;

	List<Salle> allPlannig;

	@PostConstruct
	private void init() {
		this.allPlannig = createPlanning();
	}

	@Override
	public Salle getRoom(String meetingName) {

		for (Salle room : this.allPlannig) {
			for (Reunion palnningMeet : room.getReunionList()) {
				if (palnningMeet.getName().equals(meetingName)) {
					return room;
				}
			}
		}
		return null;
	}

	@Override
	public Set<Salle> getAllPlanning() {

		return new HashSet<>(this.allPlannig);

	}

	//creer tous le planning
	private List<Salle> createPlanning() {

		List<Salle> allRooms = new ArrayList<Salle>();

		for (Reunion meeting : dataService.getMeetings()) {
			Salle room;
			room = planningCovidMeeting(meeting, dataService.getRooms(), dataService.getExtraSpeakers(),
					dataService.getExtraScreens(), dataService.getExtraWebcams(), dataService.getExtraBoards());
			if (room != null) {
				allRooms.add(room);
			}

		}
		return allRooms;
	}

	private Salle planningCovidMeeting(Reunion meeting, List<Salle> salles, List<Equipment> extraSpeakers,
			List<Equipment> extraScreens, List<Equipment> extraWebcams, List<Equipment> extraBoards) {

		List<Salle> availableRooms = new ArrayList<Salle>();

		for (Salle room : salles) {
			if (verifyAvailability(meeting, room) == true && checkCapcity(room, meeting.getPersonNb()) == true) {
				availableRooms.add(room);
			}
		}
		Comparator<Salle> capacityComparator = (cap1, cap2) -> cap1.getCapacity().compareTo(cap2.getCapacity());
		List<Salle> sortedAvailableRooms = availableRooms.stream().sorted(capacityComparator)
				.collect(Collectors.toList());

		for (Salle room : sortedAvailableRooms) {
			if (bookAvailableMeetingRoom(room, meeting, extraSpeakers, extraScreens, extraWebcams, extraBoards)) {
				return room;
			}
		}

		return null;

	}

	// reserver la salle en fonction du materiels disponibles
	private Boolean bookAvailableMeetingRoom(Salle room, Reunion meeting, List<Equipment> extraSpeakers,
			List<Equipment> extraScreens, List<Equipment> extraWebcams, List<Equipment> extraBoards) {

		if (meeting.getType().equals(MeetingType.VC)) { // replace with switch
			if (room.getSpeaker() == true && room.getScreen() == true && room.getWebcam() == true) {
				room.getReunionList().add(meeting);
				return true;
			}

			Boolean extraSc = false;
			Boolean extraSp = false;
			Boolean extraWe = false;
			if (!room.getScreen()) {
				for (Equipment extraScreen : extraScreens) {
					if (checkExtraEquipmentAvailability(extraScreen, meeting) == true) {
						extraScreen.getReunionList().add(meeting);
						extraSc = true;
						break;
					}

				}

			} else
				extraSc = true;
			if (!room.getSpeaker()) {
				for (Equipment extraSpeaker : extraSpeakers) {
					if (checkExtraEquipmentAvailability(extraSpeaker, meeting) == true) {
						extraSpeaker.getReunionList().add(meeting);
						extraSp = true;
						break;
					}
				}

			} else
				extraSp = true;
			if (!room.getWebcam()) {
				for (Equipment extraWeb : extraWebcams) {
					if (checkExtraEquipmentAvailability(extraWeb, meeting) == true) {
						extraWeb.getReunionList().add(meeting);
						extraWe = true;
						break;
					}

				}

			} else
				extraWe = true;

			if (extraSc == true && extraSp == true && extraWe == true) {
				room.getReunionList().add(meeting);
				return true;
			}

		} else if (meeting.getType().equals(MeetingType.SPEC)) {

			if (room.getBoard() == true) {
				room.getReunionList().add(meeting);
				return true;
			}

			Boolean extraBo = false;
			if (!room.getBoard()) {
				for (Equipment extraBoard : extraBoards) {
					if (checkExtraEquipmentAvailability(extraBoard, meeting)) {
						extraBoard.getReunionList().add(meeting);
						extraBo = true;
						break;
					}
				}

			} else
				extraBo = true;

			if (extraBo == true) {
				room.getReunionList().add(meeting);
				return true;
			}

		}

		else if (meeting.getType().equals(MeetingType.RS)) {
			room.getReunionList().add(meeting);
			return true;
		}

		else if (meeting.getType().equals(MeetingType.RC)) { // replace with switch
			if (room.getSpeaker() == true && room.getScreen() == true && room.getBoard() == true) {
				room.getReunionList().add(meeting);
				return true;
			}
			Boolean extraScRc = false;
			Boolean extraSpRc = false;
			Boolean extraBoRc = false;

			if (!room.getScreen()) {
				for (Equipment extraScreen : extraScreens) {
					if (checkExtraEquipmentAvailability(extraScreen, meeting)) {
						extraScreen.getReunionList().add(meeting);
						extraScRc = true;
						break;
					}

				}
			} else
				extraScRc = true;

			if (!room.getSpeaker()) {
				for (Equipment extraSpeaker : extraSpeakers) {
					if (checkExtraEquipmentAvailability(extraSpeaker, meeting)) {
						extraSpeaker.getReunionList().add(meeting);
						extraSpRc = true;
						break;
					}

				}

			} else
				extraSpRc = true;

			if (!room.getBoard()) {
				for (Equipment extraBoard : extraBoards) {
					if (checkExtraEquipmentAvailability(extraBoard, meeting)) {
						extraBoard.getReunionList().add(meeting);
						extraBoRc = true;
						break;
					}

				}

			} else
				extraBoRc = true;

			if (extraScRc == true && extraSpRc == true && extraBoRc == true) {
				room.getReunionList().add(meeting);
				return true;
			}

		}
		return false;

	}

	// verifier la disponiblité de l'equipement en fonctions des réunions déjà
	// planifiées
	private boolean checkExtraEquipmentAvailability(Equipment extraEquip, Reunion meeting) {

		if (extraEquip.getReunionList().isEmpty())
			return true;

		for (Reunion savedMeet : extraEquip.getReunionList()) {
			if (savedMeet.getPlaning().getName().equals(meeting.getPlaning().getName())) {
				return false;
			}
		}

		return true;

	}

	// verifier la disponiblité de la salle (mesure covid)
	private Boolean verifyAvailability(Reunion meeting, Salle room) {
		if (room.getReunionList().isEmpty()) {
			return true;
		}

		else {
			if (meeting.getPlaning().getName().equals("planingA")) {

				for (Reunion savedMeeting : room.getReunionList()) {
					if (savedMeeting.getPlaning().getName().equals("planingA")
							|| savedMeeting.getPlaning().getName().equals("planingB")) {
						return false;
					}
				}
			} else if (meeting.getPlaning().getName().equals("planingB")) {
				for (Reunion savedMeeting : room.getReunionList()) {
					if (savedMeeting.getPlaning().getName().equals("planingB")
							|| savedMeeting.getPlaning().getName().equals("planingA")
							|| savedMeeting.getPlaning().getName().equals("planingC")) {
						return false;
					}
				}
			} else if (meeting.getPlaning().getName().equals("planingC")) {
				for (Reunion savedMeeting : room.getReunionList()) {
					if (savedMeeting.getPlaning().getName().equals("planingC")
							|| savedMeeting.getPlaning().getName().equals("planingB")
							|| savedMeeting.getPlaning().getName().equals("planingD")) {
						return false;
					}
				}
			} else if (meeting.getPlaning().getName().equals("planingD")) {
				for (Reunion savedMeeting : room.getReunionList()) {
					if (savedMeeting.getPlaning().getName().equals("planingD")
							|| savedMeeting.getPlaning().getName().equals("planingC")) {
						return false;
					}
				}
			}
		}

		return true;

	}

	// verifier la capacité de la salle (mesure covid)
	private Boolean checkCapcity(Salle room, Integer colabs) {
		int capacityCovid = 0;
		capacityCovid = (int) (room.getCapacity() * 0.7);
		if (capacityCovid < colabs)
			return false;
		return true;

	}

}
