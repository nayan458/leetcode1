class Foo {
    private final Semaphore semaphoreFirst;
    private final Semaphore semaphoreSecond;
    private final Semaphore semaphoreThird;

    public Foo() {
        semaphoreFirst = new Semaphore(1);
        semaphoreSecond = new Semaphore(0);
        semaphoreThird = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        try {
            semaphoreFirst.acquire();
            printFirst.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphoreSecond.release();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        try {
            semaphoreSecond.acquire();
            printSecond.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphoreThird.release();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        try {
            semaphoreThird.acquire();
            printThird.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphoreThird.release();
        }
    }
}