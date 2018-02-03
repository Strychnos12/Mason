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

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MotorSubsystem extends Subsystem {

	public WPI_TalonSRX _talon;

	public void initialize() {
		System.err.println("Motor Init");

		_talon = new WPI_TalonSRX(RobotMap.MOTOR_TALON);
		_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx,
				Constants.kTimeoutMs);
		_talon.setSensorPhase(true);
		_talon.setInverted(false);
		/* Set relevant frame periods to be at least as fast as periodic rate */
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		_talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		/* set the peak and nominal outputs */
		_talon.configNominalOutputForward(0, Constants.kTimeoutMs);
		_talon.configNominalOutputReverse(0, Constants.kTimeoutMs);
		_talon.configPeakOutputForward(1, Constants.kTimeoutMs);
		_talon.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		/* set closed loop gains in slot0 - see documentation */
		_talon.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		_talon.config_kF(0, 0.455, Constants.kTimeoutMs);
		_talon.config_kP(0, 0.455, Constants.kTimeoutMs);
		_talon.config_kI(0, 0.0, Constants.kTimeoutMs);
		_talon.config_kD(0, 0, Constants.kTimeoutMs);
		_talon.config_IntegralZone(0, 50, Constants.kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		_talon.configMotionCruiseVelocity(1689, Constants.kTimeoutMs);
		_talon.configMotionAcceleration(1689, Constants.kTimeoutMs);
		/* zero the sensor */
		_talon.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		
		
		_talon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);
		_talon.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);


		// motorTalon.set(ControlMode.PercentOutput,0);

		// motorTalon = new WPI_TalonSRX(RobotMap.MOTOR_TALON);
		// motorTalon.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_1Ms,
		// 0);
		// motorTalon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
		// 0, 0);
		// motorTalon.set(ControlMode.Position, RobotMap.MOTOR_TALON);
		// double currentVelocity = motorTalon.getSelectedSensorVelocity(0);

		// motorTalon.changeControlMode(WPI_TalonSRX.TalonControlMode.PercentVbus);
		// motorTalon.enable();
	}

	@Override
	protected void initDefaultCommand() {
	}
	
	public void moveToPosition(int position) {
		
		_talon.set(ControlMode.MotionMagic, position);
		/* append more signals to print when in speed mode. */
		
	}
	
	public void driveMotor(double value) {
		_talon.set(ControlMode.PercentOutput, value);
	}
	
//	public boolean isMoveComplete(int position) {
//		StringBuffer _sb = new StringBuffer();
//		int pos = _talon.getSelectedSensorPosition(0);
//		_sb.append("\terr:");
//		_sb.append(_talon.getClosedLoopError(Constants.kPIDLoopIdx));
//		_sb.append("trgt: " + pos  + "vel: ");
//		_sb.append(_talon.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
//		return position == _talon.getSelectedSensorPosition(0);
//	}


//	public void spinForward() {
//		// double c = motorTalon.getSensorCollection().getQuadratureVelocity();
//		// double b = motorTalon.getSensorCollection().getQuadraturePosition();
//		// double a = motorTalon.getSelectedSensorPosition(0);
//		// if (a <= -4096) {
//		// System.err.println("Stopping Motor " + a + " , " + b + " , " + c);
//		// motorTalon.set(0);
//		// } else {
//		// motorTalon.set(.5);
//		// System.err.println("Spin Forward " + a + " , " + b + " , " + c);
//		// }
//		double a = _talon.getSelectedSensorPosition(0);
//		System.err.println("Spin Forward " + a);
//		_talon.set(ControlMode.MotionMagic, 4096);
//
//	}
//
//	public void spinBackwards() {
//		boolean fls = _talon.getSensorCollection().isFwdLimitSwitchClosed();
//		boolean rls = _talon.getSensorCollection().isRevLimitSwitchClosed();
//		
//		System.err.println("fls " + fls + " rls " + rls);
//		
//		_talon.set(-.5);
//		double a = _talon.getSelectedSensorPosition(0);
//		System.err.println("Spin Back " + a);
//	}

	public void spinStop() {
		_talon.set(0);

		// ErrorCode e = motorTalon.setSelectedSensorPosition(0, 0, 0);
		// if (e.equals(ErrorCode.OK)) {
		// System.err.println("OK");
		// } else {
		// System.err.println("NOK");
		// }
		// double a = motorTalon.getSelectedSensorPosition(0);
		// System.err.println("Spin Stop " + a);
	}

	public void resetEncoder() {
		_talon.set(ControlMode.MotionMagic, 0);
	}
}
