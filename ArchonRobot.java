package team001;

import battlecode.common.Clock;
import battlecode.common.RobotController;
import battlecode.common.RobotType;

public class ArchonRobot extends BaseRobot {

	public ArchonRobot(RobotController myRC) {
		super(myRC);
		//Navigation.init(this);
	}

	@Override
	public void run() {
		try {
			
		if(Clock.getRoundNum() < 300) {
			if(rc.getFlux() > RobotType.SOLDIER.spawnCost)
				rc.spawn(RobotType.SOLDIER);
		   }
		if(rc.canMove(rc.getDirection()))
			rc.moveForward();
		else
			rc.setDirection(rc.getDirection().rotateLeft());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
