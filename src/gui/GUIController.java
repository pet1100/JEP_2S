package gui;

import fw.FWcontroller;

public class GUIController
{
	FWcontroller fwc = new FWcontroller();
	
	protected resultSet caseReadAll()
	{
		fwc.caseReadAll();
	}
	
	protected resultSet caseRead(int i)
	{
		fwc.caseRead(i);
	}
	
	protected resultSet clientReadAll()
	{
		fwc.clientReadAll();
	}
	
	protected resultSet clientRead(int i)
	{
		fwc.clientRead(i);
	}
}
