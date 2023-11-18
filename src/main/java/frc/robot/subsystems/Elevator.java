package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;

public class Elevator extends SubsystemBase {
  CANSparkMax m1, m2;
  MotorControllerGroup motors;
  public boolean raised;


  public Elevator() {
    m1 = new CANSparkMax(0, MotorType.kBrushless);
    m2 = new CANSparkMax(1,MotorType.kBrushless);

  }
  public boolean isRaised(){
    return raised;
  }
  public void move(){
    if(raised){lower(); return;}
    raise();
  }

  public void stop(){
    m1.set(0);
    m2.set(0);
  }
  public void raise(){
    double start = Timer.getFPGATimestamp();
    raised = true;
    while(Timer.getFPGATimestamp() - start < 5){
        m1.set(0.5);
        m2.set(0.5);
    }
    stop();
  }

  public void lower(){
    double start = Timer.getFPGATimestamp();
    raised = false;
    while(Timer.getFPGATimestamp() - start < 5){
        m1.set(-0.5);
        m2.set(-0.5);
    }
    stop();
  }

  @Override
  public void periodic() {

  }

}
