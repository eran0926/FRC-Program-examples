// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private final CANSparkMax leftMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
  private final CANSparkMax rightMotor = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);

  private final DifferentialDrive drive = new DifferentialDrive(leftMotor, rightMotor);

  private final XboxController driveController = new XboxController(0);


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    resetMortorsFactory();
    setMortorsIdleModeBrake();
    leftMotor.setInverted(true);
    rightMotor.setInverted(false);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(driveController.getLeftY()*0.8, -driveController.getRightX()*0.8);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}

  private void resetMortorsFactory(){
    leftMotor.restoreFactoryDefaults();
    rightMotor.restoreFactoryDefaults();
  }

  private void setMortorsIdleModeBrake(){
    leftMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);
    rightMotor.setIdleMode(CANSparkMax.IdleMode.kCoast);
  }

}
