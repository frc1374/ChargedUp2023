// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.AddressableLED;
// import edu.wpi.first.wpilibj.AddressableLEDBuffer;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// public class LEDs {

//   private AddressableLED led0;
//   private AddressableLED led1;
//   private AddressableLED led2;
//   private AddressableLED led3;
  
//   private AddressableLEDBuffer led0Buffer;
//   private AddressableLEDBuffer led1Buffer;
//   private AddressableLEDBuffer led2Buffer;
//   private AddressableLEDBuffer led3Buffer;

//   public LEDs() {

//     led0 = new AddressableLED(0);
//     led1 = new AddressableLED(1);
//     led2 = new AddressableLED(2);
//     led3 = new AddressableLED(3);

//     led0Buffer = new AddressableLEDBuffer(60);
//     led1Buffer = new AddressableLEDBuffer(60);
//     led2Buffer = new AddressableLEDBuffer(60);
//     led3Buffer = new AddressableLEDBuffer(60);

//     led0.setLength(led0Buffer.getLength());
//     led1.setLength(led0Buffer.getLength());
//     led2.setLength(led0Buffer.getLength());
//     led3.setLength(led0Buffer.getLength());

//     led0.setData(led0Buffer);
//     led1.setData(led1Buffer);
//     led2.setData(led2Buffer);
//     led3.setData(led3Buffer);

//   }

//   private void indexColours(AddressableLEDBuffer ledBuffer) {
//     for (int i = 0; i < ledBuffer.getLength(); i++) {
//       ledBuffer.setRGB(i, 255, 0, 200);
//     }
//   }

//   public void setLights() {
//     indexColours(led0Buffer);
//     indexColours(led1Buffer);
//     indexColours(led2Buffer);
//     indexColours(led3Buffer);

//     led0.setData(led0Buffer);
//     led0.start();
//     led1.setData(led0Buffer);
//     led1.start();
//     led2.setData(led0Buffer);
//     led2.start();
//     led3.setData(led0Buffer);
//     led3.start();
//   }

// }
