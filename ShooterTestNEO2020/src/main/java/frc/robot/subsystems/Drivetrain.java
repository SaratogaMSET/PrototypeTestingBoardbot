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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem{
    private TalonSRX feeder;
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;
    //private TalonSRX RightMotorFollower;

    public Drivetrain() {
        leftMotor = new CANSparkMax(RobotMap.LEFT_MOTOR.value, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.RIGHT_MOTOR.value, MotorType.kBrushless);
        feeder = new TalonSRX(RobotMap.FEEDER.value);
        //RightMotorFollower = new TalonSRX(RobotMap.RIGHT_FOLLOW_MOTOR.value);
        //LeftMotorFollower = new Talon
        Robot.initTalon(feeder);
        feeder.setNeutralMode(NeutralMode.Brake);
        leftMotor.clearFaults();
        rightMotor.clearFaults();
        //Robot.initTalon(LeftMotorFollower);
        //Robot.initTalon(RightMotorFollower);

        //LeftMotorFollower.follow(LeftMotor);
        //RightMotorFollower.follow(RightMotor);

        leftMotor.setInverted(false);
        feeder.setInverted(true);

    }

    public void set( ControlMode mode, double leftvalue, double rightvalue){
        leftMotor.set(leftvalue);
        rightMotor.set(leftvalue);
        feeder.set(mode, leftvalue);
    }

    protected void initDefaultCommand() {
        //setDefaultCommand(new TankDrive());
    }
}
