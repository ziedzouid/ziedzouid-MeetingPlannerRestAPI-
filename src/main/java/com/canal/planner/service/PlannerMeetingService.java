package com.canal.planner.service;


import java.util.Set;

import org.springframework.stereotype.Component;

import com.canal.planner.data.entity.Salle;

@Component
public interface PlannerMeetingService {

	Salle getRoom(String meetingName);
	
	Set<Salle> getAllPlanning();

}
