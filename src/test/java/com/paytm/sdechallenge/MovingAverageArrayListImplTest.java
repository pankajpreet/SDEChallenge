package com.paytm.sdechallenge;

import com.paytm.sdechallenge.exceptions.InvalidOperationException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MovingAverageArrayListImplTest {

    private static final int SAMPLE_SIZE = 3;

    @Test(expected = InvalidOperationException.class)
    public void movingAverageWithNoElements() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        try {
            movingAvg.getMovingAverage();
        } catch (InvalidOperationException ex) {
            Assert.assertEquals("Sample data size(0) should not be less than sample size(3)", ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = InvalidOperationException.class)
    public void movingAverageWithElementsLessThanSampleSize() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        try {
            movingAvg.add(BigDecimal.valueOf(120));
            movingAvg.add(BigDecimal.valueOf(80));
            movingAvg.getMovingAverage();
        } catch (InvalidOperationException ex) {
            Assert.assertEquals("Sample data size(2) should not be less than sample size(3)", ex.getMessage());
            throw ex;
        }
    }

    @Test
    public void movingAverageWithElementsEqualToSamplesize() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        movingAvg.add(BigDecimal.valueOf(120));
        movingAvg.add(BigDecimal.valueOf(80));
        movingAvg.add(BigDecimal.valueOf(40));
        Assert.assertEquals(BigDecimal.valueOf(80.00).setScale(2), movingAvg.getMovingAverage());
    }

    @Test
    public void movingAverageWithElementsGreaterThanSamplesize() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        movingAvg.add(BigDecimal.valueOf(160));
        movingAvg.add(BigDecimal.valueOf(120));
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.add(BigDecimal.valueOf(80.5));
        movingAvg.add(BigDecimal.valueOf(40.75));
        Assert.assertEquals(BigDecimal.valueOf(80.25).setScale(2), movingAvg.getMovingAverage());
    }

    @Test
    public void getSamplingSize() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.add(BigDecimal.valueOf(80.5));
        movingAvg.add(BigDecimal.valueOf(40.75));
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.add(BigDecimal.valueOf(80.5));
        movingAvg.add(BigDecimal.valueOf(40.75));
        Assert.assertEquals(3, movingAvg.getSamplingSize());
    }

    @Test
    public void getElementsSize() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.add(BigDecimal.valueOf(80.5));
        movingAvg.add(BigDecimal.valueOf(40.75));
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.add(BigDecimal.valueOf(80.5));
        movingAvg.add(BigDecimal.valueOf(40.75));
        Assert.assertEquals(6, movingAvg.size());
    }

    @Test
    public void getElementAtSpecificIndex() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        BigDecimal value = BigDecimal.valueOf(40.75);
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.add(BigDecimal.valueOf(80.5));
        movingAvg.add(value);
        movingAvg.add(BigDecimal.valueOf(119.5));
        Assert.assertEquals(value, movingAvg.get(2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getElementAtNegativeIndex() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        movingAvg.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementAtIndexGreaterThanElements() {
        MovingAverage movingAvg = new MovingAverageArrayListImpl(SAMPLE_SIZE);
        movingAvg.add(BigDecimal.valueOf(119.5));
        movingAvg.get(1);
    }

}