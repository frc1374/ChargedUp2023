// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import frc.robot.RobotMap;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;


// public class IntakeSubsystem extends SubsystemBase {

//   CANSparkMax intakeMotor;
//   RelativeEncoder intakeEncoder;
//   Boolean toggle = true;

//   /** Creates a new IntakeSubsystem. */
//   public IntakeSubsystem() {
//     intakeMotor = new CANSparkMax(RobotMap.intakeMotor, MotorType.kBrushless);
//     intakeMotor.setInverted(true);
//   }

//   public void intakeSpeed(double speed) {
//     intakeMotor.set(speed);

//   }

//   public void intakeReset() {
//     toggle = !toggle;
//   }

//   public Boolean toggleForward() {
//     if (toggle) {
//       return true;
//     } else {
//       return false;
//     }

//   }
// }
