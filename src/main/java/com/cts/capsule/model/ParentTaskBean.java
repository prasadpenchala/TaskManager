package com.cts.capsule.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This ParentTaskBean model is used to create the setter, getter methods and
 * constructor.
 * 
 * @author PrasadPenchala
 * @version 1.0
 * @since 05-06-2018
 */

@Entity
@Table(name = "ParentTask")
public class ParentTaskBean {

	@Id
	private int parentid;

	private String parentTask;

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	public ParentTaskBean() {

	}

	public ParentTaskBean(int parentid, String parentTask) {
		super();
		this.parentid = parentid;
		this.parentTask = parentTask;
	}

	@Override
	public String toString() {
		return "ParentTaskBean [parentId=" + parentid + ", parentTask=" + parentTask + "]";
	}

}
