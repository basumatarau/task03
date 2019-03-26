package htp.basumatarau.task03.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamResolver {
    private static final String keyVal = "(\\w*)=(\\d*)";

    public static Param resolve(String request){
        Param param = new Param();
        Matcher matcher = Pattern.compile(keyVal).matcher(request);
        while(matcher.find()){
            param.put(matcher.group(1), Integer.parseInt(matcher.group(2)));
        }
        return param;
    }
}
