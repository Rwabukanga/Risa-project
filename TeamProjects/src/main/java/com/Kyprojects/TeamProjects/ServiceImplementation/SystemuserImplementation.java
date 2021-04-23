package com.Kyprojects.TeamProjects.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Systemuser;
import com.Kyprojects.TeamProjects.Repository.SystemuserRepository;
import com.Kyprojects.TeamProjects.Service.SystemuserService;
import com.Kyprojects.TeamProjects.Utility.Encryption;
import com.Kyprojects.TeamProjects.Utility.Msg;



@Service
public class SystemuserImplementation implements SystemuserService {

	@Autowired
	private SystemuserRepository systemuserrepo;
	
	@Autowired
	private SystemuserService systemuserservice;
	
	public String create(Systemuser user) {
		 String message="";
			try{
				user.setPassword(Encryption.md5(user.getPassword())); 
				systemuserrepo.save(user);
				message=Msg.save;
			}catch (Exception e) {
				message=Msg.error;
			}
			return message;
	}

	public String update(Systemuser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public String delete(Systemuser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Systemuser> all() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Systemuser> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Systemuser> system_user_by_referenceName(String referenceName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Systemuser findByUsernameAndPassword(String Username, String Password) {
		// TODO Auto-generated method stub
		return systemuserrepo.findByUsernameAndPassword(Username, Password);
	}

	public String lock_user(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Systemuser> findByuuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Systemuser findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Systemuser> super_admin(String applicationName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Systemuser> adminsAndEntityManagers(String applicationName, String objectName, long objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String resetPassword(Systemuser systemUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public String blockUser(long objectId, boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

}
