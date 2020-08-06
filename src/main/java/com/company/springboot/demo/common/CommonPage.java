package com.company.springboot.demo.common;


//分页排序类，封装分页排序信息
public class CommonPage {
    private int page = 1;//默认页数为1
    private int size = 5;//默认每页显示记录5条
    private String sortCon = "id";//order by后边的字段名，默认为id
    private SortType sortType = SortType.ASC;//默认order by的方式是升序
    //enum 枚举
    public enum SortType{
        ASC("ASC"),DESC("DESC");
        private String typeName;
        SortType(String typeName) {
            this.typeName = typeName;
        }
        public String getTypeName() {
            return typeName;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortCon() {
        return sortCon;
    }

    public void setSortCon(String sortCon) {
        this.sortCon = sortCon;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }
}
