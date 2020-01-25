/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class GyroSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private AHRS gyro;
  public Double gyroPIDOutput;
  public PIDController gyroPIDController;

  public GyroSubsystem() {
    gyroPIDOutput = 0.0;
    gyro = new AHRS(SPI.Port.kMXP);
    gyro.reset();
  }

  public double getGyroPIDOutput() {
    return gyroPIDOutput;
  }

  public double getYaw() {
    return gyro.getYaw();
  }

  public void reset() {
    gyro.reset();
  }

  public void gyroUsage(double Veer){
    
  };

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
