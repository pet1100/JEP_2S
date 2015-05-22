package gui;

import fw.FWcontroller;

public class GUIController
{
	FWcontroller fwc = new FWcontroller();
	
	protected resultSet caseReadAll()
	{
		return fwc.caseReadAll();
	}
	
	protected resultSet caseRead(int i)
	{
		return fwc.caseRead(i);
	}
	
	protected resultSet clientReadAll()
	{
		return fwc.clientReadAll();
	}
	
	protected resultSet clientRead(int i)
	{
		return fwc.clientRead(i);
	}
}
