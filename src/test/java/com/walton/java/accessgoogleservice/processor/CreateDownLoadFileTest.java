package com.walton.java.accessgoogleservice.processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CreateDownLoadFileTest {
    @Test
    public void testExecute() throws IOException {
        CreateDownloadFile createDownloadFile = new CreateDownloadFile();
        File expected = new File("./test");
        Assert.assertEquals(expected,createDownloadFile.execute("test"));
        expected.delete();
    }
    @Test
    public void testExecuteWithPath() throws IOException {
        CreateDownloadFile createDownloadFile = new CreateDownloadFile("test");
        File expected = new File("./test/test");
        Assert.assertEquals(expected,createDownloadFile.execute("test"));
    }
}
