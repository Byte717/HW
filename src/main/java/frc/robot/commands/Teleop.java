package frc.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;
import frc.robot.subsystems.DriveTrain;


public class Teleop extends CommandBase{
    DriveTrain m_driveTrain;
    DoubleSupplier X, Y;
    public Teleop(DriveTrain x, final DoubleSupplier xSupplier, final DoubleSupplier ySupplier){
        m_driveTrain = x;
        addRequirements(m_driveTrain);
        X = xSupplier;
        Y = ySupplier;
    }

    @Override
    public void execute(){
        m_driveTrain.drive(Y.getAsDouble(), X.getAsDouble());
    }

}