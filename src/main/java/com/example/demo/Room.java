package com.example.demo;

import com.example.demo.statepackage.BookState;
import com.example.demo.statepackage.CheckInState;
import com.example.demo.statepackage.CheckOutState;
import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2019/12/31.
 *
 * @author yangsen
 */
@Data
public class Room {

    ReentrantLock reentrantLock = new ReentrantLock();

    Integer roomId;

    /**
     * 状态
     */
    State state;

    CheckInState checkInState;

    CheckOutState checkOutState;

    BookState bookState;

    public Room(Integer roomId) {
        this.roomId = roomId;
        checkInState = new CheckInState(this);
        checkOutState = new CheckOutState(this);
        bookState = new BookState(this);
        state = checkOutState;
    }

    /**
     * 预定
     */
    public void bookRoom() {
        state.bookRoom();
    }

    /**
     * 退房
     */
    public void checkOutRoom() {
        state.checkOutRoom();
    }

    /**
     * 入住
     */
    public void checkInRoom() {
        state.checkInRoom();
    }

    @Override
    public String toString() {
        return "该房间" + roomId + "的状态是:" + getState().getClass().getName();
    }

}
