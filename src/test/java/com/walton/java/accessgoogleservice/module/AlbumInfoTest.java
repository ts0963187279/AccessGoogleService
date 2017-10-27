package com.walton.java.accessgoogleservice.module;

import org.junit.Assert;
import org.junit.Test;

public class AlbumInfoTest {
    @Test
    public void testSetAlbumName(){
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setAlbumName("test");
        Assert.assertEquals("test",albumInfo.getAlbumName());
    }
    @Test
    public void testSetAlbumId(){
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setAlbumId("test");
        Assert.assertEquals("test",albumInfo.getAlbumId());
    }
}
