package com.walton.java.accessgoogleservice.module;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OAuth2DataTest {
    @Test
    public void testSetClientId(){
        OAuth2Data oAuth2Data = new OAuth2Data();
        oAuth2Data.setClientId("test");
        String expected = "test";
        Assert.assertEquals(expected,oAuth2Data.getClientId());
    }
    @Test
    public void testSetClientSecrets(){
        OAuth2Data oAuth2Data = new OAuth2Data();
        oAuth2Data.setClientSecrets("test");
        String expected = "test";
        Assert.assertEquals(expected,oAuth2Data.getClientSecrets());
    }
    @Test
    public void testSetUserName(){
        OAuth2Data oAuth2Data = new OAuth2Data();
        oAuth2Data.setUserName("test");
        String expected = "test";
        Assert.assertEquals(expected,oAuth2Data.getUserName());
    }
    @Test
    public void testAddScope(){
        OAuth2Data oAuth2Data = new OAuth2Data();
        oAuth2Data.addScope("test1");
        List<String> expected = new ArrayList<String>();
        expected.add("test1");
        Assert.assertEquals(expected,oAuth2Data.getScope());
        oAuth2Data.addScope("test2");
        expected.add("test2");
        Assert.assertEquals(expected,oAuth2Data.getScope());
    }
    @Test
    public void getRedirectUri(){
        OAuth2Data oAuth2Data = new OAuth2Data();
        String expected = "urn:ietf:wg:oauth:2.0:oob";
        Assert.assertEquals(expected,oAuth2Data.getRedirectUri());
    }
}
