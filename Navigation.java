package team001;

import battlecode.common.*;

public class Navigation {

	private RobotController myRC;
	private static SoldierRobot robot;
	private static RobotController rc;
	private static int[] directionOffsets;
	
	public Navigation(RobotController myRC) {
		this.myRC = myRC;
	}
	
	// this method is from team162/2013
	public static void init(SoldierRobot myRobot) {
		robot = myRobot;
		rc = robot.rc;
		
		// Randomly assign soldiers priorities for trying to move left or right
		if (rc.getRobot().getID() % 4 <= 1) {
			directionOffsets = new int[]{0,1,-1,2,-2};
		} else {
			directionOffsets = new int[]{0,-1,1,-2,2};
		}
	}
	
	public static void goToLocation(MapLocation loc) throws GameActionException {
		Direction dir = rc.getLocation().directionTo(loc);
		if (dir != Direction.OMNI) {
			moveDirection(dir);
		}
	}

	public static void moveDirection(Direction direction) throws GameActionException {
		if (rc.isMovementActive()) {
			Direction lookingToward = direction;
			observe: for (int d : directionOffsets) {
				lookingToward = Direction.values()[(direction.ordinal() + d + 8) % 8];
				if(rc.isMovementActive() && rc.canMove(lookingToward)) {
					rc.setDirection(lookingToward);
					rc.moveForward();
					rc.yield();
					break observe;
				}
			}
	    }
    } // end of moveDirection method
	
	public static void archonBeginningNav(Direction direction) throws GameActionException {
		if (rc.isMovementActive() && (Clock.getRoundNum() < 100)) {
			Direction lookingToward = direction;
			observe: for (int d : directionOffsets) {
				lookingToward = Direction.values()[(direction.ordinal() + d + 8) % 8];
				if(rc.isMovementActive() && rc.canMove(lookingToward)) {
					rc.setDirection(lookingToward);
					rc.moveForward();
					break observe;
				}
			}
	    }
	}
}
