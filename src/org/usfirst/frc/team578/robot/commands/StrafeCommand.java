package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.OI;
import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class StrafeCommand extends Command {

	public StrafeCommand() {
		requires(Robot.gyroSubsystem);
	}
	
	public enum StrafeDir {
		LEFT, RIGHT, STOP
	}

	StrafeDir direction;

	public StrafeCommand(StrafeDir direction) {
		this.direction = direction;
		// this.leftTrigger = leftTrigger;
		// this.rightTrigger = rightTrigger;
		System.err.println("Construct " + direction);
	}

	@Override
	protected void end() {
		System.err.println("Strafe END");
	}

	@Override
	protected void execute() {
		if (direction == StrafeDir.LEFT &&  OI.sr.isRunning()) {
			System.err.println("Cancel!!!!!");
			return;
		}
		
		if (direction == StrafeDir.RIGHT &&  OI.sl.isRunning()) {
			System.err.println("Cancel!!!!!");
			return;
		}
		System.err.println("Direction : " + direction.name());
	}

	@Override
	protected void initialize() {
		System.err.println("Strafe INIT");
	}

	@Override
	protected void interrupted() {
		System.err.println("Strafe INTERRUPT");
	}

	@Override
	protected boolean isFinished() {
		// System.err.println("Strafe FINISH " + finished);
		return false;
	}

}
