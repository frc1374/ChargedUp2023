// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.InstantCommand;
// import frc.robot.Robot;
// import frc.robot.subsystems.IntakeSubsystem;


// public class IntakeCommandStart extends InstantCommand {
//   /** Creates a new IntakeCommand. */
//   private final IntakeSubsystem m_intake;

//   public IntakeCommandStart(IntakeSubsystem intake) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     m_intake = intake;
//     //addRequirements(intake);
//   }

//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     Robot.Intake.intakeInitialize();
//     //Robot.Intake.intakeSpin(0.6);
//   }
// }