package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.SwerveDrive;
import org.firstinspires.ftc.teamcode.Subsystems.CommandSwerveDriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.SubsystemTest;

@TeleOp(name = "Command Testing", group = "Experimental")
public class RobotContainer extends CommandOpMode {
    private SubsystemTest subsystemTest;
    private CommandSwerveDriveTrain swerveDriveTrain = new CommandSwerveDriveTrain();
    private final GamepadEx driverController = new GamepadEx(gamepad1);


    SwerveDrive swerveCommand = new SwerveDrive(swerveDriveTrain, driverController);

    @Override
    public void initialize() {

        // swerve-drive commands
        // lets the driver have continuous driver control.
        swerveDriveTrain.setDefaultCommand(swerveCommand);
    }


}

