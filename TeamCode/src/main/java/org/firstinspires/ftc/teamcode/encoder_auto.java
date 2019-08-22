package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name="encoder_auto",group="LinearOpMode")
public class encoder_auto extends LinearOpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private double diameter;
    private double distance_in_cm;
    private double ticks_per_rotations = 1440;

    public int encoder(double distance) {
        diameter = 10.16;
        distance_in_cm = distance;
        double rotations = distance_in_cm / (Math.PI * diameter);
        double ticks = rotations * 1440;
        return (int) ticks;
    }
    public void moveTarget(){
        rightMotor.setTargetPosition(encoder(10));
        leftMotor.setTargetPosition(encoder(-10));
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setPower(0.7);
        leftMotor.setPower(-0.7);
        while(leftMotor.isBusy()&&rightMotor.isBusy()){

        }
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }

    @Override
    public void runOpMode() {
        rightMotor = hardwareMap.get(DcMotor.class, "right");
        leftMotor = hardwareMap.get(DcMotor.class, "left");
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        moveTarget();

    }
}
