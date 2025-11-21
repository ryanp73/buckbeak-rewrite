// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorPorts;

public class ShooterWheelSubsystem extends SubsystemBase {

  private final WPI_TalonSRX wheelController = new WPI_TalonSRX(MotorPorts.shooterMotor);
  /** Creates a new ShooterWheelSubsystem. */
  public ShooterWheelSubsystem() {

  }

  public void setSpeed(double speed) {
    wheelController.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
