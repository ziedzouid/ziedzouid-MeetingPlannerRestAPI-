package com.canal.planner.data.dto.requestDto;

import lombok.NonNull;

public class ReunionRequest {
	
	@NonNull
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
