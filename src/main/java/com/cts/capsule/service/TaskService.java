package com.cts.capsule.service;

import java.util.List;

import com.cts.capsule.model.TaskBean;

public interface TaskService {
	
	public List<TaskBean> getTasks();
	
	public TaskBean getTask(int taskid);
	
	public TaskBean createTask(TaskBean taskBean);
	
	public void deleteTask(TaskBean taskBean);
	
	public TaskBean updateTask(TaskBean taskBean);
}
