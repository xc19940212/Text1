package com.example.administrator.text1;

import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */

public class Data {

    private List<TrailersBean> trailers;

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public static class TrailersBean {
        /**
         * id : 63624
         * movieName : 《银河护卫队2》中文预告
         * coverImg : http://img5.mtime.cn/mg/2016/12/04/143436.93575096.jpg
         * movieId : 216008
         * url : http://vfx.mtime.cn/Video/2016/12/04/mp4/161204095742030265_480.mp4
         * hightUrl : http://vfx.mtime.cn/Video/2016/12/04/mp4/161204095742030265.mp4
         * videoTitle : 银河护卫队2 中文正式版预告片
         * videoLength : 134
         * rating : -1
         * type : ["动作","科幻"]
         * summary : 英雄“正经不过三秒”
         */

        private Number id;
        private String movieName;
        private String coverImg;
        private Number movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private Number videoLength;
        private Number rating;
        private String summary;
        private List<String> type;

        public Number getId() {
            return id;
        }

        public void setId(Number id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public Number getMovieId() {
            return movieId;
        }

        public void setMovieId(Number movieId) {
            this.movieId = movieId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public Number getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(Number videoLength) {
            this.videoLength = videoLength;
        }

        public Number getRating() {
            return rating;
        }

        public void setRating(Number rating) {
            this.rating = rating;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}
