package com.hangjiang.enums.multipath;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
