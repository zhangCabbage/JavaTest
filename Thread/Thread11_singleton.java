package zhang.algorithm.JavaTest.Thread;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/1/19
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 * p>
 * Implement the model of singleton!
 */
public class Thread11_singleton {
    //-----------------------------------------------------------------------------
    //1> 饿汉式
    //-----------------------------------------------------------------------------
    static class First {
        private static First first = new First();

        private First() {
        }

        public static First instance() {
            return first;
        }
    }

    //-----------------------------------------------------------------------------
    //1.1> 饿汉式, 基于静态代码块进行实现, 这两种方式没有区别(再看一遍JVM虚拟机)
    //-----------------------------------------------------------------------------
    static class Second {
        private static Second second = null;

        static {
            second = new Second();
        }

        private Second() {
        }

        public static Second instance() {
            return second;
        }
    }

    //-----------------------------------------------------------------------------
    //2> 懒汉式, 基于DCL方式实现的懒汉式单例模式, 并且在此基础上添加了volatile多线程可见, 进行完善。
    //-----------------------------------------------------------------------------
    static class Third {
        private volatile static Third third;

        private Third() {
        }

        public static Third instance() {
            if (third == null) {
                synchronized (Third.class) {
                    if (third == null) {
                        third = new Third();
                    }
                }
            }

            return third;
        }
    }

    //-----------------------------------------------------------------------------
    //3> 基于枚举类enum实现单例模式
    //-----------------------------------------------------------------------------
    static class Five {
        private Five() {
        }

        private enum EnumSingleton {
            INSTANCE;
            private Five five;

            private EnumSingleton() {
                five = new Five();
            }
        }

        public static Five instance() {
            return EnumSingleton.INSTANCE.five;
        }
    }

    //-----------------------------------------------------------------------------
    //4> 基于静态内部类来实现单例模式
    //-----------------------------------------------------------------------------
    static class Six {
        private Six() {
        }

        private static class SixInner {
            private static Six sixHandler() {
                return new Six();
            }
        }

        public static Six instance() {
            return SixInner.sixHandler();
        }
    }


    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("instance hash code ---> " + Five.instance().hashCode());
                }
            }
        });
        thread.start();
    }
}
