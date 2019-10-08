package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
public class Hardware
{

    public DcMotor FRMotor;
    public DcMotor FLMotor;
    public DcMotor BRMotor;
    public DcMotor BLMotor;
    public Servo Hook;

    HardwareMap hwMap           ;

    public Hardware(){

    }

    public void init(HardwareMap ahwMap)
    {

        hwMap = ahwMap;
        FRMotor = hwMap.dcMotor.get("FRMotor");
        FLMotor = hwMap.dcMotor.get("FLMotor");
        BRMotor = hwMap.dcMotor.get("BRMotor");
        BLMotor = hwMap.dcMotor.get("BLMotor");
        Hook = hwMap.get(Servo.class, "Hook");

    }

}
