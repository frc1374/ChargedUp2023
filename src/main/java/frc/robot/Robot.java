// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
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



public class Robot extends TimedRobot {
 
  private AddressableLED led0;

  private AddressableLEDBuffer led0Buffer;

  // private static final String kDefaultAuto = "Default";
  // private static final String kCustomAuto = "My Auto";
  // private String m_autoSelected;
  // private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public static OI OI = new OI();
  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static DriveCommand DriveCommand = new DriveCommand();
  public static ArmSubsystem ArmSubsystem = new ArmSubsystem();
  public static ArmCommand ArmCommand = new ArmCommand();
  public static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  CommandScheduler commandScheduler = CommandScheduler.getInstance();
  UsbCamera camera1;
  UsbCamera camera2;
  // public static LEDs LEDStrip;
  Command m_autoCommand = new AutoSequence();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  @Override
  public void robotInit() {
    // CameraServer.startAutomaticCapture();
    camera1 = CameraServer.startAutomaticCapture();
    camera2 = CameraServer.startAutomaticCapture();
    camera1.setFPS(15);
    camera2.setFPS(12);
    camera1.setResolution(320, 240);
    camera2.setResolution(250, 200);

    led0 = new AddressableLED(0);
    led0Buffer = new AddressableLEDBuffer(60);
    led0.setLength(led0Buffer.getLength());
    led0.setData(led0Buffer);
    led0.start();

    // m_chooser.setDefaultOption("Drive", "AutoDrive");
    // m_chooser.addOption("DriveShoot", "AutoDriveandShoot");
    
    // SmartDashboard.putData("Auto choices", m_chooser);
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

    // m_chooser.setDefaultOption("SideDrive", "AutoDrive");
    // m_chooser.addOption("Auto", "AutoDriveandShoot");
    
    // SmartDashboard.putData("Auto choices", m_chooser);
    

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