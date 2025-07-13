package decorator;

import factory.Service;

public abstract class ReservationDecorator implements Service {
    protected Service decoratedService;

    public ReservationDecorator(Service decoratedService) {
        this.decoratedService = decoratedService;
    }

    @Override
    public void reserve() {
        decoratedService.reserve();
    }
}
