// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
// import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCloseCubeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  public IntakeCloseCubeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.IntakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.IntakeSubsystem.intakeSpeed(-0.3);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Robot.intakeSubsystem.intakeReset();
    Robot.IntakeSubsystem.intakeSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (IntakeSubsystem.intakeEncoder.getPosition() <= 4) {
      Robot.IntakeSubsystem.intakeSpeed(0);
      return true;
    }
    return false;
  }
  

}
