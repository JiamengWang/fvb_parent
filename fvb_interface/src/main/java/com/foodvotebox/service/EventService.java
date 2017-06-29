package com.foodvotebox.service;

import com.foodvotebox.pojo.DBEventMemberReturnType;
import com.foodvotebox.pojo.FvbEvent;

import java.util.List;

/**
 * Created by FYG on 17/6/22.
 */
public interface EventService {
    FvbEvent getEventById(Long eventId);

    Long createEvent(Long userId, String eventName, String eventDate, String description);

    void deleteEvent(Long eventId);

    void insertEventRestaurant(Long eventId, Long restaurantId);

    boolean findEventRestaurant(Long eventId, Long restaurantId);

    void insertEventMember(Long eventId, Long memberId);

    boolean findEventMember(Long eventId, Long memberId);

    List<DBEventMemberReturnType> findAllMembers(Long eventId);

    void deleteEventMember(Long eventId, Long memberId);
}
