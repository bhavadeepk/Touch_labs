package com.bhavadeep.letterlookbackjava;

/**
 * Class that holds the count of repeated characters and the latest index of their appearance
 */
class Content {
    private int count; // Count of repeated appearances within the lookback
    private int index; // Index of the latest appearance of the character

    Content(int index) {
        this.index = index;
        count = 0;
    }

    int getCount() {

        return count;
    }

    void setCount(int count) {
        this.count = count;
    }

    int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }
}
