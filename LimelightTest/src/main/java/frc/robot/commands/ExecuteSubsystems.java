/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ExecuteSubsystems extends Command{

    public ExecuteSubsystems(){
        // requires(Robot.intake);
        // requires(Robot.drivetrain);
        requires(Robot.gyro);
        //requires(Robot.turnTest);
    }

    protected void initialized(){

    }

    protected void execute() {
        //This sets the values for the arcade Drivetrain

        //This sets the values for the Intake motors using the joysticks

        // .arcadeDrive(Robot.oi.getLeftJoyY(), Robot.oi.getRightJoyX());

        Robot.turnTest.buttonPressed(
            Robot.oi.getLeftJoyButtons(2)
        );

        /*
        Robot.drivetrain.arcadeTest(
            Robot.oi.getRightJoyX() * throttleLeft
        );
        */
        SmartDashboard.putNumber("Heading", Robot.gyro.getYaw());
    }
    protected boolean isFinished(){
        return false;
    }

    protected void interrupted() {
        end();
    }
}