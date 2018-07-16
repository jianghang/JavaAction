package com.hangjiang.effective;

import sun.misc.Resource;
import sun.misc.URLClassPath;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public enum Elvis {
    INSTANCE;

    private Resource resource;

    Elvis(){
        resource = new Resource() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public URL getURL() {
                return null;
            }

            @Override
            public URL getCodeSourceURL() {
                return null;
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public int getContentLength() throws IOException {
                return 0;
            }
        };
    }

    public Resource getInstance(){
        return resource;
    }

    public void leaveTheBuilding(){
    }
}
