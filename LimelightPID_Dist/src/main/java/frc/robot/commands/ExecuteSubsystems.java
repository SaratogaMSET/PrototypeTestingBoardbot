/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ExecuteSubsystems extends Command{

    public ExecuteSubsystems(){
        requires(Robot.drivebase);
        requires(Robot.gyro);
        //requires(Robot.turnTest);
    }

    protected void initialized(){

    }

    protected void execute() {


        // .arcadeDrive(Robot.oi.getLeftJoyY(), Robot.oi.getRightJoyX());
        
        double throttle = (1.0 - Robot.oi.LEFT_JOY.getThrottle())/-2.0;

        Robot.drivebase.set(ControlMode.PercentOutput, Robot.oi.getLeftJoyY()*throttle, Robot.oi.getRightJoyY()*throttle);

        Robot.turnTest.buttonPressed(
            Robot.oi.getLeftJoyButtons(2)
        );


        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        NetworkTableEntry tv = table.getEntry("tv");

        //Robot.drivebase.set(ControlMode.PercentOutput, Robot.oi.getLeftJoyY(), Robot.oi.getRightJoyY());





        // double h2 = 54;
        double h2 = 89.75;
        double h1 = 22.75;
        double a1 =8.6;
        
        //read values periodically
        double x = tx.getDouble(0.0);
        double a2 = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        double LLVisible = tv.getDouble(0.0);
        double dLeg = ((h2-h1) / Math.tan(Math.toRadians(Math.abs(a1+a2))));
        double dHypo = dLeg/Math.cos(Math.toRadians(x));
        //post to smart dashboard periodically

        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", a2);
        SmartDashboard.putNumber("LimelightArea", area);
        SmartDashboard.putNumber("Limelight Visible?", LLVisible);
        SmartDashboard.putNumber("TotalAngle", Math.abs(a1+a2));
        SmartDashboard.putNumber("height", h2-h1);
        SmartDashboard.putNumber("Straight ahead distance", dLeg);
        SmartDashboard.putNumber("Final Dist to Target", dHypo);






        SmartDashboard.putNumber("Heading", Robot.gyro.getYaw());
    }
    protected boolean isFinished(){
        return false;
    }

    protected void interrupted() {
        end();
    }
}