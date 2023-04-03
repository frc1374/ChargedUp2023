// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeCloseCommand;
import frc.robot.commands.IntakeOpenCommand;


public class AutoSequence extends SequentialCommandGroup {
  /* Creates a new AutoSequence. */
  public AutoSequence() {

    // FOR TIME BASED DRIVE
    // super(new AutoDrive(3));

    // double driveSpeed = 0.5;

    addCommands(
    new AutoArm(0.5, 3.44),
    new IntakeOpenCommand(),
    new AutoArm(-0.5, 3.3),
    new IntakeCloseCommand(),
    // new AutoIntakeCloseCommand(),
    new AutoDrive(0.5,0, 45.33));
  }
}
