package command;

public class MakeReservationCommand implements Command {
    private ReservationReceiver receiver;

    public MakeReservationCommand(ReservationReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.makeReservation();
    }

    @Override
    public void undo() {
        receiver.cancelReservation();
    }
}
