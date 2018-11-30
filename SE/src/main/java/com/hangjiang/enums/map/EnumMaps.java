package com.hangjiang.enums.map;

import com.hangjiang.enums.set.AlarmPoints;

import java.util.*;

import static com.hangjiang.enums.set.AlarmPoints.*;

interface Command {
    void action();
}

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<>(AlarmPoints.class);

        em.put(KITCHEN, () -> System.out.println("Kitchen fire!"));

        em.put(BATHROOM, () -> System.out.println("Bathroom alert!"));

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.println(e.getKey() + ": ");
            e.getValue().action();
        }

        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
