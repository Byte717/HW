package frc.robot.commands;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystem.Elevator;
import frc.robot.subsystem.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MonitorGyro extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  Elevator m_elevator;
  Gyro imu;

  public ExampleCommand(Elevator e, Gyro g) {
    m_elevator = e;
    imu = g;
  }


  @Override
  public void initialize() {}


  @Override
  public void execute() {
    if(imu.angle() == Constants.certainAngle){
        m_elevator.move();
        SmartDashboard.putBoolean("Elevator", m_elevator.isRaised());
    }
  }


  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
