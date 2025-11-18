// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.PneumaticsPorts;

public class ShooterPistonSubsystem extends SubsystemBase {

  private final DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, PneumaticsPorts.forward, PneumaticsPorts.reverse);
  /** Creates a new ShooterPistonSubsystem. */
  public ShooterPistonSubsystem() {}

  public void shoot() {
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void reset() {
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
