// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import frc.robot.Subsystems.loaderSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example Intake. */
public class loaderCmd extends Command {
  private final loaderSubsystem Loader;
  private final double speed;

  public loaderCmd(loaderSubsystem Loader, double speed) {
    this.Loader = Loader;
    this.speed = speed;
    // Use addRequirements() here to declare Intake dependencies.
    addRequirements(Loader);
  }


  @Override
  public void initialize() {
}


@Override
public void execute() {
  Loader.setMotors(speed);
    
  }


  @Override
  public void end(boolean interrupted) {
    Loader.setMotors(0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
