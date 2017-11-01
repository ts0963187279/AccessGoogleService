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

import com.google.gdata.client.photos.PicasawebService;
import com.walton.java.accessgoogleservice.module.AlbumInfo;
import com.walton.java.accessgoogleservice.module.PhotoInfo;
import poisondog.core.Mission;

import java.io.File;
import java.util.List;

public class DownLoadImage implements Mission<PicasawebService>{
    private GetAlbumInfos getAlbumInfos;
    public DownLoadImage(String userName){
        getAlbumInfos = new GetAlbumInfos(userName);
    }
    public Void execute(PicasawebService picasawebService){
        List<AlbumInfo> albumInfos = getAlbumInfos.execute(picasawebService);
        for(AlbumInfo albumInfo : albumInfos){
            for(PhotoInfo photoInfo : albumInfo.getPhotoInfos()){
                CreateDownloadFile createDownloadFile = new CreateDownloadFile("./google photos/" + albumInfo.getAlbumName());
                File imageFile = createDownloadFile.execute(photoInfo.getPhotoName());
                SocketDownloadData socketDownloadData = new SocketDownloadData(imageFile);
                socketDownloadData.execute(photoInfo.getUrl());
            }
        }
        return null;
    }
}
