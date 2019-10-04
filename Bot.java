package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
public class Bot
{

    public DcMotor FRMotor = null;
    public DcMotor FLMotor = null;
    public DcMotor BRMotor = null;
    public DcMotor BLMotor = null;
    public Servo Hook = null;

    HardwareMap hwMap           =  null;

    public void init(HardwareMap ahwMap)
    {

        hwMap = ahwMap;
        FRMotor = hwMap.dcMotor.get("FRMotor");
        FLMotor = hwMap.dcMotor.get("FLMotor");
        BRMotor = hwMap.dcMotor.get("BRMotor");
        BLMotor = hwMap.dcMotor.get("BLMotor");
        Hook = hwMap.servo.get("Hook");

    }

}
