package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.sensors.PigeonIMU;

public class Gyro extends SubsystemBase {
  PigeonIMU imu;
  public Gyro() {
    imu = new PigeonIMU(1);
  }

  @Override
  public void periodic() {

  }
  public double angle(){
    return imu.getAngle();
  }
  @Override
  public void simulationPeriodic() {

  }
}
