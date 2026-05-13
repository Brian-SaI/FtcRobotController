package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class ShooterSubsystem extends SubsystemBase {

    DcMotorEx LShooter;
    DcMotorEx RShooter;



    public ShooterSubsystem() {

        LShooter = hardwareMap.get(DcMotorEx.class, "LeftShooter");
        RShooter  = hardwareMap.get(DcMotorEx.class, "RightShooter");
    }

    @Override
    public void periodic() {
    }

    public void runShooter(double velocity) {
        LShooter.setVelocity(velocity);
        RShooter.setVelocity(velocity);

    }
}