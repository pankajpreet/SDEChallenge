package com.paytm.sdechallenge;

import com.paytm.sdechallenge.exceptions.InvalidOperationException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MovingAverageLinkedListImpl implements MovingAverage {

    private final int sampleSize;
    private final Deque<BigDecimal> elements;
    private BigDecimal totalSum = BigDecimal.ZERO;
    private boolean isModified = false;
    private BigDecimal movingAverage;

    public MovingAverageLinkedListImpl(int sampleSize) {
        this.sampleSize = sampleSize;
        this.elements = new LinkedList<>();
    }

    public void add(BigDecimal value) {
        elements.add(value);
        if (elements.size() > sampleSize) {
            totalSum = totalSum.subtract(elements.removeFirst());
        }
        totalSum = totalSum.add(value);
        isModified = true;
    }

    public BigDecimal getMovingAverage() {
        if (elements.size() < sampleSize) {
            throw new InvalidOperationException(String.format("Sample data size(%d) should not be less than sample size(%d)", elements.size(), sampleSize));
        }
        if (isModified) {
            movingAverage = totalSum.divide(BigDecimal.valueOf(sampleSize), 2, RoundingMode.HALF_EVEN);
            isModified = false;
        }
        return movingAverage;
    }

    public int getSamplingSize() {
        return sampleSize;
    }

    public BigDecimal get(int index) {
        return ((List<BigDecimal>) elements).get(index);
    }

    public int size() {
        return elements.size();
    }
}