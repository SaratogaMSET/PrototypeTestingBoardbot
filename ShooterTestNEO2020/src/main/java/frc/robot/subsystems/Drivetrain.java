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

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem{
    private TalonSRX feeder;
    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;
    private TalonSRX leftMotorTalon;
    private TalonSRX rightMotorTalon;
    private double batteryVoltage = 0.0;
    private double voltUsage = .7;
    private double power = .1;
    private int amps = 5;
    //private TalonSRX RightMotorFollower;

    public Drivetrain() {
        leftMotor = new CANSparkMax(RobotMap.LEFT_MOTOR.value, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RobotMap.RIGHT_MOTOR.value, MotorType.kBrushless);
        // leftMotorTalon = new TalonSRX(RobotMap.LEFT_MOTOR_TALON.value);
        // rightMotorTalon = new TalonSRX(RobotMap.RIGHT_MOTOR_TALON.value);
        feeder = new TalonSRX(RobotMap.FEEDER.value);
        //RightMotorFollower = new TalonSRX(RobotMap.RIGHT_FOLLOW_MOTOR.value);
        //LeftMotorFollower = new Talon
        Robot.initTalon(feeder);
        feeder.setNeutralMode(NeutralMode.Brake);
        leftMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        rightMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
        leftMotor.clearFaults();
        rightMotor.clearFaults();
        leftMotor.setInverted(false);
        feeder.setInverted(true);


        // Robot.initTalon(leftMotorTalon);
        // Robot.initTalon(rightMotorTalon);
        // leftMotorTalon.setNeutralMode(NeutralMode.Brake);
        // rightMotorTalon.setNeutralMode(NeutralMode.Brake);
        // rightMotorTalon.setInverted(true);
        //Robot.initTalon(LeftMotorFollower);
        //Robot.initTalon(RightMotorFollower);

        //LeftMotorFollower.follow(LeftMotor);
        //RightMotorFollower.follow(RightMotor);

        

    }

    public void set( ControlMode mode, double leftvalue, double rightvalue, boolean buttonPressed){
        
        
        leftMotor.set(leftvalue);
        rightMotor.set(leftvalue);
        if(buttonPressed){
            amps++;
        }
        //feeder.set(mode, leftvalue);

        // leftMotorTalon.set(mode, rightvalue);
        // rightMotorTalon.set(mode, rightvalue);

        if(leftvalue < .1 && leftvalue > -0.1){
            batteryVoltage = new PowerDistributionPanel(0).getVoltage();
        }

        // if(batteryVoltage - (new PowerDistributionPanel(0).getVoltage()) < voltUsage){
        //     power *= 2;
        // } else if (batteryVoltage - (new PowerDistributionPanel(0).getVoltage()) > voltUsage){
        //     power /= 2;
        // }

        leftMotor.setSmartCurrentLimit(amps);
        rightMotor.setSmartCurrentLimit(amps);
        feeder.configContinuousCurrentLimit(amps);

        // leftMotor.set(power);
        // rightMotor.set(power);
        // feeder.set(mode, power);

        // SmartDashboard.putNumber("Current leftMotor", new PowerDistributionPanel(0).getCurrent(0));
        // SmartDashboard.putNumber("Current rightMotor", new PowerDistributionPanel(0).getCurrent(1));
        // SmartDashboard.putNumber("Current feeder", new PowerDistributionPanel(0).getCurrent(15));
        // SmartDashboard.putNumber("Total drawage", new PowerDistributionPanel(0).getCurrent(1)+  new PowerDistributionPanel(0).getCurrent(0) + new PowerDistributionPanel(0).getCurrent(15));
        // SmartDashboard.putNumber("battery voltage", (new PowerDistributionPanel(0).getVoltage()));
        SmartDashboard.putNumber("amps used per motor", amps);
        SmartDashboard.putNumber("Total voltage drawn", batteryVoltage - (new PowerDistributionPanel(0).getVoltage()));

    }

    protected void initDefaultCommand() {
        //setDefaultCommand(new TankDrive());
    }
}
