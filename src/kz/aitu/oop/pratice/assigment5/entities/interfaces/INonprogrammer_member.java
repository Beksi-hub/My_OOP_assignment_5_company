package kz.aitu.oop.pratice.assigment5.entities.interfaces;

import java.lang.reflect.Member;

public interface INonprogrammer_member extends IMember {
    String manage();
    void setDoingDuration(int day);
    void setPenalty(int penalty);
    void setBonus(int bonus);

}