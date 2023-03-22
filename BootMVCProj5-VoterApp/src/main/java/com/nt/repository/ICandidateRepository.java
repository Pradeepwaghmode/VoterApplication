package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.module.Candidate;
import com.nt.module.Users_info;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

//	@Query("from Users_info where username=:name")
//	public Users_info finuserByUserName(String name);
}
