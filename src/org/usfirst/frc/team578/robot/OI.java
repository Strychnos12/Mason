package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.PIDTurnToHeading;
import org.usfirst.frc.team578.robot.commands.StrafeCommand;
import org.usfirst.frc.team578.robot.commands.StrafeCommand.StrafeDir;
import org.usfirst.frc.team578.robot.subsystems.MoveServoCommand;
import org.usfirst.frc.team578.robot.subsystems.MoveServoCommand180;
import org.usfirst.frc.team578.util.Gamepad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// Joystick gamepad = new Joystick(RobotMap.GAMEPAD);
	// JoystickButton buttonSix = new JoystickButton(gamepad, 6);

//	Joystick leftJoystick = new Joystick(0);
//	Joystick rightJoystick = new Joystick(1);

	int JOYSTICK_TRIGGER_BUTTON_NUMBER = 1; // TODO
//	JoystickButton leftTrigger = new JoystickButton(leftJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);
//	JoystickButton rightTrigger = new JoystickButton(rightJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);

	public static final Gamepad f310 = new Gamepad(RobotMap.GAMEPAD);
	JoystickButton rightShoulderButton = f310.getRightShoulder();
	JoystickButton leftShoulderButton = f310.getLeftShoulder();
	JoystickButton buttonA = f310.getButtonA();
	JoystickButton buttonB = f310.getButtonB();
	
	public static StrafeCommand sl = new StrafeCommand(StrafeDir.LEFT);
	public static StrafeCommand sr = new StrafeCommand(StrafeDir.RIGHT);
	
	public void initialize() {
		System.err.println("Init OI");

//		leftTrigger.whileActive(sl);
//		rightTrigger.whileActive(sr);

//		leftTrigger.whileActive(StrafeCommand.create(StrafeDir.LEFT));
//		rightTrigger.whileActive(StrafeCommand.create(StrafeDir.RIGHT));

		 // rightShoulderButton.whenPressed(new PIDTurnToHeading(90));
		buttonA.whenPressed(new MoveServoCommand());
		buttonB.whenPressed(new MoveServoCommand180());
//		 leftShoulderButton.whenPressed(new TurnMotorCommandBack());
//		 buttonA.whenPressed(new ResetEncoder());

	}

}
