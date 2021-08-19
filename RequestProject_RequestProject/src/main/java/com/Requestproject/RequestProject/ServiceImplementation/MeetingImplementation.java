package com.Requestproject.RequestProject.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Meeting;
import com.Requestproject.RequestProject.Repository.MeetingRepository;
import com.Requestproject.RequestProject.Service.MeetingService;



@Service
public class MeetingImplementation implements MeetingService {

	@Autowired
	private MeetingRepository mrepo;

	public void createMeeting(Meeting mt) {
		// TODO Auto-generated method stub
		mrepo.save(mt);
	}

	public void updateMeeting(Meeting mt) {
		// TODO Auto-generated method stub
		mrepo.save(mt);
	}

	public void deleteMeeting(int id) {
		// TODO Auto-generated method stub
		mrepo.deleteById(id);
	}

	public Optional<Meeting> findById(int id) {
		// TODO Auto-generated method stub
		return mrepo.findById(id);
	}

	public Optional<Meeting> findByUuuid(String uuid) {
		// TODO Auto-generated method stub
		return mrepo.findByUuid(uuid);
	}

	public List<Meeting> findAll(Class c) {
		// TODO Auto-generated method stub
		return mrepo.findAll();
	}

	
}
