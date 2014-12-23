package team001;

import battlecode.common.RobotController;

public class RobotPlayer {
	
	public static BaseRobot robot = null;
	
	public static void run(RobotController rc) {
		while(true) {
		try {
			switch(rc.getType()) {
			
			case ARCHON: 
				robot = new ArchonRobot(rc);
				break;
					
			case SOLDIER:
				robot = new SoldierRobot(rc);
				break;
				
			default:
				break;
			}
			robot.loop();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	  } // endlessly loop back
	} // end of run method
}