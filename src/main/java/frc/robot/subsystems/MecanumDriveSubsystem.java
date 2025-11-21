// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MaxSpeeds;
import frc.robot.Constants.MotorPorts;
import frc.robot.Constants.WheelPositions;

public class MecanumDriveSubsystem extends SubsystemBase {

  private final MecanumDriveKinematics kinematics;
  private final Talon frontLeftMotorController = new Talon(MotorPorts.frontLeftMotor);
  private final Talon frontRightMotorController = new Talon(MotorPorts.frontRightMotor);
  private final Talon backLeftMotorController = new Talon(MotorPorts.backLeftMotor);
  private final Talon backRightMotorController = new Talon(MotorPorts.backRightMotor);

  /** Creates a new MecanumDriveSubsystem. */
  public MecanumDriveSubsystem() {
    kinematics = new MecanumDriveKinematics(
      WheelPositions.frontLeft,
      WheelPositions.frontRight,
      WheelPositions.backLeft, 
      WheelPositions.backRight
    );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double velocityX, double velocityY, double rotation) {
    ChassisSpeeds chassisSpeeds = new ChassisSpeeds(velocityX, velocityY, rotation);
    MecanumDriveWheelSpeeds wheelSpeeds = kinematics.toWheelSpeeds(chassisSpeeds);
    frontLeftMotorController.set(wheelSpeeds.frontLeftMetersPerSecond);
    frontRightMotorController.set(-wheelSpeeds.frontRightMetersPerSecond);
    backLeftMotorController.set(wheelSpeeds.rearLeftMetersPerSecond);
    backRightMotorController.set(-wheelSpeeds.rearRightMetersPerSecond);
  }
}
