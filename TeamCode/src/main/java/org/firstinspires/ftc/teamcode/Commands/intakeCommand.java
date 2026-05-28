package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.IndexerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class intakeCommand extends CommandBase {

    IndexerSubsystem indexerSubsystem;

    IntakeSubsystem intakeSubsystem;
    public intakeCommand(IntakeSubsystem intakeSubsystem, IndexerSubsystem indexerSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    this.indexerSubsystem = indexerSubsystem;

        addRequirements(intakeSubsystem);
        addRequirements(indexerSubsystem);

    }

    @Override
    public void initialize() {
        intakeSubsystem.runIntake(1);
        //indexer

        indexerSubsystem.runIndexer(1);
    }

    @Override
    public void execute() {


    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.runIntake(0);
        //indexer

        indexerSubsystem.runIndexer(0);
    }
}