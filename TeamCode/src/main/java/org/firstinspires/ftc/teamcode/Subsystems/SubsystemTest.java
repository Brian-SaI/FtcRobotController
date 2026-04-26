package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class SubsystemTest extends SubsystemBase {

    private final Follower follower;

    public SubsystemTest(HardwareMap hwMap) {
        follower = Constants.createFollower(hwMap);
    }

    @Override
    public void periodic() {
        follower.update();
    }

    public Pose getPose() {
        return follower.getPose();
    }

    public void setPose(Pose pose) {
        follower.setPose(pose);
    }

    public void setPower(double power) {
    }
}