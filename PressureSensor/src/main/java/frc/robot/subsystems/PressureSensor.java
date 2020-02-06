/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PressureSensor extends SubsystemBase {
  private AnalogInput pSensor;
  public PressureSensor() {
    pSensor = new AnalogInput(1);
  }

  public void sendData(){
    SmartDashboard.putString("name", pSensor.getName());
    SmartDashboard.putNumber("value", pSensor.getValue());
  }
}
