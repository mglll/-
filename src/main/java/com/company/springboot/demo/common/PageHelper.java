package com.company.springboot.demo.common;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


public class PageHelper {
    public static PageRequest getPageReq(Integer page,Integer size){
        CommonPage cp = new CommonPage();
        if (page != null) {
            cp.setPage(page);
        }
        if (size != null) {
            cp.setSize(size);
        }
        return PageRequest.of(cp.getPage()-1,cp.getSize());
    }

    public static PageRequest getSortPageReq(Integer page,Integer size,CommonPage.SortType sortType,String sortCon){
        Sort.Direction direction = "ASC".equalsIgnoreCase(sortType.getTypeName())?Sort.Direction.ASC:Sort.Direction.DESC;
        CommonPage cp = new CommonPage();
        if(page!=null) cp.setPage(page);
        if(size != null) cp.setSize(size);
        if(sortCon != null) cp.setSortCon(sortCon);
        Sort sort = Sort.by(direction,cp.getSortCon());
        return  PageRequest.of(page-1,size,sort);
    }
}
