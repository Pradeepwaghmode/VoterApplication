package com.nt.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.module.Candidate;
import com.nt.module.Users_info;
import com.nt.module.VoterReport;
import com.nt.repository.ICandidateRepository;
import com.nt.repository.IReportRepository;
import com.nt.repository.IUserRepository;

@Component
public class VoterServiceImpl implements IVoterService {

	@Autowired
	private IUserRepository repo;
	@Autowired
	private ICandidateRepository repo1;

	@Autowired
	private IReportRepository rerepo;

	private Users_info current_user;

	private Candidate canInfo;

	@Override
	public String saveUser(Users_info user) {
		// TODO Auto-generated method stub
		user.setFlag("notdone");
		Integer uid = repo.save(user).getUserid();
		return "user is saved with :: " + uid;
	}

	@Override
	public String UserValidation(Users_info user) {
		// TODO Auto-generated method stub
		String username, pass;
		System.out.println("Current User is :: " + current_user);
		Users_info u = repo.finuserByUserName(user.getUsername());
		if (!(u == null) || !(Objects.isNull(u))) {
			if (u.getUsername().equalsIgnoreCase(user.getUsername())
					&& u.getPassword().equalsIgnoreCase(user.getPassword()) && u.getUsername().equalsIgnoreCase("admin")
					&& u.getPassword().equalsIgnoreCase("admin")) {
				System.out.println("admin");
				current_user = u;

				return "admin";
			}

			if (u.getUsername().equalsIgnoreCase(user.getUsername())
					&& u.getPassword().equalsIgnoreCase(user.getPassword())) {
				System.out.println("YES");
				current_user = u;

				return "yes";
			}
		}
		System.out.println("NO");
		return " no";
	}

	@Override
	public String candidateVoting(Candidate cand) {
		// TODO Auto-generated method stub
		System.out.println(cand);
		VoterReport report = new VoterReport();

		System.out.println("VoterServiceImpl.candidateVoting()");
		if (current_user.getFlag().equalsIgnoreCase("notdone")) {
			Optional<Candidate> op = repo1.findById(201);
			String flg = null;
			Candidate can = op.get();
			if (cand.getC1() == 1) {
				int cnt = can.getC1() + 1;
				can.setC1(cnt);
				repo1.save(can);
				flg = "CANDIDATE 01";

			} else if (cand.getC2() == 1) {
				int cnt = can.getC2() + 1;
				can.setC2(cnt);
				repo1.save(can);
				flg = "CANDIDATE 02";

			} else if (cand.getC3() == 1) {
				int cnt = can.getC3() + 1;
				can.setC3(cnt);
				repo1.save(can);
				flg = "CANDIDATE 03";

			} else if (cand.getC4() == 1) {
				int cnt = can.getC4() + 1;
				can.setC4(cnt);
				repo1.save(can);
				flg = "CANDIDATE 04";

			}

			current_user.setFlag("done");
			repo.save(current_user);
			report.setCname(flg);
			report.setUsname(current_user.getUsername());
			rerepo.save(report);

			return "You are voted for " + flg + ", Thank you !";
		}

		return "You already voted";
	}
	
	@Override
	public List<VoterReport> getAllreport() {
		
		return rerepo.findAll();
	}

	@Override
	public Users_info CurrentUser() {
		// TODO Auto-generated method stub
		return current_user;
	}

	@Override
	public Candidate candiateInfo() {
		// TODO Auto-generated method stub
		canInfo = repo1.getById(201);
		return canInfo;
	}
}
