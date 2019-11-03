package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.TfodSkyStone;

import java.util.List;

@Autonomous(name = "ImageDetect", group = "Autonomous")
public class ImageDetect extends LinearOpMode {
    Bot bot = new Bot();

    private static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Stone";
    private static final String LABEL_SECOND_ELEMENT = "Skystone";

    private static final String VUFORIA_KEY =

            "AZBvjMn/////AAABmRvYg913S0qkoqmflyByhqNFdXTx3qKoESecl4WUW48rfFU3+SbkiiwTz1ovvubWWso3VHkgS48l06bCCHmuTeHWxlyxqeW8Se4vxH0cOr6kN+BbwCZKoabRjoy246WjNWdFPKsFJf76rgXlSaeDbP7lRPEPOV3ScYym/IFxdTEMsUpwAjIEJ3arGmtaa42mkYUBeyBI9JuD1r+Yly8REAumac0fTu6UzYSd2/Fu905T38l8SSt47z72cQJrgOmNIuzzniAPJfWVnC9Wi/3o2PVQM041Ix84afgscOtERO3j0Yq/ut+VduwCu8AkV3efWt0V0pDNeTB0+meG879l5+hw0QHTQtMUTOJAMSUpUbq6";

    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;


    @Override
    public void runOpMode() {

        initVuforia();
        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }

        if (tfod != null) {
            tfod.activate();

            waitForStart();





        }
    }

    private void initVuforia() {

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

    }


    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfodParameters.minimumConfidence = 0.8;
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);


    }


}