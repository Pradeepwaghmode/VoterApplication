package com.nt.service;

import java.util.List;

import com.nt.module.Candidate;
import com.nt.module.Users_info;
import com.nt.module.VoterReport;

public interface IVoterService {

	public String saveUser(Users_info user);
	public String UserValidation(Users_info user);
	public String candidateVoting(Candidate cand);
	public List<VoterReport> getAllreport();
	public Users_info CurrentUser();
	public Candidate candiateInfo();
	
}
