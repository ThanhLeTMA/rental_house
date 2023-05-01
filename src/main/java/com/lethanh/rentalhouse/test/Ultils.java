package com.lethanh.rentalhouse.test;

public class Ultils {
    public static boolean PrimativeCheck(int n){
        if(n>=2){
            for(int i=2; i< Math.sqrt(n); i++){
                if(n % i == 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
