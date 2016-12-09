package org.learn2code.seoul.pomodoro.task;

import java.util.Date;

public class Task {
	/*TODO Task keeps track of time for pomodoros
	each pomodoro should be 25 minutes.*/

	private Long id;
	private Date startTime;
	private Date endTime;

	public Task() {
	}

	public Task(Date startTime, Date endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
