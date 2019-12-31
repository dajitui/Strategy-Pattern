package com.example.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/12/31.
 *
 * @author yangsen
 */
public class RoomList {

    /**
     * 单人间
     */
    public static List<Room> list1 = new ArrayList<>(10);

    /**
     * 双人间
     */
    public static List<Room> list2 = new ArrayList<>(10);

    static {
        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3);
        list1.add(room1);
        list1.add(room2);
        list1.add(room3);
        Room room4 = new Room(4);
        Room room5 = new Room(5);
        list2.add(room4);
        list2.add(room5);
    }

}
