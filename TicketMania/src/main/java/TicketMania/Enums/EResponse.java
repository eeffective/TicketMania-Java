package TicketMania.Enums;

public enum EResponse {
    INVALID_PARAMS("Invalid parameters."),
    UNEXPECTED_ERROR("A unexpected error occurred. Try again later."),
    TICKETS_SOLD_OUT("Tickets sold out."),
    USER_DOES_NOT_EXIST("User with this specific email does not exist. "),
    USER_SUCCESSFULLY_CREATED("User created successfully! "),
    USERNAME_ALREADY_EXISTS("A user with this username already exists."),
    EMAIL_ALREADY_EXISTS("A user with this email already exists.");

    private final String message;

    EResponse(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
