package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.PIDTurnToHeading;
import org.usfirst.frc.team578.robot.commands.StrafeCommand;
import org.usfirst.frc.team578.robot.commands.StrafeCommand.StrafeDir;
import org.usfirst.frc.team578.util.Gamepad;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// Joystick gamepad = new Joystick(RobotMap.GAMEPAD);
	// JoystickButton buttonSix = new JoystickButton(gamepad, 6);

	Joystick leftJoystick = new Joystick(0);
	Joystick rightJoystick = new Joystick(1);

	int JOYSTICK_TRIGGER_BUTTON_NUMBER = 1; // TODO
	JoystickButton leftTrigger = new JoystickButton(leftJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);
	JoystickButton rightTrigger = new JoystickButton(rightJoystick, JOYSTICK_TRIGGER_BUTTON_NUMBER);

	public static final Gamepad f310 = new Gamepad(RobotMap.GAMEPAD);
	JoystickButton rightShoulderButton = f310.getRightShoulder();
	JoystickButton leftShoulderButton = f310.getLeftShoulder();
	JoystickButton buttonA = f310.getButtonA();
	
	public static StrafeCommand sl = new StrafeCommand(StrafeDir.LEFT);
	public static StrafeCommand sr = new StrafeCommand(StrafeDir.RIGHT);
	
	public void initialize() {
		System.err.println("Init OI");

		leftTrigger.whileActive(sl);
		rightTrigger.whileActive(sr);

//		leftTrigger.whileActive(StrafeCommand.create(StrafeDir.LEFT));
//		rightTrigger.whileActive(StrafeCommand.create(StrafeDir.RIGHT));

		 rightShoulderButton.whenPressed(new PIDTurnToHeading(90));
//		 leftShoulderButton.whenPressed(new TurnMotorCommandBack());
//		 buttonA.whenPressed(new ResetEncoder());

	}

}
