// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;

import frc.robot.Constants;

public class loaderSubsystem extends SubsystemBase {
    
    final CANSparkMax loaderMotor = new CANSparkMax(Constants.Loader.loaderID, MotorType.kBrushless);
    final RelativeEncoder loaderEncoder = loaderMotor.getEncoder();
    /** Creates a new Intake. */
    
    public loaderSubsystem() {
      loaderMotor.setIdleMode(IdleMode.kBrake);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotors(double speed) {
    loaderMotor.set(speed);
  }

  public double getLoader(){
    return loaderEncoder.getPosition();
  }

}
