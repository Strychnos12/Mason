package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	private WPI_TalonSRX motorTalon;

	public void initialize() {
		
//		motorTalon.set(ControlMode.PercentOutput,0);
		motorTalon = new WPI_TalonSRX(RobotMap.MOTOR_TALON);
//		motorTalon.changeControlMode(WPI_TalonSRX.TalonControlMode.PercentVbus);
//		motorTalon.enable();
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void spinForward() {
		motorTalon.set(.1);
	}

	public void spinBackwards() {
		motorTalon.set(.2);
	}

	public void spinStop() {
		motorTalon.set(0);
	}
}
