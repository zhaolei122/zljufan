package com.bwie.gl_livevideo.main.bean;

import java.util.ArrayList;

/**
 * 作者：赵雷&周辉
 * on.
 */
public class ImageUrl {

    public static final String[] images = {
            "http://resource.jufan.tv/jufan/ad20160911/3231339eb04ba4c21c74.jpg",
            "http://resource.jufan.tv/jufan/ad20160914/45b0b20bf4fc455968ae.jpg",
            "http://resource.jufan.tv/jufan/ad/20160705/2a203939059ca2a7766f.png",
            "http://resource.jufan.tv/jufan/ad/20160803/20b9660a04f4668e1314.png",
            "http://resource.jufan.tv/jufan/ad20160901/b2b7d4738f6c3499214a.jpg",
            "http://resource.jufan.tv/jufan/ad20160916/97773fe89887adad4d86.jpg"
    };
    public Contents content;

    public class Contents {

        public ArrayList<Banners> banner;

        public class Banners {
            public String comment;
            public int id;
            public String img;
            public int isShow;
            public int sort;
            public int type;
            public String url;
        }

    }


}
