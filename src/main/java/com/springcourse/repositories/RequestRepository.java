package com.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcourse.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
	
	public List<Request> findAllByOwnerId(Integer id);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE Request SET state = ?2 WHERE id = ?1")
	public Integer updateStatus(Integer id, Integer state);

}
