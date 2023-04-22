package com.example.ohana_clone.utils;

import com.example.ohana_clone.models.Room;
import com.example.ohana_clone.models.User;

public interface IClickListener {

    void onClick(Room room);
    void onClick(User user);

}
