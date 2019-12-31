package com.example.demo;

/**
 * Created on 2019/12/31.
 *
 * @author yangsen
 */
public interface State {

    /**
     * 预定
     */
    public void bookRoom();

    /**
     * 退房
     */
    public void checkOutRoom();

    /**
     * 入住
     */
    public void checkInRoom();

}
