package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Brandon",group="Linear Opmode")

public class BrandonTeleop extends LinearOpMode {
    private DcMotor rightMotor;
    private DcMotor leftMotor;
    @Override
    public void runOpMode(){
        rightMotor=hardwareMap.get(DcMotor.class,"right");
        leftMotor=hardwareMap.get(DcMotor.class,"left");

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


            telemetry.addData("Status","Running");
            telemetry.addData("X Joystick",x);
            telemetry.addData("Y Joysticl",y);
            telemetry.update();
        }
    }
}
