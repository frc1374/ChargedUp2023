// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IntakeSubsystem;
// import edu.wpi.first.wpilibj.DigitalInput;



public class IntakeSubsystem extends SubsystemBase {

  CANSparkMax intakeMotor;
  public static RelativeEncoder intakeEncoder;
  // DigitalInput intakeLimitSwitch;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new CANSparkMax(RobotMap.Intake, MotorType.kBrushless);
    // intakeLimitSwitch = new DigitalInput(RobotMap.intakeLimitSwitch);
    intakeEncoder = intakeMotor.getEncoder();
    
    intakeMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    intakeMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
    intakeMotor.setSoftLimit(SoftLimitDirection.kForward, (float)24);
    intakeMotor.setSoftLimit(SoftLimitDirection.kReverse, (float)-3.5);
    
    intakeEncoder.setPosition(0.0);

  }

  public void intakeSpeed(double speed) {
    SmartDashboard.putNumber("intake motor", intakeEncoder.getPosition());
    intakeMotor.set(speed);
    // if(Math.abs(intakeEncoder.getPosition()) < 10.0) {
    //   intakeMotor.set(speed);
    // } else {
    //   intakeMotor.set(0.0);
    // }
  }

  public void intakeReset() {
    intakeEncoder.setPosition(0.0);
  }

  // public boolean IntakeEncoderLimitReached(double setpoint) {
  //   double encoderPosition = Math.abs(intakeEncoder.getPosition());
  //   if (encoderPosition >= setpoint) {
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }


  // limit switch code

//   public boolean limitSwitchClosed() {
//     if (intakeLimitSwitch.get()) {
//       SmartDashboard.putBoolean("limit switch closed", true);
//       return true;
//     } else {
//       SmartDashboard.putBoolean("limit switch closed", false);
//       return false;
//     }
//   } 

//   public void AutoCloseIntake(double speed) {
//     if (speed < 0) {
//       if (limitSwitchClosed()) {
//         speed = 0;
//       }
//   }
//   }
}
// limit switch instead of close command, close until hits limit switch, reset encoders to 0, only for auto, create a new auto command 