package com.example.demo;

import com.example.demo.statepackage.CheckOutState;

import java.util.List;

/**
 * Created on 2019/12/31.
 *
 * @author yangsen
 */
public class BookTest {

    public static void main(String[] args) throws InterruptedException {
        //单人间
        List<Room> list1 = RoomList.list1;
        //双人间
        List<Room> list2 = RoomList.list2;

        int b = 0;
        do {
            b++;
            new Thread(() -> {
                for (Room room : list1) {
                    int i = 0;
                    if (room.getState() instanceof CheckOutState) {
                        room.reentrantLock.lock();
                        i++;
                        System.out.println(Thread.currentThread().getName()+"预定到房间:" + room.getRoomId());
                        room.setState(room.getBookState());
                        room.bookRoom();
                        room.checkInRoom();
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        room.checkOutRoom();
                        room.reentrantLock.unlock();
                        if (i == list1.size()) {
                            System.out.println(Thread.currentThread().getName()+"当前没有房间......");
                        }
                    }
                }
            }).start();
            new Thread(() -> {
                int i = 0;
                for (Room room : list2) {
                    i++;
                    if (room.getState() instanceof CheckOutState) {
                        room.reentrantLock.lock();
                        System.out.println(Thread.currentThread().getName()+"预定到房间:" + room.getRoomId());
                        room.setState(room.getCheckInState());
                        room.checkInRoom();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        room.checkOutRoom();
                        room.reentrantLock.unlock();
                        if (i == list2.size()) {
                            System.out.println(Thread.currentThread().getName()+"当前没有房间......");
                        }
                    }
                }
            }).start();
            Thread.sleep(500);
        } while (b < 10);
        Thread.sleep(10000);
        for (Room room : list1) {
            System.out.println(room.getRoomId()+" "+room.getState());
        }
        for (Room room : list2) {
            System.out.println(room.getRoomId()+" "+room.getState());
        }


    }

}
