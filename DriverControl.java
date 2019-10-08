package org.firstinspires.ftc.teamcode;

import android.text.style.TtsSpan;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "DriveControl", group = "TeleOp")
public class DriverControl extends LinearOpMode
{

    private DcMotor FRMotor;
    private DcMotor FLMotor;
    private DcMotor BRMotor;
    private DcMotor BLMotor;
    private Servo Claw;


    @Override
    public void runOpMode() throws InterruptedException
    {

        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");
        BLMotor = hardwareMap.dcMotor.get("BLMotor");
        Claw = hardwareMap.get(Servo.class, "Claw");


        waitForStart();

        while(opModeIsActive())
        {
            FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


            //double StrafeL = gamepad1.left_stick_x;
            //double StrafeR = gamepad1.left_stick_x;
            double FLspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double BLspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double FRspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double BRspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double LSpeed = gamepad1.left_stick_y;
            double RSpeed = gamepad1.right_stick_y;



            //cuts the speed value of the motors to not be <1 or >1
            FLspeed = Range.clip(FLspeed, -1, 1);
            BLspeed = Range.clip(BLspeed, -1, 1);
            FRspeed = Range.clip(FRspeed, -1, 1);
            BRspeed = Range.clip(BRspeed, -1, 1);
            LSpeed = Range.clip(LSpeed, -1, 1);
            RSpeed = Range.clip(RSpeed, -1, 1);
            //StrafeL = Range.clip(StrafeL, -1, 0);
            //StrafeR = Range.clip(StrafeR, 0, 1);

            if (gamepad1.left_stick_x == 0)
            {
                FRMotor.setPower(-RSpeed);
                BRMotor.setPower(-RSpeed);
                FLMotor.setPower(LSpeed);
                BLMotor.setPower(LSpeed);
            }else
            {

                FRMotor.setPower(-FRspeed);
                BLMotor.setPower(BLspeed);
                FLMotor.setPower(FLspeed);
                BRMotor.setPower(-BRspeed);

            }



            //FRMotor.setPower(-StrafeL);
            //FLMotor.setPower(-StrafeL);
            //BRMotor.setPower(StrafeL);
            //BLMotor.setPower(StrafeL);

            //FRMotor.setPower(-StrafeR);
            //FLMotor.setPower(-StrafeR);
            //BRMotor.setPower(StrafeR);
            //BLMotor.setPower(StrafeR);


            //FRMotor.setPower(RSpeed);
            //BRMotor.setPower(RSpeed);
            //FLMotor.setPower(LSpeed);
            //BLMotor.setPower(LSpeed);

            if (gamepad2.a)
            {
                Claw.setPosition(1);

            }else if (gamepad2.b)
            {
                Claw.setPosition(-0.5);
            }

            idle();
        }
    }
}