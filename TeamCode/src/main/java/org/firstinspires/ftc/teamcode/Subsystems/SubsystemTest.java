package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SubsystemTest extends SubsystemBase {
    private final DcMotorEx motor;

    public SubsystemTest(HardwareMap hwMap) {
        motor = hwMap.get(DcMotorEx.class, "motor");
    }

    public void setPower(double power) {
        motor.setPower(power);
    }
}