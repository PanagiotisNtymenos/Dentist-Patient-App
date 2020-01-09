package com.example.efarmoghgiaodontiatrous.util;

/**
 * The type System date stub.
 */
public class SystemDateStub {
    /**
     * Sets stub.
     *
     * @param stub the stub
     */
    public static void setStub(SimpleCalendar stub) {
        SystemDate.setStub(stub);
    }

    /**
     * Reset.
     */
    public static void reset() {
        SystemDate.removeStub();
    }
}