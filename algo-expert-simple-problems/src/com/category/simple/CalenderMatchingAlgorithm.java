package com.category.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalenderMatchingAlgorithm {

	public static void main(String[] args) {
		Meeting[] person1Cal = new Meeting[3];
		Meeting[] person2Cal = new Meeting[4];
		Meeting person1Bounds = new Meeting(new Time(9, 0), new Time(20, 0));
		Meeting person2Bounds = new Meeting(new Time(10, 0), new Time(18, 30));
		person1Cal[0] = new Meeting(new Time(9, 0), new Time(10, 30));
		person1Cal[1] = new Meeting(new Time(12, 0), new Time(13, 0));
		person1Cal[2] = new Meeting(new Time(16, 0), new Time(18, 0));

		person2Cal[0] = new Meeting(new Time(10, 0), new Time(11, 30));
		person2Cal[1] = new Meeting(new Time(12, 30), new Time(14, 30));
		person2Cal[2] = new Meeting(new Time(14, 30), new Time(15, 0));
		person2Cal[3] = new Meeting(new Time(16, 0), new Time(17, 0));
		Integer meetingDuration = 30;
		determineAvailability(person1Cal, person2Cal, person1Bounds, person2Bounds, meetingDuration)
				.forEach(System.out::println);
	}

	private static List<Meeting> determineAvailability(Meeting[] person1Cal, Meeting[] person2Cal,
			Meeting person1Bounds, Meeting person2Bounds, Integer meetingDuration) {

		List<Meeting> persn1Cal = new ArrayList<>();
		List<Meeting> persn2Cal = new ArrayList<>();

		// determine the calender of person 1 for whole day
		persn1Cal.add(determinestartMeet(person1Bounds.getStartTime()));
		persn1Cal.addAll(Arrays.asList(person1Cal));
		persn1Cal.add(determineEndMeet(person1Bounds.getEndTime()));

		// determine the calender of person 2 for whole day
		persn2Cal.add(determinestartMeet(person2Bounds.getStartTime()));
		persn2Cal.addAll(Arrays.asList(person2Cal));
		persn2Cal.add(determineEndMeet(person2Bounds.getEndTime()));
		List<Meeting> strightenedList = StrightenOutCalendar(mergeCalenders(persn1Cal, persn2Cal));
		List<Meeting> availableSlots = getAvailableSlots(strightenedList, meetingDuration.intValue());

		return availableSlots;
	}

	private static List<Meeting> getAvailableSlots(List<Meeting> strightenedList, int meetingDuration) {
		List<Meeting> finalList = new ArrayList<>();
		int counter = 0, counter1 = 1;
		while (counter1 < strightenedList.size()) {
			if (strightenedList.get(counter1).getStartTime()
					.getDifference(strightenedList.get(counter).getEndTime()) >= meetingDuration)
				finalList.add(new Meeting(strightenedList.get(counter).getEndTime(),
						strightenedList.get(counter1).getStartTime()));

			counter++;
			counter1++;

		}

		return finalList;
	}

	private static List<Meeting> mergeCalenders(List<Meeting> calendar1, List<Meeting> calendar2) {
		List<Meeting> mergedMeetingList = new ArrayList<>();
		int counter1 = 0, counter2 = 0;
		Meeting meet1 = calendar1.get(counter1);
		Meeting meet2 = calendar2.get(counter2);
		while (counter1 < calendar1.size() || counter2 < calendar2.size()) {
			if (counter1 > 0 || counter2 > 0) {
				if (counter1 < calendar1.size())
					meet1 = calendar1.get(counter1);
				if (counter2 < calendar2.size())
					meet2 = calendar2.get(counter2);
			}
			if (counter1 < calendar1.size() && meet1.getEndTime().compareTo(meet2.getEndTime()) <= 0) {
				counter1++;
				mergedMeetingList.add(meet1);
			} else if (counter2 < calendar2.size() && meet2.getEndTime().compareTo(meet1.getEndTime()) <= 0) {
				counter2++;
				mergedMeetingList.add(meet2);
			}

		}
		return mergedMeetingList;
	}

	private static Meeting determinestartMeet(Time startOfDayTime) {
		return new Meeting(new Time(0, 0), startOfDayTime);
	}

	private static Meeting determineEndMeet(Time endOfDayTime) {
		return new Meeting(endOfDayTime, new Time(23, 59));
	}

	private static List<Meeting> StrightenOutCalendar(List<Meeting> mergedCalendar) {
		int counter = 0, counter1 = 1;
		List<Meeting> strightenedList = new ArrayList<>();
		Meeting previousMeeting = mergedCalendar.get(counter);
		while (counter1 <= mergedCalendar.size()) {
			if (counter1 <= mergedCalendar.size() - 1
					&& previousMeeting.getEndTime().compareTo(mergedCalendar.get(counter1).getStartTime()) > 0) {
				previousMeeting = StrightenOutMeeting(previousMeeting, mergedCalendar.get(counter1));
			} else {
				strightenedList.add(previousMeeting);
				if (counter1 <= mergedCalendar.size() - 1) {
					previousMeeting = mergedCalendar.get(counter1);
				}
			}
			counter1++;
		}
		return strightenedList;

	}

	private static Meeting StrightenOutMeeting(Meeting meet1, Meeting meet2) {
		Time startTime = null;
		Time endTime = null;
		if (meet2.getStartTime().compareTo(meet1.getStartTime()) <= 0) {
			startTime = meet2.getStartTime();
		} else {
			startTime = meet1.getStartTime();
		}

		if (meet1.getEndTime().compareTo(meet2.getEndTime()) >= 0) {
			endTime = meet1.getEndTime();
		} else {
			endTime = meet2.getEndTime();
		}
		return new Meeting(startTime, endTime);
	}

	private static class Meeting {
		private Time startTime;
		private Time endTime;

		public Meeting(Time startTime, Time endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public Meeting() {

		}

		public Time getStartTime() {
			return startTime;
		}

		public void setStartTime(Time startTime) {
			this.startTime = startTime;
		}

		public Time getEndTime() {
			return endTime;
		}

		public void setEndTime(Time endTime) {
			this.endTime = endTime;
		}

		@Override
		public String toString() {
			return this.startTime.getHour() + " : " + this.startTime.getMinutes() + " - " + this.endTime.getHour()
					+ " : " + this.endTime.getMinutes();
		}
	}

	private static class Time implements Comparable<Time> {
		private int hour;
		private int minutes;

		public Time(int hour, int minutes) {
			this.hour = hour;
			this.minutes = minutes;
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public int getMinutes() {
			return minutes;
		}

		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}

		@Override
		public int compareTo(Time time) {
			int result = 0;
			if (this.hour > time.getHour())
				result = 1;
			else if (this.hour < time.getHour())
				result = -1;
			else if (this.minutes > time.getMinutes())
				result = 1;
			else if (this.minutes < time.getMinutes())
				result = -1;
			return result;
		}

		public int getDifference(Time time) {
			int minutes = 0;
			int hours = 0;
			if (this.hour > time.getHour()) {
				if (time.getMinutes() > 0)
					minutes = 60 - time.getMinutes();
				minutes += this.getMinutes();
				if (time.getMinutes() > 0)
					hours = this.getHour() - time.getHour() - 1;
				else
					hours = this.getHour() - time.getHour();
				if (minutes >= 60) {
					minutes -= 60;
					hours--;
				}
			} else if (this.hour < time.getHour()) {
				if (this.getMinutes() > 0)
					minutes = 60 - this.getMinutes();
				minutes += time.getMinutes();
				if (this.getMinutes() > 0)
					hours = time.getHour() - this.getHour() - 1;
				else
					hours = time.getHour() - this.getHour();
				if (minutes >= 60) {
					minutes -= 60;
					hours--;
				}} else {
					hours = 0;
					if (this.minutes > time.getMinutes()) {
						minutes = this.minutes - time.getMinutes();
					} else if (this.minutes < time.getMinutes()) {
						minutes = time.getMinutes() - this.getMinutes();
					}
				}

			
			return minutes + hours * 60;
		}
	}
}
