package com.om.example.dvr.fixtures;

public class RemoveProgramById {
	   public RemoveProgramById(String id) {
		   AddProgramsToSchedule.getSchedule().removeProgramById(id);
	   }
	}
