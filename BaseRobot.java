package team001;

import battlecode.common.RobotController;

public abstract class BaseRobot {

	public RobotController rc;
	public int id;
	
	public BaseRobot(RobotController myRC) {
		rc = myRC;
		id = rc.getRobot().getID();
	}
	
	// this method will have to be made concrete for each type of robot
	abstract public void run();
	
	// this method will be the only method called in the switch statement in RobotPlayer
	public void loop() {
		try {
			run();
		} catch(Exception e) {
			// deal with exception
			e.printStackTrace();
		}
		rc.yield();
	} // end of loop method
} // end of BaseRobot class
