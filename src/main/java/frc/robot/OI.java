// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeCommand;

// import frc.robot.commands.ClimberCommandMove;
// import frc.robot.commands.ConveyorBeltCommandForward;
// import frc.robot.commands.ConveyorBeltCommandReverse;
// import frc.robot.commands.ConveyorBeltCommandStop;
// import frc.robot.commands.ConveyorBeltCommandToggle;
// import frc.robot.commands.IntakeCommandStart;
// import frc.robot.commands.IntakeCommandStop;
// import frc.robot.commands.IntakeCommandToggle;
// import frc.robot.commands.intakeCommandSpin;
// import frc.robot.commands.intakeOut;
// import frc.robot.commands.intakeIn;
// import frc.robot.subsystems.ConveyorBeltSubsystem;
// import frc.robot.commands.intakeCommandSpin;




public class OI {

    public XboxController driver = new XboxController(0);
    
    public XboxController operator = new XboxController(1);

    //Driver Controls
    public JoystickButton driverAButton;
    public JoystickButton driverBButton;
    public JoystickButton driverXButton;
    public JoystickButton driverYButton;
    public JoystickButton driverLbump;
    public JoystickButton driverRbump;

    public JoystickButton driverLeftTrigger;
    public JoystickButton driverRightTrigger;

    //Operator Controls
    public JoystickButton operatorAButton;
    public JoystickButton operatorBButton;
    public JoystickButton operatorXButton;
    public JoystickButton operatorYButton;
    public JoystickButton operatorLbump;
    public JoystickButton operatorRbump;

    public JoystickButton operatorRightTrigger;
    public JoystickButton operatorLeftTrigger;

  /** Creates a new OI. */
  public OI() {
    

    //Need edit: 1
    driverAButton = new JoystickButton(driver, 1);
    driverBButton = new JoystickButton(driver, 2);
    driverXButton = new JoystickButton(driver, 3);
    driverYButton = new JoystickButton(driver, 4);
    driverLbump = new JoystickButton(driver, 5);
    driverRbump = new JoystickButton(driver, 6);

    driverRightTrigger = new JoystickButton(driver, 5);
    driverLeftTrigger = new JoystickButton(driver, 6);

    operatorAButton = new JoystickButton(operator, 1);
    operatorBButton = new JoystickButton(operator, 2);
    operatorXButton = new JoystickButton(operator, 3);
    operatorYButton = new JoystickButton(operator, 4);
    operatorLbump = new JoystickButton(operator, 5);
    operatorRbump = new JoystickButton(operator, 6);

    
    operatorRightTrigger = new JoystickButton(operator, 5);
    operatorLeftTrigger = new JoystickButton(operator, 6);

    operatorXButton.whileTrue(new IntakeCommand());


    // driverAButton.whileTrue(new IntakeCommand());
    
    //Trigger endConveyorDetector = new Trigger(() -> conveyor.getBeamBrakeSensor);
    
    // driverAButton.onTrue(new ClimberCommandMove(Robot.climber));
    // // driverRbump.onTrue(new IntakeCommandToggle(Robot.Intake));
    // driverLbump.onTrue(new ConveyorBeltCommandToggle(Robot.conveyor));


    
    // driverXButton.onTrue(new ConveyorBeltCommandForward(Robot.conveyor));
    // driverXButton.onTrue(new ConveyorBeltCommandStop(Robot.conveyor));
    // driverYButton.onTrue(new ConveyorBeltCommandReverse(Robot.conveyor));
    // driverYButton.onTrue(new ConveyorBeltCommandStop(Robot.conveyor));
    

    // operatorXButton.onTrue(new intakeOut(Robot.Intake));
    // operatorYButton.onTrue(new intakeIn(Robot.Intake));

    // operatorLbump.onTrue(new intakeCommandSpin(Robot.Intake));
    // operatorRbump.onTrue(new IntakeCommandStop(Robot.Intake));


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