package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

@Autonomous(name = "StrafeAuto", group = "Autonomous")
public class StrafeAuto extends LinearOpMode {


    Bot bot = new Bot();
    private ElapsedTime runtime = new ElapsedTime();



    public void runOpMode()
    {


        bot.FRMotor = hardwareMap.dcMotor.get("FRMotor");
        bot.FLMotor = hardwareMap.dcMotor.get("FLMotor");
        bot.BRMotor = hardwareMap.dcMotor.get("BRMotor");
        bot.BLMotor = hardwareMap.dcMotor.get("BLMotor");

        bot.Claw = hardwareMap.get(Servo.class, "Claw");

        waitForStart();

        bot.BLMotor.setPower(-1);
        bot.FRMotor.setPower(1);
        bot.FLMotor.setPower(1);
        bot.BRMotor.setPower(-1);
        sleep(1000);
        bot.BLMotor.setPower(0);
        bot.FRMotor.setPower(0);
        bot.FLMotor.setPower(0);
        bot.BRMotor.setPower(0);
        sleep(1000);

        bot.Claw.setPosition(1);

        sleep(2000);

        bot.BLMotor.setPower(1);
        bot.FRMotor.setPower(-1);
        bot.FLMotor.setPower(-1);
        bot.BRMotor.setPower(1);

        sleep(1000);

        bot.BLMotor.setPower(0);
        bot.FRMotor.setPower(0);
        bot.FLMotor.setPower(0);
        bot.BRMotor.setPower(0);

        sleep(40000);

        idle();

    }
}
