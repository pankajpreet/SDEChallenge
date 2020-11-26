package com.paytm.sdechallenge;

import java.math.BigDecimal;

/**
 * An interface used for calculating the average of last n elements. User of this interface can add elements,
 * retrieve number of elements added, get moving average.
 *
 * If number of elements is less than sample size in that
 *
 * @author Pankaj
 */
public interface MovingAverage {

    /**
     * Add the element at the end.
     *
     * @param value element to be added at the end
     */
    void add(BigDecimal value);

    /**
     * Add the element at the end.
     *
     * @param value element to be added at the end
     */
    void add(Long value);

    /**
     * Returns the element at the specified index.
     *
     * @param index index of the element to return
     * @throws ArrayIndexOutOfBoundsException if index out of range.
     * @throws IndexOutOfBoundsException if index out of range
     */
    BigDecimal get(int index);

    /**
     * Return size of elements added for moving average.
     *
     * @return elements added for moving average
     */
    int size();

    /**
     * Calculate and return moving average of last n elements.
     *
     * @return moving average
     * @throws com.paytm.sdechallenge.exceptions.InvalidOperationException when sampling data is less than sample size i.e n
     */
    BigDecimal getMovingAverage();

    /**
     * Return sample size for calculating moving average. This value denotes how many elements will be used for calculating moving average.
	 *
	 * @return return element count configured to calculate moving average.
     */
    int getSamplingSize();
}