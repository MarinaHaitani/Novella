package com.example.novella;
public class TeaManager {
    private static int ticketCount = 2; // Начальное количество чая
    private static long lastTicketTime = 0; // Время последнего использования чая
    private static long ticketRestoreInterval = 60 * 1000; // Интервал восстановления чая (1 минута)
    public static int getTicketCount() {
        return ticketCount;
    }
    public static long getLastTicketTime() {
        return lastTicketTime;
    }
    public static long getTicketRestoreInterval() {
        return ticketRestoreInterval;
    }
    public static void useTicket() {
        if (ticketCount > 0) {
            ticketCount--;
            lastTicketTime = System.currentTimeMillis();
        }
    }
    public static void restoreTickets() {
        if (ticketCount < 2) {
            long currentTime = System.currentTimeMillis();
            long timeSinceLastTicket = currentTime - lastTicketTime;
            // Проверяем, если время идет назад, сбрасываем последнее время билета
            if (timeSinceLastTicket < 0) {
                lastTicketTime = currentTime;
                return;
            }
            if (timeSinceLastTicket >= ticketRestoreInterval) {
                int ticketsRestored = (int) (timeSinceLastTicket / ticketRestoreInterval);
                ticketCount = Math.min(ticketCount + ticketsRestored, 2);
                // Обновляем время последнего использования билета, учитывая возможное нарушение времени
                lastTicketTime = currentTime - (timeSinceLastTicket % ticketRestoreInterval);
            }
        }
    }
}