package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

@Autonomous(name = "RedFrontZone", group = "Autonomous")
public class RedFrontZone extends LinearOpMode {


    private DcMotor FRMotor;
    private DcMotor FLMotor;
    private DcMotor BRMotor;
    private DcMotor BLMotor;
    private Servo Claw;
    private ElapsedTime runtime = new ElapsedTime();



    public void runOpMode()
    {


        FRMotor = hardwareMap.dcMotor.get("FRMotor");
        FLMotor = hardwareMap.dcMotor.get("FLMotor");
        BRMotor = hardwareMap.dcMotor.get("BRMotor");
        BLMotor = hardwareMap.dcMotor.get("BLMotor");

        waitForStart();

        BLMotor.setPower(-1);
        FRMotor.setPower(1);
        FLMotor.setPower(-1);
        BRMotor.setPower(1);
        sleep(300);
        BLMotor.setPower(0);
        FRMotor.setPower(0);
        FLMotor.setPower(0);
        BRMotor.setPower(0);
        sleep(40000);
        idle();

    }
}
