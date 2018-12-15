package com.zxs.mine.api.controller;

import java.util.List;

public class UmiJsonObj {

    public class Info {
        private String seed ;
        private int results ;
        private int page ;
        private String version ;

        Info(){
            this.seed = "741a56fccb7d5a3e";
            this.version = "1.2";
        }

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

        public int getResults() {
            return results;
        }

        public void setResults(int results) {
            this.results = results;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
    private List results ;

    private Info info = new Info();

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
