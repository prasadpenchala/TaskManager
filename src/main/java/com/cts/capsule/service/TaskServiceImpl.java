package com.cts.capsule.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.capsule.model.TaskBean;
import com.cts.capsule.repository.ParentTaskRepository;
import com.cts.capsule.repository.TaskRepository;

/**
 * This TaskService is used .
 * 
 * @author PrasadPenchala
 * @version 1.0
 * @since 05-06-2018
 */
@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger logger = LogManager.getLogger(TaskService.class);

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ParentTaskRepository parentTaskRepository;

	@Override
	public List<TaskBean> getTasks() {
		logger.info("Enter into getTasks method in TaskService");
		return taskRepository.findAll();
	}

	@Override
	public TaskBean getTask(int taskid) {
		logger.info("Enter into getTask method in TaskService");
		return taskRepository.getOne(taskid);

	}

	@Override
	public TaskBean createTask(TaskBean taskBean) {
		logger.info("Enter into createTask method in TaskService" + taskBean.getPriority());
		return taskRepository.save(taskBean);
	}

	@Override
	public void deleteTask(TaskBean taskBean) {
		logger.info("Enter into deleteTask method in TaskService");
		taskRepository.delete(taskBean);
		;

	}

	@Override
	public TaskBean updateTask(TaskBean taskBean) {
		logger.info("Enter into updateTask method in TaskService");
		return taskRepository.save(taskBean);
	}

}
