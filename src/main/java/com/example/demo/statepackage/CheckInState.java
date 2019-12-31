package com.example.demo.statepackage;

import com.example.demo.Room;
import com.example.demo.State;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on 2019/12/31.
 *
 * @author yangsen
 */
@Data
@AllArgsConstructor
public class CheckInState implements State {

    Room room;

    @Override
    public void bookRoom() {
        room.setState(room.getBookState());
        System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间预定!");
    }

    @Override
    public void checkOutRoom() {
        room.setState(room.getCheckOutState());
        System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间退房!");
    }

    @Override
    public void checkInRoom() {
        if (!(room.getState() instanceof CheckInState)) {
            System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间不能入住!");
            return;
        }
        room.setState(room.getCheckInState());
        System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间入住!");
    }
}
