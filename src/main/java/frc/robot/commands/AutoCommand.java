package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Gyro;

public class AutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrain m_subsystem;
  Gyro imu;
  public double start;
  public ExampleCommand(DriveTrain subsystem, Gyro g) {
    m_subsystem = subsystem;
    imu = g;
    addRequirements(subsystem);
    addRequirements(g);
  }

  @Override
  public void initialize() {
    start = Timer.getFPGATimestamp();
    while(Timer.getFPGATimestamp() - start < 10){
      subsystem.drive(0.5,0);
    }
    start = Timer.getFPGATimestamp();
    while(Timer.getFPGATimestamp() - start < 10 && imu.angle() < 90){
      subsystem.drive(0,0.5);
    }

  }


  @Override
  public void execute() {

  }


  @Override
  public void end(boolean interrupted) {

  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
