package team001;

import battlecode.common.RobotController;

public class SoldierRobot extends BaseRobot {

	public SoldierRobot(RobotController myRC) {
		super(myRC);
		Navigation.init(this);
	}

	@Override
	public void run() {
		try {
			Navigation.moveDirection(rc.getDirection());
		} catch(Exception e) {
			// any exceptions to deal with?
			e.printStackTrace();
		}
	}
}
