/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.GyroPIDCommand;

/**
 * Add your docs here.
 */
public class Turn90Test extends Subsystem{

    private TalonSRX LeftMotor;
    //private TalonSRX LeftMotorFollower;
    private TalonSRX RightMotor;
    //private TalonSRX RightMotorFollower;


    public Turn90Test() {
        LeftMotor = new TalonSRX(RobotMap.LEFT_MOTOR.value);
        RightMotor = new TalonSRX(RobotMap.RIGHT_MOTOR.value);
        //RightMotorFollower = new TalonSRX(RobotMap.RIGHT_FOLLOW_MOTOR.value);
        //LeftMotorFollower = new Talon
        Robot.initTalon(LeftMotor);
        Robot.initTalon(RightMotor);
        //Robot.initTalon(LeftMotorFollower);
        //Robot.initTalon(RightMotorFollower);

        //LeftMotorFollower.follow(LeftMotor);
        //RightMotorFollower.follow(RightMotor);

        RightMotor.setInverted(true);

    }

    public void buttonPressed(boolean buttonPressed){
        final double gyroVal = Robot.gyro.getYaw();
        //final double turnAngle = 90;
        final double timeoutSec = 10;
        final double speed = 0;
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        double turnAngle = tx.getDouble(0.0);
        SmartDashboard.putNumber("angle to Correct", turnAngle);
        if(buttonPressed){
            new GyroPIDCommand(gyroVal + turnAngle, timeoutSec, speed).start();
        }
        
    }

    protected void initDefaultCommand() {
        //setDefaultCommand(new TankDrive());
    }
}
