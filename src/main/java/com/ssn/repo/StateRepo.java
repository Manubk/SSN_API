package com.ssn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssn.entity.StateEntity;

@Repository
public interface StateRepo extends JpaRepository<StateEntity, Integer> {

	@Query("SELECT DISTINCT(stateName)from StateEntity where sNum <= :sNum and fNum >= :sNum")
	 public List<String> findState(Integer sNum);
}
