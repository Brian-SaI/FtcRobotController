package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.MecanumDrive;
import org.firstinspires.ftc.teamcode.Commands.OuttakeCommand;
import org.firstinspires.ftc.teamcode.Commands.ShootCommand;
import org.firstinspires.ftc.teamcode.Commands.intakeCommand;
// import org.firstinspires.ftc.teamcode.Subsystems.IndexerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.CommandMecanumDriveTrain;
import org.firstinspires.ftc.teamcode.Subsystems.IndexerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.ShooterSubsystem;

@TeleOp(name = "2026-Michiana Tele-Op", group = "Experimental")
public class RobotContainer extends CommandOpMode {

    // 1. Declare Subsystems (Do not instantiate yet!)
    private IntakeSubsystem intakeSubsystem;
    private IndexerSubsystem indexerSubsystem;
    private ShooterSubsystem shooterSubsystem;

    private CommandMecanumDriveTrain driveTrain;
    private MecanumDrive mecanumDriveCommand;

    // 2. Declare Commands
    private intakeCommand intakeCommand;
    private OuttakeCommand outtakeCommand;
    private ShootCommand shootCommand;

    // 3. Declare Controllers
    private GamepadEx driverController;
    private GamepadEx manipulatorController;

    @Override
    public void initialize() {
        // Initialize Gamepads
        driverController = new GamepadEx(gamepad1);
        manipulatorController = new GamepadEx(gamepad2);

        // 4. Initialize Subsystems (Pass hardwareMap here!)
        // (Assuming Intake and Indexer also take hardwareMap in their constructors)
        intakeSubsystem = new IntakeSubsystem(hardwareMap);
        indexerSubsystem = new IndexerSubsystem(hardwareMap);
        shooterSubsystem = new ShooterSubsystem(hardwareMap);
        driveTrain = new CommandMecanumDriveTrain(hardwareMap);

        mecanumDriveCommand = new MecanumDrive(driveTrain, () -> -driverController.getLeftY(), () -> driverController.getLeftX(), () -> driverController.getRightX());

        // 5. Initialize Commands (Safe now because subsystems are no longer null)
        intakeCommand = new intakeCommand(intakeSubsystem, indexerSubsystem);
        outtakeCommand = new OuttakeCommand(intakeSubsystem, indexerSubsystem);
        shootCommand = new ShootCommand(shooterSubsystem);

        // manipulatorController.getGamepadButton(GamepadKeys.Button.Y).whileHeld(new RunCommand(() -> intakeSubsystem.runIntake(0.5), intakeSubsystem));

        // 6. Assign Button Bindings
        manipulatorController.getGamepadButton(GamepadKeys.Button.A).whileHeld(shootCommand);

        driveTrain.setDefaultCommand(mecanumDriveCommand);

        // Uncomment these whenever your intake/outtake subsystems and commands are fully ready:

        manipulatorController.getGamepadButton(GamepadKeys.Button.X).whileHeld(outtakeCommand);

        manipulatorController.getGamepadButton(GamepadKeys.Button.Y).whileHeld(intakeCommand);

        driverController.getGamepadButton(GamepadKeys.Button.A).whenPressed(driveTrain::zeroGyro);
    }
}