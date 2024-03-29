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
// import com.revrobotics.CANSparkMax.SoftLimitDirection;

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
    CANSparkMax L1ArmMotor;
    RelativeEncoder L1ArmEncoder;
    SparkMaxPIDController L1ArmController;

    CANSparkMax R1ArmMotor;
    RelativeEncoder R1ArmEncoder;
    SparkMaxPIDController R1ArmController;

  public ArmSubsystem() {

    double rampValue = 0.5; // Set the time in seconds for ramp up value (acceleration curve)


    L1ArmMotor = new CANSparkMax(RobotMap.ArmLeft, MotorType.kBrushless);
    L1ArmEncoder = L1ArmMotor.getEncoder();
    L1ArmController = L1ArmMotor.getPIDController();
    L1ArmMotor.setOpenLoopRampRate(rampValue);

    // L1ArmMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    // L1ArmMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
    // L1ArmMotor.setSoftLimit(SoftLimitDirection.kForward, (float)5.4);
    // L1ArmMotor.setSoftLimit(SoftLimitDirection.kReverse, (float)0.1);

    L1ArmMotor.burnFlash();
    L1ArmEncoder.setPosition(0.0);

    
    R1ArmMotor = new CANSparkMax(RobotMap.ArmRight, MotorType.kBrushless);
    R1ArmEncoder = R1ArmMotor.getEncoder();
    R1ArmController = R1ArmMotor.getPIDController();
    R1ArmMotor.setOpenLoopRampRate(rampValue);

    // R1ArmMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    // R1ArmMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);
    // R1ArmMotor.setSoftLimit(SoftLimitDirection.kForward, (float)-5.4);
    // R1ArmMotor.setSoftLimit(SoftLimitDirection.kReverse, (float)-0.1);

    R1ArmMotor.burnFlash();
    R1ArmEncoder.setPosition(0.0);

  }

  public void ArmSet(double left, double right) {
    L1ArmMotor.set(-left);
    R1ArmMotor.set(right);
    
  }

  public double speedRamp(double speed){  
    if (speed > 0){
      return 0.2*(Math.pow(speed, 3))+0.8*(Math.pow(speed, 2));

    } else {
      speed = speed * -1;
    } return   -1 * (0.2*(Math.pow(speed, 3))+0.8*(Math.pow(speed, 2)));
    
  }
  
  
  public void ArmDrive(double speed) {  
    SmartDashboard.putNumber("Left Arm", L1ArmEncoder.getPosition());
    SmartDashboard.putNumber("Right Arm", R1ArmEncoder.getPosition());

    speed = speedRamp(speed);
    ArmSet(speed, speed);
  }

   public void ArmReset(){
    ArmDrive(0);
    L1ArmEncoder.setPosition(0);
    R1ArmEncoder.setPosition(0);
  }

  public boolean armEncoderLimitReached(double setpoint) {
    double encoderPosition = Math.abs(R1ArmEncoder.getPosition());
    if (encoderPosition >= setpoint) {
      return true;
    } else {
      return false;
    }
  }
}