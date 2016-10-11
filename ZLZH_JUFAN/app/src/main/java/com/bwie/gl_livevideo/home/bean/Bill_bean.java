package com.bwie.gl_livevideo.home.bean;

import java.util.List;

/**
 * 作者：高磊
 * on 2016/9/12.
 */
public class Bill_bean {


    /**
     * state : 0
     * message : SUCCESS
     * content : {"data":[{"uid":90661478,"level":16,"nickname":"👌","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160823/53baeb1cae7f5ff4430f.png","out_amount":12061,"attention":false},{"uid":90388041,"level":28,"nickname":"😄我微信号","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160526/a8279f63ef6d2c43b09b.jpg","out_amount":10500,"attention":false},{"uid":89739453,"level":29,"nickname":"醉生梦死","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160719/ea59250b8c97ee6eb487.jpg","out_amount":9593,"attention":false},{"uid":91596924,"level":43,"nickname":"🔞大V","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160802/fea25d27dc5f4d98d840.jpg","out_amount":9308,"attention":false},{"uid":89418643,"level":48,"nickname":"西瓜","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/1f7b1b3b77458285722d.jpg","out_amount":9019,"attention":true},{"uid":500079312,"level":12,"nickname":"不能说的秘密","headImgSmall":null,"out_amount":6666,"attention":false},{"uid":500065034,"level":14,"nickname":"迷心梦","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160912/90a9e546c96661e637a7.png","out_amount":5250,"attention":false},{"uid":86781220,"level":21,"nickname":"莉宝宝保护神","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160706/86c62dd1743c7ee6c9fb.jpg","out_amount":5010,"attention":false},{"uid":90826366,"level":18,"nickname":"封刀看海","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160720/c21c44188b3aca12a2b1.jpg","out_amount":4500,"attention":false},{"uid":500053937,"level":13,"nickname":"我姓蒋","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160906/68e1d67787d79f3cff68.jpg","out_amount":3000,"attention":false},{"uid":500004558,"level":15,"nickname":"566","headImgSmall":null,"out_amount":2515,"attention":false},{"uid":88698345,"level":15,"nickname":"【夜魅】♐️鲍哥✨","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160910/c3921bca78cd33635b0b.png","out_amount":2000,"attention":false},{"uid":90088162,"level":20,"nickname":"【夜魅】♐迷茫✨","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160822/b0cdf094c0c2f2cbe145.png","out_amount":1907,"attention":false},{"uid":500011615,"level":22,"nickname":"红领巾","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160805/97bcfaf45974c32a991c.png","out_amount":1681,"attention":false},{"uid":92970970,"level":33,"nickname":"六哥","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160908/61f71e443f2d1f0c54a2.jpg","out_amount":1600,"attention":true}],"page_count":14}
     */

    private int state;
    private String message;
    /**
     * data : [{"uid":90661478,"level":16,"nickname":"👌","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160823/53baeb1cae7f5ff4430f.png","out_amount":12061,"attention":false},{"uid":90388041,"level":28,"nickname":"😄我微信号","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160526/a8279f63ef6d2c43b09b.jpg","out_amount":10500,"attention":false},{"uid":89739453,"level":29,"nickname":"醉生梦死","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160719/ea59250b8c97ee6eb487.jpg","out_amount":9593,"attention":false},{"uid":91596924,"level":43,"nickname":"🔞大V","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160802/fea25d27dc5f4d98d840.jpg","out_amount":9308,"attention":false},{"uid":89418643,"level":48,"nickname":"西瓜","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160810/1f7b1b3b77458285722d.jpg","out_amount":9019,"attention":true},{"uid":500079312,"level":12,"nickname":"不能说的秘密","headImgSmall":null,"out_amount":6666,"attention":false},{"uid":500065034,"level":14,"nickname":"迷心梦","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160912/90a9e546c96661e637a7.png","out_amount":5250,"attention":false},{"uid":86781220,"level":21,"nickname":"莉宝宝保护神","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160706/86c62dd1743c7ee6c9fb.jpg","out_amount":5010,"attention":false},{"uid":90826366,"level":18,"nickname":"封刀看海","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160720/c21c44188b3aca12a2b1.jpg","out_amount":4500,"attention":false},{"uid":500053937,"level":13,"nickname":"我姓蒋","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160906/68e1d67787d79f3cff68.jpg","out_amount":3000,"attention":false},{"uid":500004558,"level":15,"nickname":"566","headImgSmall":null,"out_amount":2515,"attention":false},{"uid":88698345,"level":15,"nickname":"【夜魅】♐️鲍哥✨","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160910/c3921bca78cd33635b0b.png","out_amount":2000,"attention":false},{"uid":90088162,"level":20,"nickname":"【夜魅】♐迷茫✨","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160822/b0cdf094c0c2f2cbe145.png","out_amount":1907,"attention":false},{"uid":500011615,"level":22,"nickname":"红领巾","headImgSmall":"http://resource.jufan.tv/jufan/userhead/20160805/97bcfaf45974c32a991c.png","out_amount":1681,"attention":false},{"uid":92970970,"level":33,"nickname":"六哥","headImgSmall":"http://resource.jufan.tv/jufan/userhead20160908/61f71e443f2d1f0c54a2.jpg","out_amount":1600,"attention":true}]
     * page_count : 14
     */

    private ContentBean content;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        private int page_count;
        /**
         * uid : 90661478
         * level : 16
         * nickname : 👌
         * headImgSmall : http://resource.jufan.tv/jufan/userhead20160823/53baeb1cae7f5ff4430f.png
         * out_amount : 12061
         * attention : false
         */

        private List<DataBean> data;

        public int getPage_count() {
            return page_count;
        }

        public void setPage_count(int page_count) {
            this.page_count = page_count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private int uid;
            private int level;
            private String nickname;
            private String headImgSmall;
            private int out_amount;
            private boolean attention;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getHeadImgSmall() {
                return headImgSmall;
            }

            public void setHeadImgSmall(String headImgSmall) {
                this.headImgSmall = headImgSmall;
            }

            public int getOut_amount() {
                return out_amount;
            }

            public void setOut_amount(int out_amount) {
                this.out_amount = out_amount;
            }

            public boolean isAttention() {
                return attention;
            }

            public void setAttention(boolean attention) {
                this.attention = attention;
            }
        }
    }
}
