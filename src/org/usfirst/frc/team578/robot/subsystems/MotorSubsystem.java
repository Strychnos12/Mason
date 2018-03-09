package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class MotorSubsystem extends Subsystem {

	// Servo exampleServo = new Servo(0);
	// int endpoint = 0;
	public WPI_TalonSRX _talon;

	public void initialize() {
		System.err.println("Motor Init");

		_talon = new WPI_TalonSRX(RobotMap.MOTOR_TALON);
		_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx,
				Constants.kTimeoutMs);
		_talon.setSensorPhase(true);
		_talon.setInverted(false);
		/*
		 * Set relevant frame periods to be at least as fast as periodic rate
		 */
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		/* set the peak and nominal outputs */
		_talon.configNominalOutputForward(0, Constants.kTimeoutMs);
		_talon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		_talon.configPeakOutputForward(1, Constants.kTimeoutMs);
		_talon.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		/* set closed loop gains in slot0 - see documentation */
		_talon.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		_talon.config_kF(0, 5, Constants.kTimeoutMs);
		_talon.config_kP(0, 5, Constants.kTimeoutMs);
		_talon.config_kI(0, 0.1, Constants.kTimeoutMs);
		_talon.config_kD(0, 0.0, Constants.kTimeoutMs);
		_talon.config_IntegralZone(0, 50, Constants.kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		_talon.configMotionCruiseVelocity(1689 * 20, Constants.kTimeoutMs);
		_talon.configMotionAcceleration(1689 * 20, Constants.kTimeoutMs);
		/* zero the sensor */
		_talon.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);

		_talon.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled, 0);
		_talon.configForwardLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled, 0);

	}

	@Override
	protected void initDefaultCommand() {
	}

	public void moveToPosition(int position) {
		_talon.set(ControlMode.MotionMagic, position);
	}

	public void driveMotor(double value) {
		// _talon.set(ControlMode.PercentOutput, value);
	}

	public boolean isMoveComplete(int position) {
		int pos = _talon.getSelectedSensorPosition(0);
		int cle = _talon.getClosedLoopError(Constants.kPIDLoopIdx);
		int vel = _talon.getSelectedSensorVelocity(Constants.kPIDLoopIdx);
		System.err.println(String.join(",", "" + pos, "" + cle, "" + vel, "" + (position == pos)));
		return position == pos;
	}

	public void spinStop() {
		_talon.set(0);
	}
}
