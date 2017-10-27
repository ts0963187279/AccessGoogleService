/*
 * Copyright (C) 2017 RS Wong <ts0963187279@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.java.accessgoogleservice.module;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.util.LinkedList;
import java.util.List;

public class OAuth2Data {
    private List<String> scopes = new LinkedList<String>();
    private String clientId;
    private String clientSecrets;
    private String userName;
    private HttpTransport transport = new NetHttpTransport();
    private JsonFactory jsonFactory = new JacksonFactory();
    private String redirectUri = "urn:ietf:wg:oauth:2.0:oob";
    public void addScope(String scope){
        scopes.add(scope);
    }
    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public String getClientId(){
        return clientId;
    }
    public void setClientSecrets(String clientSecrets){
        this.clientSecrets = clientSecrets;
    }
    public String getClientSecrets(){
        return clientSecrets;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }
    public List<String> getScope(){
        return scopes;
    }
    public HttpTransport getTransport() {
        return transport;
    }
    public JsonFactory getJsonFactory() {
        return jsonFactory;
    }
    public String getRedirectUri() {
        return redirectUri;
    }
}
