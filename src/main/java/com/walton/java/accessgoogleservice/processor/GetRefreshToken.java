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
package com.walton.java.accessgoogleservice.processor;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.walton.java.accessgoogleservice.module.OAuth2Data;
import poisondog.core.Mission;

import java.io.IOException;
import java.util.List;

public class GetRefreshToken implements Mission<String> {
    private String clientId;
    private String clientSecrets;
    private List<String> scopes;
    private HttpTransport transport;
    private JsonFactory jsonFactory;
    private String redirectUri;
    public GetRefreshToken(OAuth2Data oAuth2Data){
        clientId = oAuth2Data.getClientId();
        clientSecrets = oAuth2Data.getClientSecrets();
        scopes = oAuth2Data.getScope();
        transport = oAuth2Data.getTransport();
        jsonFactory = oAuth2Data.getJsonFactory();
        redirectUri = oAuth2Data.getRedirectUri();
    }
    public String execute(String authCode){
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(transport,jsonFactory,clientId,clientSecrets,scopes).build();
        GoogleTokenResponse response = null;
        try {
            response = flow.newTokenRequest(authCode).setRedirectUri(redirectUri).execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        return response.getRefreshToken();
    }
}
