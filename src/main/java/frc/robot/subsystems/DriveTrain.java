package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  CANSparkMax leftFront, leftBack, rightFront, rightBack;

  MotorControllerGroup m_left, m_right;

  DifferentialDrive m_drive;

  public DriveTrain() {
    leftFront = new CANSparkMax(Constants.motors[0], MotorType.kBrushless);
    public static final SparkMaxPIDController frontLeftPID = leftFront.getPIDController();

    leftBack = new CANSparkMax(Constants.motors[1], MotorType.kBrushless);
    public static final SparkMaxPIDController backLeftPID = leftBack.getPIDController();

    m_left = new MotorControllerGroup(leftFront, leftBack);


    rightFront = new CANSparkMax(Constants.motors[2], MotorType.kBrushless);
    public static final SparkMaxPIDController frontRightPID = rightFront.getPIDController();

    rightBack = new CANSparkMax(Constants.motors[2], MotorType.kBrushless);
    public static final SparkMaxPIDController frontRightPID = rightBack.getPIDController();

    m_right = new MotorControllerGroup(rightFront,rightBack);


    m_drive = new DifferentialDrive(m_left, m_right);

  }

  @Override
  public void periodic() {

  }
  public void drive(double speed, double rotation){
    m_drive.arcadeDrive(speed, rotation);
  }
}
