package com.how2java.tmall.web;

import com.how2java.tmall.service.Dbo_baserService;
import com.how2java.tmall.sqlpojo.Dbo_baser;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Combine {

    private static List<Dbo_baser> tmpArr = new ArrayList<>();
    public static void main(String[] args) {
        Dbo_baserService dboBaserService = null;
        int k = 415;
//        int [] com = {1,2,3,4,5,6,7,8};
//        int k = 2;
//        int j=0;
//        if(k > com.length || com.length <= 0){
//            return ;
//        }
//        combine(0 ,k ,com);
        tmpArr=dboBaserService.findlike("121415");
        System.out.println("index="+tmpArr);
    }

//    public List<Dbo_baser> findLike(String name) throws Exception {
//        log.info("findByNameLikelog=="+name);
//        return dboBaserService.findlike("121415");
//    }

//    public static void combine(int index,int k,int []arr) {
//        if(k == 1){
//            for (int i = index; i < arr.length; i++) {
//                tmpArr.add(arr[i]);
//                System.out.println("index="+i+tmpArr.toString());
//                tmpArr.remove((Object)arr[i]);
//            }
//        }else if(k > 1){
//            for (int i = index; i <= arr.length - k; i++) {
//                tmpArr.add(arr[i]);
//                combine(i + 1,k - 1, arr);
//                tmpArr.remove((Object)arr[i]);
//            }
//        }else{
//            System.out.println("index"+index);
//            return ;
//        }
//    }
}