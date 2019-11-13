package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name = "DriveControl", group = "TeleOp")
public class DriverControl extends LinearOpMode {
    Bot bot = new Bot();



    private int L = 0;
    private int R = 0;


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
        bot.LiftClaw1 = hardwareMap.get(CRServo.class, "LiftClaw1");
        bot.LiftClaw2 = hardwareMap.get(CRServo.class, "LiftClaw2");


        waitForStart();

        while (opModeIsActive()) {
            bot.FRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.FLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.BRMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.BLMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.Lift1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.Lift2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            bot.Lift1.setDirection(DcMotor.Direction.FORWARD);
            bot.Lift2.setDirection(DcMotor.Direction.REVERSE);


            double FLspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double BLspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double FRspeed = gamepad1.left_stick_y + gamepad1.left_stick_x;
            double BRspeed = gamepad1.left_stick_y - gamepad1.left_stick_x;
            double LSpeed = gamepad1.left_stick_y;
            double RSpeed = gamepad1.right_stick_y;
            double LiftS1 = gamepad2.right_trigger + -gamepad2.left_trigger;
            double LiftS2 = gamepad2.right_trigger + -gamepad2.left_trigger;
            double ClawSpeed1 = gamepad2.left_stick_x;
            double ClawSpeed2 = gamepad2.right_stick_x;


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
            LiftS1 = Range.clip(LiftS1, -1, 1);
            LiftS2 = Range.clip(LiftS2, -1, 1);
            ClawSpeed1 = Range.clip(ClawSpeed1, -1, 1);
            ClawSpeed2 = Range.clip(ClawSpeed2, -1, 1);


            //controls the movement & strafing of the bot
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



            bot.Lift1.setPower(LiftS1);
            bot.Lift2.setPower(LiftS2);

            bot.LiftClaw1.setPower(ClawSpeed1);
            bot.LiftClaw2.setPower(ClawSpeed2);




            idle();
        }
    }
}