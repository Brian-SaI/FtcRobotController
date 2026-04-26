package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.pedropathing.ftc.localization.Encoder;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Limelight extends SubsystemBase {

    // limelight(s)
    public Limelight3A shooterLimelight;

    // odometry pods
    public Encoder par0, par1, perp;

    public Limelight() {

    }

    @Override
    public void periodic() {

    }

    public void podPose(double power) {

    }
}