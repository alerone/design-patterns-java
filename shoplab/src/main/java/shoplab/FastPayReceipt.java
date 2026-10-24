package shoplab;

/**
 * FastPayReceipt
 */
public record FastPayReceipt(boolean accepted, String receiptId, String reason) {
}
