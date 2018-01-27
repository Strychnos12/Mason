package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnMotorCommand extends Command {

//	boolean isFinished = false;
//	boolean inCommand = false;

	public TurnMotorCommand() {
		System.err.println("Turn Motor Requires");
		requires(Robot.motorSubsystem);
	}

	@Override
	protected void initialize() {
		Robot.motorSubsystem.spinStop();
	}

	@Override
	protected void execute() {
		System.err.println("TM ");
		// Robot.motorSubsystem.spinForward();
		Robot.motorSubsystem.moveToPosition(4096 * 10);

//		if (!inCommand) {
//			
//			inCommand = true;
//		} else {
//			if (Robot.motorSubsystem.isMoveComplete(4096)) {
//				inCommand = false;
//				isFinished = true;
//			}
//		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {

	}

	@Override
	public void interrupted() {
		System.err.println("TM Interrupt");
		Robot.motorSubsystem.spinStop();
	}

}
