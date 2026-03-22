package org.firstinspires.ftc.teamcode.Commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.Subsystems.SubsystemTest;

public class CommandTest extends CommandBase {
    private final SubsystemTest subsystem;
    private final double power;
    private final double durationSeconds;
    private final ElapsedTime timer = new ElapsedTime();

    public CommandTest(SubsystemTest subsystem, double power, double durationSeconds) {
        this.subsystem = subsystem;
        this.power = power;
        this.durationSeconds = durationSeconds;

        // This is exactly like FRC's addRequirements(subsystem);
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        subsystem.setPower(power);
    }

    @Override
    public void execute() {
        // You could add logic here if the power needed to change over time
    }

    @Override
    public boolean isFinished() {
        // Return true when the timer hits the limit
        return timer.seconds() >= durationSeconds;
    }

    @Override
    public void end(boolean interrupted) {
        // Always good practice to shut off the motor
        subsystem.setPower(0);
    }
}