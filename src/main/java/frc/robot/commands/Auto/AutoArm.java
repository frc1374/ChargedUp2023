// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;


public class AutoArm extends CommandBase {

  double speed;
  double setpoint;


  /** Creates a new AutoArm. */
  public AutoArm(double speed, double setpoint) {

    addRequirements(Robot.ArmSubsystem);
    this.speed = speed;
    this.setpoint = setpoint;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.ArmSubsystem.ArmDrive(speed);    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.ArmSubsystem.ArmReset();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.ArmSubsystem.armEncoderLimitReached(setpoint)) {
      return true;
    }
    return false;
  }
}