// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
    CANSparkMax L1motor;
    RelativeEncoder L1encoder;
    SparkMaxPIDController L1controller;

    CANSparkMax L2motor;
    RelativeEncoder L2encoder;
    SparkMaxPIDController L2controller;

    CANSparkMax R1motor;
    RelativeEncoder R1encoder;
    SparkMaxPIDController R1controller;

    CANSparkMax R2motor;
    RelativeEncoder R2encoder;
    SparkMaxPIDController R2controller;

    // RelativeEncoder driveEncoder;
  public DriveSubsystem() {

    double rampValue = 0.5; // Set the time in seconds for ramp up value (acceleration curve)
   // driveEncoder = L1motor.getEncoder();

    L1motor = new CANSparkMax(RobotMap.Left1, MotorType.kBrushless);
    L1encoder = L1motor.getEncoder();
    L1controller = L1motor.getPIDController();
    L1motor.setOpenLoopRampRate(rampValue);
    L1encoder.setPosition(0.0);
    L1motor.burnFlash();
    

    L2motor = new CANSparkMax(RobotMap.Left2, MotorType.kBrushless);
    L2encoder = L2motor.getEncoder();
    L2controller = L2motor.getPIDController();
    L2motor.setOpenLoopRampRate(rampValue);
    L2encoder.setPosition(0.0);
    L2motor.burnFlash();
    

    R1motor = new CANSparkMax(RobotMap.Right1, MotorType.kBrushless);
    R1encoder = R1motor.getEncoder();
    R1controller = R1motor.getPIDController();
    R1motor.setOpenLoopRampRate(rampValue);
    R1encoder.setPosition(0.0);
    R1motor.burnFlash();

    R2motor = new CANSparkMax(RobotMap.Right2, MotorType.kBrushless);
    R2encoder = R2motor.getEncoder();
    R2controller = R2motor.getPIDController();
    R2motor.setOpenLoopRampRate(rampValue);
    R2encoder.setPosition(0.0);
    R2motor.burnFlash();

  }

  public void TankDrive(double left, double right) {
    L1motor.set(left);
    L2motor.set(left);
    R1motor.set(-right);
    R2motor.set(-right);
  }

  public double speedRamp(double speed){ 
    if (speed > 0){
      return 0.2*(Math.pow(speed, 3))+0.8*(Math.pow(speed, 2));

    } else {
      speed = speed * -1;
    } return   -1 * (0.2*(Math.pow(speed, 3))+0.8*(Math.pow(speed, 2)));
    
  }
  
  
  public void ArcadeDrive(double speed, double turn) {  
    SmartDashboard.putNumber("Drive L1", L1encoder.getPosition());
    SmartDashboard.putNumber("Drive L2", L2encoder.getPosition());
    SmartDashboard.putNumber("Drive R1", R1encoder.getPosition());
    SmartDashboard.putNumber("Drive R2", R2encoder.getPosition());

    speed = speedRamp(speed);
    turn = speedRamp(turn);
    turn = turn * 0.75;
    TankDrive((speed) - turn, speed + turn);
    // SmartDashboard.putNumber("drive encoder", driveEncoder.getPosition()); 
    
  }

  public void driveReset(){
    ArcadeDrive(0, 0);
    L1encoder.setPosition(0);
    L2encoder.setPosition(0);
    R1encoder.setPosition(0);
    R2encoder.setPosition(0);

  }

  public double getL1DriveEncoder() {
    return L1encoder.getPosition();
  }

}