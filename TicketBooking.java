import java.util.concurrent.locks.ReentrantLock;

class TicketBookingSystem {
    private static int availableSeats = 5;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void bookTicket(String user) {
        lock.lock();
        try {
            if (availableSeats > 0) {
                System.out.println(user + " booked seat number: " + availableSeats);
                availableSeats--;
            } else {
                System.out.println(user + " booking failed! No seats available.");
            }
        } finally {
            lock.unlock();
        }
    }
}

class BookingThread extends Thread {
    private String user;

    BookingThread(String user, int priority) {
        this.user = user;
        setPriority(priority);
    }

    public void run() {
        TicketBookingSystem.bookTicket(user);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        BookingThread user1 = new BookingThread("VIP User 1", Thread.MAX_PRIORITY);
        BookingThread user2 = new BookingThread("Regular User 1", Thread.NORM_PRIORITY);
        BookingThread user3 = new BookingThread("VIP User 2", Thread.MAX_PRIORITY);
        BookingThread user4 = new BookingThread("Regular User 2", Thread.NORM_PRIORITY);
        BookingThread user5 = new BookingThread("Regular User 3", Thread.NORM_PRIORITY);
        BookingThread user6 = new BookingThread("Regular User 4", Thread.NORM_PRIORITY);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
        user6.start();
    }
}
