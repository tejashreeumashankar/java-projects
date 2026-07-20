class FizzBuzz {
    private int n;
    private int current = 1; // Start counting from 1

    public FizzBuzz(int n) {
        this.n = n;
    }

    // Thread A calls fizz()
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            // Check if 'current' is divisible by 3 but NOT 5
            if (current % 3 == 0 && current % 5 != 0) {
                printFizz.run();  // Print "fizz"
                current++;        // Move to the next number
                notifyAll();      // Wake up other threads to check the new number
            } else {
                wait();           // Not our turn, wait until the number changes
            }
        }
    }

    // Thread B calls buzz()
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            // Check if 'current' is divisible by 5 but NOT 3
            if (current % 5 == 0 && current % 3 != 0) {
                printBuzz.run();  // Print "buzz"
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // Thread C calls fizzbuzz()
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            // Check if 'current' is divisible by BOTH 3 and 5
            if (current % 3 == 0 && current % 5 == 0) {
                printFizzBuzz.run(); // Print "fizzbuzz"
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // Thread D calls number()
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            // Check if 'current' is NOT divisible by 3 and NOT divisible by 5
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current); // Print the actual number
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}