/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgorithmsQA;

/**
 *
 * @author Olugbenga.Falodun
 */
public class Pallidrion {

    public String quasiPal(String str){
        if(!pall(str)) return "IMPOSSIBLE";
        int half = (int)Math.ceil((str.length()/2));
        String s = "";
        int i;
        for(i=1; i<half; i++){
            if(str.charAt(i)!='A' || str.charAt(i)!='a'){
                str = str.replace(str.charAt(i),'a');
                return str;
            }
        }
        return "IMPOSSIBLE";
    }


    private boolean pall(String str){
        StringBuilder strb = new StringBuilder(str);
        strb.reverse();
        return str.equalsIgnoreCase(strb.toString());
    }
}