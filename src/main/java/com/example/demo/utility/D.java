package com.example.demo.utility;

import java.util.HashMap;
import java.util.Map;

class A {
    private static final Map<Class<?>, Integer> instanceCountMap = new HashMap<>();
    protected A() {
        if(this.getClass() == A.class) {
            throw new UnsupportedOperationException("Cannot create an instance of class A.");
        }
        incrementInstanceCount(A.class);
        if (getInstanceCount(A.class) > 1) {
            throw new UnsupportedOperationException("Cannot create an instance of class A.");
        }
    }

    static void incrementInstanceCount(Class<?> clazz) {
        instanceCountMap.put(clazz, instanceCountMap.getOrDefault(clazz, 0) + 1);
    }
    protected static int getInstanceCount(Class<?> clazz) {
        return instanceCountMap.getOrDefault(clazz, 0);
    }
}

class B extends A {
    protected B() {
        if(this.getClass() == B.class) {
            throw new UnsupportedOperationException("Cannot create an instance of class A.");
        }
        incrementInstanceCount(B.class);
        if (getInstanceCount(B.class) > 1) {
            throw new UnsupportedOperationException("Cannot create an instance of class B.");
        }
    }
}

class C extends B {
    private static C instance;
    private C() {
        incrementInstanceCount(C.class);
        if (getInstanceCount(C.class) > 1) {
            throw new UnsupportedOperationException("Cannot create more than one instance of class C.");
        }
    }
    public static C getInstance() {
        if (instance == null) {
            instance = new C();
        }
        return instance;
    }
}

public class D extends A {
    public D() {
        super();
    }

    public static void main(String[] args) {
     //   A a = new A();
     //   D d = new D();
        C c1 = C.getInstance();
        C c2 = C.getInstance();

        C c3 = C.getInstance();
        C c4 = C.getInstance();

        // Will print 'TRUE'
        System.out.println((c1 == c2) + " " + (c3 == c4));

        // Will throw exception
        A a1 = new A();
        D d1 = new D();
    }
}
