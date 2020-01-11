/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public enum RobotMap {

  //MOTORS
  LEFT_MOTOR(34),
  RIGHT_MOTOR(40),
  //LEFT_FOLLOW_MOTOR(2),
  //RIGHT_FOLLOW_MOTOR(3),

  //CONTROL MAPPINGS
  LEFT_JOYSTICK(2),
  RIGHT_JOYSTICK(4);

  public final int value;

  RobotMap(int value){
    this.value = value;
  }

}
