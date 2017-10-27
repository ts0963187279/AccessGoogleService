package com.walton.java.accessgoogleservice.module;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class PhotoInfoTest {
    @Test
    public void testSetPhotoName(){
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.setPhotoName("test");
        String expected = "test";
        Assert.assertEquals(expected,photoInfo.getPhotoName());
    }
    @Test
    public void testSetUrl() throws MalformedURLException {
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.setUrl(new URL("http://test"));
        URL expected = new URL("http://test");
        Assert.assertEquals(expected, photoInfo.getUrl());
    }
}
