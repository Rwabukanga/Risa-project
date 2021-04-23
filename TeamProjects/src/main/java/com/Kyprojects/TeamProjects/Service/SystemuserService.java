package com.Kyprojects.TeamProjects.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Kyprojects.TeamProjects.Domain.Systemuser;



@Service
public interface SystemuserService {

	public String create(Systemuser user);
	public String update (Systemuser systemUser);
	public String delete(Systemuser systemUser);
	public List<Systemuser>all();
	public Optional<Systemuser> findById(long id);
	public List<Systemuser> system_user_by_referenceName(String referenceName);
	/*public List<Permission>user_permissions(String applicationName, long objectId, String objectName);*/ 
	public Systemuser findByUsernameAndPassword(String Username, String Password);
	public String lock_user( String username);
	public Optional<Systemuser> findByuuid(String uuid); 
	public Systemuser findByUsername(String username); 
	public List<Systemuser>super_admin(String applicationName);
	public List<Systemuser>adminsAndEntityManagers(String applicationName, String objectName,long objectId);
	public String resetPassword(Systemuser systemUser);
	public String blockUser(long objectId,boolean status);
	
}
