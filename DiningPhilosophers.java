import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    
    // There are 5 forks for 5 philosophers
    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        // Determine the fork IDs for this philosopher
        int leftForkId = philosopher;
        int rightForkId = (philosopher + 1) % 5;
        
        // Resource Hierarchy: Always lock the smaller ID first to avoid deadlock
        int firstFork = Math.min(leftForkId, rightForkId);
        int secondFork = Math.max(leftForkId, rightForkId);
        
        // Acquire locks in the strict order
        forks[firstFork].lock();
        forks[secondFork].lock();
        
        try {
            // Pick up the forks
            pickLeftFork.run();
            pickRightFork.run();
            
            // Eat spaghetti
            eat.run();
            
            // Put down the forks
            putLeftFork.run();
            putRightFork.run();
        } finally {
            // Always release the locks in the reverse order inside the finally block
            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }
    }
}