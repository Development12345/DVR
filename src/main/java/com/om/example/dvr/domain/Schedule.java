package com.om.example.dvr.domain;


import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
 
public class Schedule {
   private List<Program> scheduledPrograms = new LinkedList<Program>();
 
   public Program addProgram(String programName, String episodeName, int channel,
         Date startDateTime, int lengthInMinutes) {
 
      TimeSlot timeSlot = new TimeSlot(channel, startDateTime, lengthInMinutes);
 
      if (conflictsWithOtherTimeSlots(timeSlot))
         throw new ConflictingProgramException();
 
      Program program = new Program(programName, episodeName, timeSlot);
      scheduledPrograms.add(program);
      return program;
   }
 
   private boolean conflictsWithOtherTimeSlots(TimeSlot timeSlot) {
      for (Program current : scheduledPrograms)
         if (current.timeSlot.conflictsWith(timeSlot))
            return true;
 
      return false;
   }
   
   public void removeProgramById(String programIdToRemove) {
	      for (Iterator<Program> iter = scheduledPrograms.iterator(); iter.hasNext();)
	         if (iter.next().getId().equals(programIdToRemove)) {
	            iter.remove();
	            break;
	         }
	   }
   
}
