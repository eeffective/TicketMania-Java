package TicketMania.Utilities;

public enum CustomResponse {
    INVALID_PARAMS("Invalid parameters."),
    UNEXPECTED_ERROR("A unexpected error occurred. Try again later."),
    TICKETS_SOLD_OUT("Tickets sold out."),
    USER_ALREADY_EXISTS("A user with this email already exists.");

    private final String message;

    CustomResponse(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
