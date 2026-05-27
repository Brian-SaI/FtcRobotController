package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

//import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private final DcMotorEx intake;

    public IntakeSubsystem(final HardwareMap hMap) {
        intake =  hMap.get(DcMotorEx.class, "Intake");
    }

    @Override
    public void periodic() {
    }

    public void runIntake(double power) {
        intake.setPower(power);
    }
}
//
//package org.firstinspires.ftc.teamcode.Subsystems;
//
//import com.arcrobotics.ftclib.command.SubsystemBase;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//public class IntakeSubsystem extends SubsystemBase {
//    private final DcMotorEx intake;
//
//    public ShooterSubsystem(final HardwareMap hMap) {
//        intake = hMap.get(DcMotorEx.class, "Intake");
//
//        // Optional but recommended: Reverse one motor if they face opposite directions
//        // rShooter.setDirection(DcMotorEx.Direction.REVERSE);
//    }
//
//    @Override
//    public void periodic() {
//        // Will run automatically every loop cycle if needed later
//    }
//
//    public void runShooter(double velocity) {
//        lShooter.setVelocity(velocity);
//        rShooter.setVelocity(velocity);
//    }
//}