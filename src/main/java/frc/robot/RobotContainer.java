// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
//import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RomiDrivetrain m_romiDrivetrain = new RomiDrivetrain();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_romiDrivetrain);

  private CommandXboxController m_controller = new CommandXboxController(0);

  private Intake intake;
 // private Arm arm;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_romiDrivetrain.setDefaultCommand(
        new RunCommand(() -> m_romiDrivetrain.arcadeDrive(-m_controller.getLeftY(), -m_controller.getLeftX()), m_romiDrivetrain)
    );

    intake = new Intake();
    //arm = new Arm();

    intake.setDefaultCommand(new RunCommand(() -> intake.makeItNotSpin(), intake));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    m_controller.leftBumper().whileTrue(new RunCommand(intake :: makeItSpinIn));
    // Add whileFalse statement if intake overheats.
    m_controller.rightBumper().whileTrue(new RunCommand(intake :: makeItSpinOut));
    
    /*m_controller.leftTrigger().whileTrue(new RunCommand(arm :: armUp));
    m_controller.leftTrigger().whileFalse(new RunCommand(arm :: armStop));
    m_controller.rightTrigger().whileTrue(new RunCommand(arm :: armDown));
    m_controller.rightTrigger().whileFalse(new RunCommand(arm :: armStop));*/
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    SequentialCommandGroup spagehhti = new SequentialCommandGroup (
      new RunCommand(() -> m_romiDrivetrain.arcadeDrive(-0.8, 0), m_romiDrivetrain).withTimeout(2),
      new RunCommand(() -> m_romiDrivetrain.arcadeDrive(0.8, 0), m_romiDrivetrain).withTimeout(2),
      new RunCommand(() -> intake.makeItSpinOut()).withTimeout(2)
    );
    return spagehhti;
  }
}
