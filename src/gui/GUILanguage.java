package gui;

import javax.swing.JFrame;


public class GUILanguage extends JFrame
{
	
	protected static String menu = "Menu";
	protected static String client = "Client";
	protected static String newSomething = "newSomething";
	
	public static void setMenuLang(String s)
	{
		menu = s;
	}
	
	public static void setClient(String s)
	{
		client = s;
	}
	
	public static void setNew(String s)
	{
		newSomething = s;
	}
}
