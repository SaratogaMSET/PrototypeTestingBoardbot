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
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

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

  @Override
  public void robotInit() {
    oi = new OI();
    drivebase = new Drivebase();
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
    
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    //double throttle = (1.0 - Robot.oi.LEFT_JOY.getThrottle())/-2.0;
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry tv = table.getEntry("tv");

    Robot.drivebase.set(ControlMode.PercentOutput, Robot.oi.getLeftJoyY(), Robot.oi.getRightJoyY());





    double h2 = 54;
    double h1 = 24;
    double a1 = 11.63;
    
    //read values periodically
    double x = tx.getDouble(0.0);
    double a2 = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
    double LLVisible = tv.getDouble(0.0);
    double d = ((h2-h1) / Math.tan(Math.toRadians(Math.abs(a1+a2))));
    //post to smart dashboard periodically

    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", a2);
    SmartDashboard.putNumber("LimelightArea", area);
    SmartDashboard.putNumber("Limelight Visible?", LLVisible);
    SmartDashboard.putNumber("TotalAngle", Math.abs(a1+a2));
    SmartDashboard.putNumber("height", h2-h1);
    SmartDashboard.putNumber("Distance", d);
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