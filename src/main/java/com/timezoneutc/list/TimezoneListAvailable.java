package com.timezoneutc.list;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 * @author rute.souza
 *
 */
public class TimezoneListAvailable {

    public static void list() {
        new TimezoneListAvailable().availableZones();
    }

    private void availableZones() {
        final Set<String> setAvailableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println("\n Available zones\n");

        final ArrayList<String> availableZoneIds = new ArrayList<String>(setAvailableZoneIds);
        Collections.sort(availableZoneIds);

        for (final String string : availableZoneIds) {
            System.out.println(string);
        }

        System.out.println("\n\n\n ----- " + availableZoneIds.size() + " zones ------ \n\n");
    }

}
