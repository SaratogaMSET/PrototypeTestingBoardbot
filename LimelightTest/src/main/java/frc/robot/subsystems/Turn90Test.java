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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ExecuteSubsystems;
import frc.robot.commands.GyroPIDCommand;

/**
 * Add your docs here.
 */
public class Turn90Test extends Subsystem{

    private CANSparkMax MotorL1;
    private CANSparkMax MotorL2;
    private CANSparkMax MotorR1;
    private CANSparkMax MotorR2;


    public Turn90Test() {
        MotorL1 = new CANSparkMax(RobotMap.DRIVETRAIN_L1.value, MotorType.kBrushless);
        MotorL2 = new CANSparkMax(RobotMap.DRIVETRAIN_L2.value, MotorType.kBrushless);
        //SpeedControllerGroup L = new SpeedControllerGroup(MotorL1, MotorL2);

        MotorR1 = new CANSparkMax(RobotMap.DRIVETRAIN_R1.value, MotorType.kBrushless);
        MotorR2 = new CANSparkMax(RobotMap.DRIVETRAIN_R2.value, MotorType.kBrushless);
        //SpeedControllerGroup R = new SpeedControllerGroup(MotorR1, MotorR2);

        //DifferentialDrive drive = new DifferentialDrive(L, R);

        MotorL1.clearFaults();
        MotorL2.clearFaults();
        MotorR1.clearFaults();
        MotorR2.clearFaults();

        MotorR1.setInverted(true);
        MotorR2.setInverted(true);

    }

    public void buttonPressed(boolean buttonPressed){
        final double gyroVal = Robot.gyro.getYaw();
        final double turnAngle = 90;
        final double timeoutSec = 10;
        final double speed = 0;
        if(buttonPressed){
            new GyroPIDCommand(gyroVal + turnAngle, timeoutSec, speed).start();
        }
        
    }

    protected void initDefaultCommand() {
        //setDefaultCommand(new TankDrive());
    }
}
