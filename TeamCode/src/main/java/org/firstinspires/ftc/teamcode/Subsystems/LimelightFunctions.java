package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.limelightvision.LLResult;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class LimelightFunctions extends SubsystemBase {

    // limelight(s)
    public Limelight3A shooterLimelight;


    private final Follower follower;

    public LimelightFunctions() {
        follower = Constants.createFollower(hardwareMap);
        shooterLimelight = hardwareMap.get(Limelight3A.class, "Limelight");
    }

    public void startLimelights() {
        shooterLimelight.pipelineSwitch(0);
        shooterLimelight.start();
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

    public Pose getMegatag2Pose() {
        // MegaTag2 needs the robot's current heading to work
        shooterLimelight.updateRobotOrientation(Math.toDegrees(follower.getPose().getHeading()));

        LLResult results = shooterLimelight.getLatestResult();

        if (results == null || !results.isValid()) {
            return null;
        }

        Pose3D botpose = results.getBotpose_MT2();

        if (botpose == null) {
            return null;
        }

        // Convert from Limelight's coordinate system (meters) to Pedro's (inches)
        return new Pose(
                botpose.getPosition().x * 39.3701,
                botpose.getPosition().y * 39.3701,
                botpose.getOrientation().getYaw(AngleUnit.RADIANS)
        );
    }
}