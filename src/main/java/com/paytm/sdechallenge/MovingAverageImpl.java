package com.paytm.sdechallenge;

import com.paytm.sdechallenge.exceptions.InvalidOperationException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MovingAverageImpl implements MovingAverage {

    private final int sampleSize;
    private final List<BigDecimal> elements;
    private int sampleStartIndex = 0;
    private BigDecimal totalSum = BigDecimal.ZERO;

    public MovingAverageImpl(int sampleSize) {
        this.sampleSize = sampleSize;
        this.elements = new ArrayList<>();
    }

    public void add(BigDecimal value) {
        elements.add(value);
        totalSum = totalSum.add(value);
        if (elements.size() > sampleSize) {
            totalSum = totalSum.subtract(elements.get(sampleStartIndex));
            sampleStartIndex++;
        }
    }

    public void add(Long value) {
        add(BigDecimal.valueOf(value));
    }

    public BigDecimal getMovingAverage() {
        if (elements.size() < sampleSize) {
            throw new InvalidOperationException(String.format("Sample data size(%d) should not be less than sample size(%d)", elements.size(), sampleSize));
        }
        return totalSum.divide(BigDecimal.valueOf(sampleSize), 2, RoundingMode.HALF_EVEN);
    }

    public int getSamplingSize() {
        return sampleSize;
    }

    public BigDecimal get(int index) {
        return elements.get(index);
    }

    public int size() {
        return elements.size();
    }
}