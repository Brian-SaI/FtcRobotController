//package org.firstinspires.ftc.teamcode.Subsystems;
//
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
//
//import com.arcrobotics.ftclib.command.SubsystemBase;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//public class IndexerSubsystem extends SubsystemBase {
//
//    CRServo topRight;
//    CRServo topLeft;
//    CRServo bottomRight;
//    CRServo bottomLeft;
//
//    public IndexerSubsystem() {
//        topLeft =  hardwareMap.get(CRServo.class, "TopLServo");
//        bottomLeft =  hardwareMap.get(CRServo.class, "BottomLServo");
//        topRight =  hardwareMap.get(CRServo.class, "TopRServo");
//        bottomRight =  hardwareMap.get(CRServo.class, "BottomRServo");
//    }
//
//    @Override
//    public void periodic() {
//    }
//
//    public void runIndexer(double power) {
//        topLeft.setPower(power);
//        topRight.setPower(power);
//        bottomLeft.setPower(power);
//        bottomRight.setPower(power);
//    }
//}

package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IndexerSubsystem extends SubsystemBase {

    private final CRServo topRight;
    private final CRServo topLeft;
    private final CRServo bottomRight;
    private final CRServo bottomLeft;

    public IndexerSubsystem(final HardwareMap hMap) {
        topRight = hMap.get(CRServo.class, "TopRServo");
        topLeft = hMap.get(CRServo.class, "TopLServo");
        bottomRight = hMap.get(CRServo.class, "BottomRServo");
        bottomLeft = hMap.get(CRServo.class, "BottomLServo");
    }

    @Override
    public void periodic() {
        // Will run automatically every loop cycle if needed later
    }

    public void runIndexer(double power) {
        topLeft.setPower(power);
        topRight.setPower(power);
        bottomLeft.setPower(power);
        bottomRight.setPower(power);
    }
}