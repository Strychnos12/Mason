package org.usfirst.frc.team578.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSubsystem extends Subsystem {

	private AHRS navx;

	@Override
	protected void initDefaultCommand() {
	}

	public void initialize() {

		// Start up the NAVX

		try {
			navx = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
	      System.err.println("Error instantiating navX-MXP:  " + ex.getMessage());
		}
	}

	public double getHeading() {
		// double angle = Math.abs(navx.getAngle()) % 360;

		double angle = navx.getFusedHeading();
		System.err.println("H->" + angle);

		return angle;
	}

	public void setToZero() {
		navx.zeroYaw();
	}

	public void resetGyro() {
		navx.reset();
	}

	public double getAnglePidGet() {
		return navx.pidGet();
	}

	public double getRate() {
		return navx.getRate();
	}

	public boolean isConnected() {
		return navx.isConnected();
	}

}
