package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.PIDTurnToHeading;
import org.usfirst.frc.team578.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team578.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team578.robot.subsystems.MotorSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */
public class Robot extends IterativeRobot {

//	public static DriveSubsystem driveSubsystem;
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
		// System.err.println("Robot Init");
//		driveSubsystem = new DriveSubsystem();
//		driveSubsystem.initialize();

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
