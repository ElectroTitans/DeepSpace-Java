/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.networking.Networking;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public class NetworkingSettings{
    public static final boolean useVictoryConnect = false;
  }
  public class HID{
    public static final int joyboy1 = 0;
    public static final int joyboy2 = 1;
  }

  public class CAN{
    public static final int driveLeft1 = 3;
    public static final int driveLeft2 = 4;
    public static final int driveRight1 = 2;
    public static final int driveRight2 = 1;

    public static final int elevator1 = 5;

    public static final int intakeWheel1 = 6;
    public static final int intakeWheel2 = 7;
  }


  public class DIO{
    public static final int encoderLeft1 = 0;
    public static final int encoderLeft2 = 1;
    public static final int encoderRight1 = 2;
    public static final int encoderRight2 = 3;

    public static final int hallEffectTop = 4;
    public static final int hallEffectBottom = 5;
  }

  public class Analog{
    public static final int pressureSensor = 0;
  }

  public class DriveProfile{
    public static final double maxAccel = 2.0;
    public static final double maxVelocity = 1.7;
    public static final double maxJerk = 60.0;
    public static final double wheelBaseWidth = 0.5;
    public static final double gearRatio = 10.71;
    public static final double encoderTicks = 40;
    public static final double gearBoxTicks = encoderTicks * gearRatio; 
    public static final double wheelDiameter = 0.1524;
    public static final double ticksPerMeter = gearBoxTicks * ((wheelDiameter / 2) * (2*3.1415));
    public static final double P = 1.0;
    public static final double I = 0;
    public static final double D = 0;
    public static final double V = 1 / maxVelocity;
    public static final double A = 0;
    public static final double trim  = -0.15;
  }

  public static class ElevatorProfile{
    public static double maxAccel = 2.0;
    public static double maxVelocity = 1.7;

    public static double P = 1.0;
    public static double I = 0;
    public static double D = 0;
    public static double V = 1 / maxVelocity;
    public static double A = 0;
    public static double encoderTicks = 40;
  }

  public static void syncWithNetwork(){
    Networking.vcClient.setTopic("bot/profile/elevator/P", ElevatorProfile.P);
    Networking.vcClient.setTopic("bot/profile/elevator/I", ElevatorProfile.I);
    Networking.vcClient.setTopic("bot/profile/elevator/D", ElevatorProfile.D);

  }
}
