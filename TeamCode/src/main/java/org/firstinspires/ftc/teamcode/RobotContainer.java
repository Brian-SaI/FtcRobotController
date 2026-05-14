package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//import org.firstinspires.ftc.teamcode.Commands.MecanumDrive;
import org.firstinspires.ftc.teamcode.Commands.OuttakeCommand;
import org.firstinspires.ftc.teamcode.Commands.ShootCommand;
//import org.firstinspires.ftc.teamcode.Commands.SwerveDrive;
import org.firstinspires.ftc.teamcode.Commands.intakeCommand;
//import org.firstinspires.ftc.teamcode.Subsystems.CommandMecanumDriveTrain;
//import org.firstinspires.ftc.teamcode.Subsystems.CommandSwerveDriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.IndexerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSubsystem;
// import org.firstinspires.ftc.teamcode.Subsystems.SubsystemTest;

@TeleOp(name = "2026-Michiana Tele-Op", group = "Experimental")
public class RobotContainer extends CommandOpMode {

    //subsystems
    IntakeSubsystem intakeSubsystem;
    IndexerSubsystem indexerSubsystem;

    ShooterSubsystem shooterSubsystem;

    // commands
    intakeCommand intakeCommand = new intakeCommand(intakeSubsystem, indexerSubsystem);
    OuttakeCommand outtakeCommand = new OuttakeCommand(intakeSubsystem, indexerSubsystem);
//
    ShootCommand shootCommand = new ShootCommand(shooterSubsystem);
    // private SubsystemTest subsystemTest;
    // DISABLE FOR MICHIANA!!! - Brian
    // private final CommandSwerveDriveTrain swerveDriveTrain = new CommandSwerveDriveTrain();
    // private final CommandMecanumDriveTrain mecanumDriveTrain = new CommandMecanumDriveTrain();
    private final GamepadEx driverController = new GamepadEx(gamepad1);
    private final GamepadEx manipulatorController = new GamepadEx(gamepad2);


    // SwerveDrive swerveCommand = new SwerveDrive(swerveDriveTrain, driverController);
    // MecanumDrive mecanumCommand = new MecanumDrive(mecanumDriveTrain, driverController.getLeftX(), driverController.getLeftY(), driverController.getRightX());

    @Override
    public void initialize() {

        // swerve-drive commands
        // lets the driver have continuous driver control.
        // swerveDriveTrain.setDefaultCommand(swerveCommand);

        // mecanum-drive commands
        //mecanumDriveTrain.setDefaultCommand(mecanumCommand);

//        manipulatorController.getGamepadButton(GamepadKeys.Button.Y).whileHeld(intakeCommand);
//        manipulatorController.getGamepadButton(GamepadKeys.Button.X).whileHeld(outtakeCommand);
//        manipulatorController.getGamepadButton(GamepadKeys.Button.A).whileHeld(shootCommand);
    }


}

