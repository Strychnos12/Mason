package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team578.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team578.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	public static MotorSubsystem ms;
	public static DriveSubsystem driveSubsystem;
	public static GyroSubsystem gyroSubsystem;
	public static OI oi;
//	DigitalInput cubeInput;
//	double maxv = 0;
//	
//	public boolean joystickInUse = false;

	public Robot() {
	}

	@Override
	public void robotInit() {
		 System.err.println("Robot Init");
//		driveSubsystem = new DriveSubsystem();
//		driveSubsystem.initialize();
		
		ms = new MotorSubsystem();
		ms.initialize();

		gyroSubsystem = new GyroSubsystem();
		gyroSubsystem.initialize();
		
//		cubeInput = new DigitalInput(0);

		oi = new OI();
		oi.initialize();
	}

	@Override
	public void teleopInit() {
		System.err.println("Tele Init");
		gyroSubsystem.setToZero();
		// TurnMotorCommand driveCommand = new TurnMotorCommand();
		// driveCommand.start();
	}

	@Override
	public void teleopPeriodic() {
		
		
//		System.err.println(OI.f310.getRightY());
		
//		double a = motorSubsystem._talon.getSelectedSensorPosition(0);
//		double v = motorSubsystem._talon.getSelectedSensorVelocity(0);
//		maxv = Math.max(v, maxv);
//		System.err.println("velo : " + v + " Maxv: " + maxv + " Encoder : " + a + " To Zero " + (0 - a) + " To 10x " + ((4096 * 10) - a));
//		System.err.println("FFGain : " + 1023/maxv + " 75%maxUL : " + (maxv * .75) + "");
		// System.err.println("Tele Period");

//		 System.err.println("Cube : -> " + !cubeInput.get());

		//
		// double leftX = f310.getLeftX();
		// double leftY = f310.getLeftY();
		// double rightX = f310.getRightX();
		// double rightY = f310.getRightY();

		// System.err.println(String.format("%f %f %f %f", leftX, leftY, rightX,
		// rightY));
		// double a = motorSubsystem.motorTalon.getSelectedSensorPosition(0);
		// System.err.println("Spin Stop " + a);

//		double leftX = OI.f310.getLeftX();
//		double leftY = OI.f310.getLeftY();
//
//		
//		if (Math.abs(leftX) > .05 || Math.abs(leftY) > .05) {
//			joystickInUse = true;
//			motorSubsystem.driveMotor(leftY);
//		} else if (joystickInUse){
//			joystickInUse = false;
//			motorSubsystem.spinStop();
//		}
			

		Scheduler.getInstance().run();
	}
}
