package com.timezoneutc.main;

import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.timezoneutc.list.TimezoneListAvailable;

/**
 *
 * @author rute.souza
 *
 */
public class Main {

    public static void main(final String[] args) {

        System.out.println("\n\n ------ Settings java: If your region has daylight saving time, find out when to switch UTC to your location");
        System.out.println(" ------ Descubra como o java está configurado para mudar o horário de verão, caso a região tenha horário de verão\n");
        System.out.println("\n\nYou can try set other zone:");
        System.out.println("Such as: \n java -jar timezonejavatester-1.0.jar \"America/Rio_Branco\"");
        System.out.println("Also you can choose 2 days to show UTC by month: \n java -jar timezonejavatester-1.0.jar \"America/Rio_Branco\" \"2\" \"20\"");
        System.out.println(" -- -- --");

        String zoneParameter = "";
        Integer dayStarts = 1;
        Integer dayEnds = 25;
        if (args != null && args.length > 0) {
            zoneParameter = args[0];
            try {
                dayStarts = Integer.parseInt(args[1]);
                dayEnds = Integer.parseInt(args[2]);
            } catch (final Throwable t) {

            }

        }

        TimezoneListAvailable.list();

        final ZoneId systemDefault = Main.discoveryZone(zoneParameter);
        System.out.println("Your zone: " + systemDefault);

        Main.pintOfZone(systemDefault, dayStarts, dayEnds);

        System.out.println("");
    }

    private static ZoneId discoveryZone(final String zoneParameter) {
        ZoneId systemDefault = ZoneId.systemDefault();
        systemDefault = ZoneId.of("US/Hawaii");
        if (!zoneParameter.isEmpty()) {
            try {
                final ZoneId of = ZoneId.of(zoneParameter);
                if (of != null) {
                    systemDefault = of;
                }
            } catch (final Exception e) {
                System.out.println("Invalid zone: " + zoneParameter + " " + e.getMessage());
            }
        }
        return systemDefault;
    }

    private static void pintOfZone(final ZoneId systemDefault, final Integer dayStarts, final Integer dayEnds) {

        final TimeZone timeZone = TimeZone.getTimeZone(systemDefault);

        for (int i = 0; i < 12; i++) {

            System.out.println(" -- ");

            Main.setData(timeZone, i, dayStarts, 8);
            Main.setData(timeZone, i, dayEnds, 8);

            System.out.println(" -- ");
        }
    }

    private static void setData(final TimeZone timeZone, final int month, final int day, final int hour) {

        final GregorianCalendar x = new GregorianCalendar(timeZone);
        x.set(2018, month, day, hour, 10);

        final int offset = timeZone.getOffset(x.getTimeInMillis());

        final Integer hours = (int) (offset / 3600000);

        System.out.println(timeZone.getID() + " Time => " + x.getTime() + Main.getSummerTime(hours, timeZone.getID()));

    }

    private static String getSummerTime(final int hours, final String zoneId) {
        return "  [[ UTC: " + hours + " ]]";
    }

}
