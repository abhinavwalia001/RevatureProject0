package com.aw.bank.main;

import java.util.Scanner;

import com.aw.bank.bean.Coustmer;
import com.aw.bank.bean.CoustmerApplication;
import com.aw.bank.bean.Employee;
import com.aw.bank.dao.ApplyForAccount;
import com.aw.bank.operation.AccountStatusOperation;
import com.aw.bank.operation.CoustmerOperation;
import com.aw.bank.operation.EmployeeOperation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int exit=0;
		System.out.println("********Welcome To AW bank*********");
		int main_choice;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("\n1. Employee Login \n2. Coustmer Login \n3. Create Account \n4. Account Status \n5.Exit \nEnter Your Choice");
			main_choice=sc.nextInt();
			
			switch(main_choice)
			{
				case 1:
					int exit_employee=0;
					
					do {
						System.out.println("*******Welcome To Employee Login*********");
						
						do {
						int username;
						System.out.println("Ente Employee Id:");
						username=sc.nextInt();
					
						
						
						sc.nextLine();
							
						System.out.println("Enter Password:");
						String password=sc.nextLine();
						
						Employee e = new Employee();
						int temp1=e.checkEmployeeCrediential(username, password);
					//	System.out.println("Temp1"+temp1);
						int emplyeelogin=0;
						if(temp1!=0)
						{
							EmployeeOperation eo = new EmployeeOperation();
						System.out.println("Employee Login Successfully");
						do {
						int employee_choice;
						System.out.println("\n1. View Coustmer Details 1 \n2. Pending Request For Account Opening \n3. All Transcation \n4.Logout \nEnter Your Choice");
						employee_choice=sc.nextInt();
						switch(employee_choice)
						{
							case 1:
								int exit_coustmer_details=0;
				
								do{
									System.out.println("View Coustmer Details");
									
									eo.viewcoustmerdetails();
									do {
									System.out.println("Enter 1 to exit");
									int temp=sc.nextInt();
									if(temp==1) {
										exit_coustmer_details=1;
									}
									else {
										System.out.println("Enter Correct Choice");
										
									}
									
									}while(exit_coustmer_details!=1);
									
								}while(exit_coustmer_details!=1);
								
							break;
							
							case 2:
							int pending_coustmer_details=0;
							do{
								System.out.println("Pending Coustmer Details");
							//	EmployeeOperation eo = new EmployeeOperation();
								eo.pendings();
								do {
								System.out.println("Enter 1 to exit");
								int temp=sc.nextInt();
								if(temp==1) {
									pending_coustmer_details=1;
								}
								else {
									System.out.println("Enter Correct Choice");
								}
								
								}while(pending_coustmer_details!=1);
								
							}while(pending_coustmer_details!=1);
								
								
								
							break;
							
							case 3:
								
								int log_coustmer_details=0;
					
								do{
									System.out.println("Coustmer Log Details");
									
									eo.showlog();
									do {
									System.out.println("Enter 1 to exit");
									int temp=sc.nextInt();
									if(temp==1) {
										log_coustmer_details=1;
									}
									else {
										System.out.println("Enter Correct Choice");
									}
									
									}while(log_coustmer_details!=1);
									
								}while(log_coustmer_details!=1);
							
							break;
							
							case 4:
								
								emplyeelogin=1;
								exit_employee=1;
								
							break;
							
							default:
								System.out.println("Invalid Choice \n Enter Correct Choice");
						}
						}while(emplyeelogin!=1);
						
						}
						
						else
						{
						   System.out.println("Invalid Username and password");	
						   
						   System.out.println("Enter 1 to exit ");
						   System.out.println("Enter any tab to continue");
						   int temp=sc.nextInt();
						   if(temp==1)
						   {
							   exit_employee=1;
						   }
						}
						}while(exit_employee!=1);
						
					}while(exit_employee!=1);
					
				break;
				
				case 2:
					
					int exit_coustmer=0;
					
                     //int exit_employee=0;
					
					do {
						System.out.println("*******Welcome To Coustmer Login*********");
						
						do {
						int username;
						System.out.println("Ente Coustmer Id:");
						username=sc.nextInt();
					
						
						
						sc.nextLine();
							
						System.out.println("Enter Password:");
						String password=sc.nextLine();
						
						//Employee e = new Employee();
						Coustmer c =new Coustmer();
						int temp1=c.checkCoustmerCrediential(username, password);
					//	System.out.println("Temp1"+temp1);
						int coustmerlogin=0;
						if(temp1!=0)
						{
							CoustmerOperation co = new CoustmerOperation();
							//EmployeeOperation eo = new EmployeeOperation();
						System.out.println("Coustmer Login Successfully");
					do {
						System.out.println("********Welcome To Coustmer Login***********");
						int coustmer_choice;
						System.out.println("\n1. View Account Balance 1 \n2. Deposit \n3. Withdrawl \n4. Transfer \n5. logout \nEnter Your Choice");
						coustmer_choice=sc.nextInt();
						switch(coustmer_choice)
						{
							case 1:
								
								int coustmer_account_balance=0;
								
								do{
									System.out.println("Account Balance");
									
									int balance = co.coustmerbalance(username);
									System.out.println("Balance in Account Number ="+username+" Balance : "+balance);
									do {
									System.out.println("Enter 1 to exit");
									int temp=sc.nextInt();
									if(temp==1) {
										coustmer_account_balance=1;
									}
									else {
										System.out.println("Enter Correct Choice");
									}
									
									}while(coustmer_account_balance!=1);
									
								}while(coustmer_account_balance!=1);
								
							break;
							
							case 2:
								int coustmer_deposite_balance=0;
								
								do{
									System.out.println("Deposite Balance");
									int amount;
									do {
									System.out.println("Enter Amount Do you want to deposite");
									amount=sc.nextInt();
									if(amount<=0)
									{
										System.out.println("Negative or 0 can not be Deposite");
									}
									}while(amount<=0);
									
									int check = co.deposit(username, amount);
									
									if(check!=0)
									{
										System.out.println("Money is SuccessFully Deposited");
									}
									else
									{
										System.out.println("Fail To Deposite Your Money");
									}
									do {
									System.out.println("Enter 1 to exit");
									int temp=sc.nextInt();
									if(temp==1) {
										coustmer_deposite_balance=1;
									}
									else {
										System.out.println("Enter Correct Choice");
									}
									
									}while(coustmer_deposite_balance!=1);
									
								}while(coustmer_deposite_balance!=1);
								
								
								
							break;
							
							case 3:
								
								int coustmer_withdrawl_balance=0;
								
								do{
									System.out.println("Withdrawal Balance");
									
									int amount;
									do {
									System.out.println("Enter Amount Do you want to Withdrawal:");
									amount=sc.nextInt();
									if(amount<=0)
									{
										System.out.println("Negative or 0 can not be Withdrawal");
									}
									}while(amount<=0);
									
									int check = co.withdrawal(username, amount);
									
									if(check!=0)
									{
										System.out.println("Money is SuccessFully Withdrawal");
									}
									else
									{
										System.out.println("Fail To Withdrawal Your Money");
									}
									
									do {
									System.out.println("Enter 1 to exit");
									int temp=sc.nextInt();
									if(temp==1) {
										coustmer_withdrawl_balance=1;
									}
									else {
										System.out.println("Enter Correct Choice");
									}
									
									}while(coustmer_withdrawl_balance!=1);
									
								}while(coustmer_withdrawl_balance!=1);
								
							
							break;
							
							case 4:
								
								int coustmer_transfer_balance=0;
								
								do{
									System.out.println("Transfer Balance");
									
									
									int amount;
									int reciverId;
									do {
									System.out.println("Enter Amount Do you want to Transfer:");
									amount=sc.nextInt();
									if(amount<=0)
									{
										System.out.println("Negative or 0 can not be Withdrawal");
									}
									}while(amount<=0);
									
									System.out.println("Enter CoustmerId Whome You Want To Transfer:");
									reciverId = sc.nextInt();
									int check = co.transfer(username, reciverId, amount);
									
									if(check!=0)
									{
										System.out.println("Money is SuccessFully Transfer");
									}
									else
									{
										System.out.println("Fail To Transfer Your Money");
									}
									
									do {
									System.out.println("Enter 1 to exit");
									int temp=sc.nextInt();
									if(temp==1) {
										coustmer_transfer_balance=1;
									}
									else {
										System.out.println("Enter Correct Choice");
									}
									
									}while(coustmer_transfer_balance!=1);
									
								}while(coustmer_transfer_balance!=1);
							break;
							
								
							case 5:
								coustmerlogin=1;
								exit_coustmer=1;
								
							break;
							
							default:
								System.out.println("Invalid Choice \n Enter Correct Choice");
						}
						}while(coustmerlogin!=1);
						
					}   
					
						else
						{
					   System.out.println("Invalid Username and password");	
					   
					   System.out.println("Enter 1 to exit ");
					   System.out.println("Enter any tab to continue");
					   int temp=sc.nextInt();
					   if(temp==1)
					   {
						   exit_coustmer=1;
					   }
						}
					}while(exit_coustmer!=1);
						
					}while(exit_coustmer!=1);
					
				break;
				
				case 3:
					
					int exit_create_account=0;
					
					do{
						System.out.println("*******Create Account********");
						CoustmerApplication eapp= new CoustmerApplication();
						String fname;
						String lname;
						String addarCardNumber;
						String mob;
						String city;
						String pincode;
						int balance;
						String password;
						String email;
						sc.nextLine();
						System.out.println("Enter First Name :-");
						fname=sc.nextLine();
						eapp.setFname(fname);
						System.out.println("Enter Last Name :-");
						lname=sc.nextLine();
						eapp.setlname(lname);
						System.out.println("Enter Adhar Card No :-");
						addarCardNumber=sc.nextLine();
						eapp.setAddarCardNumber(addarCardNumber);
						System.out.println("Enter Mobile No :-");
						mob=sc.nextLine();
						eapp.setMob(mob);
						System.out.println("Enter Mail Id :-");
						email=sc.nextLine();
						eapp.setEmail(email);
						System.out.println("City Name :-");
						city=sc.nextLine();
						eapp.setCity(city);
						System.out.println("Enter Pin Code :-");
						pincode=sc.nextLine();
						eapp.setPincode(pincode);
						System.out.println("Enter Password:-");
						password=sc.nextLine();
						eapp.setPassword(password);
						System.out.println("Enter Deposite Amount:-");
						balance=sc.nextInt();
						eapp.setBalance(balance);
						
						ApplyForAccount ap =new ApplyForAccount();
						int apply1=ap.apply(eapp);
						
						if(apply1!=0) {
							System.out.println("Application Successfully Submited");
						}
						else {
							System.out.println("Application Failed");
						}
						do {
						System.out.println("Enter 1 to exit");
						
						int temp=sc.nextInt();
						if(temp==1) {
							exit_create_account=1;
						}
						else {
							System.out.println("Enter Correct Choice");
						}
						
						}while(exit_create_account!=1);
						
					}while(exit_create_account!=1);
				
				break;
				
				case 4:
					int exit_account_status=0;
					
					do{
						System.out.println("*******Account Status********");
						AccountStatusOperation aso =new AccountStatusOperation();
						aso.status();
						do {
						System.out.println("Enter 1 to exit");
						int temp=sc.nextInt();
						if(temp==1) {
							exit_account_status=1;
						}
						else {
							System.out.println("Enter Correct Choice");
						}
						
						}while(exit_account_status!=1);
						
					}while(exit_account_status!=1);
					
				break;
				
				case 5:
					
				exit=1;
				
				break;
				
				default:
					
					System.out.println("Invalid Input \n Please enter Valid Response ");
			}
		}while(exit!=1);
		
		System.out.println("Bank Application Successfully Terminated");
	}

}
