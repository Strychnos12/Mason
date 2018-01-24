package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	public WPI_TalonSRX motorTalon;

	public void initialize() {
		System.err.println("Motor Init");
//		motorTalon.set(ControlMode.PercentOutput,0);
		motorTalon = new WPI_TalonSRX(RobotMap.MOTOR_TALON);
		motorTalon.set(ControlMode.Velocity,RobotMap.MOTOR_TALON);
		double currentVelocity = motorTalon.getSelectedSensorVelocity(0);
		
//		motorTalon.changeControlMode(WPI_TalonSRX.TalonControlMode.PercentVbus);
//		motorTalon.enable();
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void spinForward() {
		motorTalon.set(.1);
		double a =  motorTalon.getSelectedSensorPosition(0);
		System.err.println("Spin Forward " + a);
	}

	public void spinBackwards() {
		motorTalon.set(-.1);
		double a =  motorTalon.getSelectedSensorPosition(0);
		System.err.println("Spin Back " + a);
	}

	public void spinStop() {
		motorTalon.set(0);
		
		ErrorCode e = motorTalon.setSelectedSensorPosition(0, 0, 0);
		if (e.equals(ErrorCode.OK)) {
			System.err.println("OK");
		} else {
			System.err.println("NOK");
		}
		double a =  motorTalon.getSelectedSensorPosition(0);
		System.err.println("Spin Stop " + a);
	}
}
