package htp.basumatarau.task03.controller;

public class ActionResolver {
    public static Action resolve(String request){
        Action result = Action.ERROR;

        for (Action action : Action.values()) {
            if(request.contains(action.name)){
                result = action;
                break;
            }
        }

        return result;
    }
}
