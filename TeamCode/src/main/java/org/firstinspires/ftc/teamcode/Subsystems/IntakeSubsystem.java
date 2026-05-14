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

    DcMotorEx intake;

    public IntakeSubsystem() {
        intake =  hardwareMap.get(DcMotorEx.class, "Intake");
    }

    @Override
    public void periodic() {
    }

    public void runIntake(double power) {
        intake.setPower(power);
    }
}