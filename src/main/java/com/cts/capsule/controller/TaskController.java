package com.cts.capsule.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.capsule.TaskManagerApplication;
import com.cts.capsule.model.ParentTaskBean;
import com.cts.capsule.model.TaskBean;
import com.cts.capsule.repository.ParentTaskRepository;
import com.cts.capsule.repository.TaskRepository;

/**
 * This Controller is used to add, update view and delete task details.
 * @author PrasadPenchala
 *@version 1.0
 *@since 05-06-2018
 *
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class TaskController {

	 private static final Logger logger = LogManager.getLogger(TaskManagerApplication.class);
	 	
	@Autowired
	ParentTaskRepository parentTaskRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	/**
	 * @param parentTaskBean
	 * @return parentTaskBean
	 */
	@PostMapping("/parentTask")
	public ParentTaskBean createParentTask(ParentTaskBean parentTaskBean ){
	logger.info("Enter into createParentTaskmethod in controller.......");
		return parentTaskRepository.save(parentTaskBean);
		
	}
	
	
	/**
	 * @return list
	 */
	@GetMapping("/list")
	public List<TaskBean> getTasks(){
		logger.info("Enter into getTasks method in controller.......");
		return taskRepository.findAll();
		
	}
	
	/**
	 * @return list
	 */
	@GetMapping("/parentlist")
	public List<ParentTaskBean> getParentTasks(){
		logger.info("Enter into getParentTasks method in controller.......");
		return parentTaskRepository.findAll();
		
	}
	
	/**
	 * @param taskid
	 * @return TaskBean
	 */
	@GetMapping("/findById/{taskid}")
	public Optional<TaskBean> getTask(@PathVariable int taskid){
		logger.info("Enter into getTask method in controller.......");
		return taskRepository.findById(taskid);
		
	}
	
	/**
	 * @param taskBean
	 * @return TaskBean
	 */
	@PostMapping("/addtask")
	public TaskBean createTask(@RequestBody TaskBean taskBean ){
		logger.info("Enter into createTask method in controller......."+taskBean.getIsTaskEnded());
		taskBean.setIsTaskEnded("false");
		return taskRepository.save(taskBean);
		
	}
	
	/**
	 * @param taskid
	 * @return taskid
	 */
	@DeleteMapping("/deleteById/{taskid}")
	public int deleteTask(@PathVariable  int taskid){
		logger.info("Enter into deleteTask method in controller.......");
		 taskRepository.deleteById(taskid);
		return taskid;		
	}
	
	/**
	 * @param taskBean
	 * @return taskBean
	 */
	@PutMapping("/updateById/{taskid}")
	public TaskBean updateTask(@RequestBody TaskBean taskBean){
		logger.info("Enter into updateTask method in controller.......");
		return taskRepository.save(taskBean);
	}
	
	/**
	 * @param taskBean
	 * @return taskBean
	 */
	@PutMapping("/IsTaskEnded/{taskid}")
	public TaskBean TaskEnded(@RequestBody TaskBean taskBean){
		logger.info("Enter into TaskEnded method in controller......."+taskBean.getIsTaskEnded());
		taskBean.setIsTaskEnded("True");
		return taskRepository.save(taskBean);
	}
	
}
