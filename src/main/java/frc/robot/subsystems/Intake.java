package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{

    //This makes a motor
    private final PWMTalonSRX glizzieguzzlerintake = new PWMTalonSRX(0);

    public Intake() {
        
    }

    //intakes balls
    public void makeItSpinIn() {
        glizzieguzzlerintake.set(0.3);
    }
    //outputs balls
    public void makeItSpinOut() {
        glizzieguzzlerintake.set(-0.3);
    }


}