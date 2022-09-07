package net.ins.edu.java;

public class NestedAndInnerClasses {


    public static class Aggregate {
        private String aPrivate;
        protected String aProtected;
        public String aPublic;

        private static String aPrivateStatic;

        public void aSample() {
            InnerClass.iPrivateStatic = "12313";
            NestedClass.nPrivateStatic = "123311";
            var innerInstance = new InnerClass();
        }

        public static class NestedClass {
            private String nPrivate;
            protected String nProtected;
            public String nPublic;

            private static String nPrivateStatic;

            public void nSample() {
                aPrivateStatic = "static private outer class field is accessible";
            }
        }

        public class InnerClass {
            private String iPrivate;
            protected String iProtected;
            public String iPublic;

            private static String iPrivateStatic;

            public void iSample() {
                aPrivate = "private outer class field is accessible";
                aProtected = "protected outer class field is accessible";
                aPublic = "public outer class field is accessible";
            }
        }
    }

    public static void main(String[] args) {
        Aggregate.InnerClass instance = new Aggregate().new InnerClass();
    }
}
