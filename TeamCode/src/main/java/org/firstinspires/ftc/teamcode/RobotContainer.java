package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.SubsystemTest;

@TeleOp(name = "Command Testing", group = "Experimental")
public class RobotContainer extends CommandOpMode {
    private SubsystemTest subsystemTest;
    private GamepadEx gamepad;

    @Override
    public void initialize() {
        subsystemTest = new SubsystemTest(hardwareMap);
        gamepad = new GamepadEx(gamepad1);

        gamepad.getGamepadButton(GamepadKeys.Button.A).whileHeld(new RunCommand(() -> subsystemTest.setPower(0.5), subsystemTest));
    }


}

