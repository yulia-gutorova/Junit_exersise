package com.jensen;

public class Cup {
    private String liquidType;
    private double percentFull;

//---------------- Constructor ----------------------

    public Cup(String liquidType, double percentFull) {
        this.liquidType = liquidType;
        this.percentFull = percentFull;

/*        setLiquidType(liquidType);
        setPercentFull(percentFull);*/
    }

// --------------- Setters ------------------------

    public void setLiquidType(String liquidType) {
        if(liquidType == null) {
            return;
        }
        this.liquidType = liquidType;
    }

    public void setPercentFull(double percentFull) {
        if(percentFull > 100 || percentFull < 0) {
            throw new IllegalArgumentException("Percent must be >=0 and <= 100");
        }
        this.percentFull = percentFull;
    }

// --------------- Getters ------------------------
    public String getLiquidType() {
        return liquidType;
    }

    public double getPercentFull() {
        return percentFull;
    }


// --------------- Other methods  ---------------------

    public boolean isEmpty() {
        return percentFull == 0;
    }
    public boolean isFull () {return percentFull == 100;}

}
