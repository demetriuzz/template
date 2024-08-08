package ru.demetriuzz.template.other;

import org.junit.jupiter.api.Test;

public class ClonePatternExample {

    private static class MObject implements Cloneable {

        private final Integer id;
        private final String name;

        public MObject(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "MObject{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MObject mObject = (MObject) o;

            if (!id.equals(mObject.id)) return false;
            return name.equals(mObject.name);
        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + name.hashCode();
            return result;
        }
    }

    @Test
    void doIt() throws Exception {
        MObject obj1 = new MObject(1, "первый");
        MObject obj2 = (MObject) obj1.clone();

        System.out.println("1, " + obj1);
        System.out.println("2, " + obj2);
        System.out.println();
        System.out.println("== " + (obj1 == obj2));
        System.out.println("equals " + obj1.equals(obj2));
    }

}