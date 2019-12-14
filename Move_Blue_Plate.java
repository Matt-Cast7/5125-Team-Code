package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//Tick Equation [(Distance/12.12)/2)*1440]
@Autonomous(name = "Move_Blue_Plate", group = "Autonomous")

public class Move_Blue_Plate extends LinearOpMode {


    Bot bot = new Bot();


    public void runOpMode()
    {


        bot.FRMotor = hardwareMap.dcMotor.get("FRMotor");
        bot.FLMotor = hardwareMap.dcMotor.get("FLMotor");
        bot.BRMotor = hardwareMap.dcMotor.get("BRMotor");
        bot.BLMotor = hardwareMap.dcMotor.get("BLMotor");

        bot.Claw = hardwareMap.get(Servo.class, "Claw");
        bot.Claw2 = hardwareMap.get(Servo.class, "Claw2");

        bot.BLMotor.setDirection(DcMotor.Direction.REVERSE);
        bot.FLMotor.setDirection(DcMotor.Direction.REVERSE);



        waitForStart();



        bot.FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.FRMotor.setTargetPosition(-2792);
        bot.FLMotor.setTargetPosition(-2792);
        bot.BRMotor.setTargetPosition(-2792);
        bot.BLMotor.setTargetPosition(-2792);

        bot.FRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        do{

            bot.BLMotor.setPower(1);
            bot.FRMotor.setPower(1);
            bot.FLMotor.setPower(1);
            bot.BRMotor.setPower(1);

        }
        while(bot.FRMotor.isBusy() && bot.BLMotor.isBusy() && bot.BRMotor.isBusy() && bot.FLMotor.isBusy());


        bot.Claw.setPosition(1);
        bot.Claw2.setPosition(1);

        sleep(1500);

        bot.FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.FRMotor.setTargetPosition(1000);
        bot.FLMotor.setTargetPosition(-1000);
        bot.BRMotor.setTargetPosition(1000);
        bot.BLMotor.setTargetPosition(-1000);

        bot.FRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        do {
            bot.BLMotor.setPower(0.25);
            bot.FRMotor.setPower(0.25);
            bot.FLMotor.setPower(0.25);
            bot.BRMotor.setPower(0.25);
        }while(bot.FRMotor.isBusy() && bot.BLMotor.isBusy() && bot.BRMotor.isBusy() && bot.FLMotor.isBusy());



        bot.FRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.FLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BRMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bot.BLMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        bot.FRMotor.setTargetPosition(-1000);
        bot.FLMotor.setTargetPosition(1000);
        bot.BRMotor.setTargetPosition(1000);
        bot.BLMotor.setTargetPosition(-1000);

        bot.FRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.FLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BRMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bot.BLMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        do {
            bot.BLMotor.setPower(0.25);
            bot.FRMotor.setPower(0.25);
            bot.FLMotor.setPower(0.25);
            bot.BRMotor.setPower(0.25);
        }while(bot.FRMotor.isBusy() && bot.BLMotor.isBusy() && bot.BRMotor.isBusy() && bot.FLMotor.isBusy());

        sleep(2500);

        idle();

    }
}
