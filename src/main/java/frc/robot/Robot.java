// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.ArmCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.Auto.AutoSequence;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
 
  private AddressableLED led0;

  private AddressableLEDBuffer led0Buffer;

  public static OI OI = new OI();

  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static DriveCommand DriveCommand = new DriveCommand();
  public static ArmSubsystem ArmSubsystem = new ArmSubsystem();
  public static ArmCommand ArmCommand = new ArmCommand();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  // public static LEDs LEDStrip;
  Command m_autoCommand = new AutoSequence();


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();
    led0 = new AddressableLED(0);
    led0Buffer = new AddressableLEDBuffer(60);
    led0.setLength(led0Buffer.getLength());
    led0.setData(led0Buffer);
    led0.start();
}

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    for (int i = 0; i < led0Buffer.getLength(); i++) {
      led0Buffer.setRGB(i, 200, 0, 200);
    }
    led0.setData(led0Buffer);
    
  }

  @Override
  public void autonomousInit() {
    if(m_autoCommand != null)
    {
      m_autoCommand.schedule();
    }
    
  }

  @Override
  public void autonomousPeriodic() {

  }

 /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    if(m_autoCommand != null)
    {
      m_autoCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    DriveCommand.schedule();
    ArmCommand.schedule();
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