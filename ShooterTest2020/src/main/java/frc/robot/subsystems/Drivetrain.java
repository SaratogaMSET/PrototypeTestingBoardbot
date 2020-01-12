/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem{
    private TalonSRX leftMotor;
    //private TalonSRX LeftMotorFollower;
    private TalonSRX rightMotor;
    //private TalonSRX RightMotorFollower;

    public Drivetrain() {
        leftMotor = new TalonSRX(RobotMap.LEFT_MOTOR.value);
        rightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR.value);
        //RightMotorFollower = new TalonSRX(RobotMap.RIGHT_FOLLOW_MOTOR.value);
        //LeftMotorFollower = new Talon
        Robot.initTalon(leftMotor);
        Robot.initTalon(rightMotor);
        leftMotor.setNeutralMode(NeutralMode.Brake);
        rightMotor.setNeutralMode(NeutralMode.Brake);

        //Robot.initTalon(LeftMotorFollower);
        //Robot.initTalon(RightMotorFollower);

        //LeftMotorFollower.follow(LeftMotor);
        //RightMotorFollower.follow(RightMotor);

        rightMotor.setInverted(true);

    }

    public void set( ControlMode mode, double leftvalue, double rightvalue){
        leftMotor.set(mode, leftvalue);
        rightMotor.set(mode, leftvalue);
    }

    protected void initDefaultCommand() {
        //setDefaultCommand(new TankDrive());
    }
}
