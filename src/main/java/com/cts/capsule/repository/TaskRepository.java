package com.cts.capsule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.capsule.model.TaskBean;

/**
 * This TaskRepository is an interface which extends JpaRepository and perfroms
 * crud operation and hits the database.
 * 
 * @author PrasadPenchala
 * @version 1.0
 * @since 05-06-2018
 */
@Repository
public interface TaskRepository extends JpaRepository<TaskBean, Integer> {

}
