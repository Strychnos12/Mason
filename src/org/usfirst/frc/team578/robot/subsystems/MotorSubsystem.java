package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	private CANTalon motorTalon;

	private final double scaleFactor = 1;

	public void initialize() {
		motorTalon = new CANTalon(RobotMap.MOTOR_TALON);
		motorTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		motorTalon.enable();
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void spinForward() {
		motorTalon.set(-1 * scaleFactor);
	}

	public void spinBackwards() {
		motorTalon.set(1 * scaleFactor);
	}

	public void spinStop() {
		motorTalon.set(0);
	}
}
