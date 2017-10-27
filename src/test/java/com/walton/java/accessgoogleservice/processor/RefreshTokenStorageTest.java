package com.walton.java.accessgoogleservice.processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class RefreshTokenStorageTest {
    @Test
    public void testUpdate(){
        RefreshTokenStorage refreshTokenStorage = new RefreshTokenStorage();
        String userName = "Name";
        String refreshToken = "Toke";
        refreshTokenStorage.update(userName,refreshToken);
        Assert.assertEquals(userName,refreshTokenStorage.getUserName());
        Assert.assertEquals(refreshToken,refreshTokenStorage.getToken());
    }
    @Test
    public void testGetUserName(){
        File file = new File("RefreshTokenStorage.dat");
        file.delete();
        RefreshTokenStorage refreshTokenStorage = new RefreshTokenStorage();
        String expected = "NULL";
        Assert.assertEquals(expected,refreshTokenStorage.getUserName());
    }
    @Test
    public void testGetToken(){
        File file = new File("RefreshTokenStorage.dat");
        file.delete();
        RefreshTokenStorage refreshTokenStorage = new RefreshTokenStorage();
        String expected = "NULL";
        Assert.assertEquals(expected,refreshTokenStorage.getToken());
    }
}
