package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Arm extends SubsystemBase{
    
    private final PWMTalonSRX colinsArm = new PWMTalonSRX(0);

    public Arm() {

    }

    public void armUp() {
        colinsArm.set(0.4);
    }

    public void armDown() {
        colinsArm.set(-0.4);
    }

}
