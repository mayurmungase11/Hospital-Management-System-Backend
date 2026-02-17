package com.Apex.Mtechno.Dao;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.Apex.Mtechno.Dao.RevenueDao;
import com.Apex.Mtechno.Entity.BillGeneration;
import com.Apex.Mtechno.Entity.HospitalRevenue;

public class RevenueDao {

	public void getRevenue(HospitalRevenue revenue) {
		
		
		Configuration cfg= new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(HospitalRevenue.class);
		cfg.addAnnotatedClass(BillGeneration.class);
		SessionFactory sf= cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		/* LocalDate monthstart= LocalDate.of(2025, 1, 01);
		
		while(monthstart.isBefore(LocalDate.now())) {
	
		
		LocalDate monthend=monthstart.withDayOfMonth(monthstart.lengthOfMonth());
		LocalDateTime startDateTime = monthstart.atStartOfDay();
	    LocalDateTime endDateTime = monthend.atTime(23, 59, 59);
		
		Criteria criteriab1=session.createCriteria(BillGeneration.class);
		criteriab1.add(Restrictions.between("dateOfGeneration", startDateTime, endDateTime));
		
		
		criteriab1.setProjection(Projections.sum("payableamount"));
		double income= (double)criteriab1.uniqueResult();
		 if (income!=0.0) {
			
		} else {

		}
		
		System.out.println("doneeeeeeeeeee");
		
		criteriab1.setProjection(Projections.sum("totalamount"));
		double total= (double)criteriab1.uniqueResult();
		double discount= total-income;
		
		criteriab1.setProjection(Projections.rowCount());
		int noOfPatients= (int)criteriab1.uniqueResult();
	   
		
		HospitalRevenue monthly= new HospitalRevenue();
		monthly.setMonth(monthstart.getMonth().toString());
		monthly.setNoOfPatients(noOfPatients);
		monthly.setTotalIncome(income);
		monthly.setTotalDiscount(discount);
		
		
		session.saveOrUpdate(monthly);
		session.beginTransaction().commit();
				
		monthstart=monthstart.plusMonths(1);
		
		}
		
		Criteria criteria1=session.createCriteria(HospitalRevenue.class);
		criteria1.add(Restrictions.eq("month", revenue.getMonth()));
		
		HospitalRevenue r=(HospitalRevenue)criteria1.uniqueResult();
		
		System.out.println(r);
		
		session.close();
		}
		
} */
		
		LocalDate monthstart = LocalDate.of(2025, 1, 1);

		while (monthstart.isBefore(LocalDate.now())) {

		    LocalDate monthend = monthstart.withDayOfMonth(monthstart.lengthOfMonth());
		    LocalDateTime startDateTime = monthstart.atStartOfDay();
		    LocalDateTime endDateTime = monthend.atTime(23, 59, 59);

		    Criteria criteriab1 = session.createCriteria(BillGeneration.class);
		    criteriab1.add(Restrictions.between("dateOfGeneration", startDateTime, endDateTime));

		    // ✅ Sum of payable amount
		    criteriab1.setProjection(Projections.sum("payableamount"));
		    Double incomeObj = (Double) criteriab1.uniqueResult();
		    double income = (incomeObj != null) ? incomeObj : 0.0;

		    // ✅ Sum of total amount
		    criteriab1.setProjection(Projections.sum("totalamount"));
		    Double totalObj = (Double) criteriab1.uniqueResult();
		    double total = (totalObj != null) ? totalObj : 0.0;

		    double discount = total - income;

		    // ✅ Row count
		    criteriab1.setProjection(Projections.rowCount());
		    Long countObj = (Long) criteriab1.uniqueResult();
		    int noOfPatients = (countObj != null) ? countObj.intValue() : 0;

		    // ✅ Save to HospitalRevenue
		    
		    HospitalRevenue monthly = new HospitalRevenue();
		    monthly.setMonth(monthstart.getMonth().toString());
		    monthly.setNoOfPatients(noOfPatients);
		    monthly.setTotalIncome(income);
		    monthly.setTotalDiscount(discount);

		    session.beginTransaction();
		    session.saveOrUpdate(monthly);
		    session.getTransaction().commit();

		    monthstart = monthstart.plusMonths(1);
		}

		
		Criteria criteria1=session.createCriteria(HospitalRevenue.class);
		criteria1.add(Restrictions.eq("month", revenue.getMonth()));
		
		HospitalRevenue r=(HospitalRevenue)criteria1.uniqueResult();
		
		System.out.println(r);
		
		session.close();
		}
		
}
