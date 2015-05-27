package gui;
//@Elinor
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class GUIRun
{
	
	public static void main(String[] args)
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { //ser igennem listen af instaleret look and feel
		        if ("Nimbus".equals(info.getName())) {// er look and feelet Nimbus?
		            UIManager.setLookAndFeel(info.getClassName());// hvis ja, s�t til nimbus
		        }
		    }
		} catch (Exception e) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// g�r noget galt i loopet, s�t look and feel til samme som OS
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	    GUIMain gm = new GUIMain();
	}

}
