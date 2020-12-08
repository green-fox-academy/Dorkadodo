import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FleetOfThings {

    public static void main(String[] args) {
        // - Achieve this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch

        Fleet fleet = new Fleet();

        List<Thing> fleetOfThings =fleet.getFleet();

        addNewItem("Get milk", false, fleet);
        addNewItem("Remove the obstacles", false, fleet);
        addNewItem("Stand up", true, fleet);
        addNewItem("Eat lunch", true, fleet);

        Collections.sort(fleetOfThings);

        System.out.println(fleet);
    }

    public static void addNewItem(String newItem, boolean completed, Fleet fleet) {
        Thing newThing = new Thing(newItem);
        if (completed) {
            newThing.complete();
        }
        fleet.add(newThing);
    }
}