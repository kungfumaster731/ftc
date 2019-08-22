package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Brandon",group="Linear Opmode")

public class BrandonTeleop extends LinearOpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    private DcMotor armMotor;
    private DcMotor elevatorMotor;
    private Servo scoopMotor;
    @Override
    public void runOpMode(){
        rightMotor=hardwareMap.get(DcMotor.class,"right");
        leftMotor=hardwareMap.get(DcMotor.class,"left");
        armMotor=hardwareMap.get(DcMotor.class,"scoop");
        elevatorMotor=hardwareMap.get(DcMotor.class,"elevator");
        scoopMotor=hardwareMap.get(Servo.class,"arm");
        telemetry.addData("Status","Initialized");
        telemetry.update();
        boolean modes=false;
        boolean prevMode = true;
        waitForStart();
        while(opModeIsActive()){
            double x = this.gamepad1.right_stick_x;
            double y = this.gamepad1.right_stick_y;
            double right = -this.gamepad1.right_stick_y;
            double left  = this.gamepad1.left_stick_y;
            if(this.gamepad1.x&&prevMode==modes){
                modes=!modes;
            }
            prevMode = modes;
            if(modes==false){
                leftMotor.setPower(y-x);
                rightMotor.setPower(-y-x);
            }
            else{
                leftMotor.setPower(left);
                rightMotor.setPower(right);
            }
            if(this.gamepad1.dpad_up){
                armMotor.setPower(1);
            }
            else if(this.gamepad1.dpad_down){
                armMotor.setPower(-1);
            }
            else{
                armMotor.setPower(0);
            }
            if(this.gamepad1.right_bumper){
                elevatorMotor.setPower(1);
            }
            if(this.gamepad1.right_trigger>0.5){
                elevatorMotor.setPower(-1);
            }
            else{
                elevatorMotor.setPower(0);
            }
            if(this.gamepad1.left_bumper) {
                scoopMotor.setPosition(180);
            }
            else if(this.gamepad1.left_trigger>0.5){
                scoopMotor.setPosition(-180);
            }
            else{
                scoopMotor.setPosition(0);
            }


            telemetry.addData("Status","Running");
            telemetry.addData("X Joystick",x);
            telemetry.addData("Y Joysticl",y);
            telemetry.update();
        }
    }
}
