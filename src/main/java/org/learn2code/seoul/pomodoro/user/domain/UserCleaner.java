package org.learn2code.seoul.pomodoro.user.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Created by hector on 2/9/17.
*/
public class UserCleaner {

    public static String regexIt(String string){
        String stringGoingOut ="";
        String id_pattern="(?<=\\=)(.*?)(?=\\,)";
        String email_pattern="(?<=\\')(.*?)(?=\\')";
        String pass_pattern="(\\wword)(.*?)(?=\\'})";
        Pattern r = Pattern.compile(id_pattern);
        Matcher m = r.matcher(string);
        if(m.find( )){
            stringGoingOut += "User id: " + m.group(0) + " ";
        }else{
            System.out.println("No match");
        }
        Pattern email = Pattern.compile(email_pattern);
        Matcher ematch = email.matcher(string);
        if(ematch.find( )){
            stringGoingOut += "Email: " + ematch.group(0) + " ";
        }else{
            System.out.println("No match");
        }
        Pattern pass = Pattern.compile(pass_pattern);
        Matcher passmatch = pass.matcher(string);
        if(passmatch.find( )){
            stringGoingOut += "Pass: " + passmatch.group(0).substring(7);
        }else{
            System.out.println("No match");
        }
        return stringGoingOut;
    }
}

