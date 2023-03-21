// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.commands.DriveCommand;
// import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
// import frc.robot.commands.ArmCommand;
// import frc.robot.subsystems.IntakeSubsystem;
// import frc.robot.commands.IntakeCommand;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
  public static OI OI = new OI();

  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static DriveCommand DriveCommand = new DriveCommand();
  // public static ArmSubsystem ArmSubsystem = new ArmSubsystem();
  // public static ArmCommand ArmCommand = new ArmCommand();

  // public static IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();
  // public static IntakeCommand IntakeCommand = new IntakeCommand();

  
  
  CommandScheduler commandScheduler = CommandScheduler.getInstance();


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  @Override
  public void robotInit() {
    // test
}

 /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    commandScheduler.run();
    DriveCommand.schedule();
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}