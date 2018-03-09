package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveServoCommand180 extends Command{

	public MoveServoCommand180() {
		setTimeout(50);
	}
	
	@Override
	protected void execute() {
//		System.err.println("Move To 0");
		Robot.ms.moveToPosition(0);
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.ms.isMoveComplete(0) || isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.ms.spinStop();
		System.err.println("End Move 0");
	}

}
