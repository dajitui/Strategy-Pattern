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
public class BookState implements State {

    Room room;

    @Override
    public void bookRoom() {
        if (!(room.getState() instanceof BookState)) {
            System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间不能预定!");
            return;
        }
        room.setState(room.getBookState());
        System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间预定!");
    }

    @Override
    public void checkOutRoom() {
        room.setState(room.getCheckOutState());
        System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间退订!");
    }

    @Override
    public void checkInRoom() {
        room.setState(room.getCheckInState());
        System.out.println(Thread.currentThread().getName()+"当前" + room.getRoomId() + "房间入住!");
    }

}
