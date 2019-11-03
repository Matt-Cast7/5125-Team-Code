package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
public class Bot
{

    public DcMotor FRMotor;
    public DcMotor FLMotor;
    public DcMotor BRMotor;
    public DcMotor BLMotor;
    public Servo Claw;
    public Servo Claw2;
    public DcMotor Lift1;
    public DcMotor Lift2;


    HardwareMap hwMap;

    public Bot(){

    }

    public void init(HardwareMap ahwMap)
    {

        hwMap = ahwMap;
        FRMotor = hwMap.dcMotor.get("FRMotor");
        FLMotor = hwMap.dcMotor.get("FLMotor");
        BRMotor = hwMap.dcMotor.get("BRMotor");
        BLMotor = hwMap.dcMotor.get("BLMotor");
        Claw = hwMap.get(Servo.class, "Claw");
        Claw2 = hwMap.get(Servo.class, "Claw2");
        Lift1 = hwMap.dcMotor.get("Lift1");
        Lift2 = hwMap.dcMotor.get("Lift2");


    }

}
