package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.IndexerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class OuttakeCommand extends CommandBase {

IndexerSubsystem indexerSubsystem;

    IntakeSubsystem intakeSubsystem;
    public OuttakeCommand(IntakeSubsystem intakeSubsystem, IndexerSubsystem indexerSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    this.indexerSubsystem = indexerSubsystem;

        addRequirements(intakeSubsystem);
        addRequirements(indexerSubsystem);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intakeSubsystem.runIntake(-1);
        //indexer

        indexerSubsystem.runIndexer(-1);

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.runIntake(-0.00);

        indexerSubsystem.runIndexer(-0.00);
    }
}