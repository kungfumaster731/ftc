package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name="BrandonAuto",group="LinearOpMode")
public class BrandonAuto extends LinearOpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    @Override
    public void runOpMode(){
        rightMotor = hardwareMap.get(DcMotor.class,"right");
        leftMotor = hardwareMap.get(DcMotor.class,"left");
        ElapsedTime myTimer = new ElapsedTime();
        telemetry.addData("Status","Initailized");
        telemetry.update();
        moveTime(myTimer,0.5,0.5,1000);

    }
    public void moveTime(ElapsedTime myTimer,double right, double left,int time){
        waitForStart();
        myTimer.reset();
        leftMotor.setPower(0.5);
        rightMotor.setPower(0.5);
        while(myTimer.milliseconds()<time){

        }
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

}
