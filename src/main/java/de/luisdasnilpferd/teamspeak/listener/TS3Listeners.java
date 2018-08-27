package de.luisdasnilpferd.teamspeak.listener;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.api.event.*;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

/**
 * Created by LuisDasNilpferd | Luis Gar.
 */

public class TS3Listeners {

    private final TS3Api ts3API;

    public TS3Listeners(final TS3Api ts3Api){
        this.ts3API = ts3Api;
    }

    public void loadListener() {
        this.ts3API.registerAllEvents();
        this.ts3API.addTS3Listeners(new TS3Listener() {
          public void onTextMessage(TextMessageEvent e) {
              //TODO
          }

          public void onClientJoin(ClientJoinEvent clientJoinEvent) {
              //TODO
          }

          public void onClientLeave(ClientLeaveEvent e) {
              //TODO
          }

          public void onServerEdit(ServerEditedEvent e) {
              //TODO
          }

          public void onChannelEdit(ChannelEditedEvent e) {
              //TODO
          }

          public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent e) {
              //TODO
          }

          public void onClientMoved(ClientMovedEvent clientMovedEvent) {

              final int clientId = clientMovedEvent.getClientId();
              final int channelId = clientMovedEvent.getTargetChannelId();

              String nickname = "";

              for(Client clients : ts3API.getClients()){ if(clients.getId() == clientId){nickname = clients.getNickname();} }

              if(channelId == 382) {
                  for (Client clients : ts3API.getClients()) {
                      if (clients.isInServerGroup(299)) {
                          ts3API.pokeClient(clients.getId(), "Der Spieler " + nickname +  " ist im Support-Warteraum.");
                      }
                  }
              }

          }

          public void onChannelCreate(ChannelCreateEvent e) {
              //TODO
          }

          public void onChannelDeleted(ChannelDeletedEvent e) {
              //TODO
          }

          public void onChannelMoved(ChannelMovedEvent e) {
              //TODO
          }

          public void onChannelPasswordChanged(ChannelPasswordChangedEvent e) {
              //TODO
          }

          public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent e) {
              //TODO
          }
      });
    }

}
