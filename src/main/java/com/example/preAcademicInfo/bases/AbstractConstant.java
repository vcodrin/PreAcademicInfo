package com.example.preAcademicInfo.bases;

import java.util.Objects;

public abstract class AbstractConstant {
    private String name;

    public AbstractConstant(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static <U extends AbstractConstant> U valueOf(AbstractConstant constant, U[] values){
        U value = null;
        for(U val : values){
            if (val.equals(constant)){
                value = val;
                break;
            }
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractConstant that = (AbstractConstant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
