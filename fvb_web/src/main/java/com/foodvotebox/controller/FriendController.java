package com.foodvotebox.controller;

import com.foodvotebox.pojo.FvbFriend;
import com.foodvotebox.pojo.FvbUser;
import com.foodvotebox.service.FvbFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqi on 6/28/17.
 */
@Controller
@RequestMapping("")
public class FriendController {
    @Autowired
    private FvbFriendService fvbFriendService;
    @RequestMapping("/addFriend")
    public String gotoAddFriend(HttpSession session){
        if (session == null){
            return "login";
        }
        return "addFriend";
    }
    @RequestMapping("/addFriend/do")
    public String doAddFriend(HttpSession session, @RequestParam("friendname") String friendName, Map<String,Object> model){
        if (session == null){
            return "login";
        }
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        if (user != null && !fvbFriendService.cannotAddFriend(user.getUserId(),friendName)) {
            fvbFriendService.addFriend(user.getUserId(), friendName);
        }
        model.put("user",user);
        return "loginSuccess";
    }
    @RequestMapping("/deleteFriend")
    public String gotoDeleteFriend(HttpSession session){
        if (session == null){
            return "login";
        }
        return "deleteFriend";
    }
    @RequestMapping("/deleteFriend/do")
    public String doDeleteFriend(HttpSession session, @RequestParam("friendname") String friendName, Map<String,Object> model){
        if (session == null){
            return "login";
        }
        FvbUser user = (FvbUser) session.getAttribute("newUser");
        if (user!= null){
            fvbFriendService.deleteFriend(user.getUserId(),friendName);
        }
        model.put("user",user);
        return "loginSuccess";
    }

    /**
     * display friend method, return friend list
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/displayFriend")
    public @ResponseBody List<FvbFriend> displayFriend(HttpSession session, Map<String, Object> model){
        FvbUser user = (FvbUser) model.get("user");
        if (user != null){
            return fvbFriendService.displayFriend(user.getUserId());
        }
        return null;
    }
}
