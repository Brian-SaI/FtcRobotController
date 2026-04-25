/* Copyright (c) 2025 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.firstinspires.ftc.teamcode.Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

/*
 * This OpMode illustrates how to program your robot to drive field relative.  This means
 * that the robot drives the direction you push the joystick regardless of the current orientation
 * of the robot.
 *
 * This OpMode assumes that you have four mecanum wheels each on its own motor named:
 *   front_left_motor, front_right_motor, back_left_motor, back_right_motor
 *
 *   and that the left motors are flipped such that when they turn clockwise the wheel moves backwards
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 *
 */
@TeleOp(name = "Robot: Field Relative Swerve Drive", group = "Robot")
@Disabled
public class CommandSwerveDriveTrain extends SubsystemBase {
    // drive motors
    DcMotorEx frontLeftDrive;
    DcMotorEx frontRightDrive;
    DcMotorEx backLeftDrive;
    DcMotorEx backRightDrive;
    // steer motors
    Servo frontLeftSteer;
    Servo frontRightSteer;
    Servo backRightSteer;
    Servo backLeftSteer;

    // This declares the IMU needed to get the current direction the robot is facing
    IMU imu;

    //Front Left PID info
    public static double FL_kP = 40;
    public static double FL_kI = 0.05;
    public static double FL_kD = 0;
    public static double FL_kF = 11.65;
    //Front Left PID info
    public static double FR_kP = 40;
    public static double FR_kI = 0.05;
    public static double FR_kD = 0;
    public static double FR_kF = 11.65;
    //Front Left PID info
    public static double BL_kP = 40;
    public static double BL_kI = 0.05;
    public static double BL_kD = 0;
    public static double BL_kF = 11.65;
    //Front Left PID info
    public static double BR_kP = 40;
    public static double BR_kI = 0.05;
    public static double BR_kD = 0;
    public static double BR_kF = 11.65;

    public CommandSwerveDriveTrain() {
        // sets up all the drive motors
        frontLeftDrive = hardwareMap.get(DcMotorEx.class, "front_left_drive");
        frontRightDrive = hardwareMap.get(DcMotorEx.class, "front_right_drive");
        backLeftDrive = hardwareMap.get(DcMotorEx.class, "back_left_drive");
        backRightDrive = hardwareMap.get(DcMotorEx.class, "back_right_drive");
        // sets up all the steer motors
        frontLeftSteer = hardwareMap.get(Servo.class, "front_left_steer");
        frontRightSteer = hardwareMap.get(Servo.class, "front_left_steer");
        backRightSteer = hardwareMap.get(Servo.class, "front_left_steer");
        backLeftSteer = hardwareMap.get(Servo.class, "front_left_steer");

        // We set the left motors in reverse which is needed for drive trains where the left
        // motors are opposite to the right ones.
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);

        // This uses RUN_USING_ENCODER to be more accurate.   If you don't have the encoder
        // wires, you should remove these
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        imu = hardwareMap.get(IMU.class, "imu");
        // This needs to be changed to match the orientation on your robot
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection =
                RevHubOrientationOnRobot.LogoFacingDirection.UP;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection =
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD;

        RevHubOrientationOnRobot orientationOnRobot = new
                RevHubOrientationOnRobot(logoDirection, usbDirection);
        imu.initialize(new IMU.Parameters(orientationOnRobot));

        // set up drive motor PIDs TODO: CONFIGURE DRIVE PIDS
        frontLeftDrive.setVelocityPIDFCoefficients(FL_kP, FL_kI, FL_kD, FL_kF);
        frontRightDrive.setVelocityPIDFCoefficients(FR_kP, FR_kI, FR_kD, FR_kF);
        backLeftDrive.setVelocityPIDFCoefficients(BL_kP, BL_kI, BL_kD, BL_kF);
        backRightDrive.setVelocityPIDFCoefficients(BR_kP, BR_kI, BR_kD, BR_kF);
        // Make sure to set up the PIDS. This will in theory prevent drag.

    }

    @Override
    public void periodic() {
        // TODO: put stuff on the computer Dashboard for tuning and whatnot!

    }

    public void gyroZero() {
        imu.resetYaw();
    }

    // This routine drives the robot field relative
    private void driveFieldRelative(GamepadEx controller) {
        drive(controller);
        steer(controller);
    }

    public double spinSpeedCalculation(GamepadEx controller) {
        double maxTurnSpeed = 50;

        // turning should only apply to X-Axis. I think
        double turnSpeed = controller.getLeftX();

        if (Math.abs(turnSpeed) > 0.05) {
            return maxTurnSpeed * turnSpeed;
        }
        else {
            return 0;
        }
    }

    public double driveSpeedCalc(GamepadEx controller) {

        // get the distance between actual left stick point
        double controllerPower = Math.sqrt(Math.pow((controller.getLeftX()), 2) + Math.pow((controller.getLeftY()), 2));

        double outputSpeed = Math.min(controllerPower, 1);

        // multiply the max rotations per second by the controller power (shouldn't need to be positive?)
        // max theoretical motor velocity is 6000RPMs
        return 100 * outputSpeed;
    }
    public void drive(GamepadEx controller) {
        double forwardVelocity = driveSpeedCalc(controller);
        double turnVelocity = spinSpeedCalculation(controller);
        // diameter of the wheels, useful for determine robot speed
        double wheelDiameter = 64.0;
        // gives the robot velocity in m/s
        double robotVelocity = ((wheelDiameter * Math.PI)/1000) * forwardVelocity;

        // target velocity assuming you're turning left
        if (turnVelocity < -0) {
            // turning left
            frontLeftDrive.setVelocity((forwardVelocity+turnVelocity) * 360, AngleUnit.DEGREES);
            frontRightDrive.setVelocity((forwardVelocity-turnVelocity) * 360, AngleUnit.DEGREES);
            backLeftDrive.setVelocity((forwardVelocity+turnVelocity) * 360, AngleUnit.DEGREES);
            backRightDrive.setVelocity((forwardVelocity-turnVelocity) * 360, AngleUnit.DEGREES);
        } else if (turnVelocity > 0) {
            // turning right
            frontLeftDrive.setVelocity((forwardVelocity-turnVelocity) * 360, AngleUnit.DEGREES);
            frontRightDrive.setVelocity((forwardVelocity+turnVelocity) * 360, AngleUnit.DEGREES);
            backLeftDrive.setVelocity((forwardVelocity-turnVelocity) * 360, AngleUnit.DEGREES);
            backRightDrive.setVelocity((forwardVelocity+turnVelocity) * 360, AngleUnit.DEGREES);
        } else {
            // no turning
            frontLeftDrive.setVelocity(forwardVelocity * 360, AngleUnit.DEGREES);
            frontRightDrive.setVelocity(forwardVelocity * 360, AngleUnit.DEGREES);
            backLeftDrive.setVelocity(forwardVelocity * 360, AngleUnit.DEGREES);
            backRightDrive.setVelocity(forwardVelocity * 360, AngleUnit.DEGREES);
        }
    }

    // steering is just turret math except the field is a joystick
    public void steer(GamepadEx controller) {
        double swerveRotation;
        // TODO: update the pulley ratio for the actual pulley ratio!
        double pulleyRatio = 0.833333333; // 300 / 360
        double targetRotation;
        // servos like SWYFT tend to have their 0 degrees point be at 0.5, this accounts for that.
        double normalizedAngle;

        if (Math.abs(controller.getLeftX()) > 0.05 || Math.abs(controller.getLeftY()) > 0.05) {
            // as weird as it sounds, the atan function goes "Y,X" instead of "X,Y".
            targetRotation = Math.toDegrees(Math.atan2(controller.getLeftY(), controller.getLeftX()));
            normalizedAngle = (targetRotation + 180) / 360.0;
            swerveRotation = normalizedAngle * pulleyRatio;

            // sets the target rotation of the servos
            frontLeftSteer.setPosition(swerveRotation);
            frontRightSteer.setPosition(swerveRotation);
            backLeftSteer.setPosition(swerveRotation);
            backRightSteer.setPosition(swerveRotation);
        }
    }
}
