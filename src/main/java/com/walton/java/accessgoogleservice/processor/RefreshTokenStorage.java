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

import java.io.*;

public class RefreshTokenStorage {
    private File file;
    private String refreshToken;
    private String userName;
    public RefreshTokenStorage(){
        file = new File("RefreshTokenStorage.dat");
        if(!exists())
            create();
    }
    public String getUserName() {
        userName = readLineAt(1);
        return userName;
    }
    public String getToken(){
        refreshToken = readLineAt(2);
        return refreshToken;
    }
    public void update(String userName, String refreshToken){
        writeUserName(userName);
        writeRefreshToken(refreshToken);
    }
    private void writeUserName(String userName){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(userName + "\r\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeRefreshToken(String refreshToken){
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(refreshToken + "\r\n");
            try {
                fileWriter.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private boolean exists(){
        if(file.exists())
            return true;
        return false;
    }
    private void create(){
        try {
            file.createNewFile();
            update("NULL","NULL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String readLineAt(int line){
        String str = null;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for(int i = 1;i<line;i++)
                bufferedReader.readLine();
            str = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
