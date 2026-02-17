package com.Apex.Mtechno.Service;

import java.time.LocalDateTime;

import com.Apex.Mtechno.Dao.DrFeesDao;

import com.Apex.Mtechno.Entity.DoctorFeesAudit;

public class DrFeesService {

	public void doUpdate(DoctorFeesAudit dr) {

		
		dr.setChangedAt(LocalDateTime.now());
		dr.setChangeBy("Admin");

		DrFeesDao dao=new DrFeesDao();
		dao.doUpdate(dr);
		
	}

}
