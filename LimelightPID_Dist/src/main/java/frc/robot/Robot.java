/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExecuteSubsystems;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.Turn90Test;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  public static Drivebase drivebase;
  public static Turn90Test turnTest;
  public static GyroSubsystem gyro;

  @Override
  public void robotInit() {
    oi = new OI();
    drivebase = new Drivebase();
    turnTest = new Turn90Test();
    gyro = new GyroSubsystem();
  }

  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    gyro.reset();
    new ExecuteSubsystems().start();
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //double throttle = (1.0 - Robot.oi.LEFT_JOY.getThrottle())/-2.0;
    
  }

  @Override
  public void testPeriodic() {

  }

  public static void initTalon(TalonSRX motor) {
    motor.setNeutralMode(NeutralMode.Coast);
    motor.neutralOutput();
    motor.setSensorPhase(false);
    motor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    motor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
    motor.configNominalOutputForward(0.0, 0);
    motor.configNominalOutputReverse(0.0, 0);
    motor.configClosedloopRamp(0.5, 0);
    
  }
}
