package gui;

import java.sql.ResultSet;

import fw.FWcontroller;

public class GUIController
{
	FWcontroller fwc = new FWcontroller();
	
	protected ResultSet caseReadAll()
	{
		return fwc.caseReadAll();
	}
	
	protected ResultSet caseRead(int i)
	{
		return fwc.caseRead(i);
	}
	
	protected ResultSet clientReadAll()
	{
		return fwc.clientReadAll();
	}
	
	protected ResultSet clientRead(int i)
	{
		return fwc.clientRead(i);
	}
}
