/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public static final double JOY_DEADZONE = 0.05;

  public final Joystick LEFT_JOY = new Joystick(RobotMap.LEFT_JOYSTICK.value);
  public final Joystick RIGHT_JOY = new Joystick(RobotMap.RIGHT_JOYSTICK.value);

  public double getLeftJoyX() {
    double raw = LEFT_JOY.getX();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
  }

  public double getLeftJoyY() {
    double raw = LEFT_JOY.getY();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
  }


  public double getRightJoyX() {
    double raw = RIGHT_JOY.getX();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
  }

  public double getRightJoyY() {
    double raw = RIGHT_JOY.getY();
    return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
  }
  public boolean getLeftJoyButtons(int buttonNum) {
    boolean raw = LEFT_JOY.getRawButton(buttonNum);
    return raw;
  }

  public OI(){

  }
  

}
