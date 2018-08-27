package de.luisdasnilpferd.teamspeak;

import de.luisdasnilpferd.teamspeak.listener.TS3Listeners;
import de.luisdasnilpferd.teamspeak.utils.connection.TS3Connection;

/*********************************************************************************
 *   Urheberrechtshinweis                                                         *
 *   Copyright © Luis Garcia 2018                                                 *
 *   Erstellt: 26.08.2018 / 15:01                                                  *
 *                                                                                *
 *   Alle Inhalte dieses Quelltextes sind urheberrechtlich geschützt.             *
 *   Das Urheberrecht liegt, soweit nicht ausdrücklich anderes gekennzeichnet,    *
 *   bei Luis Garcia. Alle Rechte vorbehalten.                                    *
 *                                                                                *
 *   Jede Art der Vervielfältigung, Verbreitung, Vermietung, Verleihung,          *
 *   öffentlichen Zugänglichmachung oder andere Nutzung                           *
 *   bedarf der ausdrücklichen, schriftlichen Zustimmung von Luis Garcia.         *
 *********************************************************************************/

public class Main {

    public static void main(String[] args) {
            final TS3Connection ts3Connection = new TS3Connection("luisdasnilpferd.de","test","vrs2ICkJ",9987,"Nilpferd » Bot");
            ts3Connection.connect();
            new TS3Listeners(ts3Connection.getTs3Api()).loadListener();
    }


}
