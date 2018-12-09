package com.cts.capsule.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 /**
 *This TaskBean model is used to create the setter, getter methods and constructor.
 *@author PrasadPenchala
 *@version 1.0
 *@since 05-06-2018
 */
 
@Entity
@Table(name = "task")
public class TaskBean implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int taskid;

	private String parentid;
	private String task;
	private Date startdate;
	private Date enddate;
	private int priority;
	private String isTaskEnded;
	
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getIsTaskEnded() {
		return isTaskEnded;
	}
	public void setIsTaskEnded(String isTaskEnded) {
		this.isTaskEnded = isTaskEnded;
	}
	public TaskBean(int taskid, String parentid, String task, Date startdate, Date enddate, int priority,
			String isTaskEnded) {
		super();
		this.taskid = taskid;
		this.parentid = parentid;
		this.task = task;
		this.startdate = startdate;
		this.enddate = enddate;
		this.priority = priority;
		this.isTaskEnded = isTaskEnded;
	}
	public TaskBean() {
	}
	@Override
	public String toString() {
		return "TaskBean [taskid=" + taskid + ", parentid=" + parentid + ", task=" + task + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", priority=" + priority + ", isTaskEnded=" + isTaskEnded + "]";
	}
		
}