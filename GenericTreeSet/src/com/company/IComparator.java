package com.company;

public interface IComparator<T> {

    /**
     * @param value1 first value
     * @param value2 second value
     * @return Returns true if first_value >= second_value else, returns false
     */
    boolean compare(T value1, T value2);
}
