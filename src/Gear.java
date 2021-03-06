import greenfoot.Actor;

public class Gear extends Actor {
    int vel = 3;
    boolean onFloor;

    public Gear(int rot) {
        onFloor = false;
        this.setRotation(rot);
    }

    public void act() {
        this.move(this.vel);
        Actor boilerBottom = this.getOneObjectAtOffset(0, 0, BoilerBottom.class);
        if(boilerBottom == null) {

            // Makes the gear acc. towards the ground after leaving the alliance station chute.
            if(this.vel < 10 && !onFloor) {
                ++this.vel;
            }

            if(this.getRotation() > 90) {
                this.turn(-5);
            }

            if(this.getRotation() < 90) {
                this.turn(5);
            }
        }

        if(this.getY() > 378) {
            onFloor = true;
            this.setLocation(this.getX(), 396);
            this.setRotation(0);
            vel = 0;
        }

    }
}
