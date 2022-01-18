package com.canal.planner.webController;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canal.planner.data.dto.responseDto.MessageResponse;
import com.canal.planner.data.entity.Salle;
import com.canal.planner.service.PlannerMeetingService;

@RestController
@RequestMapping("/meetingPlanner")
public class MeetingController {

	@Autowired
	PlannerMeetingService meetingService;

	// envoyer la salle disponible avec un simple message
	@GetMapping("/select/{name}")
	public ResponseEntity<?> getSelectedRoom(@PathVariable("name") String name) {

		Salle selectedRoom = meetingService.getRoom(name);
		MessageResponse response;
		if (selectedRoom == null) {
			response = new MessageResponse("Salles non disponibles pour ce type de reunion");
			return new ResponseEntity<>(response, HttpStatus.OK);

		}
		response = new MessageResponse("La salle disponible pour la " + name + " est " + selectedRoom.getName());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// envoyer tous le planning possible
	@GetMapping("/AllPlanning")
	public ResponseEntity<Set<Salle>> getAllPlanning() {

		Set<Salle> allRooms = meetingService.getAllPlanning();
		return new ResponseEntity<>(allRooms, HttpStatus.OK);

	}
}
