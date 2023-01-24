package Team4450.Lib.Swerve;

import Team4450.Lib.Util;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;

@FunctionalInterface
public interface DriveControllerFactory<Controller extends DriveController, DriveConfiguration> 
{
    default void addDashboardEntries(ShuffleboardContainer container, Controller controller) 
    {
        Util.consoleLog();
    
        container.addNumber("Current Velocity", controller::getVelocity).withPosition(0, 3);
        //TODO: remove these items when done testing.
        container.addNumber("Distance", controller::getDistance).withPosition(0,  4);
        //container.addNumber("1 Voltage", controller::getVoltage);
        //container.addNumber("Drive Encoder position", () -> controller.getEncoder().getPosition()); 
    }

    default Controller create(
            ShuffleboardContainer container,
            DriveConfiguration driveConfiguration,
            ModuleConfiguration moduleConfiguration) 
    {
        Util.consoleLog();
    
        var controller = create(driveConfiguration, moduleConfiguration);
        
        addDashboardEntries(container, controller);

        return controller;
    }

    Controller create(DriveConfiguration driveConfiguration, ModuleConfiguration moduleConfiguration);
}
