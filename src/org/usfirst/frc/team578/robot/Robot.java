package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.TurnMotorCommand;
import org.usfirst.frc.team578.robot.subsystems.MotorSubsystem;
import org.usfirst.frc.team578.util.Gamepad;

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
	
	public static MotorSubsystem motorSubsystem;
	public static OI oi;
	Gamepad f310 = new Gamepad(RobotMap.GAMEPAD);
	
	public Robot() {
	}

	@Override
	public void robotInit() {
		System.err.println("Robot Init");
		motorSubsystem = new MotorSubsystem();
		motorSubsystem.initialize();
	
		oi = new OI();
		oi.initialize();
	}
	
	@Override
	public void teleopInit() {
		System.err.println("Tele Init");
//		TurnMotorCommand driveCommand = new TurnMotorCommand();
//		driveCommand.start();
	}
	
	@Override
	public void teleopPeriodic() {
//		System.err.println("Tele Period");
		
		double leftX = f310.getLeftX();
		double leftY = f310.getLeftY();
		double rightX = f310.getRightX();
		double rightY = f310.getRightY();
		
		System.err.println(String.format("%f %f %f %f",leftX, leftY, rightX, rightY));
		
		Scheduler.getInstance().run();		
	}
}
