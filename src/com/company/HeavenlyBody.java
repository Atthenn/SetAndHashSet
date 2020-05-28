package com.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public  abstract class HeavenlyBody {

    private final double orbintalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;
    public enum BodyTypes{
        PLANET,
        STAR,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbintalPeriod,BodyTypes bodyType){
        this.key = new Key(name, bodyType);
        this.orbintalPeriod = orbintalPeriod;
        this.satellites = new HashSet<>();
    }



    public double getOrbintalPeriod() {
        return orbintalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon){
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
       return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
           return this.key.equals(theObject.getKey());
        }
        return false;
    }
    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyTypes){
        return new Key(name,bodyTypes);
    }

    @Override
    public String toString() {
        return this.key.name + ":" + this.key.bodyType + "," +this.orbintalPeriod;
    }

    public static final class Key{
        private String name;
        private BodyTypes bodyType;
        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object o) {

            Key key = (Key) o;
            return Objects.equals(name, key.name) &&
                    bodyType == key.bodyType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, bodyType);
        }

        @Override
        public String toString() {
            return this.name + ":" + this.bodyType;
        }
    }
}

