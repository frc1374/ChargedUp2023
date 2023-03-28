// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeSubsystem extends SubsystemBase {

  CANSparkMax intakeMotor;
  public static RelativeEncoder intakeEncoder;
  Boolean toggle = true;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new CANSparkMax(RobotMap.Intake, MotorType.kBrushless);
    intakeEncoder = intakeMotor.getEncoder();
    intakeEncoder.setPosition(0.0);

  }

  public void intakeSpeed(double speed) {
    SmartDashboard.putNumber("intake motor", intakeEncoder.getPosition());
    
    if(Math.abs(intakeEncoder.getPosition()) < 10.0) {
      intakeMotor.set(speed);
    } else {
      intakeMotor.set(0.0);
    }

  }

  public void intakeReset() {
    intakeEncoder.setPosition(0.0);
  }

  public boolean IntakeEncoderLimitReached(double setpoint) {
    double encoderPosition = Math.abs(intakeEncoder.getPosition());
    if (encoderPosition >= setpoint) {
      return true;
    } else {
      return false;
    }

  }

}
