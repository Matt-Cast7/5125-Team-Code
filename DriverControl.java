package org.firstinspires.ftc.teamcode;

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
    private Servo Hook;


    @Override
    public void runOpMode() throws InterruptedException
    {

        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");
        BLMotor = hardwareMap.dcMotor.get("BLMotor");
        Hook = hardwareMap.servo.get("Hook");


        waitForStart();

        while(opModeIsActive())
        {
            FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            double FLspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double BLspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double FRspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double BRspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double RSpeed = gamepad1.right_stick_x;

            //cuts the speed value of the motors to not be <1 or >1
            FLspeed = Range.clip(FLspeed, -1, 1);
            BLspeed = Range.clip(BLspeed, -1, 1);
            FRspeed = Range.clip(FRspeed, -1, 1);
            BRspeed = Range.clip(BRspeed, -1, 1);

            if (gamepad1.right_stick_x ==0)
            {

                FRMotor.setPower(FRspeed);
                BLMotor.setPower(BLspeed);
                FLMotor.setPower(FLspeed);
                BRMotor.setPower(BRspeed);


            }else
                {
                    FRMotor.setPower(RSpeed);
                    BLMotor.setPower(-RSpeed);
                    FLMotor.setPower(-RSpeed);
                    BRMotor.setPower(RSpeed);
                }
            if (gamepad2.a)
            {
                Hook.setPosition(1);

            }else if (gamepad2.b)
            {
                Hook.setPosition(-1);
            }


            idle();
        }
    }
}