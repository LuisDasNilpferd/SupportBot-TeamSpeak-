package de.luisdasnilpferd.teamspeak;

import de.luisdasnilpferd.teamspeak.listener.TS3Listeners;
import de.luisdasnilpferd.teamspeak.utils.connection.TS3Connection;

/**
 * Created by LuisDasNilpferd | Luis Gar.
 */

public class Main {

    public static void main(String[] args) {
            final TS3Connection ts3Connection = new TS3Connection("luisdasnilpferd.de","test","vrs2ICkJ",9987,"Nilpferd » Bot");
            ts3Connection.connect();
            new TS3Listeners(ts3Connection.getTs3Api()).loadListener();
    }


}
