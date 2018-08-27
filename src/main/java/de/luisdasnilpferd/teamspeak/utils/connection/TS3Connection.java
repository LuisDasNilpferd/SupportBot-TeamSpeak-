package de.luisdasnilpferd.teamspeak.utils.connection;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

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

public class TS3Connection {

    private final TS3Config ts3Config;
    private final TS3Query ts3Query;
    private final TS3Api ts3Api;

    private final String host,username,password;
    private final int port;

    private String displayname;

    public TS3Connection(final String host, final String username, final String password , final int port , final String displayname) {

        this.host = host;

        this.ts3Config = new TS3Config();
        this.ts3Query = new TS3Query(this.ts3Config);
        this.ts3Api = this.ts3Query.getApi();

        this.username = username;
        this.password = password;
        this.displayname = displayname;

        this.port = port;
    }

    public void connect(){

        if(!this.ts3Query.isConnected()) {
            this.ts3Config.setHost(host);
            this.ts3Config.setFloodRate(TS3Query.FloodRate.UNLIMITED);

            this.ts3Query.connect();

            this.ts3Api.login(this.username, this.password);
            this.ts3Api.selectVirtualServerByPort(this.port);

            this.ts3Api.setNickname(this.displayname);
        }
    }

    public void disconnect(){ if(this.ts3Query.isConnected()) this.ts3Query.exit(); }

    public void setDisplayname(final String displayname){
        if(this.ts3Query.isConnected())this.ts3Api.setNickname(displayname);
        this.displayname = displayname;
    }

    public String getDisplayname() {
        return displayname;
    }

    public TS3Query getTs3Query() {
        return ts3Query;
    }

    public TS3Api getTs3Api() {
        return ts3Api;
    }

    public TS3Config getTs3Config() {
        return ts3Config;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }
}
