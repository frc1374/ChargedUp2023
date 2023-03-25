// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class AutoSequence extends SequentialCommandGroup {
  /** Creates a new AutoSequence. */
  public AutoSequence() {

    // super(new AutoDrive(3));


    double driveSpeed = 0.5;
   
   
    addCommands(
    new AutoDrive(driveSpeed, 0, 30));
  

  }
}