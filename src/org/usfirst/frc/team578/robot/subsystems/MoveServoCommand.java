package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveServoCommand extends Command{
	
	public MoveServoCommand() {
		setTimeout(50);
	}

	@Override
	protected void execute() {
//		System.err.println("Move To 1000");
		Robot.ms.moveToPosition(10000);
		
//		Robot.ms.turnServ(0);
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.ms.isMoveComplete(10000) || isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.ms.spinStop();
		System.err.println("End Move 10k");
	}

}
