package com.cts.capsule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.capsule.model.TaskBean;
import com.cts.capsule.repository.TaskRepository;
import com.cts.capsule.service.TaskServiceImpl;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)

public class TaskManagerTest {

	@Mock
	private TaskRepository taskRepository;

	@InjectMocks
	private TaskServiceImpl taskService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("deprecation")

	@Test
	public void testAddtask() {
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskid(1);
		taskBean.setParentid("t1");
		taskBean.setTask("T2");
		taskBean.setPriority(20);
		taskBean.setStartdate(new Date(2018, 1, 1));
		taskBean.setEnddate(new Date(2019, 2, 2));
		taskBean.setIsTaskEnded("true");
		taskService.createTask(taskBean);
	}

	@Test
	public void testGetAll() {
		List<TaskBean> toDoList = new ArrayList<TaskBean>();
		toDoList.add(new TaskBean(77, "Task77", "ptask77", new Date(), new Date(), 4, "false"));
		toDoList.add(new TaskBean(88, "Task88", "ptask88", new Date(), new Date(), 8, "true"));
		when(taskRepository.findAll()).thenReturn(toDoList);
		List<TaskBean> result = taskService.getTasks();
		assertEquals(2, result.size());

	}

	@Test
	public void testDelete() {
		TaskBean taskBean = new TaskBean(7, "Task7", "parenttask7", new Date(), new Date(), 7, "true");
		taskService.deleteTask(taskBean);
		verify(taskRepository, times(1)).delete(taskBean);
	}

	@Test
	public void testUpdate() {
		TaskBean taskBean = new TaskBean();
		taskBean.setTaskid(8);
		taskBean.setPriority(30);
		taskService.updateTask((taskBean));
	}

}
