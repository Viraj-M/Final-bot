// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OperatorConstants;
import java.io.File;
import frc.robot.Commands.*;


import com.pathplanner.lib.auto.NamedCommands;

import frc.robot.Subsystems.*;

public class RobotContainer {

  private final SwerveSubsystem drivebase = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
      "JsonConstants"));
  // private final  armSubystem arm = new armSubystem();
  // private final shooterSubsystem shooter = new shooterSubsystem();
  private final intakeSubsystem intake = new intakeSubsystem();
  private final hoodSubsystem hood = new hoodSubsystem();
  // private final loaderSubsystem loader = new loaderSubsystem();
  // private final climberSubsystem climber = new climberSubsystem();
  final CommandXboxController driverXbox = new CommandXboxController(0);
  // final Joystick joystick = new Joystick(1);

  public RobotContainer() {
    
    NamedCommands.registerCommand("intakeCmd", new intakeCmd(intake, 0.7));
    
    configureBindings();

    Command driveSwerve = drivebase.driveCommand(
        () -> -MathUtil.applyDeadband(driverXbox.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
        () -> -MathUtil.applyDeadband(driverXbox.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
        () -> -MathUtil.applyDeadband(driverXbox.getRightX(), OperatorConstants.RIGHT_X_DEADBAND), false, true);

    drivebase.setDefaultCommand(driveSwerve);


    

    
    // intake.setDefaultCommand);
  }

  private void configureBindings() {
    //driverXbox.a().whileTrue(new Aim(drivebase, armsubsystem));
    // driverXbox.b().whileTrue(new shooterCmd(shooter, Constants.Shooter.shootSpeed));
    // driverXbox.a().whileTrue(new shooterCmd(shooter, 1));    
    // driverXbox.b().whileTrue(Commands.runOnce(drivebase::zeroGyro));
    // driverXbox.x().whileTrue(new Align(drivebase));
    driverXbox.y().whileTrue(new intakeCmd(intake, -0.3));
    driverXbox.x().whileTrue(new hoodCmd(hood, -0.1));
    driverXbox.a().whileTrue(new hoodCmd(hood, 0.1));
    // driverXbox.b().whileTrue(new loaderCmd(loader, 0.2));

    // driverXbox.leftBumper().whileTrue(new armCmd(arm, 1));
    // driverXbox.rightBumper().whileTrue(new armCmd(arm, 1));

  }

  public Command getAutonomousCommand() {
    return drivebase.getAutonomousCommand("Intake");
  }

  public void setMotorBrake(boolean brake) {
    // drivebase.setMotorBrake(brake);
  }
}
