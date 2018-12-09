package com.cts.capsule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.capsule.model.ParentTaskBean;
import com.cts.capsule.repository.ParentTaskRepository;

/**
 * This TaskManagerApplication is used to run the main application.
 * 
 * @author PrasadPenchala
 * @version 1.0
 * @since 05-06-2018
 *
 */
@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {
	
	private static final Logger logger = LogManager.getLogger(TaskManagerApplication.class);

	@Autowired
	private ParentTaskRepository parentTaskRepository;


	public static void main(String[] args) {
		logger.info("Enter into main method method in TaskManagerApplication.......");
		SpringApplication.run(TaskManagerApplication.class, args);
		logger.info("Exit from main method method in TaskManagerApplication.......");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Enter into run method method in TaskManagerApplication.......");

		ParentTaskBean parentTaskBean = new ParentTaskBean();
		parentTaskRepository.save(new ParentTaskBean(1, "ParentTask1"));
		parentTaskRepository.save(new ParentTaskBean(2, "ParentTask2"));
		parentTaskRepository.save(new ParentTaskBean(3, "ParentTask3"));
		parentTaskRepository.save(new ParentTaskBean(4, "ParentTask4"));
		parentTaskRepository.save(new ParentTaskBean(5, "ParentTask5"));
		parentTaskRepository.save(new ParentTaskBean(6, "ParentTask6"));
		logger.info("Exit from run method mrethod in TaskManagerApplication.......");
	}

}
