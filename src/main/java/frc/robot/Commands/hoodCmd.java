// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Subsystems.hoodSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example Intake. */
public class hoodCmd extends Command {
  private final hoodSubsystem Hood;
  private final double speed;

  public hoodCmd(hoodSubsystem Hood, double speed) {
    this.Hood = Hood;
    this.speed = speed;
    // Use addRequirements() here to declare Intake dependencies.
    addRequirements(Hood);
  }


  @Override
  public void initialize() {
}


@Override
public void execute() {
  Hood.setMotors(speed);
    
  }


  @Override
  public void end(boolean interrupted) {
    Hood.setMotors(0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
