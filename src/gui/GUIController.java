package gui;

// @Peter J.

import java.sql.ResultSet;

import dbe.Case;
import dbe.Client;
import dbe.Employee;
import fw.FWcontroller;

// A controller that comunicate with the filewrapper.
public class GUIController
{

	// All methodes with case
	protected ResultSet caseReadAll()
	{
		return FWcontroller.caseReadAll();
	}

	protected ResultSet caseRead(int i)
	{
		return FWcontroller.caseRead(i);
	}

	protected void updateCase(Case c)
	{
		FWcontroller.caseUpdate(c);
	}

	protected int caseCreate()
	{
		return FWcontroller.createCase();
	}

	// All methodes with client
	protected ResultSet clientReadAll()
	{
		return FWcontroller.clientReadAll();
	}

	protected ResultSet clientRead(int i)
	{
		return FWcontroller.clientRead(i);
	}

	protected void updateClient(Client c)
	{
		FWcontroller.clientUpdate(c);
	}

	protected int clientCreate()
	{
		return FWcontroller.clientCreate();
	}

	// All methodes with worker
	protected ResultSet workerReadAll()
	{
		return FWcontroller.employeeReadAll();
	}

	protected ResultSet workerRead(int i)
	{
		return FWcontroller.employeeRead(i);
	}

	protected void workerUpdate(Employee c)
	{
		FWcontroller.empoyeeUpdate(c);
	}

	protected int workerCreate()
	{
		return FWcontroller.employeeCreate();
	}

}
