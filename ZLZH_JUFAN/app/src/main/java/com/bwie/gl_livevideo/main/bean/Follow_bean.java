package com.bwie.gl_livevideo.main.bean;

import java.util.ArrayList;

/**
 * 作者：周辉&赵雷
 * on .
 */
public class Follow_bean {

    public Contents content;

    public class Contents {

        public ArrayList<ImageUrl> banner;
        public ArrayList<Bean> list;

        public class Bean {
            public String bigheadimg;
            public int level;
            public String livename;
            public String midheadimg;
            public String name;
            public int online;
            public String place;
            public int rid;
            public int score;
            public ArrayList<Ser> servers;

            public class Ser {
                public String host;
                public int port;
            }

            public String smallheadimg;
            public int uid;
            public String video;
        }


    }

}
