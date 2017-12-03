package controllers;

import mvc.ApiResult;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * Base api
     */
    public Result index() {
        return ok("This is the Neg5 stats calculation api!");
    }

    public Result status() {
        return new ApiResult<SystemStatus>().success(new SystemStatus());
    }

    private class SystemStatus {

    }

}
