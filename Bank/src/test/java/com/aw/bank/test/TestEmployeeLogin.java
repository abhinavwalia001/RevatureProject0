package com.aw.bank.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.aw.bank.bean.Employee;
public class TestEmployeeLogin {

	Employee co = new Employee();

	@Test
    public void testtransfer()
    {
		assertEquals(1,co.checkEmployeeCrediential(1000,"Akshay@123"));;
	}
}

