// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StringPublisher;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NetworkTableClient extends SubsystemBase {
    private final StringPublisher timePub;
    private final DateTimeFormatter timeFormat;
    private final NetworkTableInstance instance;
    private final DoublePublisher xPub, yPub;
    private double x, y;

    private LocalDateTime time = java.time.LocalDateTime.now();

    public NetworkTableClient() {
        instance = NetworkTableInstance.getDefault();
        NetworkTable table = instance.getTable(getName());

        timePub = table.getStringTopic("time").publish();
        timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd | hh:mm:ss | a");
        xPub = table.getDoubleTopic("x").publish();
        yPub = table.getDoubleTopic("y").publish();
    }

    @Override
    public void periodic() {
        // public values that increase constantly
        timePub.set(time.format(timeFormat));
        time = LocalDateTime.now();
    }

    /**
     * Increnents the values of x
     * 
     * @param xIncrement the value which x will change
     */
    public void incrementX(double xIncrement) {
        x += xIncrement;
        xPub.set(x);
    }

    /**
     * Increments the values of y
     * 
     * @param yIncrement the value which y will change
     */
    public void incrementY(double yIncrement) {
        y += yIncrement;
        yPub.set(y);
    }

    /**
     * Resets X and publishes the new value to the smart dashboard
     */
    public void resetX() {
        x = 0;
        xPub.set(x);
    }

    /**
     * Resets Y and publishes the new value to the smart dashboard
     */
    public void resetY() {
        y = 0;
        yPub.set(y);
    }

    public NetworkTableInstance getNetworkTableInstance() {
        return instance;
    }
}
