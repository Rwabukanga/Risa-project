package com.Requestproject.RequestProject.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Systemuser;
import com.Requestproject.RequestProject.Repository.SystemuserRepository;
import com.Requestproject.RequestProject.Service.SystemuserService;
import com.Requestproject.RequestProject.Utility.Encryption;
import com.Requestproject.RequestProject.Utility.Msg;





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

	public List<Systemuser> super_admin(String applicationName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Systemuser> adminsAndEntityManagers(String applicationName, String objectName, long objectId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String resetPassword(Systemuser systemUser) {
		String message="";
		try{
			/* systemUser.setPassword(Encryption.md5(systemUser.getPassword())); */
			final String hashedPassword = BCrypt.hashpw(systemUser.getPassword(), BCrypt.gensalt());
			systemUser.setPassword(hashedPassword);
			systemuserrepo.save(systemUser);
			message=Msg.reset;
		}catch (Exception e) {
			e.printStackTrace();
			message=Msg.error;
		}
		
		return message;
	}

	public String blockUser(long objectId, boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Systemuser findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


	

	
	

	/*
	 * @Override public Optional<Systemuser>
	 * findByUsernameAndEmailVerifiedAndDeletedStatus(String username) { // TODO
	 * Auto-generated method stub return null; }
	 */
	
	/*
	 * @Override public Optional<Systemuser> findByUsername(String username) throws
	 * UsernameNotFoundException { Optional<Systemuser> userr =
	 * systemuserrepo.findByUsername(username); Systemuser user = userr.get();
	 * if(user == null){ throw new
	 * UsernameNotFoundException("Invalid username or password."); } return new
	 * org.springframework.security.core.userdetails.Systemuser(user.getUsername(),
	 * user.getPassword(), getAuthority()); };
	 */

}
