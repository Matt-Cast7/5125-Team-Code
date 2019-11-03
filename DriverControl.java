package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "DriveControl", group = "TeleOp")
public class DriverControl extends LinearOpMode {
    Bot bot = new Bot();


    private int L = 0;
    private int R = 0;
    boolean L0;
    boolean L1;
    boolean L2;
    boolean L3;


    @Override
    public void runOpMode() throws InterruptedException {

        bot.FRMotor = hardwareMap.dcMotor.get("FRMotor");
        bot.FLMotor = hardwareMap.dcMotor.get("FLMotor");
        bot.BRMotor = hardwareMap.dcMotor.get("BRMotor");
        bot.BLMotor = hardwareMap.dcMotor.get("BLMotor");
        bot.Claw = hardwareMap.get(Servo.class, "Claw");
        bot.Claw2 = hardwareMap.get(Servo.class, "Claw2");
        bot.Lift1 = hardwareMap.dcMotor.get("Lift1");
        bot.Lift2 = hardwareMap.dcMotor.get("Lift2");


        waitForStart();

        while (opModeIsActive()) {
            bot.FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.Lift1.setDirection(DcMotor.Direction.FORWARD);
            bot.Lift2.setDirection(DcMotor.Direction.REVERSE);


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
            //makes sure these values don't accidentally go beyond 0 or 1
            L = Range.clip(L, 0, 1);
            R = Range.clip(R, 0, 1);


            //controls the movement of the bot
            if (gamepad1.left_stick_x == 0) {
                bot.FRMotor.setPower(-RSpeed);
                bot.BRMotor.setPower(-RSpeed);
                bot.FLMotor.setPower(LSpeed);
                bot.BLMotor.setPower(LSpeed);
            } else {

                bot.FRMotor.setPower(-FRspeed);
                bot.BLMotor.setPower(BLspeed);
                bot.FLMotor.setPower(FLspeed);
                bot.BRMotor.setPower(-BRspeed);

            }


            //left and right hooks to move building zones
            if (gamepad2.left_bumper && L == 0) {
                L = +1;

                bot.Claw.setPosition(1);
                sleep(500);

            } else if (gamepad2.left_bumper && L == 1) {
                L = -1;
                bot.Claw.setPosition(-0.5);
                sleep(500);
            }
            if (gamepad2.right_bumper && R == 0) {
                R = +1;
                bot.Claw2.setPosition(-0.5);
                sleep(500);

            } else if (gamepad2.right_bumper && R == 1) {
                R = -1;
                bot.Claw2.setPosition(1);
                sleep(500);
            }

            //zeros the lift
            if (gamepad2.start) {
                L0 = true;
                L1 = false;
                L2= false;
                L3 = false;

            }

            if (gamepad2.dpad_up) {
                if (L0) {
                    bot.Lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift1.setTargetPosition(1440);
                    bot.Lift2.setTargetPosition(1440);
                    while (bot.Lift1.isBusy() && bot.Lift2.isBusy() && opModeIsActive()) {
                    }
                    L0 = false;
                    L1 = true;
                } else if (L1) {
                    bot.Lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift1.setTargetPosition(2880);
                    bot.Lift2.setTargetPosition(2880);
                    while (bot.Lift1.isBusy() && bot.Lift2.isBusy() && opModeIsActive()) {
                    }
                    L1 = false;
                    L2 = true;
                } else if (L2) {
                    bot.Lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift1.setTargetPosition(4320);
                    bot.Lift2.setTargetPosition(4320);
                    while (bot.Lift1.isBusy() && bot.Lift2.isBusy() && opModeIsActive()) {
                    }
                    L2 = false;
                    L3 = true;
                } else if (L3) {
                }
            }

            if (gamepad2.dpad_down) {
                if (L3) {
                    bot.Lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift1.setTargetPosition(2880);
                    bot.Lift2.setTargetPosition(2880);
                    while (bot.Lift1.isBusy() && bot.Lift2.isBusy() && opModeIsActive()) {
                    }
                    L3 = false;
                    L2 = true;
                }else if(L2)
                {
                    bot.Lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift1.setTargetPosition(1440);
                    bot.Lift2.setTargetPosition(1440);
                    while (bot.Lift1.isBusy() && bot.Lift2.isBusy() && opModeIsActive()) {
                    }
                    L2 = false;
                    L1 = true;
                }else if(L1)
                {
                    bot.Lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bot.Lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    bot.Lift1.setTargetPosition(0);
                    bot.Lift2.setTargetPosition(0);
                    while (bot.Lift1.isBusy() && bot.Lift2.isBusy() && opModeIsActive()) {
                    }
                    L1 = false;
                    L0 = true;
                }


                idle();
            }
        }
    }
}