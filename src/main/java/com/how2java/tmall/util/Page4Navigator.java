package com.how2java.tmall.util;

import org.springframework.data.domain.Page;

import java.util.List;

public class Page4Navigator<T> {
    Page<T> pageFromJPA;
    boolean first;
    boolean last;
    boolean hasPrevious;
    boolean hasNext;
    List<T> content;
    int number;
    int size;
    int totalPages;
    int[] navigatepageNums;


    public Page<T> getPageFromJPA() {
        return pageFromJPA;
    }

    public void setPageFromJPA(Page<T> pageFromJPA) {
        this.pageFromJPA = pageFromJPA;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Page4Navigator(Page<T> pageFromJPA){
        this.first=pageFromJPA.isFirst();
        this.last=pageFromJPA.isLast();
        hasNext=pageFromJPA.hasNext();
        hasPrevious=pageFromJPA.hasPrevious();
        content=pageFromJPA.getContent();
        totalPages=pageFromJPA.getTotalPages();
        number=pageFromJPA.getNumber();
        size=pageFromJPA.getSize();


    }

}
