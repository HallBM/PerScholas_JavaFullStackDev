package org.example.HibernateJPAFirst;

import org.example.hib.controller.FindUser_HQL;

public class App {
	public static void main(String[] args) {
		FindUser_HQL u = new FindUser_HQL();
		// u.findUser();
		// u.findUserSelect();
		// u.getRecordbyId(1);
		// u.getRecords();
		// u.getmaxSalary();
		// u.getRowCount();
		u.getmaxSalaryGroupBy();
	}
}
