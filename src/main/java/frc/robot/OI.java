// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeCloseCommand;
import frc.robot.commands.IntakeCloseCubeCommand;
import frc.robot.commands.IntakeOpenCommand;

public class OI {

    public XboxController driver = new XboxController(0);
    public XboxController operator = new XboxController(1);
    
    //Driver Controls
    public JoystickButton driverLeftTrigger;
    public JoystickButton driverRightTrigger;

    //Operator Controls
    public JoystickButton operatorAButton;
    public JoystickButton operatorBButton;
    public JoystickButton operatorXButton;
    public JoystickButton operatorYButton;
    
    public JoystickButton operatorRightTrigger;
    public JoystickButton operatorLeftTrigger;

  /** Creates a new OI. */
  public OI() {
  
    driverRightTrigger = new JoystickButton(driver, 5);
    driverLeftTrigger = new JoystickButton(driver, 6);

    operatorXButton = new JoystickButton(operator, 3);
    operatorYButton = new JoystickButton(operator, 4);
    operatorBButton = new JoystickButton(operator, 2);
      
    operatorRightTrigger = new JoystickButton(operator, 5);
    operatorLeftTrigger = new JoystickButton(operator, 6);

    operatorXButton.onTrue(new IntakeOpenCommand());
    operatorBButton.onTrue(new IntakeCloseCommand());
    operatorYButton.onTrue(new IntakeCloseCubeCommand());

  }

  // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
  public double getSpeed() {
    if (Math.abs(driver.getLeftTriggerAxis() - driver.getRightTriggerAxis()) > 0.04){
      return driver.getLeftTriggerAxis() - driver.getRightTriggerAxis();}
    else
      return 0.0;

  }

  // method that allows for joystick control to determine turns to left/right
  public double getTurn() {
    if (Math.abs(driver.getRawAxis(0)) > 0.04) {
      return driver.getRawAxis(0);
    } else {
      return 0.0;
    }
  }

  public double getArmSpeed() {
    if (Math.abs(operator.getLeftTriggerAxis() - operator.getRightTriggerAxis()) > 0.04){
      return operator.getLeftTriggerAxis() - operator.getRightTriggerAxis();}
    else
      return 0.0;

  }

}